package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.CountryCode;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.BankAccountRequest;
import com.lob.protocol.request.BankAccountVerifyRequest;
import com.lob.protocol.request.CheckRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.BankAccountResponse;
import com.lob.protocol.response.CheckResponse;

public class CheckExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final String apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc"; // Replace this API key with your own.
        final LobClient client = AsyncLobClient.createDefault(apiKey);

        // Creating an Address Object
        final AddressRequest exampleAddressRequest = AddressRequest.builder()
            .name("Joe Smith")
            .line1("104, Printing Boulevard")
            .city("Boston")
            .state("MA")
            .country("us")
            .zip("12345")
            .build();
        final AddressResponse exampleAddressResponse = client.createAddress(exampleAddressRequest).get();

        printResponse("Address Response", exampleAddressResponse);

        // Creating a Bank Account using the previously created address
        final BankAccountRequest exampleBankAccountRequest = BankAccountRequest.builder()
            .routingNumber("122100024")
            .accountNumber("1234564789")
            .signatory("John Doe")
            .bankAddress(AddressRequest.builder()
                .name("Bank Address")
                .line1("123 Wall Street")
                .city("San Francisco")
                .state("CA")
                .zip("94158")
                .country("us")
                .build())
            .accountAddress(exampleAddressResponse.getId())
            .build();

        final BankAccountResponse exampleBankAccountResponse = client.createBankAccount(exampleBankAccountRequest).get();

        printResponse("Bank Account Response", exampleBankAccountResponse);

        // Verify a the previously created bank account
        final BankAccountVerifyRequest exampleBankAccountVerifyRequest = BankAccountVerifyRequest.builder()
            .id(exampleBankAccountResponse.getId())
            .amounts(25, 63)
            .build();

        final BankAccountResponse exampleBankAccountVerifyResponse = client.verifyBankAccount(exampleBankAccountVerifyRequest).get();

        printResponse("Bank Account Verify Response", exampleBankAccountVerifyResponse);

        // Creating a Check using the previously created bank account
        final CheckRequest exampleCheckRequest = CheckRequest.builder()
            .description("Example Check")
            .to(AddressRequest.builder()
                .name("Lob")
                .line1("185 Berry Street")
                .line2("Suite 1510")
                .city("San Francisco")
                .state("CA")
                .zip("94107")
                .country("us")
                .build())
            .bankAccount(exampleBankAccountResponse.getId())
            .amount(1000)
            .memo("Services Rendered")
            .logo("https://s3-us-west-2.amazonaws.com/lob-assets/lob_check_logo.png")
            .build();
        final CheckResponse exampleCheckResponse = client.createCheck(exampleCheckRequest).get();

        printResponse("Check Response", exampleCheckResponse);
    }
}

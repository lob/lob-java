package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.BankAccountRequest;
import com.lob.protocol.request.BankAccountVerifyRequest;
import com.lob.protocol.request.CheckRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.BankAccountResponse;
import com.lob.protocol.response.CheckResponse;

public class CheckExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        // Creating a Bank Account
        final BankAccountRequest exampleBankAccountRequest = BankAccountRequest.builder()
            .routingNumber("122100024")
            .accountNumber("1234564789")
            .accountType("company")
            .signatory("John Doe")
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

        // Creating a Check using the previously created bank account and address
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
            .from(exampleAddressResponse.getId())
            .bankAccount(exampleBankAccountResponse.getId())
            .amount(1000)
            .memo("Services Rendered")
            .logo("https://s3-us-west-2.amazonaws.com/lob-assets/lob_check_logo.png")
            .build();
        final CheckResponse exampleCheckResponse = client.createCheck(exampleCheckRequest).get();

        printResponse("Check Response", exampleCheckResponse);

        System.exit(0);
    }
}

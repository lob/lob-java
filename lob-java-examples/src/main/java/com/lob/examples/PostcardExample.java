package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.PostcardRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.PostcardResponse;

public class PostcardExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

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

        // Creating a postcard
        final PostcardRequest examplePostcardRequest = PostcardRequest.builder()
            .description("Test Postcard")
            .to(exampleAddressResponse.getId())
            .from(exampleAddressResponse.getId())
            .front("https://lob.com/postcardfront.pdf")
            .back("https://lob.com/postcardback.pdf")
            .build();

        final PostcardResponse examplePostcardResponse = client.createPostcard(examplePostcardRequest).get();

        printResponse("Postcard Response", examplePostcardResponse);

        System.exit(0);
    }
}

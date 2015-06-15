package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.CountryCode;
import com.lob.id.SettingId;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.JobRequest;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.JobResponse;
import com.lob.protocol.response.LobObjectResponse;

public class JobExample extends BaseExample {
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

        // Creating an Object
        final LobObjectRequest exampleObjectRequest = LobObjectRequest.builder()
            .name("Example Object")
            .file("https://s3-us-west-2.amazonaws.com/lob-assets/test.pdf")
            .setting(200)
            .quantity(1)
            .doubleSided(true)
            .build();
        final LobObjectResponse exampleObjectResponse = client.createLobObject(exampleObjectRequest).get();

        printResponse("Object Response", exampleObjectResponse);

        // Creating a Job using the previously created address and object
        final JobRequest exampleJobRequest = JobRequest.builder()
            .name("Test Job")
            .to(exampleAddressResponse.getId())
            .from(exampleAddressResponse.getId())
            .objectIds(exampleObjectResponse.getId())
            .build();
        final JobResponse exampleJobResponse = client.createJob(exampleJobRequest).get();

        printResponse("Job Response", exampleJobResponse);
    }
}

package com.lob.examples;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.LobObjectId;
import com.lob.id.SettingId;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.JobRequest;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.JobResponse;
import com.lob.protocol.response.LobObjectResponse;

import java.util.List;

public class AsyncJobExample extends BaseExample {
    // This example demonstrates launching multiple requests synchronously and transforming their results
    // once they come in. The only blocking call is the final get().
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        final List<ListenableFuture<?>> futures = Lists.newArrayList();

        // Creating an Address Object
        final AddressRequest exampleAddressRequest = AddressRequest.builder()
            .name("Joe Smith")
            .line1("104, Printing Boulevard")
            .city("Boston")
            .state("MA")
            .country("us")
            .zip("12345")
            .build();
        final ListenableFuture<AddressResponse> addressFuture = client.createAddress(exampleAddressRequest);
        futures.add(addressFuture);

        // Create 5 objects
        final LobObjectRequest.Builder objectBuilder = LobObjectRequest.builder()
            .description("Example Object")
            .file("https://s3-us-west-2.amazonaws.com/lob-assets/lob-jelly-photo.jpg")
            .setting(500)
            .quantity(1);
        for (int i = 0; i < 5; ++i) {
            final LobObjectRequest objectRequest = objectBuilder.butWith().description("Example Object " + i).build();
            final ListenableFuture<LobObjectResponse> objectFuture = client.createLobObject(objectRequest);
            futures.add(objectFuture);
        }

        // Take the results of all the previous requests and use them to parse a job asynchronously.
        final ListenableFuture<JobResponse> jobFuture = Futures.transform(
            Futures.allAsList(futures),
            new AsyncFunction<List<Object>, JobResponse>() {
                @Override
                public ListenableFuture<JobResponse> apply(final List<Object> inputs) throws Exception {
                    // Creating a Job using the previously created address and object
                    final JobRequest.Builder builder = JobRequest.builder().description("Test Job");

                    final List<LobObjectId> objectIds = Lists.newArrayList();
                    for (final Object input : inputs) {
                        if (input instanceof AddressResponse) {
                            final AddressResponse addressResponse = (AddressResponse) input;
                            builder.to(addressResponse.getId()).from(addressResponse.getId());
                        }
                        else if (input instanceof LobObjectResponse) {
                            final LobObjectResponse objectResponse = (LobObjectResponse) input;
                            objectIds.add(objectResponse.getId());
                        }
                    }
                    builder.objectIds(objectIds);
                    return client.createJob(builder.build());
                }
            }
        );

        final long startTime = System.currentTimeMillis();

        printResponse("Job Response", jobFuture.get());

        System.out.println("Look at all the work I got done in the " + (System.currentTimeMillis() - startTime) +
                               " milliseconds I was waiting for the responses to come in!");
    }
}

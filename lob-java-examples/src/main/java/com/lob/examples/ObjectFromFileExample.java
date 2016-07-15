package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.response.LobObjectResponse;

public class ObjectFromFileExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final LobClient client = AsyncLobClient.createDefault(API_KEY);

        final LobObjectRequest objectRequest = LobObjectRequest.builder()
            .description("Example File Object")
            .file("https://s3-us-west-2.amazonaws.com/lob-assets/lob-jelly-photo.jpg")
            .setting(500)
            .build();
        final LobObjectResponse objectResponse = client.createLobObject(objectRequest).get();

        printResponse("File Object Response", objectResponse);
        System.out.println("Check out the object here: " + objectResponse.getUrl());

        System.exit(0);
    }
}

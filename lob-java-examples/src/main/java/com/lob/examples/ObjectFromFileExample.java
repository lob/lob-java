package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.SettingId;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.response.LobObjectResponse;

import java.io.File;

public class ObjectFromFileExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final String apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc"; // Replace this API key with your own.
        final LobClient client = AsyncLobClient.createDefault(apiKey);

        final File file = fileFromResource("goblue.pdf");
        final LobObjectRequest objectRequest = LobObjectRequest.builder()
            .name("Example File Object")
            .file(file)
            .setting(200)
            .build();
        final LobObjectResponse objectResponse = client.createLobObject(objectRequest).get();

        printResponse("File Object Response", objectResponse);
        System.out.println("Check out the object here: " + objectResponse.getUrl());
    }
}

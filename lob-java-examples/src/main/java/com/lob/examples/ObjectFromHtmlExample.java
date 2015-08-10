package com.lob.examples;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.SettingId;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.request.PostcardRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.LobObjectResponse;
import com.lob.protocol.response.PostcardResponse;

public class ObjectFromHtmlExample extends BaseExample {
    public static void main(final String[] args) throws Exception {
        final String apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc"; // Replace this API key with your own.
        final LobClient client = AsyncLobClient.createDefault(apiKey);

        final String body =
            "<html>" +
                "<body>" +
                    "<div style=\"text-align: center; color: blue;\" />" +
                        "<img src=\"https://s3-us-west-2.amazonaws.com/lob-assets/lob_small.png\" />" +
                        "<h1>Print with Lob</h1>" +
                    "</div>" +
                "</body>" +
            "</html>";

        final LobObjectRequest objectRequest = LobObjectRequest.builder()
            .description("Example Object")
            .file(body)
            .setting(200)
            .build();
        final LobObjectResponse objectResponse = client.createLobObject(objectRequest).get();

        System.out.println("Check out the created PDF here: " + objectResponse.getUrl());
    }
}

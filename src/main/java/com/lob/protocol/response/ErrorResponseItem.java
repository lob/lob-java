package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseItem {
    @JsonProperty private final String message;
    @JsonProperty private final int statusCode;

    public ErrorResponseItem(
            @JsonProperty("message") final String message,
            @JsonProperty("status_code") final int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return statusCode + ": " + message;
    }
}

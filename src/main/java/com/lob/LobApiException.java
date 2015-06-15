package com.lob;

import com.lob.protocol.response.ErrorResponse;

import java.net.URI;

public class LobApiException extends RuntimeException {
    private final URI uri;
    private final ErrorResponse errorResponse;

    public LobApiException(final URI uri, final ErrorResponse errorResponse) {
        super(uri + " " + errorResponse.getError().toString());
        this.uri = uri;
        this.errorResponse = errorResponse;
    }

    public URI getUri() {
        return uri;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public String toString() {
        return "LobApiException: " + uri + " " + errorResponse.getError().toString();
    }
}

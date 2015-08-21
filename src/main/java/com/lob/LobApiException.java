package com.lob;

import com.lob.protocol.response.ErrorResponse;
import com.ning.http.client.uri.Uri;

public class LobApiException extends RuntimeException {
    private final Uri uri;
    private final ErrorResponse errorResponse;

    public LobApiException(final Uri uri, final ErrorResponse errorResponse) {
        super(uri + " " + errorResponse.getError().toString());
        this.uri = uri;
        this.errorResponse = errorResponse;
    }

    public Uri getUri() {
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

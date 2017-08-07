package com.lob.net;

import java.util.List;
import java.util.Map;

public class LobResponse<T> {

    int responseCode;
    T responseBody;
    Map<String, List<String>> responseHeaders;

    public LobResponse(int responseCode, T responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = null;
    }

    public LobResponse(int responseCode, T responseBody, Map<String, List<String>> responseHeaders) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }
}

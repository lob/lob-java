package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;

public abstract class AbstractResponse {
    @JsonIgnore private int statusCode;
    @JsonIgnore private FluentCaseInsensitiveStringsMap headers;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public FluentCaseInsensitiveStringsMap getHeaders() {
        return headers;
    }

    public void setHeaders(FluentCaseInsensitiveStringsMap headers) {
        this.headers = headers;
    }
}

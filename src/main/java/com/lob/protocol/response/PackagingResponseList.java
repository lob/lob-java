package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PackagingResponseList extends AbstractResponseList<PackagingResponse> {
    public PackagingResponseList(
            @JsonProperty("data") final List<PackagingResponse> data,
            @JsonProperty("object") final String object) {
        super(data, object);
    }
    @Override
    public String toString() {
        return "PackagingResponseList" + super.toString();
    }
}

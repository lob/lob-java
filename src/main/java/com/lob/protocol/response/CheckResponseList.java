package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CheckResponseList extends AbstractPagedResponseList<CheckResponse> {
    public CheckResponseList(
            @JsonProperty("data") final List<CheckResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "CheckResponseList{" + super.toString() + "}";
    }
}

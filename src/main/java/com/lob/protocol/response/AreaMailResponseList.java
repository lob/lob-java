package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AreaMailResponseList extends AbstractPagedResponseList<AreaMailResponse> {
    public AreaMailResponseList(
            @JsonProperty("data") final List<AreaMailResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("next_url") final String nextUrl,
            @JsonProperty("previous_url") final String previousUrl,
            @JsonProperty("count") final int count) {
        super(data, object, nextUrl, previousUrl, count);
    }

    @Override
    public String toString() {
        return "AreaMailResponseList{" + super.toString() + "}";
    }
}

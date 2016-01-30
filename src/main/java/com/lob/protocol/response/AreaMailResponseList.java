package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AreaMailResponseList extends AbstractPagedResponseList<AreaMailResponse> {
    public AreaMailResponseList(
            @JsonProperty("data") final List<AreaMailResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "AreaMailResponseList{" + super.toString() + "}";
    }
}

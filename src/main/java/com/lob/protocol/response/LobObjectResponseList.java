package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LobObjectResponseList extends AbstractPagedResponseList<LobObjectResponse> {
    public LobObjectResponseList(
            @JsonProperty("data") final List<LobObjectResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "LobObjectResponseList{" + super.toString() + "}";
    }
}

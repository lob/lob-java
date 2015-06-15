package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StateResponse extends AbstractResourceResponse {
    public StateResponse(
            @JsonProperty("id") final int id,
            @JsonProperty("name") final String name,
            @JsonProperty("short_name") final String shortName,
            @JsonProperty("object") final String object) {
        super(id, name, shortName, object);
    }

    @Override
    public String toString() {
        return "StateResponse" + super.toString();
    }
}

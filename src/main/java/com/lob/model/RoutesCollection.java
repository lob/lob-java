package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoutesCollection extends LobCollection<Routes> {

    @JsonCreator
    public RoutesCollection(
            @JsonProperty("data") final List<Routes> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CheckCollection extends LobCollection<Check> {

    @JsonCreator
    public CheckCollection(
            @JsonProperty("data") final List<Check> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

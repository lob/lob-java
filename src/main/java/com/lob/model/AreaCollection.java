package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AreaCollection extends LobCollection<Area> {

    @JsonCreator
    public AreaCollection(
            @JsonProperty("data") final List<Area> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostcardCollection extends LobCollection<Postcard> {

    @JsonCreator
    public PostcardCollection(
            @JsonProperty("data") final List<Postcard> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

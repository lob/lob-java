package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LetterCollection extends LobCollection<Letter> {

    @JsonCreator
    public LetterCollection(
            @JsonProperty("data") final List<Letter> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

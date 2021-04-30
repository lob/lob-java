package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SelfMailerCollection extends LobCollection<SelfMailer> {

    @JsonCreator
    public SelfMailerCollection(
            @JsonProperty("data") final List<SelfMailer> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

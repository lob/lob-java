package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TemplateCollection extends LobCollection<Template> {

    @JsonCreator
    public TemplateCollection(
            @JsonProperty("data") final List<Template> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

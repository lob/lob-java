package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractResourceResponse {
    @JsonProperty private final int id;
    @JsonProperty private final String name;
    @JsonProperty private final String shortName;
    @JsonProperty private final String object;

    @JsonCreator
    public AbstractResourceResponse(
            @JsonProperty("id") final int id,
            @JsonProperty("name") final String name,
            @JsonProperty("short_name") final String shortName,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", shortName='" + shortName + '\'' +
            ", object='" + object + '\'' +
            '}';
    }
}

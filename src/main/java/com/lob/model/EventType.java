package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventType {

    @JsonProperty private final String id;
    @JsonProperty private final boolean enabledForTest;
    @JsonProperty private final String resource;
    @JsonProperty private final String object;

    @JsonCreator
    public EventType(
            @JsonProperty("id") final String id,
            @JsonProperty("enabled_for_test") final boolean enabledForTest,
            @JsonProperty("resource") final String resource,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.enabledForTest = enabledForTest;
        this.resource = resource;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public boolean isEnabledForTest() {
        return enabledForTest;
    }

    public String getResource() {
        return resource;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "id='" + id + '\'' +
                ", enabledForTest='" + enabledForTest + '\'' +
                ", resource='" + resource + '\'' +
                ", object='" + object + '\'' +
                '}';
    }

}

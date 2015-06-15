package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.PackagingId;

public class PackagingResponse {
    @JsonProperty private final PackagingId id;
    @JsonProperty private final String name;
    @JsonProperty private final String description;
    @JsonProperty private final String object;

    @JsonCreator
    public PackagingResponse(
            @JsonProperty("id") final PackagingId id,
            @JsonProperty("name") final String name,
            @JsonProperty("description") final String description,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.object = object;
    }

    public PackagingId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "PackagingResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", object='" + object + '\'' +
            '}';
    }
}

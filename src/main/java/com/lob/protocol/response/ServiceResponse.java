package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.ServiceId;

public class ServiceResponse {
    @JsonProperty("id") private final ServiceId id;
	@JsonProperty("name") private final String name;
	@JsonProperty("description") private final String description;
	@JsonProperty("object") private final String object;

    @JsonCreator
    public ServiceResponse(
            @JsonProperty("id") final ServiceId id,
            @JsonProperty("name") final String name,
            @JsonProperty("description") final String description,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.object = object;
    }

    public ServiceId getId() {
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
        return "ServiceResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", object='" + object + '\'' +
            '}';
    }
}
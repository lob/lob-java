package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lob.protocol.serializer.DateTimeSerializer;
import org.joda.time.DateTime;

import java.util.Map;

public abstract class AbstractLobResponse extends AbstractResponse {
    @JsonProperty private final String description;
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final String object;

    public AbstractLobResponse(
            @JsonProperty("description") final String description,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata")final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.metadata = metadata;
        this.object = object;
    }

    public String getDescription() {
        return description;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public DateTime getDateCreated() {
        return dateCreated;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public DateTime getDateModified() {
        return dateModified;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return ", description=" + description + '\'' +
            ", dateCreated=" + dateCreated +
            ", dateModified=" + dateModified +
            ", metadata=" + metadata +
            ", object='" + object + '\'' +
            '}';
    }
}

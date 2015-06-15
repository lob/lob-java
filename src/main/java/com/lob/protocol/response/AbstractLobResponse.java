package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.util.Map;

public abstract class AbstractLobResponse {
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final String object;

    public AbstractLobResponse(
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata")final Map<String, String> metadata,
            @JsonProperty("object") final String object) {
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.metadata = metadata;
        this.object = object;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

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
        return ", dateCreated=" + dateCreated +
            ", dateModified=" + dateModified +
            ", metadata=" + metadata +
            ", object='" + object + '\'' +
            '}';
    }
}

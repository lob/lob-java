package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.LobId;

public abstract class AbstractDeleteResponse<T extends LobId> extends AbstractResponse {
    @JsonProperty private final boolean deleted;
    @JsonProperty private final T id;

    public AbstractDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final T id) {
        this.deleted = deleted;
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public T getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
            "deleted=" + deleted +
            ", id=" + id +
            '}';
    }
}

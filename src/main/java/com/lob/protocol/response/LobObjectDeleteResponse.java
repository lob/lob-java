package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.LobObjectId;

public class LobObjectDeleteResponse extends AbstractDeleteResponse<LobObjectId> {
    public LobObjectDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final LobObjectId id) {
        super(deleted, id);
    }

    @Override
    public String toString() {
        return "LobObjectDeleteResponse" + super.toString();
    }
}

package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.CheckId;

public class CheckDeleteResponse extends AbstractDeleteResponse<CheckId> {
    public CheckDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final CheckId id) {
        super(deleted, id);
    }

    @Override
    public String toString() {
        return "CheckDeleteResponse" + super.toString();
    }
}

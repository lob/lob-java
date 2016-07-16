package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.LetterId;

public class LetterDeleteResponse extends AbstractDeleteResponse<LetterId> {
    public LetterDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final LetterId id) {
        super(deleted, id);
    }

    @Override
    public String toString() {
        return "LetterDeleteResponse" + super.toString();
    }
}

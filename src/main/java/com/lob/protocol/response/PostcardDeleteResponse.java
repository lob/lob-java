package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.PostcardId;

public class PostcardDeleteResponse extends AbstractDeleteResponse<PostcardId> {
    public PostcardDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final PostcardId id) {
        super(deleted, id);
    }

    @Override
    public String toString() {
        return "PostcardDeleteResponse" + super.toString();
    }
}

package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class PostcardId extends LobId {
    private PostcardId(final String id) {
        super(id);
    }

    @JsonCreator
    public static PostcardId parse(final String s) {
        return new PostcardId(s);
    }
}

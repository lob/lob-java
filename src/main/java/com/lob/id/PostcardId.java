package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class PostcardId extends LobId {
    private PostcardId(final Prefix prefix, final String id) {
        super(prefix, id);
    }

    @JsonCreator
    public static PostcardId parse(final String s) {
        return new PostcardId(Prefix.POSTCARD, s);
    }
}

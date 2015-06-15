package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LobObjectId extends LobId {
    private LobObjectId(final Prefix prefix, final String identifier) {
        super(prefix, identifier);
    }

    @JsonCreator
    public static LobObjectId parse(final String s) {
        return new LobObjectId(Prefix.OBJECT, s);
    }
}

package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LobObjectId extends LobId {
    private LobObjectId(final String identifier) {
        super(identifier);
    }

    @JsonCreator
    public static LobObjectId parse(final String s) {
        return new LobObjectId(s);
    }
}

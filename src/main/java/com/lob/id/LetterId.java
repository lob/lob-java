package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LetterId extends LobId {
    private LetterId(final String identifier) {
        super(identifier);
    }

    @JsonCreator
    public static LetterId parse(final String s) {
        return new LetterId(s);
    }
}

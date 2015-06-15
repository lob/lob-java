package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LetterId extends LobId {
    private LetterId(final Prefix prefix, final String identifier) {
        super(prefix, identifier);
    }

    @JsonCreator
    public static LetterId parse(final String s) {
        return new LetterId(Prefix.LETTER, s);
    }
}

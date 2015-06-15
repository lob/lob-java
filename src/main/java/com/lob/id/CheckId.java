package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CheckId extends LobId {
    private CheckId(final Prefix prefix, final String id) {
        super(prefix, id);
    }

    @JsonCreator
    public static CheckId parse(final String s) {
        return new CheckId(Prefix.CHECK, s);
    }
}

package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CheckId extends LobId {
    private CheckId(final String id) {
        super(id);
    }

    @JsonCreator
    public static CheckId parse(final String s) {
        return new CheckId(s);
    }
}

package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AreaMailId extends LobId {
    private AreaMailId(final String id) {
        super(id);
    }

    @JsonCreator
    public static AreaMailId parse(final String s) {
        return new AreaMailId(s);
    }
}

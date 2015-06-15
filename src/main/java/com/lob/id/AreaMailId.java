package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AreaMailId extends LobId {
    private AreaMailId(final Prefix prefix, final String id) {
        super(prefix, id);
    }

    @JsonCreator
    public static AreaMailId parse(final String s) {
        return new AreaMailId(Prefix.AREA, s);
    }
}

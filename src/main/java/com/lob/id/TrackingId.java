package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TrackingId extends LobId {
    private TrackingId(final String id) {
        super(id);
    }

    @JsonCreator
    public static TrackingId parse(final String s) {
        return new TrackingId(s);
    }
}

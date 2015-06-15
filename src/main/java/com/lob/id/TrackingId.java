package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TrackingId extends LobId {
    private TrackingId(final Prefix prefix, final String id) {
        super(prefix, id);
    }

    @JsonCreator
    public static TrackingId parse(final String s) {
        return new TrackingId(Prefix.TRACKING, s);
    }
}

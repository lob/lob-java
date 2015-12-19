package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class JobId extends LobId {
    private JobId(final String id) {
        super(id);
    }

    @JsonCreator
    public static JobId parse(final String s) {
        return new JobId(s);
    }
}

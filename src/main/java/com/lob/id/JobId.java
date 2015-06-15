package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class JobId extends LobId {
    private JobId(final Prefix prefix, final String id) {
        super(prefix, id);
    }

    @JsonCreator
    public static JobId parse(final String s) {
        return new JobId(Prefix.JOB, s);
    }
}

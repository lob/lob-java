package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ServiceId extends IntegerId {
    private ServiceId(final int id) {
        super(id);
    }

    public static ServiceId create(final int id) {
        return new ServiceId(id);
    }

    @JsonCreator
    public static ServiceId parse(final String s) {
        return new ServiceId(Integer.valueOf(s));
    }
}

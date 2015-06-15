package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class PackagingId extends IntegerId {
    private PackagingId(final int id) {
        super(id);
    }

    public static PackagingId create(final int id) {
        return new PackagingId(id);
    }

    @JsonCreator
    public static PackagingId parse(final String s) {
        return new PackagingId(Integer.valueOf(s));
    }
}

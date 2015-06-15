package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AddressId extends LobId {
    private AddressId(final Prefix prefix, final String identifier) {
        super(prefix, identifier);
    }

    @JsonCreator
    public static AddressId parse(final String s) {
        return new AddressId(Prefix.ADDRESS, s);
    }
}

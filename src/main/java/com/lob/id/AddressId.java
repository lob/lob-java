package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AddressId extends LobId {
    private AddressId(final String identifier) {
        super(identifier);
    }

    @JsonCreator
    public static AddressId parse(final String s) {
        return new AddressId(s);
    }
}

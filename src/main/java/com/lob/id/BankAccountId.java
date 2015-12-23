package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BankAccountId extends LobId {
    private BankAccountId(final String id) {
        super(id);
    }

    @JsonCreator
    public static BankAccountId parse(final String s) {
        return new BankAccountId(s);
    }
}

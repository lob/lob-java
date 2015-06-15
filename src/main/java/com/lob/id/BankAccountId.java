package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BankAccountId extends LobId {
    private BankAccountId(final Prefix prefix, final String id) {
        super(prefix, id);
    }

    @JsonCreator
    public static BankAccountId parse(final String s) {
        return new BankAccountId(Prefix.BANK, s);
    }
}

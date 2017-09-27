package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BankAccountCollection extends LobCollection<BankAccount> {

    @JsonCreator
    public BankAccountCollection(
            @JsonProperty("data") final List<BankAccount> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

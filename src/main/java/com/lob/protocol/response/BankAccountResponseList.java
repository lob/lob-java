package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BankAccountResponseList extends AbstractPagedResponseList<BankAccountResponse> {
    public BankAccountResponseList(
            @JsonProperty("data") final List<BankAccountResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "BankAccountResponseList{" + super.toString() + "}";
    }
}

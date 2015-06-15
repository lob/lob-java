package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.AddressId;
import com.lob.id.BankAccountId;

public class BankAccountDeleteResponse extends AbstractDeleteResponse<BankAccountId> {
    public BankAccountDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final BankAccountId id) {
        super(deleted, id);
    }

    @Override
    public String toString() {
        return "BankAccountDeleteResponse" + super.toString();
    }
}

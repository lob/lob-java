package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.AddressId;
import com.lob.id.LobObjectId;

public class AddressDeleteResponse extends AbstractDeleteResponse<AddressId> {
    public AddressDeleteResponse(
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("id") final AddressId id) {
        super(deleted, id);
    }

    @Override
    public String toString() {
        return "AddressDeleteResponse" + super.toString();
    }
}

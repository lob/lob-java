package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddressResponseList extends AbstractPagedResponseList<AddressResponse> {
    public AddressResponseList(
            @JsonProperty("data") final List<AddressResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "AddressResponseList{" + super.toString() + "}";
    }
}

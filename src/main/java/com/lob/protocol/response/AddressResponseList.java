package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.Util;
import com.lob.protocol.request.AddressRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddressResponseList extends AbstractPagedResponseList<AddressResponse> {
    public AddressResponseList(
            @JsonProperty("data") final List<AddressResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("next_url") final String nextUrl,
            @JsonProperty("previous_url") final String previousUrl,
            @JsonProperty("count") final int count) {
        super(data, object, nextUrl, previousUrl, count);
    }

    @Override
    public String toString() {
        return "AddressResponseList{" + super.toString() + "}";
    }
}

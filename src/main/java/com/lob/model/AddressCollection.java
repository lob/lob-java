package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddressCollection extends LobCollection<Address> {

    @JsonCreator
    public AddressCollection(
            @JsonProperty("data") final List<Address> data,
            @JsonProperty("count") final int count,
            @JsonProperty("object") final String object) {
        super(data, count, object);
    }

}

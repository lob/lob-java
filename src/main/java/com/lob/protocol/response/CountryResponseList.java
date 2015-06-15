package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountryResponseList extends AbstractResponseList<CountryResponse> {
    public CountryResponseList(
            @JsonProperty("data") final List<CountryResponse> data,
            @JsonProperty("object") final String object) {
        super(data, object);
    }
    @Override
    public String toString() {
        return "CountryResponseList" + super.toString();
    }
}

package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LetterResponseList extends AbstractPagedResponseList<LetterResponse> {
    public LetterResponseList(
            @JsonProperty("data") final List<LetterResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "LetterResponseList{" + super.toString() + "}";
    }
}

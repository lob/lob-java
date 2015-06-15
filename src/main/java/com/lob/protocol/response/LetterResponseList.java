package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LetterResponseList extends AbstractPagedResponseList<LetterResponse> {
    public LetterResponseList(
            @JsonProperty("data") final List<LetterResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("next_url") final String nextUrl,
            @JsonProperty("previous_url") final String previousUrl,
            @JsonProperty("count") final int count) {
        super(data, object, nextUrl, previousUrl, count);
    }

    @Override
    public String toString() {
        return "LetterResponseList{" + super.toString() + "}";
    }
}

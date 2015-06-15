package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PostcardResponseList extends AbstractPagedResponseList<PostcardResponse> {
    public PostcardResponseList(
            @JsonProperty("data") final List<PostcardResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("next_url") final String nextUrl,
            @JsonProperty("previous_url") final String previousUrl,
            @JsonProperty("count") final int count) {
        super(data, object, nextUrl, previousUrl, count);
    }

    @Override
    public String toString() {
        return "PostcardResponseList{" + super.toString() + "}";
    }
}

package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JobResponseList extends AbstractPagedResponseList<JobResponse> {
    public JobResponseList(
            @JsonProperty("data") final List<JobResponse> data,
            @JsonProperty("object") final String object,
            @JsonProperty("count") final int count) {
        super(data, object, count);
    }

    @Override
    public String toString() {
        return "JobResponseList{" + super.toString() + "}";
    }
}

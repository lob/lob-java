package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ThumbnailResponse {
    @JsonProperty private final String small;
    @JsonProperty private final String medium;
    @JsonProperty private final String large;

    @JsonCreator
    public ThumbnailResponse(
            @JsonProperty("small") final String small,
            @JsonProperty("medium") final String medium,
            @JsonProperty("large") final String large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }

    @Override
    public String toString() {
        return "ThumbnailResponse{" +
            "small='" + small + '\'' +
            ", medium='" + medium + '\'' +
            ", large='" + large + '\'' +
            '}';
    }
}

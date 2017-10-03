package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Thumbnail {

    @JsonProperty private final String small;
    @JsonProperty private final String medium;
    @JsonProperty private final String large;

    @JsonCreator
    public Thumbnail(
            @JsonProperty("id") final String small,
            @JsonProperty("name") final String medium,
            @JsonProperty("object") final String large) {
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
        return "Thumbnail{" +
                "small=" + small + + '\'' +
                ", medium='" + medium + '\'' +
                ", large=" + large + '\'' +
                '}';
    }

}

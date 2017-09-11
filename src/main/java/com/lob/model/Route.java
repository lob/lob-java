package com.lob.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {
    @JsonProperty private final String route;
    @JsonProperty private final int residential;
    @JsonProperty private final int business;
    @JsonProperty private final String object;

    public Route(@JsonProperty final String route,
                 @JsonProperty final int residential,
                 @JsonProperty final int business,
                 @JsonProperty final String object) {
        this.route = route;
        this.residential = residential;
        this.business = business;
        this.object = object;
    }

    public String getRoute() {
        return route;
    }

    public int getResidential() {
        return residential;
    }

    public int getBusiness() {
        return business;
    }

    @Override
    public String toString() {
        return "Route{" +
                "route=" + route + + '\'' +
                "residential=" + residential + + '\'' +
                "business=" + business + + '\'' +
                '}';
    }
}

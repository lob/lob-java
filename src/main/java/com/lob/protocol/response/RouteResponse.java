package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.RouteId;

public class RouteResponse {
    @JsonProperty private final RouteId route;
    @JsonProperty private final int residential;
    @JsonProperty private final int business;
    @JsonProperty private final String object;

    @JsonCreator
    public RouteResponse(
            @JsonProperty("route") final RouteId route,
            @JsonProperty("residential") final int residential,
            @JsonProperty("business") final int business,
            @JsonProperty("object") final String object) {
        this.route = route;
        this.residential = residential;
        this.business = business;
        this.object = object;
    }

    public RouteId getRoute() {
        return route;
    }

    public int getResidential() {
        return residential;
    }

    public int getBusiness() {
        return business;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "RouteResponse{" +
            "route=" + route +
            ", residential=" + residential +
            ", business=" + business +
            ", object='" + object + '\'' +
            '}';
    }
}

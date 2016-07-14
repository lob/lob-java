package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.ZipCode;

import java.util.List;

import static com.lob.Util.defensiveCopy;

public class ZipCodeRouteResponse {
    @JsonProperty private final ZipCode zipCode;
    @JsonProperty private final List<RouteResponse> routes;

    @JsonCreator
    public ZipCodeRouteResponse(
            @JsonProperty("zip_code") final ZipCode zipCode,
            @JsonProperty("routes") final List<RouteResponse> routes) {
        this.zipCode = zipCode;
        this.routes = routes;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public List<RouteResponse> getRoutes() {
        return defensiveCopy(routes);
    }

    @Override
    public String toString() {
        return "ZipCodeRouteCollection{" +
            "zipCode=" + zipCode +
            ", routes=" + routes +
            '}';
    }
}

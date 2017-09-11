package com.lob.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ZipCode {
    @JsonProperty private final String zipCode;
    @JsonProperty private final List<Route> routes;
    @JsonProperty private final String object;

    public ZipCode(String zipCode, List<Route> routes, String object) {
        this.zipCode = zipCode;
        this.routes = routes;
        this.object = object;
    }

    public String getZipCode() { return zipCode; }

    public List<Route> getRoutes() { return routes; }

    @Override
    public String toString() {
        return "ZipCode{" +
                "zipCode=" + zipCode + + '\'' +
                "routes=" + routes + '\'' +
                "object=" + object + + '\'' +
                '}';
    }
}

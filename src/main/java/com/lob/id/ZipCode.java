package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ZipCode implements StringValued {
    private final String zipCode;

    public ZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public ZipCodeRouteId toZipCodeRouteId(final RouteId routeId) {
        return ZipCodeRouteId.create(this, routeId);
    }

    @Override
    public String value() {
        return this.zipCode;
    }

    @JsonCreator
    public static ZipCode parse(final String s) {
        return new ZipCode(s);
    }

    @Override
    public String toString() {
        return this.zipCode;
    }
}

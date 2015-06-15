package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

import static com.lob.Util.checkNotNull;

public class ZipCodeRouteId implements StringValued {
    private final ZipCode zipCode;
    private final RouteId routeId;

    private ZipCodeRouteId(final ZipCode zipCode, final RouteId routeId) {
        this.zipCode = checkNotNull(zipCode);
        this.routeId = checkNotNull(routeId);
    }

    @JsonCreator
    public static ZipCodeRouteId parse(final String s) {
        final String[] split = s.split("-");
        if (split == null || split.length != 2) {
            throw new IllegalArgumentException("not a valid ZipCodeRouteId! " + s);
        }

        return new ZipCodeRouteId(ZipCode.parse(split[0]), RouteId.parse(split[1]));
    }

    public static ZipCodeRouteId create(final ZipCode zipCode, final RouteId routeId) {
        return new ZipCodeRouteId(zipCode, routeId);
    }

    @Override
    public String value() {
        return this.zipCode.value() + "-" + this.routeId.value();
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public RouteId getRouteId() {
        return routeId;
    }

    @Override
    public String toString() {
        return value();
    }
}

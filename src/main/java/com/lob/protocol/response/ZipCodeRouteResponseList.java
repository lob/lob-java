package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.ZipCodeRouteId;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ZipCodeRouteResponseList extends AbstractResponseList<ZipCodeRouteResponse> {
    public ZipCodeRouteResponseList(
        @JsonProperty("data") final List<ZipCodeRouteResponse> data,
        @JsonProperty("object") final String object) {
        super(data, object);
    }

    public Collection<ZipCodeRouteId> toRequest() {
        final List<ZipCodeRouteId> list = new ArrayList<ZipCodeRouteId>(getData().size());
        for (final ZipCodeRouteResponse response : getData()) {
            for (final RouteResponse route : response.getRoutes()) {
                list.add(ZipCodeRouteId.create(response.getZipCode(), route.getRoute()));
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "ZipCodeRouteList" + super.toString();
    }
}

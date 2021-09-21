package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USReverseGeocodeLookup extends APIResource {
    public static final String RESOURCE = "us_reverse_geocode_lookups";

    public static class Addresses {
        @JsonProperty private Components components;
        @JsonProperty private LocationAnalysis locationAnalysis;

        @JsonCreator
        public Addresses(
                @JsonProperty("components") final Components components,
                @JsonProperty("location_analysis") final LocationAnalysis locationAnalysis) {
            this.components = components;
            this.locationAnalysis = locationAnalysis;

        }

        public Components getComponents() {
            return components;
        }

        public LocationAnalysis locationAnalysis() {
            return locationAnalysis;
        }

        @Override
        public String toString() {
            return "{" +
                    "components='" + components + '\'' +
                    ", locationAnalysis='" + locationAnalysis + '\'' +
                    '}';
        }

    }

    public static class Components {
        @JsonProperty private String zipCode;
        @JsonProperty private String zipCodePlus4;

        @JsonCreator
        public Components(
                @JsonProperty("zip_code") final String zipCode,
                @JsonProperty("zip_code_plus_4") final String zipCodePlus4) {
            this.zipCode = zipCode;
            this.zipCodePlus4 = zipCodePlus4;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getZipCodePlus4() {
            return zipCodePlus4;
        }

        @Override
        public String toString() {
            return "{" +
                    "zipCode='" + zipCode + '\'' +
                    ", zipCodePlus4='" + zipCodePlus4 + '\'' +
                    '}';
        }

    }

    public static class LocationAnalysis {
        @JsonProperty private double latitude;
        @JsonProperty private double longitude;

        @JsonCreator
        public LocationAnalysis(
                @JsonProperty("latitude") final double latitude,
                @JsonProperty("longitude") final double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        @Override
        public String toString() {
            return "{" +
                    "latitude='" + latitude + '\'' +
                    ", longitude='" + longitude + '\'' +
                    '}';
        }

    }

    @JsonProperty private final String id;
    @JsonProperty private final String object;
    @JsonProperty private final List<Addresses> addresses;

    @JsonCreator
    public USReverseGeocodeLookup(
            @JsonProperty("id") final String id,
            @JsonProperty("addresses") final List<Addresses> addresses,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.addresses = addresses;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "USReverseGeocodeLookup{" +
                "id='" + id + '\'' +
                ", addresses='" + addresses + '\'' +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setLatitude(double lat) {
            params.put("latitude", lat);
            return this;
        }
        
        public RequestBuilder setLongitude(double lon) {
            params.put("longitude", lon);
            return this;
        }

        public LobResponse<USReverseGeocodeLookup> lookup() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return lookup(null);
        }

        public LobResponse<USReverseGeocodeLookup> lookup(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, USReverseGeocodeLookup.class, options);
        }
    }

}
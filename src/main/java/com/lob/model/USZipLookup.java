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

public class USZipLookup extends APIResource {

    public static final String RESOURCE = "us_zip_lookups";

    public static class City {

        @JsonProperty private final String city;
        @JsonProperty private final String state;
        @JsonProperty private final String county;
        @JsonProperty private final String countyFips;
        @JsonProperty private final boolean preferred;

        @JsonCreator
        public City(
                @JsonProperty("city") final String city,
                @JsonProperty("state") final String state,
                @JsonProperty("county") final String county,
                @JsonProperty("county_fips") final String countyFips,
                @JsonProperty("preferred") final boolean preferred) {
            this.city = city;
            this.state = state;
            this.county = county;
            this.countyFips = countyFips;
            this.preferred = preferred;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getCounty() {
            return county;
        }

        public String getCountyFips() {
            return countyFips;
        }

        public boolean isPreferred() {
            return preferred;
        }

        @Override
        public String toString() {
            return "City{" +
                    "city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", county='" + county + '\'' +
                    ", countyFips='" + countyFips + '\'' +
                    '}';
        }

    }

    @JsonProperty private final String id;
    @JsonProperty private final String zipCode;
    @JsonProperty private final String zipCodeType;
    @JsonProperty private final List<City> cities;
    @JsonProperty private final String object;

    @JsonCreator
    public USZipLookup(
            @JsonProperty("id") final String id,
            @JsonProperty("zip_code") final String zipCode,
            @JsonProperty("zip_code_type") final String zipCodeType,
            @JsonProperty("cities") final List<City> cities,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.zipCode = zipCode;
        this.zipCodeType = zipCodeType;
        this.cities = cities;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getZipCodeType() {
        return zipCodeType;
    }

    public List<City> getCities() {
        return cities;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "USZipLookup{" +
                "id='" + id + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", zipCodeType='" + zipCodeType + '\'' +
                ", cities=" + cities +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setZipCode(String zipCode) {
            params.put("zip_code", zipCode);
            return this;
        }

        public LobResponse<USZipLookup> lookup() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return lookup(null);
        }

        public LobResponse<USZipLookup> lookup(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, USZipLookup.class, options);
        }
    }

}

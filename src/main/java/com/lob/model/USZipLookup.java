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

    public static final String ENDPOINT = "us_zip_lookups";

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
            @JsonProperty("cities") final List cities,
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

    @Override
    public String toString() {
        return "USZipLookup{" +
                "id=" + id +
                ", zipCode='" + zipCode + '\'' +
                ", zipCodeType='" + zipCodeType + '\'' +
                ", cities='" + cities + '\'' +
                ", object='" + object + '\'' +
                '}';
    }

    public static USZipLookupCreator creator() {
        return new USZipLookupCreator();
    }

    public static final class USZipLookupCreator {
        private Map<String, Object> params = new HashMap<String, Object>();

        public USZipLookupCreator() {
        }

        public USZipLookupCreator setZipCode(String zipCode) {
            params.put("zip_code", zipCode);
            return this;
        }


        public Map<String, Object> build() {
            return params;
        }

        public LobResponse<USZipLookup> lookup() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return lookup(null);
        }

        public LobResponse<USZipLookup> lookup(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, USZipLookup.class, options);
        }
    }

    public static LobResponse<Address> lookup(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, null, USZipLookup.class, options);
    }

}

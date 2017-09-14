package com.lob.model;

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

public class ZipCode extends APIResource {
    public static final String ENDPOINT = "routes";

    @JsonProperty private final String zipCode;
    @JsonProperty private final List<Route> routes;

    public ZipCode(
            @JsonProperty("zip_code") String zipCode,
            @JsonProperty("routes") List<Route> routes) {
        this.zipCode = zipCode;
        this.routes = routes;
    }

    public String getZipCode() { return zipCode; }

    public List<Route> getRoutes() { return routes; }

    @Override
    public String toString() {
        return "ZipCode{" +
                "zipCode=" + zipCode + + '\'' +
                "routes=" + routes + '\'' +
                '}';
    }

    public static ZipCodeCreator creator() { return new ZipCodeCreator(); }

    public static final class ZipCodeCreator {
        private Map<String, Object> params = new HashMap<String, Object>();

        public ZipCodeCreator() {
        }

        public ZipCodeCreator setZipCode(String zipCode) {
            params.put("zip_code", zipCode);
            return this;
        }

        public Map<String, Object> build() {
            return params;
        }

    }
    public static LobResponse<ZipCode> retrieve(String zipCode, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", ENDPOINT, zipCode), null, ZipCode.class, options);
    }

    public static LobResponse<ZipCodeCollection> list(String zipCodes, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s?%s", ENDPOINT, zipCodes), null, ZipCode.class, options);
    }
}

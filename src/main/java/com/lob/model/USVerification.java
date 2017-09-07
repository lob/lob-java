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
import java.util.Map;

public class USVerification extends APIResource {

    public static final String ENDPOINT = "us_verifications";

    @JsonProperty private final String id;
    @JsonProperty private final String primaryLine;
    @JsonProperty private final String secondaryLine;
    @JsonProperty private final String urbanization;
    @JsonProperty private final String city;
    @JsonProperty private final String state;
    @JsonProperty private final String zipCode;

    @JsonCreator
    public USVerification(
            @JsonProperty("id") final String id,
            @JsonProperty("primary_line") final String primaryLine,
            @JsonProperty("secondary_line") final String secondaryLine,
            @JsonProperty("urbanization") final String urbanization,
            @JsonProperty("city") final String city,
            @JsonProperty("state") final String state,
            @JsonProperty("zip_code") final String zipCode) {
        this.id = id;
        this.primaryLine = primaryLine;
        this.secondaryLine = secondaryLine;
        this.urbanization = urbanization;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public String getPrimaryLine() {
        return primaryLine;
    }

    public String getSecondaryLine() {
        return secondaryLine;
    }

    public String getUrbanization() {
        return urbanization;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "USVerification{" +
                "id=" + id +
                ", primaryLine='" + primaryLine + '\'' +
                ", secondaryLine='" + secondaryLine + '\'' +
                ", urbanization='" + urbanization + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public static USVerificationCreator creator() {
        return new USVerificationCreator();
    }

    public static final class USVerificationCreator {
        private Map<String, Object> params = new HashMap<String, Object>();

        public USVerificationCreator() {
        }

        public USVerificationCreator setPrimaryLine(String primaryLine) {
            params.put("primary_line", primaryLine);
            return this;
        }

        public USVerificationCreator setSecondaryLine(String secondaryLine) {
            params.put("secondary_line", secondaryLine);
            return this;
        }

        public USVerificationCreator setUrbanization(String urbanization) {
            params.put("urbanization", urbanization);
            return this;
        }

        public USVerificationCreator setCity(String city) {
            params.put("city", city);
            return this;
        }

        public USVerificationCreator setState(String state) {
            params.put("state", state);
            return this;
        }

        public USVerificationCreator setZipCode(String zipCode) {
            params.put("zip_code", zipCode);
            return this;
        }

        public Map<String, Object> build() {
            return params;
        }

        public LobResponse<USVerification> verify() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return verify(null);
        }

        public LobResponse<USVerification> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.GET, RequestType.NORMAL, ENDPOINT, params, USVerification.class, options);
        }
    }

    public static LobResponse<Address> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, ENDPOINT, null, USVerification.class, options);
    }

}

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

public class InternationalVerification extends APIResource {

    public static final String ENDPOINT = "intl_verifications";

    @JsonProperty private final String id;
    @JsonProperty private final String primaryLine;
    @JsonProperty private final String secondaryLine;
    @JsonProperty private final String city;
    @JsonProperty private final String state;
    @JsonProperty private final String postalCode;
    @JsonProperty private final String country;

    @JsonCreator
    public InternationalVerification(
            @JsonProperty("id") final String id,
            @JsonProperty("primary_line") final String primaryLine,
            @JsonProperty("secondary_line") final String secondaryLine,
            @JsonProperty("city") final String city,
            @JsonProperty("state") final String state,
            @JsonProperty("postal_code") final String postalCode,
            @JsonProperty("country") final String country) {
        this.id = id;
        this.primaryLine = primaryLine;
        this.secondaryLine = secondaryLine;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
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

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "InternationalVerification{" +
                "id=" + id +
                ", primaryLine='" + primaryLine + '\'' +
                ", secondaryLine='" + secondaryLine + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postcalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static InternationalVerificationCreator creator() {
        return new InternationalVerificationCreator();
    }

    public static final class InternationalVerificationCreator {
        private Map<String, Object> params = new HashMap<String, Object>();

        public InternationalVerificationCreator() {
        }

        public InternationalVerificationCreator setPrimaryLine(String primaryLine) {
            params.put("primary_line", primaryLine);
            return this;
        }

        public InternationalVerificationCreator setSecondaryLine(String secondaryLine) {
            params.put("secondary_line", secondaryLine);
            return this;
        }

        public InternationalVerificationCreator setCity(String city) {
            params.put("city", city);
            return this;
        }

        public InternationalVerificationCreator setState(String state) {
            params.put("state", state);
            return this;
        }

        public InternationalVerificationCreator setPostalCode(String postalCode) {
            params.put("postal_code", postalCode);
            return this;
        }

        public Map<String, Object> build() {
            return params;
        }

        public LobResponse<InternationalVerification> verify() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return verify(null);
        }

        public LobResponse<InternationalVerification> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, InternationalVerification.class, options);
        }
    }

    public static LobResponse<Address> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, null, InternationalVerification.class, options);
    }

}

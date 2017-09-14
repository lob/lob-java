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
    @JsonProperty private final String recipient;
    @JsonProperty private final String primaryLine;
    @JsonProperty private final String secondaryLine;
    @JsonProperty private final String lastLine;
    @JsonProperty private final String deliverability;
    @JsonProperty private final String urbanization;
    @JsonProperty private final String object;
    @JsonProperty private final Map<String, String> components;
    @JsonProperty private final DeliverabilityAnalysis deliverabilityAnalysis;

    @JsonCreator
    public USVerification(
            @JsonProperty("id") final String id,
            @JsonProperty("recipient") final String recipient,
            @JsonProperty("primary_line") final String primaryLine,
            @JsonProperty("secondary_line") final String secondaryLine,
            @JsonProperty("last_line") final String lastLine,
            @JsonProperty("deliverability") final String deliverabilty,
            @JsonProperty("urbanization") final String urbanization,
            @JsonProperty("object") final String object,
            @JsonProperty("components") final Map<String, String> components,
            @JsonProperty("deliverability_analysis") final DeliverabilityAnalysis deliverabilityAnalysis) {
        this.id = id;
        this.recipient = recipient;
        this.primaryLine = primaryLine;
        this.secondaryLine = secondaryLine;
        this.lastLine = lastLine;
        this.deliverability = deliverabilty;
        this.urbanization = urbanization;
        this.object = object;
        this.deliverabilityAnalysis = deliverabilityAnalysis;
        this.components = components;
    }

    public String getId() {
        return id;
    }

    public String getRecipient() { return recipient; }

    public String getPrimaryLine() {
        return primaryLine;
    }

    public String getSecondaryLine() {
        return secondaryLine;
    }

    public String getLastLine() { return lastLine; }

    public String getUrbanization() { return urbanization; }

    public String getDeliverability() { return deliverability; }

    public DeliverabilityAnalysis getDeliverabilityAnalysis() { return deliverabilityAnalysis; }

    public String getObject() { return object; }

    public Map<String, String> getComponents() { return components; }

    @Override
    public String toString() {
        return "USVerification{" +
                "id=" + id +
                ", primaryLine='" + primaryLine + '\'' +
                ", secondaryLine='" + secondaryLine + '\'' +
                ", lastLine='" + lastLine + '\'' +
                ", urbanization='" + urbanization + '\'' +
                ", components='" + components + '\'' +
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
            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, USVerification.class, options);
        }
    }

    public static LobResponse<Address> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, null, USVerification.class, options);
    }

}

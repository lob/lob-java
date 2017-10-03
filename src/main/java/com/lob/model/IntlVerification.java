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

public class IntlVerification extends APIResource {

    public static final String ENDPOINT = "intl_verifications";

    public static class Components {
        @JsonProperty private String primaryNumber;
        @JsonProperty private String streetName;
        @JsonProperty private String city;
        @JsonProperty private String state;
        @JsonProperty private String postalCode;

        @JsonCreator
        public Components(
                @JsonProperty("primary_number") final  String primaryNumber,
                @JsonProperty("street_name") final  String streetName,
                @JsonProperty("city") final String city,
                @JsonProperty("state") final String state,
                @JsonProperty("postal_code") final String postalCode) {
            this.primaryNumber = primaryNumber;
            this.streetName = streetName;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
        }

        public String getPrimaryNumber() {
            return primaryNumber;
        }

        public String getStreetName() {
            return streetName;
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
            return "{" +
                    "primaryNumber='" + primaryNumber + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    '}';
        }

    }

    @JsonProperty private final String id;
    @JsonProperty private final String recipient;
    @JsonProperty private final String primaryLine;
    @JsonProperty private final String secondaryLine;
    @JsonProperty private final String lastLine;
    @JsonProperty private final String country;
    @JsonProperty private final String deliverability;
    @JsonProperty private final Components components;
    @JsonProperty private final String object;

    @JsonCreator
    public IntlVerification(
            @JsonProperty("id") final String id,
            @JsonProperty("recipient") final String recipient,
            @JsonProperty("primary_line") final String primaryLine,
            @JsonProperty("secondary_line") final String secondaryLine,
            @JsonProperty("last_line") final String lastLine,
            @JsonProperty("deliverability") final String deliverability,
            @JsonProperty("components") final Components components,
            @JsonProperty("country") final String country,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.recipient = recipient;
        this.primaryLine = primaryLine;
        this.secondaryLine = secondaryLine;
        this.lastLine = lastLine;
        this.country = country;
        this.deliverability = deliverability;
        this.components = components;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getPrimaryLine() {
        return primaryLine;
    }

    public String getSecondaryLine() {
        return secondaryLine;
    }

    public String getLastLine() {
        return lastLine;
    }

    public String getCountry() {
        return country;
    }

    public String getDeliverability() {
        return deliverability;
    }

    public Components getComponents() {
        return components;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "InternationalVerification{" +
                "id=" + id +
                ", recipient='" + recipient + '\'' +
                ", primaryLine='" + primaryLine + '\'' +
                ", secondaryLine='" + secondaryLine + '\'' +
                ", lastLine='" + lastLine + '\'' +
                ", deliverability='" + deliverability + '\'' +
                ", components=" + components +
                '}';
    }


    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setRecipient(String recipient) {
            params.put("recipient", recipient);
            return this;
        }

        public RequestBuilder setPrimaryLine(String primaryLine) {
            params.put("primary_line", primaryLine);
            return this;
        }

        public RequestBuilder setSecondaryLine(String secondaryLine) {
            params.put("secondary_line", secondaryLine);
            return this;
        }

        public RequestBuilder setCity(String city) {
            params.put("city", city);
            return this;
        }

        public RequestBuilder setState(String state) {
            params.put("state", state);
            return this;
        }

        public RequestBuilder setPostalCode(String postalCode) {
            params.put("postal_code", postalCode);
            return this;
        }

        public RequestBuilder setCountry(String country) {
            params.put("country", country);
            return this;
        }

        public LobResponse<IntlVerification> verify() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return verify(null);
        }

        public LobResponse<IntlVerification> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, IntlVerification.class, options);
        }
    }

}

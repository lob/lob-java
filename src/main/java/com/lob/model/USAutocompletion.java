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

public class USAutocompletion extends APIResource {
    public static final String RESOURCE = "us_autocompletions";

    public static class Suggestion {

        @JsonProperty private final String primaryLine;
        @JsonProperty private final String city;
        @JsonProperty private final String state;
        @JsonProperty private final String zipCode;

        @JsonCreator
        public Suggestion(
                @JsonProperty("primary_line") final String primaryLine,
                @JsonProperty("city") final String city,
                @JsonProperty("state") final String state,
                @JsonProperty("zip_code") final String zipCode) {
            this.primaryLine = primaryLine;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
        }

        public String getPrimaryLine() {
            return primaryLine;
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
            return String.format(
                "Suggestion{primaryLine='%s', city='%s', state='%s', zipCode='%s'}",
                primaryLine, city, state, zipCode
            );
        }

    }

    @JsonProperty private final String id;
    @JsonProperty private final List<Suggestion> suggestions;
    @JsonProperty private final String object;

    @JsonCreator
    public USAutocompletion(
            @JsonProperty("id") final String id,
            @JsonProperty("suggestions") final List<Suggestion> suggestions,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.suggestions = suggestions;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return String.format(
            "USAutocomplete{id='%s', suggestions='%s', object='%s'}",
            id, suggestions, object
        );
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {}

        public RequestBuilder setAddressPrefix(String addressPrefix) {
            params.put("address_prefix", addressPrefix);
            return this;
        }

        public RequestBuilder setCity (String city) {
            params.put("city", city);
            return this;
        }

        public RequestBuilder setState (String state) {
            params.put("state", state);
            return this;
        }

        public RequestBuilder setGeoIpSort (Boolean geoIpSort) {
            params.put("geo_ip_sort", geoIpSort);
            return this;
        }

        public LobResponse<USAutocompletion> autocomplete() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return autocomplete(null);
        }

        public LobResponse<USAutocompletion> autocomplete(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, USAutocompletion.class, options);
        }
    }

}

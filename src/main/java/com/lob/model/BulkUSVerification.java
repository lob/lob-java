package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.ParsingException;
import com.lob.exception.RateLimitException;
import com.lob.model.USVerification;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BulkUSVerification extends APIResource {

    public static final String ENDPOINT = "bulk/us_verifications";

    @JsonProperty private final List<USVerification> addresses;

    @JsonCreator
    public BulkUSVerification(
            @JsonProperty("addresses") final List<USVerification> addresses
    ) {
        this.addresses = addresses;
    }

    public List<USVerification> getAddresses() {
        return addresses;
    }


    @Override
    public String toString() {
        return "BulkUSVerification{" +
                "addresses='" + addresses +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private ObjectMapper objectMapper = new ObjectMapper();

        public RequestBuilder() {
        }

        public RequestBuilder setAddresses(List<USVerification.RequestBuilder> addresses) throws ParsingException {
            params.put("addresses", addresses.stream().map(address -> address.build()).collect(Collectors.toList()));
            return this;
        }

        public LobResponse<BulkUSVerification> verify() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return verify(Collections.emptyMap(), null);
        }

        public LobResponse<BulkUSVerification> verify(Map<String, Object> query) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return verify(query, null);
        }

        public LobResponse<BulkUSVerification> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return verify(Collections.emptyMap(), options);
        }

        public LobResponse<BulkUSVerification> verify(Map<String, Object> query, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.JSON, ENDPOINT, params, query, BulkUSVerification.class, options);
        }
    }

}

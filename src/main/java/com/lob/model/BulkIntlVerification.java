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
import com.lob.model.IntlVerification;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BulkIntlVerification extends APIResource {

    public static final String ENDPOINT = "bulk/intl_verifications";

    @JsonProperty private final List<IntlVerification> addresses;

    @JsonCreator
    public BulkIntlVerification(
            @JsonProperty("addresses") final List<IntlVerification> addresses
    ) {
        this.addresses = addresses;
    }

    public List<IntlVerification> getAddresses() {
        return addresses;
    }


    @Override
    public String toString() {
        return "BulkIntlVerification{" +
                "addresses='" + addresses +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private ObjectMapper objectMapper = new ObjectMapper();

        public RequestBuilder() {
        }

        public RequestBuilder setAddresses(List<IntlVerification.RequestBuilder> addresses) throws ParsingException {
            params.put("addresses", addresses.stream().map(address -> address.build()).collect(Collectors.toList()));
            return this;
        }

        public LobResponse<BulkIntlVerification> verify() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return verify(Collections.emptyMap(), null);
        }

        public LobResponse<BulkIntlVerification> verify(Map<String, Object> query) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return verify(query, null);
        }

        public LobResponse<BulkIntlVerification> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return verify(Collections.emptyMap(), options);
        }

        public LobResponse<BulkIntlVerification> verify(Map<String, Object> query, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.JSON, ENDPOINT, params, query, BulkIntlVerification.class, options);
        }
    }

}

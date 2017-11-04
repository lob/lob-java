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
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Address extends APIResource {

    public static final String RESOURCE = "addresses";

    @JsonProperty private final String id;
    @JsonProperty private final String description;
    @JsonProperty private final String name;
    @JsonProperty private final String company;
    @JsonProperty private final String phone;
    @JsonProperty private final String email;
    @JsonProperty private final String line1;
    @JsonProperty private final String line2;
    @JsonProperty private final String city;
    @JsonProperty private final String state;
    @JsonProperty private final String zip;
    @JsonProperty private final String country;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final ZonedDateTime dateCreated;
    @JsonProperty private final ZonedDateTime dateModified;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Address(
            @JsonProperty("id") final String id,
            @JsonProperty("description") final String description,
            @JsonProperty("name") final String name,
            @JsonProperty("company") final String company,
            @JsonProperty("phone") final String phone,
            @JsonProperty("email") final String email,
            @JsonProperty("address_line1") final String line1,
            @JsonProperty("address_line2") final String line2,
            @JsonProperty("address_city") final String city,
            @JsonProperty("address_state") final String state,
            @JsonProperty("address_zip") final String zip,
            @JsonProperty("address_country") final String country,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("date_created") final ZonedDateTime dateCreated,
            @JsonProperty("date_modified") final ZonedDateTime dateModified,
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("object") final String object) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.metadata = metadata;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.deleted = deleted;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", metadata=" + metadata +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", deleted=" + deleted +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public RequestBuilder setName(String name) {
            params.put("name", name);
            return this;
        }

        public RequestBuilder setCompany(String company) {
            params.put("company", company);
            return this;
        }

        public RequestBuilder setPhone(String phone) {
            params.put("phone", phone);
            return this;
        }

        public RequestBuilder setEmail(String email) {
            params.put("email", email);
            return this;
        }

        public RequestBuilder setLine1(String line1) {
            params.put("address_line1", line1);
            return this;
        }

        public RequestBuilder setLine2(String line2) {
            params.put("address_line2", line2);
            return this;
        }

        public RequestBuilder setCity(String city) {
            params.put("address_city", city);
            return this;
        }

        public RequestBuilder setState(String state) {
            params.put("address_state", state);
            return this;
        }

        public RequestBuilder setZip(String zip) {
            params.put("address_zip", zip);
            return this;
        }

        public RequestBuilder setCountry(String country) {
            params.put("address_country", country);
            return this;
        }

        public RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }

        public Map<String, Object> build() {
            return params;
        }

        public LobResponse<Address> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public LobResponse<Address> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Address.class, options);
        }
    }

    public static LobResponse<Address> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static LobResponse<Address> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Address.class, options);
    }

    public static LobResponse<AddressCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static LobResponse<AddressCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<AddressCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static LobResponse<AddressCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, AddressCollection.class, options);
    }

    public static LobResponse<Address> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static LobResponse<Address> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Address.class, options);
    }

}

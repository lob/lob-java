package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;
import java.util.Map;
import org.joda.time.DateTime;

public class Address extends APIResource {

    public static final String ENDPOINT = "addresses";

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
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
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
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
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

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
        return dateModified;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", metadata=" + metadata +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", object=" + object +
                '}';
    }

    public static LobResponse retrieve(String id) throws APIException, Exception {
        return request(RequestMethod.GET, String.format("%s/%s", ENDPOINT, id), null, Address.class, null);
    }

    public static LobResponse retrieve(String id, RequestOptions options) throws APIException, Exception {
        return request(RequestMethod.GET, String.format("%s/%s", ENDPOINT, id), null, Address.class, options);
    }

    public static LobResponse list() throws APIException, Exception {
        return request(RequestMethod.GET, ENDPOINT, null, AddressCollection.class, null);
    }

    public static LobResponse list(Map<String, Object> params) throws APIException, Exception {
        return request(RequestMethod.GET, ENDPOINT, params, AddressCollection.class, null);
    }

    public static LobResponse list(RequestOptions options) throws APIException, Exception {
        return request(RequestMethod.GET, ENDPOINT, null, AddressCollection.class, options);
    }

    public static LobResponse list(Map<String, Object> params, RequestOptions options) throws APIException, Exception {
        return request(RequestMethod.GET, ENDPOINT, params, AddressCollection.class, options);
    }

}

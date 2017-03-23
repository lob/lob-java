package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lob.id.AddressId;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;
import com.lob.protocol.serializer.DateTimeSerializer;
import org.joda.time.DateTime;

import java.util.Map;

public class AddressResponse extends BaseAddressResponse {
    @JsonProperty private final AddressId id;
    @JsonProperty private final String description;
    @JsonProperty private final String name;
    @JsonProperty private final String company;
    @JsonProperty private final String email;
    @JsonProperty private final String phone;
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final Map<String, String> metadata;

    @JsonCreator
    public AddressResponse(
            @JsonProperty("id") final AddressId id,
            @JsonProperty("description") final String description,
            @JsonProperty("name") final String name,
            @JsonProperty("company") final String company,
            @JsonProperty("email") final String email,
            @JsonProperty("phone") final String phone,
            @JsonProperty("address_line1") final String line1,
            @JsonProperty("address_line2") final String line2,
            @JsonProperty("address_city") final String city,
            @JsonProperty("address_state") final String state,
            @JsonProperty("address_zip") final ZipCode zip,
            @JsonProperty("address_country") final CountryCode country,
            @JsonProperty("object") final String object,
            @JsonProperty("date_created") final DateTime dateCreated,
            @JsonProperty("date_modified") final DateTime dateModified,
            @JsonProperty("metadata") final Map<String, String> metadata) {

        super(line1, line2, city, state, zip, country, object);
        this.id = id;
        this.description = description;
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.metadata = metadata;
    }

    public AddressId getId() {
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

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public DateTime getDateCreated() {
        return dateCreated;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public DateTime getDateModified() {
        return dateModified;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "AddressResponse{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", name='" + name + '\'' +
            ", company='" + company + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", dateCreated=" + dateCreated +
            ", dateModified=" + dateModified +
            ", metadata=" + metadata +
            super.toString();
    }
}

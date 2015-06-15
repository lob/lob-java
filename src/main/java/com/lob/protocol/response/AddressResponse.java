package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.AddressId;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;
import org.joda.time.DateTime;

import java.util.Map;

public class AddressResponse extends BaseAddressResponse {
    @JsonProperty private final AddressId id;
    @JsonProperty private final String name;
    @JsonProperty private final String email;
    @JsonProperty private final String phone;
    @JsonProperty private final DateTime dateCreated;
    @JsonProperty private final DateTime dateModified;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final Map<String, String> metadata;

    @JsonCreator
    public AddressResponse(
            @JsonProperty("id") final AddressId id,
            @JsonProperty("name") final String name,
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
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("metadata") final Map<String, String> metadata) {

        super(line1, line2, city, state, zip, country, object);
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.deleted = deleted;
        this.metadata = metadata;
    }

    public AddressId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
        return dateModified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "AddressResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", dateCreated=" + dateCreated +
            ", dateModified=" + dateModified +
            ", deleted=" + deleted +
            ", metadata=" + metadata +
            super.toString();
    }
}

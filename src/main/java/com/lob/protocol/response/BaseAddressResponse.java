package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;

public class BaseAddressResponse extends AbstractResponse {
    @JsonProperty("address_line1") private final String line1;
    @JsonProperty("address_line2") private final String line2;
    @JsonProperty("address_city") private final String city;
    @JsonProperty("address_state") private final String state;
    @JsonProperty("address_zip") private final ZipCode zip;
    @JsonProperty("address_country") private final CountryCode country;
    @JsonProperty("object") private final String object;

    @JsonCreator
    public BaseAddressResponse(
            @JsonProperty("address_line1") final String line1,
            @JsonProperty("address_line2") final String line2,
            @JsonProperty("address_city") final String city,
            @JsonProperty("address_state") final String state,
            @JsonProperty("address_zip") final ZipCode zip,
            @JsonProperty("address_country") final CountryCode country,
            @JsonProperty("object") final String object) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.object = object;
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

    public ZipCode getZip() {
        return zip;
    }

    public CountryCode getCountry() {
        return country;
    }

    public String getObject() {
        return object;
    }

    protected String toStringWithoutLeadingComma() {
        return
            "line1='" + line1 + '\'' +
            ", line2='" + line2 + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", country='" + country + '\'' +
            ", object='" + object + '\'' +
            '}';
    }

    @Override
    public String toString() {
        return ", " + toStringWithoutLeadingComma();
    }
}

package com.lob.protocol.request;

import com.lob.LobParamsBuilder;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;

import java.util.Map;

public abstract class AbstractAddressRequest extends AbstractLobRequest {
    private final String line1;
    private final String line2;
    private final String city;
    private final String state;
    private final ZipCode zip;
    private final CountryCode country;

    public AbstractAddressRequest(
            final String line1,
            final String line2,
            final String city,
            final String state,
            final ZipCode zip,
            final CountryCode country,
            final Map<String, String> metadata,
            final String description) {

        super(metadata, description);

        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    protected LobParamsBuilder beginParams() {
        return super.beginParams()
            .put("address_line1", line1)
            .put("address_line2", line2)
            .put("address_city", city)
            .put("address_state", state)
            .put("address_zip", zip)
            .put("address_country", country);
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

    @Override
    public String toString() {
        return
            ", line1='" + line1 + '\'' +
            ", line2='" + line2 + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", country=" + country +
            super.toString() +
            '}';
    }
}

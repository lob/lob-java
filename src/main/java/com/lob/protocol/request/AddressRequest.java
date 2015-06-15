package com.lob.protocol.request;

import com.lob.id.CountryCode;
import com.lob.id.ZipCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.lob.Util.checkNotNull;
import static com.lob.Util.checkPresent;

public class AddressRequest extends AbstractAddressRequest implements HasLobParams {
    private final static int MAX_LENGTH = 50;

    private final String name;
    private final String email;
    private final String phone;

    public AddressRequest(
            final String name,
            final String email,
            final String phone,
            final String line1,
            final String line2,
            final String city,
            final String state,
            final ZipCode zip,
            final CountryCode country,
            final Map<String, String> metadata) {

        super(
            checkNotNull(line1,
            "address_line1 is required"),
            line2,
            city,
            state,
            zip,
            checkNotNull(country, "country is required"),
            metadata);

        this.name = checkPresent(name, "name is required");
        this.email = email;
        this.phone = phone;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams()
            .put("name", name)
            .put("email", email)
            .put("phone", phone)
            .build();
    }

    public static Builder builder() {
        return new Builder();
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

    @Override
    public String toString() {
        return "AddressRequest{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            super.toString();
    }

    public static class Builder {
        private String name;
        private String email;
        private String phone;
        private String line1;
        private String line2;
        private String city;
        private String state;
        private ZipCode zip;
        private CountryCode country;
        private Map<String, String> metadata;

        private Builder() {
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        public Builder line1(final String line1) {
            this.line1 = line1;
            return this;
        }

        public Builder line2(final String line2) {
            this.line2 = line2;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder state(final String state) {
            this.state = state;
            return this;
        }

        public Builder zip(final String zip) {
            this.zip = ZipCode.parse(zip);
            return this;
        }

        public Builder zip(final ZipCode zip) {
            this.zip = zip;
            return this;
        }

        public Builder country(final String country) {
            this.country = CountryCode.parse(country);
            return this;
        }

        public Builder country(final CountryCode country) {
            this.country = country;
            return this;
        }

        public Builder metadata(final Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .name(name)
                .email(email)
                .phone(phone)
                .line1(line1)
                .line2(line2)
                .city(city)
                .state(state)
                .zip(zip)
                .country(country)
                .metadata(metadata);
        }

        public AddressRequest build() {
            return new AddressRequest(name, email, phone, line1, line2, city, state, zip, country, metadata);
        }
    }
}

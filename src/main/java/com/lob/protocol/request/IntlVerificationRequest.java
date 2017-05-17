package com.lob.protocol.request;

import com.lob.id.CountryCode;
import com.lob.id.ZipCode;

import java.util.Collection;

public class IntlVerificationRequest extends AbstractAddressRequest implements HasLobParams {
    public IntlVerificationRequest(
        final String line1,
        final String line2,
        final String city,
        final String state,
        final ZipCode zip,
        final CountryCode country) {

        super(line1, line2, city, state, zip, country, null, null);
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return super.beginParams().build();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "VerifyAddressRequest{" + super.toString();
    }

    public static class Builder {
        private String line1;
        private String line2;
        private String city;
        private String state;
        private ZipCode zip;
        private CountryCode country;

        private Builder() {
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

        public Builder butWith() {
            return new Builder()
                .line1(line1)
                .line2(line2)
                .city(city)
                .state(state)
                .zip(zip)
                .country(country);
        }

        public IntlVerificationRequest build() {
            return new IntlVerificationRequest(line1, line2, city, state, zip, country);
        }
    }
}

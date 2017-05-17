package com.lob.protocol.request;

import com.lob.LobParamsBuilder;

import java.util.Collection;

public class USVerificationRequest implements HasLobParams {

    private final String primary_line;
    private final String secondary_line;
    private final String urbanization;
    private final String city;
    private final String state;
    private final String zipCode;

    public USVerificationRequest(
        final String primary_line,
        final String secondary_line,
        final String urbanization,
        final String city,
        final String state,
        final String zipCode) {

        this.primary_line = primary_line;
        this.secondary_line = secondary_line;
        this.urbanization = urbanization;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public Collection<LobParam> getLobParams() {
        return LobParamsBuilder.create()
            .put("primary_line", primary_line)
            .put("secondary_line", secondary_line)
            .put("urbanization", urbanization)
            .put("city", city)
            .put("state", state)
            .put("zip_code", zipCode)
            .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "USVerificationRequest{" + super.toString() + "}";
    }

    public static class Builder {
        private String primary_line;
        private String secondary_line;
        private String urbanization;
        private String city;
        private String state;
        private String zipCode;

        private Builder() {
        }

        public Builder primary_line(final String primary_line) {
            this.primary_line = primary_line;
            return this;
        }

        public Builder secondary_line(final String secondary_line) {
            this.secondary_line = secondary_line;
            return this;
        }

        public Builder urbanization(final String urbanization) {
            this.urbanization = urbanization;
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

        public Builder zipCode(final String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder butWith() {
            return new Builder()
                .primary_line(primary_line)
                .secondary_line(secondary_line)
                .urbanization(urbanization)
                .city(city)
                .state(state)
                .zipCode(zipCode);
        }

        public USVerificationRequest build() {
            return new USVerificationRequest(primary_line, secondary_line, urbanization, city, state, zipCode);
        }
    }
}

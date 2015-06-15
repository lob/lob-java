package com.lob.id;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CountryCode implements StringValued {
    private final String countryCode;

    public CountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String value() {
        return this.countryCode;
    }

    @JsonCreator
    public static CountryCode parse(final String s) {
        return new CountryCode(s);
    }

    @Override
    public String toString() {
        return this.countryCode;
    }
}

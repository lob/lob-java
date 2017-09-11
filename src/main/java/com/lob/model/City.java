package com.lob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class City {
    @JsonProperty private final String city;
    @JsonProperty private final String state;
    @JsonProperty private final String country;
    @JsonProperty private final String countryFips;
    @JsonProperty private final String object;
    @JsonProperty private final boolean preferred;

    public City(@JsonProperty("city") String city,
                @JsonProperty("state") String state,
                @JsonProperty("country") String country,
                @JsonProperty("country_fips") String countryFips,
                @JsonProperty("preferred") boolean preferred,
                @JsonProperty("object") String object) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.countryFips = countryFips;
        this.preferred = preferred;
        this.object = object;
    }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getCountry() { return country; }

    public String getCountryFips() { return countryFips; }

    public boolean getPreferred() { return preferred; }

    @Override
    public String toString() {
        return "City{" +
                ", city=" + city + + '\'' +
                ", state=" + state + '\'' +
                ", country=" + country + '\'' +
                ", countryFips=" + countryFips + '\'' +
                ", preferred=" + preferred + '\'' +
                ", object=" + object + + '\'' +
                '}';
    }
}

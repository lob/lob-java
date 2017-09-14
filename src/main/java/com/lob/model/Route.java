package com.lob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.lob.net.APIResource.request;

public class Route extends APIResource {
    @JsonProperty private final String route;
    @JsonProperty private final int residential;
    @JsonProperty private final int business;
    @JsonProperty private final int medianIncome;
    @JsonProperty private final int age2024;
    @JsonProperty private final int age2534;
    @JsonProperty private final int age3544;
    @JsonProperty private final int age4554;
    @JsonProperty private final int age5564;
    @JsonProperty private final int age6574;
    @JsonProperty private final int age7584;
    @JsonProperty private final int ageLt19;
    @JsonProperty private final int ageGt85;
    @JsonProperty private final int medianAge;
    @JsonProperty private final int avgHouseholdSize;
    @JsonProperty private final String object;

    public Route(@JsonProperty("route") final String route,
                 @JsonProperty("residential") final int residential,
                 @JsonProperty("business") final int business,
                 @JsonProperty("median_income") final int medianIncome,
                 @JsonProperty("age_20_24") final int age2024,
                 @JsonProperty("age_25_34") final int age2534,
                 @JsonProperty("age_35_44") final int age3544,
                 @JsonProperty("age_45_54") final int age4554,
                 @JsonProperty("age_55_64") final int age5564,
                 @JsonProperty("age_65_74") final int age6574,
                 @JsonProperty("age_75_84") final int age7584,
                 @JsonProperty("age_gt_85") final int ageGt85,
                 @JsonProperty("age_lt_19") final int ageLt19,
                 @JsonProperty("median_age") final int medianAge,
                 @JsonProperty("avg_household_size") final int avgHouseholdSize,
                 @JsonProperty("object") final String object) {
        this.route = route;
        this.residential = residential;
        this.business = business;
        this.medianIncome = medianIncome;
        this.age2024 = age2024;
        this.age2534 = age2534;
        this.age3544 = age3544;
        this.age4554 = age4554;
        this.age5564 = age5564;
        this.age6574 = age6574;
        this.age7584 = age7584;
        this.ageLt19 = ageLt19;
        this.ageGt85 = ageGt85;
        this.medianAge = medianAge;
        this.avgHouseholdSize = avgHouseholdSize;
        this.object = object;
    }

    public String getRoute() { return route; }

    public int getResidential() {
        return residential;
    }

    public int getBusiness() {
        return business;
    }

    public int getMedianIncome() { return medianIncome; }

    public int getAge2534() { return age2534; }

    public int getAge3544() { return age3544; }

    public int getAge4554() { return age4554; }

    public int getAge5564() { return age5564; }

    public int getAge6574() { return age6574; }

    public int getAge7584() { return age7584; }

    public int getAgeLt19() { return ageLt19; }

    public int getAgeGt85() { return ageGt85; }

    public int getMedianAge() { return medianAge; }

    public int getAvgHouseholdSize() { return avgHouseholdSize; }

    @Override
    public String toString() {
        return "Route{" +
                "route='" + route + +'\'' +
                "residential='" + residential + +'\'' +
                "business='" + business + +'\'' +
                "medianIncome='" + medianIncome + '\'' +
                "age2534='" + age2534 + '\'' +
                "age3544='" + age3544 + '\'' +
                "age4554='" + age4554 + '\'' +
                "age5564='" + age5564 + '\'' +
                "age6574='" + age6574 + '\'' +
                "age7584='" + age7584 + '\'' +
                "ageLt19='" + ageLt19 + '\'' +
                "ageGt85='" + ageGt85 + '\'' +
                "medianAge='" + medianAge + '\'' +
                "avgHouseholdSize='" + avgHouseholdSize + '\'' +
                '}';
    }
}

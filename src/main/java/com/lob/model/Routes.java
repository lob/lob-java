package com.lob.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.APIResource;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Routes extends APIResource {

    public static final String RESOURCE = "routes";

    public static class Route {

        @JsonProperty private final String route;
        @JsonProperty private final int residential;
        @JsonProperty private final int business;
        @JsonProperty private final Integer medianIncome;
        @JsonProperty private final Integer age_lt_19;
        @JsonProperty private final Integer age_20_24;
        @JsonProperty private final Integer age_25_34;
        @JsonProperty private final Integer age_35_44;
        @JsonProperty private final Integer age_45_54;
        @JsonProperty private final Integer age_55_64;
        @JsonProperty private final Integer age_65_74;
        @JsonProperty private final Integer age_75_84;
        @JsonProperty private final Integer age_gt_85;
        @JsonProperty private final Integer medianAge;
        @JsonProperty private final Float averageHouseholdSize;
        @JsonProperty private final String object;

        @JsonCreator
        public Route(
                @JsonProperty("route") final String route,
                @JsonProperty("residential") final int residential,
                @JsonProperty("business") final int business,
                @JsonProperty("median_income") final int medianIncome,
                @JsonProperty("age_lt_19") final int age_lt_19,
                @JsonProperty("age_20_24") final int age_20_24,
                @JsonProperty("age_25_34") final int age_25_34,
                @JsonProperty("age_35_44") final int age_35_44,
                @JsonProperty("age_45_54") final int age_45_54,
                @JsonProperty("age_55_64") final int age_55_64,
                @JsonProperty("age_65_74") final int age_65_74,
                @JsonProperty("age_75_84") final int age_75_84,
                @JsonProperty("age_gt_85") final int age_gt_85,
                @JsonProperty("median_age") final int medianAge,
                @JsonProperty("avg_household_size") final Float averageHouseholdSize,
                @JsonProperty("object") final String object) {
            this.route = route;
            this.residential = residential;
            this.business = business;
            this.medianIncome = medianIncome;
            this.age_lt_19 = age_lt_19;
            this.age_20_24 = age_20_24;
            this.age_25_34 = age_25_34;
            this.age_35_44 = age_35_44;
            this.age_45_54 = age_45_54;
            this.age_55_64 = age_55_64;
            this.age_65_74 = age_65_74;
            this.age_75_84 = age_75_84;
            this.age_gt_85 = age_gt_85;
            this.medianAge = medianAge;
            this.averageHouseholdSize = averageHouseholdSize;
            this.object = object;
        }

        public String getRoute() {
            return route;
        }

        public int getResidential() {
            return residential;
        }

        public int getBusiness() {
            return business;
        }

        public Integer getMedianIncome() {
            return medianIncome;
        }

        public Integer getAge_lt_19() {
            return age_lt_19;
        }

        public Integer getAge_20_24() {
            return age_20_24;
        }

        public Integer getAge_25_34() {
            return age_25_34;
        }

        public Integer getAge_35_44() {
            return age_35_44;
        }

        public Integer getAge_45_54() {
            return age_45_54;
        }

        public Integer getAge_55_64() {
            return age_55_64;
        }

        public Integer getAge_65_74() {
            return age_65_74;
        }

        public Integer getAge_75_84() {
            return age_75_84;
        }

        public Integer getAge_gt_85() {
            return age_gt_85;
        }

        public Integer getMedianAge() {
            return medianAge;
        }

        public Float getAverageHouseholdSize() {
            return averageHouseholdSize;
        }

        public String getObject() {
            return object;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "route='" + route + +'\'' +
                    ", residential=" + residential +
                    ", business=" + business +
                    ", medianIncome=" + medianIncome +
                    ", age_lt_19=" + age_lt_19 +
                    ", age_25_34=" + age_25_34 +
                    ", age_35_44=" + age_35_44 +
                    ", age_45_54=" + age_45_54 +
                    ", age_55_64=" + age_55_64 +
                    ", age_65_74=" + age_65_74 +
                    ", age_75_84=" + age_75_84 +
                    ", age_gt_85=" + age_gt_85 +
                    ", medianAge=" + medianAge +
                    ", averageHouseholdSize=" + averageHouseholdSize +
                    ", object='" + object + '\'' +
                    '}';
        }

    }

    @JsonProperty private final String zipCode;
    @JsonProperty private final List<Route> routes;
    @JsonProperty private final String object;

    @JsonCreator
    public Routes(
            @JsonProperty("zip_code") String zipCode,
            @JsonProperty("routes") List<Route> routes,
            @JsonProperty("object") String object) {
        this.zipCode = zipCode;
        this.routes = routes;
        this.object = object;
    }

    public String getZipCode() {
        return zipCode;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "zipCode='" + zipCode + +'\'' +
                ", routes=" + routes +
                ", object='" + object + +'\'' +
                '}';
    }

    public static LobResponse<Routes> retrieve(String route) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(route, null);
    }

    public static LobResponse<Routes> retrieve(String route, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, route), null, Routes.class, options);
    }

    public static LobResponse<RoutesCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static LobResponse<RoutesCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, RoutesCollection.class, options);
    }

}

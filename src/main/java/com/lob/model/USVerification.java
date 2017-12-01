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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USVerification extends APIResource {

    public static final String ENDPOINT = "us_verifications";

    public static class Components {
        @JsonProperty private String primaryNumber;
        @JsonProperty private String streetPredirection;
        @JsonProperty private String streetName;
        @JsonProperty private String streetSuffix;
        @JsonProperty private String streetPostdirection;
        @JsonProperty private String secondaryDesignator;
        @JsonProperty private String secondaryNumber;
        @JsonProperty private String pmbDesignator;
        @JsonProperty private String pmbNumber;
        @JsonProperty private String extraSecondaryDesignator;
        @JsonProperty private String extraSecondaryNumber;
        @JsonProperty private String city;
        @JsonProperty private String state;
        @JsonProperty private String zipCode;
        @JsonProperty private String zipCodePlus4;
        @JsonProperty private String zipCodeType;
        @JsonProperty private String deliveryPointBarcode;
        @JsonProperty private String addressType;
        @JsonProperty private String recordType;
        @JsonProperty private String defaultBuildingAddress;
        @JsonProperty private String county;
        @JsonProperty private String countyFips;
        @JsonProperty private String carrierRoute;
        @JsonProperty private String carrierRouteType;
        @JsonProperty private String latitude;
        @JsonProperty private String longitude;

        @JsonCreator
        public Components(
                @JsonProperty("primary_number") final  String primaryNumber,
                @JsonProperty("street_predirection") final  String streetPredirection,
                @JsonProperty("street_name") final  String streetName,
                @JsonProperty("street_suffix") final String streetSuffix,
                @JsonProperty("street_postdirection") final String streetPostdirection,
                @JsonProperty("secondary_designator") final String secondaryDesignator,
                @JsonProperty("secondary_number") final String secondaryNumber,
                @JsonProperty("pmb_designator") final String pmbDesignator,
                @JsonProperty("pmb_number") final String pmbNumber,
                @JsonProperty("extra_secondary_designator") final String extraSecondaryDesignator,
                @JsonProperty("extra_secondary_number") final String extraSecondaryNumber,
                @JsonProperty("city") final String city,
                @JsonProperty("state") final String state,
                @JsonProperty("zip_code") final String zipCode,
                @JsonProperty("zip_code_plus_4") final String zipCodePlus4,
                @JsonProperty("zip_code_type") final String zipCodeType,
                @JsonProperty("delivery_point_barcode") final String deliveryPointBarcode,
                @JsonProperty("address_type") final String addressType,
                @JsonProperty("record_type") final String recordType,
                @JsonProperty("default_building_address") final String defaultBuildingAddress,
                @JsonProperty("county") final String county,
                @JsonProperty("county_fips") final String countyFips,
                @JsonProperty("carrier_route") final String carrierRoute,
                @JsonProperty("carrier_route_type") final String carrierRouteType,
                @JsonProperty("latitude") final String latitude,
                @JsonProperty("longitude") final String longitude) {
            this.primaryNumber = primaryNumber;
            this.streetPredirection = streetPredirection;
            this.streetName = streetName;
            this.streetSuffix = streetSuffix;
            this.streetPostdirection = streetPostdirection;
            this.secondaryDesignator = secondaryDesignator;
            this.secondaryNumber = secondaryNumber;
            this.pmbDesignator = pmbDesignator;
            this.pmbNumber = pmbNumber;
            this.extraSecondaryDesignator = extraSecondaryDesignator;
            this.extraSecondaryNumber = extraSecondaryNumber;
            this.city = city;
            this.state = state;
            this.zipCode = zipCode;
            this.zipCodePlus4 = zipCodePlus4;
            this.zipCodeType = zipCodeType;
            this.deliveryPointBarcode = deliveryPointBarcode;
            this.addressType = addressType;
            this.recordType = recordType;
            this.defaultBuildingAddress = defaultBuildingAddress;
            this.county = county;
            this.countyFips = countyFips;
            this.carrierRoute = carrierRoute;
            this.carrierRouteType = carrierRouteType;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getPrimaryNumber() {
            return primaryNumber;
        }

        public String getStreetPredirection() {
            return streetPredirection;
        }

        public String getStreetName() {
            return streetName;
        }

        public String getStreetSuffix() {
            return streetSuffix;
        }

        public String getStreetPostdirection() {
            return streetPostdirection;
        }

        public String getSecondaryDesignator() {
            return secondaryDesignator;
        }

        public String getSecondaryNumber() {
            return secondaryNumber;
        }

        public String getPmbDesignator() {
            return pmbDesignator;
        }

        public String getPmbNumber() {
            return pmbNumber;
        }

        public String getExtraSecondaryDesignator() {
            return extraSecondaryDesignator;
        }

        public String getExtraSecondaryNumber() {
            return extraSecondaryNumber;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public String getZipCodePlus4() {
            return zipCodePlus4;
        }

        public String getZipCodeType() {
            return zipCodeType;
        }

        public String getDeliveryPointBarcode() {
            return deliveryPointBarcode;
        }

        public String getAddressType() {
            return addressType;
        }

        public String getRecordType() {
            return recordType;
        }

        public String getDefaultBuildingAddress() {
            return defaultBuildingAddress;
        }

        public String getCounty() {
            return county;
        }

        public String getCountyFips() {
            return countyFips;
        }

        public String getCarrierRoute() {
            return carrierRoute;
        }

        public String getCarrierRouteType() {
            return carrierRouteType;
        }

        public String getLatitude() {
            return latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        @Override
        public String toString() {
            return "{" +
                    "primaryNumber='" + primaryNumber + '\'' +
                    ", streetPredirection='" + streetPredirection + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", streetSuffix='" + streetSuffix + '\'' +
                    ", streetPostdirection='" + streetPostdirection + '\'' +
                    ", secondaryDesignator='" + secondaryDesignator + '\'' +
                    ", secondaryNumber='" + secondaryNumber + '\'' +
                    ", pmbDesignator='" + pmbDesignator + '\'' +
                    ", pmbNumber='" + pmbNumber + '\'' +
                    ", extraSecondaryDesignator='" + extraSecondaryDesignator + '\'' +
                    ", extraSecondaryNumber='" + extraSecondaryNumber + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", zipCodePlus4='" + zipCodePlus4 + '\'' +
                    ", zipCodeType='" + zipCodeType + '\'' +
                    ", deliveryPointBarcode='" + deliveryPointBarcode + '\'' +
                    ", addressType='" + addressType + '\'' +
                    ", recordType='" + recordType + '\'' +
                    ", defaultBuildingAddress='" + defaultBuildingAddress + '\'' +
                    ", county='" + county + '\'' +
                    ", countyFips='" + countyFips + '\'' +
                    ", carrierRoute='" + carrierRoute + '\'' +
                    ", carrierRouteType='" + carrierRouteType + '\'' +
                    ", latitude='" + latitude + '\'' +
                    ", longitude='" + longitude + '\'' +
                    '}';
        }

    }

    public static class Deliverability {
        @JsonProperty private String dpvConfirmation;
        @JsonProperty private String dpvCmra;
        @JsonProperty private String dpvVacant;
        @JsonProperty private List<String> dpvFootnotes;
        @JsonProperty private String ewsMatch;
        @JsonProperty private String lacsIndicator;
        @JsonProperty private String lacsReturnCode;
        @JsonProperty private String suiteReturnCode;

        @JsonCreator
        public Deliverability(
                @JsonProperty("dpv_confirmation") final  String dpvConfirmation,
                @JsonProperty("dpv_cmra") final  String dpvCmra,
                @JsonProperty("dpv_vacant") final String dpvVacant,
                @JsonProperty("dpv_footnotes") final List<String> dpvFootnotes,
                @JsonProperty("ews_match") final String ewsMatch,
                @JsonProperty("lacs_indicator") final String lacsIndicator,
                @JsonProperty("lacs_return_code") final String lacsReturnCode,
                @JsonProperty("suite_return_code") final String suiteReturnCode) {
            this.dpvConfirmation = dpvConfirmation;
            this.dpvCmra = dpvCmra;
            this.dpvVacant = dpvVacant;
            this.dpvFootnotes = dpvFootnotes;
            this.ewsMatch = ewsMatch;
            this.lacsIndicator = lacsIndicator;
            this.lacsReturnCode = lacsReturnCode;
            this.suiteReturnCode = suiteReturnCode;
        }

        public String getDpvConfirmation() {
            return dpvConfirmation;
        }

        public String getDpvCmra() {
            return dpvCmra;
        }

        public String getDpvVacant() {
            return dpvVacant;
        }

        public List<String> getDpvFootnotes() {
            return dpvFootnotes;
        }

        public String getEwsMatch() {
            return ewsMatch;
        }

        public String getLacsIndicator() {
            return lacsIndicator;
        }

        public String getLacsReturnCode() {
            return lacsReturnCode;
        }

        public String getSuiteReturnCode() {
            return suiteReturnCode;
        }

        @Override
        public String toString() {
            return "{" +
                    "dpvConfirmation='" + dpvConfirmation + '\'' +
                    ", dpvCmra='" + dpvCmra + '\'' +
                    ", dpvVacant='" + dpvVacant + '\'' +
                    ", dpvFootnotes='" + dpvFootnotes + '\'' +
                    ", ewsMatch='" + ewsMatch + '\'' +
                    ", lacsIndicator='" + lacsIndicator + '\'' +
                    ", lacsReturnCode='" + lacsReturnCode + '\'' +
                    ", suiteReturnCode='" + suiteReturnCode + '\'' +
                    '}';
        }

    }

    @JsonProperty private final String id;
    @JsonProperty private final String recipient;
    @JsonProperty private final String primaryLine;
    @JsonProperty private final String secondaryLine;
    @JsonProperty private final String urbanization;
    @JsonProperty private final String lastLine;
    @JsonProperty private final String deliverability;
    @JsonProperty private final Components components;
    @JsonProperty private final Deliverability deliverabilityAnalysis;
    @JsonProperty private final String object;

    @JsonCreator
    public USVerification(
            @JsonProperty("id") final String id,
            @JsonProperty("recipient") final String recipient,
            @JsonProperty("primary_line") final String primaryLine,
            @JsonProperty("secondary_line") final String secondaryLine,
            @JsonProperty("urbanization") final String urbanization,
            @JsonProperty("last_line") final String lastLine,
            @JsonProperty("deliverability") final String deliverability,
            @JsonProperty("components") final Components components,
            @JsonProperty("deliverability_analysis") final Deliverability deliverabilityAnalysis,
            @JsonProperty("object") final String object
    ) {
        this.id = id;
        this.recipient = recipient;
        this.primaryLine = primaryLine;
        this.secondaryLine = secondaryLine;
        this.urbanization = urbanization;
        this.lastLine = lastLine;
        this.deliverability = deliverability;
        this.components = components;
        this.deliverabilityAnalysis = deliverabilityAnalysis;
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getPrimaryLine() {
        return primaryLine;
    }

    public String getSecondaryLine() {
        return secondaryLine;
    }

    public String getUrbanization() {
        return urbanization;
    }

    public String getLastLine() {
        return lastLine;
    }

    public String getDeliverability() {
        return deliverability;
    }

    public Components getComponents() {
        return components;
    }

    public Deliverability getDeliverabilityAnalysis() {
        return deliverabilityAnalysis;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "USVerification{" +
                "id='" + id + '\'' +
                ", recipient='" + recipient + '\'' +
                ", primaryLine='" + primaryLine + '\'' +
                ", secondaryLine='" + secondaryLine + '\'' +
                ", urbanization='" + urbanization + '\'' +
                ", lastLine='" + lastLine + '\'' +
                ", deliverability='" + deliverability + '\'' +
                ", components=" + components +
                ", deliverabilityAnalysis=" + deliverabilityAnalysis +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();

        public RequestBuilder() {
        }

        public RequestBuilder setRecipient(String recipient) {
            params.put("recipient", recipient);
            return this;
        }

        public RequestBuilder setPrimaryLine(String primaryLine) {
            params.put("primary_line", primaryLine);
            return this;
        }

        public RequestBuilder setSecondaryLine(String secondaryLine) {
            params.put("secondary_line", secondaryLine);
            return this;
        }

        public RequestBuilder setUrbanization(String urbanization) {
            params.put("urbanization", urbanization);
            return this;
        }

        public RequestBuilder setCity(String city) {
            params.put("city", city);
            return this;
        }

        public RequestBuilder setState(String state) {
            params.put("state", state);
            return this;
        }

        public RequestBuilder setZipCode(String zipCode) {
            params.put("zip_code", zipCode);
            return this;
        }

        public LobResponse<USVerification> verify() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return verify(null);
        }

        public LobResponse<USVerification> verify(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            return request(RequestMethod.POST, RequestType.NORMAL, ENDPOINT, params, USVerification.class, options);
        }
    }

}

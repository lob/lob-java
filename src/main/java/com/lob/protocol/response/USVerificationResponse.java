package com.lob.protocol.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;

import java.util.Collection;

public class USVerificationResponse extends AbstractResponse {

    public static class Components {
        private String primaryNumber;
        private String streetPredirection;
        private String streetName;
        private String streetSuffix;
        private String streetPostdirection;
        private String secondaryDesignator;
        private String secondaryNumber;
        private String pmbDesignator;
        private String pmbNumber;
        private String extraSecondaryInformation;
        private String city;
        private String state;
        private String zipCode;
        private String zipCodePlus4;
        private String zipCodeType;
        private String deliveryPointBarcode;
        private String addressType;
        private String recordType;
        private String defaultBuildingAddress;
        private String county;
        private String countyFips;
        private String carrierRoute;
        private String carrierRouteType;
        private String latitude;
        private String longitude;

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
            @JsonProperty("extra_secondary_information") final String extraSecondaryInformation,
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
            @JsonProperty("longitude") final String longitude
        ) {
            this.primaryNumber = primaryNumber;
            this.streetPredirection = streetPredirection;
            this.streetName = streetName;
            this.streetSuffix = streetSuffix;
            this.streetPostdirection = streetPostdirection;
            this.secondaryDesignator = secondaryDesignator;
            this.secondaryNumber = secondaryNumber;
            this.pmbDesignator = pmbDesignator;
            this.pmbNumber = pmbNumber;
            this.extraSecondaryInformation = extraSecondaryInformation;
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

        public String getExtraSecondaryInformation() {
            return extraSecondaryInformation;
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
    }

    public static class Deliverability {
        private String dpvConfirmation;
        private String dpvCmra;
        private String dpvVacant;
        private Collection<String> dpvFootnotes;
        private String ewsMatch;
        private String lacsIndicator;
        private String lacsReturnCode;
        private String suiteReturnCode;

        @JsonCreator
        public Deliverability(
            @JsonProperty("dpv_confirmation") final  String dpvConfirmation,
            @JsonProperty("dpv_cmra") final  String dpvCmra,
            @JsonProperty("dpv_vacant") final String dpvVacant,
            @JsonProperty("dpv_footnotes") final Collection<String> dpvFootnotes,
            @JsonProperty("ews_match") final String ewsMatch,
            @JsonProperty("lacs_indicator") final String lacsIndicator,
            @JsonProperty("lacs_return_code") final String lacsReturnCode,
            @JsonProperty("suite_return_code") final String suiteReturnCode
        ) {
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

        public Collection<String> getDpvFootnotes() {
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
    public USVerificationResponse(
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
}

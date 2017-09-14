package com.lob.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeliverabilityAnalysis {
    @JsonProperty private final String dpvConfirmation;
    @JsonProperty private final String dpvCmra;
    @JsonProperty private final String dpvVacant;
    @JsonProperty private final List<String> dpvFootnotes;
    @JsonProperty private final boolean ewsMatch;
    @JsonProperty private final String lacsIndicator;
    @JsonProperty private final String lacsReturnCode;
    @JsonProperty private final String suiteReturnCode;

    public DeliverabilityAnalysis(@JsonProperty("dpv_confirmation") final String dpvConfirmation,
            @JsonProperty("dpv_cmra") final String dpvCmra,
            @JsonProperty("dpv_vacant") final String dpvVacant,
            @JsonProperty("dpv_footnotes") final List<String> dpvFootnotes,
            @JsonProperty("ews_match") final boolean ewsMatch,
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

    public boolean isEwsMatch() {
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
        return "DeliverabilityAnalysis{" +
                "dpvConfirmation=" + dpvConfirmation + + '\'' +
                "dpvCmra=" + dpvCmra + + '\'' +
                "dpvVacant=" + dpvVacant + + '\'' +
                "dpvFootnotes=" + dpvFootnotes + + '\'' +
                "ewsMatch=" + ewsMatch + + '\'' +
                "lacsIndicator=" + lacsIndicator + + '\'' +
                "lacsReturnCode=" + lacsReturnCode + + '\'' +
                "suiteReturnCode=" + suiteReturnCode + + '\'' +
                '}';
    }
}

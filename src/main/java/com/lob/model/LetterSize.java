package com.lob.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The size of paper on which to print the letter. 
 * Note that size A4 is only available for Lob accounts with the feature enabled. 
 */
public enum LetterSize {
    US_LETTER("us_letter"),
    A4("A4");

    private String value;
    
    private LetterSize(String value) {
        this.value = value;
    }
    
    @JsonValue
    public String value() {
        return this.value;
    }
}

package com.lob.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RateLimitException extends LobException {

    @JsonCreator
    public RateLimitException(@JsonProperty("error") final Map<String, Object> error) {
        super((String)error.get("message"), (Integer)error.get("status_code"));
    }

}

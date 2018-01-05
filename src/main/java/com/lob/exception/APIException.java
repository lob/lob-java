package com.lob.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class APIException extends LobException {

    private static final long serialVersionUID = 1L;

    @JsonCreator
    public APIException(@JsonProperty("error") final Map<String, Object> error) {
        super((String)error.get("message"), (Integer)error.get("status_code"));
    }

}

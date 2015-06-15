package com.lob;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String val = jsonParser.getValueAsString();
        if (val.equals("0")) {
            return false;
        }
        if (val.equals("1")) {
            return true;
        }
        if (val.toLowerCase().equals("false")) {
            return false;
        }
        if (val.toLowerCase().equals("true")) {
            return true;
        }
        return false;
    }
}

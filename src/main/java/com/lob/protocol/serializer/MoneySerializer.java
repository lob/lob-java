package com.lob.protocol.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.Money;

import java.io.IOException;

public class MoneySerializer extends JsonSerializer<Money>
{
    @Override
    public void serialize(Money value, JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        jgen.writeString(String.valueOf(value.getAmount()));
    }

}

package com.lob.protocol.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;

public class DateTimeSerializer extends JsonSerializer<DateTime>
{
    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        jgen.writeString(value.toString());
    }

}

package com.lob.protocol.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.lob.id.StringValued;

import java.io.IOException;

public class StringValuedSerializer extends JsonSerializer<StringValued>
{
    @Override
    public void serialize(StringValued value, JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        jgen.writeString(value.value());
    }

}

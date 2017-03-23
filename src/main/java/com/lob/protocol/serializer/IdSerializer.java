package com.lob.protocol.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.lob.id.LobId;

import java.io.IOException;

public class IdSerializer extends JsonSerializer<LobId>
{
    @Override
    public void serialize(LobId value, JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        jgen.writeString(value.value());
    }

}

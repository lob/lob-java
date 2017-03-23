package com.lob.id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lob.protocol.serializer.StringValuedSerializer;

@JsonSerialize(using = StringValuedSerializer.class)
public interface StringValued {
    public String value();
}

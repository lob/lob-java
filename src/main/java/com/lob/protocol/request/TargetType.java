package com.lob.protocol.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lob.id.StringValued;

import java.util.HashMap;
import java.util.Map;

public enum TargetType implements StringValued {
    ALL("all"),
    RESIDENTIAL("residential");

    private final static Map<String, TargetType> stringMap = new HashMap<String, TargetType>();
    static {
        for (final TargetType targetType : TargetType.values()) {
            stringMap.put(targetType.value(), targetType);
        }
    }

    private final String value;

    TargetType(final String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }

    @JsonCreator
    public static TargetType parse(final String s) {
        return stringMap.get(s);
    }
}

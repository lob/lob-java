package com.lob.protocol.request;

import java.util.Map;

public class Filters {
    public static Filter ofLimit(final int limit) {
        return new Filter(limit, null, null);
    }

    public static Filter ofOffset(final int offset) {
        return new Filter(null, offset, null);
    }

    public static Filter ofMetadata(final Map<String, String> metadata) {
        return new Filter(null, null, metadata);
    }
}

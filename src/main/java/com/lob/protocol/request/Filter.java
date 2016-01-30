package com.lob.protocol.request;

import java.util.Map;

public class Filter {
    private Integer limit;
    private Integer offset;
    private Map<String, String> metadata;

    public Filter(final Integer count, final Integer offset, final Map<String, String> metadata) {
        this.limit = count;
        this.offset = offset;
        this.metadata = metadata;
    }

    public Filter withLimit(final int limit) {
        this.limit = limit;
        return this;
    }

    public Filter withOffset(final int offset) {
        this.offset = offset;
        return this;
    }

    public Filter withMetadata(final Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "Filter{" +
            "limit=" + limit +
            ", offset=" + offset +
            ", metadata=" + metadata +
            '}';
    }
}

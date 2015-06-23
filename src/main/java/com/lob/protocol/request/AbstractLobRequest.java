package com.lob.protocol.request;

import com.lob.LobParamsBuilder;

import java.util.Map;

public abstract class AbstractLobRequest {
    private final Map<String, String> metadata;
    private final String description;

    public AbstractLobRequest(final Map<String, String> metadata, final String description) {
        this.metadata = metadata;
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public String getDescription() {
        return description;
    }

    protected LobParamsBuilder beginParams() {
        return LobParamsBuilder.create()
            .putMap("metadata", metadata)
            .put("description", description);
    }

    @Override
    public String toString() {
        return ", metadata=" + metadata +
            ", description=" + description +
            '}';
    }

    public static abstract class Builder<B extends Builder<B>> {
        protected Map<String, String> metadata;
        protected String description;

        public B metadata(final Map<String, String> metadata) {
            this.metadata = metadata;
            return (B)this;
        }

        public B description(final String description) {
            this.description = description;
            return (B)this;
        }
    }
}

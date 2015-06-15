package com.lob.protocol.request;

import com.lob.LobParamsBuilder;

import java.util.Map;

public abstract class AbstractLobRequest {
    private final Map<String, String> metadata;

    public AbstractLobRequest(final Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    protected LobParamsBuilder beginParams() {
        return LobParamsBuilder.create()
            .putMap("metadata", metadata);
    }

    @Override
    public String toString() {
        return ", metadata=" + metadata +
            '}';
    }
}

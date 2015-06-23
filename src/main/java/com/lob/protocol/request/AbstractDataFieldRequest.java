package com.lob.protocol.request;

import com.lob.LobParamsBuilder;

import java.util.Map;

public abstract class AbstractDataFieldRequest extends AbstractLobRequest {
    private final Map<String, String> data;

    public AbstractDataFieldRequest(
            final Map<String, String> metadata,
            final Map<String, String> data,
            final String description) {
        super(metadata, description);
        this.data = data;
    }

    public Map<String, String> getData() {
        return data;
    }

    @Override
    protected LobParamsBuilder beginParams() {
        return super.beginParams().putMap("data", this.data);
    }

    @Override
    public String toString() {
        return ", data=" + data + super.toString();
    }

    public static abstract class Builder<B extends Builder<B>> extends AbstractLobRequest.Builder<B> {
        protected Map<String, String> data;

        public B data(final Map<String, String> data) {
            this.data = data;
            return (B)this;
        }
    }
}

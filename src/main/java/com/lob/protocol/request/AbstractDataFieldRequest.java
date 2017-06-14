package com.lob.protocol.request;

import com.lob.LobParamsBuilder;

import java.util.Map;

public abstract class AbstractDataFieldRequest extends AbstractLobRequest {
    private final Map<String, String> mergeVariables;

    public AbstractDataFieldRequest(
            final Map<String, String> metadata,
            final Map<String, String> mergeVariables,
            final String description) {
        super(metadata, description);
        this.mergeVariables = mergeVariables;
    }

    public Map<String, String> getData() {
        return mergeVariables;
    }

    @Override
    protected LobParamsBuilder beginParams() {
        return super.beginParams().putMap("merge_variables", this.mergeVariables);
    }

    @Override
    public String toString() {
        return ", mergeVariables=" + mergeVariables + super.toString();
    }

    public static abstract class Builder<B extends Builder<B>> extends AbstractLobRequest.Builder<B> {
        protected Map<String, String> mergeVariables;

        public B mergeVariables(final Map<String, String> mergeVariables) {
            this.mergeVariables = mergeVariables;
            return (B)this;
        }
    }
}

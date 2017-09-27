package com.lob.net;

import com.lob.Lob;

public class RequestOptions {
    public static RequestOptions getDefault() {
        return new RequestOptions(Lob.apiKey, Lob.apiVersion, null);
    }

    private final String apiKey;
    private final String lobVersion;
    private final String idempotencyKey;

    private RequestOptions(String apiKey, String lobVersion, String idempotencyKey) {
        this.apiKey = apiKey;
        this.lobVersion = lobVersion;
        this.idempotencyKey = idempotencyKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getLobVersion() {
        return lobVersion;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RequestOptions that = (RequestOptions) o;

        if (apiKey != null ? !apiKey.equals(that.apiKey) : that.apiKey != null) {
            return false;
        }

        if (idempotencyKey != null ? !idempotencyKey.equals(that.idempotencyKey) : that.idempotencyKey != null) {
            return false;
        }

        if (lobVersion != null ? !lobVersion.equals(that.lobVersion) : that.lobVersion != null) {
            return false;
        }

        return true;
    }

    public static final class Builder {
        private String apiKey;
        private String lobVersion;
        private String idempotencyKey;

        public Builder() {
            this.apiKey = Lob.apiKey;
            this.lobVersion = Lob.apiVersion;
        }

        public String getApiKey() {
            return this.apiKey;
        }

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder setLobVersion(String lobVersion) {
            this.lobVersion = lobVersion;
            return this;
        }

        public String getLobVersion() {
            return this.lobVersion;
        }

        public Builder setIdempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public String getIdempotencyKey() {
            return this.idempotencyKey;
        }

        public RequestOptions build() {
            return new RequestOptions(this.apiKey, this.lobVersion, this.idempotencyKey);
        }
    }

}

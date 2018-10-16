package com.lob.net;

import java.net.Proxy;
import java.util.Objects;

import com.lob.Lob;

public class RequestOptions {
    public static RequestOptions getDefault() {
        return new RequestOptions(Lob.apiKey, Lob.apiVersion, null, null);
    }

    private final String apiKey;
    private final String lobVersion;
    private final String idempotencyKey;
    private final Proxy proxy;

    private RequestOptions(String apiKey, String lobVersion, String idempotencyKey, Proxy proxy) {
        this.apiKey = apiKey;
        this.lobVersion = lobVersion;
        this.idempotencyKey = idempotencyKey;
        this.proxy = proxy;
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
    
    public Proxy getProxy() {
    	return proxy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o instanceof RequestOptions) {
            RequestOptions that = (RequestOptions) o;
            
            if (!Objects.equals(this.apiKey, that.getApiKey())) {
                return false;
            }
            
            if (!Objects.equals(this.lobVersion, that.getLobVersion())) {
                return false;
            }
    
            if (!Objects.equals(this.idempotencyKey, that.getIdempotencyKey())) {
                return false;
            }       
            
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(apiKey, lobVersion, idempotencyKey);
    }    

    public static final class Builder {
        private String apiKey;
        private String lobVersion;
        private String idempotencyKey;
        private Proxy proxy;

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
        
        public Builder setProxy(Proxy proxy) {
        	this.proxy = proxy;
        	return this;
        }
        
        public Proxy getProxy() {
        	return this.proxy;
        }

        public RequestOptions build() {
            return new RequestOptions(this.apiKey, this.lobVersion, this.idempotencyKey, this.proxy);
        }
    }

}

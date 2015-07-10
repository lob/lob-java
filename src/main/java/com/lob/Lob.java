package com.lob;

import com.google.common.base.Optional;

public final class Lob {
    private static String BASE_URL = "https://api.lob.com/v1/";
    private static Optional<String> API_VERSION = Optional.absent();

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static void setBaseUrl(final String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static Optional<String> getApiVersion() {
        return API_VERSION;
    }

    public static void setApiVersion(final String apiVersion) {
        API_VERSION = Optional.of(apiVersion);
    }

    public static void clearApiVersion() {
        API_VERSION = Optional.absent();
    }
}

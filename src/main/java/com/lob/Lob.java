package com.lob;

public class Lob {

    public static final String API_BASE_URL = "https://api.lob.com/v1/";
    public static final String VERSION = "7.0.0";

    public static String apiKey;
    public static String apiVersion;

    public static void init(final String apiKey) {
        Lob.apiKey = apiKey;
        Lob.apiVersion = null;
    }

    public static void init(final String apiKey, final String apiVersion) {
        Lob.apiKey = apiKey;
        Lob.apiVersion = apiVersion;
    }

}

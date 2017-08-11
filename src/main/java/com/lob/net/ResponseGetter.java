package com.lob.net;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.Lob;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import org.apache.commons.codec.binary.Base64;

import static com.lob.net.APIResource.CHARSET;
import static com.lob.net.APIResource.RequestMethod.*;

public class ResponseGetter implements IResponseGetter {

    private final static ObjectMapper MAPPER = new ObjectMapper().registerModule(new JodaModule());

    private final static class Parameter {
        public final String key;
        public final String value;

        public Parameter(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public <T> LobResponse request(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            Class<T> clazz,
            APIResource.RequestType type,
            RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        return _request(method, url, params, clazz, type, options);
    }

    static Map<String, String> getHeaders(RequestOptions options) {
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Authorization", String.format("Basic %s", Base64.encodeBase64String((options.getApiKey() + ":").getBytes())));
        headers.put("User-Agent", String.format("LobJava/%s JDK/%s", Lob.VERSION, System.getProperty("java.version")));

        if (options.getLobVersion() != null) {
            headers.put("Lob-Version", options.getLobVersion());
        }

        if (options.getIdempotencyKey() != null) {
            headers.put("Idempotency-Key", options.getIdempotencyKey());
        }

        return headers;
    }

    private static java.net.HttpURLConnection createDefaultConnection(String url, RequestOptions options) throws IOException {
        URL lobURL = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) lobURL.openConnection();
        conn.setUseCaches(false);
        for (Map.Entry<String, String> header : getHeaders(options).entrySet()) {
            conn.setRequestProperty(header.getKey(), header.getValue());
        }

        return conn;
    }

    private static java.net.HttpURLConnection createGetConnection(String url, String query, RequestOptions options) throws IOException {
        String getURL = query.isEmpty() ? url : String.format("%s?%s", url, query);
        java.net.HttpURLConnection conn = createDefaultConnection(getURL, options);

        conn.setRequestMethod("GET");

        return conn;
    }

    private static java.net.HttpURLConnection createPostConnection(String url, String query, RequestOptions options) throws IOException {
        java.net.HttpURLConnection conn = createDefaultConnection(url, options);

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", String.format("application/x-www-form-urlencoded;charset=%s", APIResource.CHARSET));

        OutputStream output = null;
        try {
            output = conn.getOutputStream();
            output.write(query.getBytes(APIResource.CHARSET));
        } finally {
            if (output != null) {
                output.close();
            }
        }
        return conn;
    }

    private static java.net.HttpURLConnection createDeleteConnection(String url, RequestOptions options) throws IOException {
        java.net.HttpURLConnection conn = createDefaultConnection(url, options);

        conn.setRequestMethod("DELETE");

        return conn;
    }

    static String createQuery(Map<String, Object> params) throws UnsupportedEncodingException {
        if (params == null) {
            return "";
        }

        StringBuilder queryStringBuffer = new StringBuilder();
        List<Parameter> flatParams = flattenParams(params);
        Iterator<Parameter> it = flatParams.iterator();

        while (it.hasNext()) {
            if (queryStringBuffer.length() > 0) {
                queryStringBuffer.append("&");
            }
            Parameter param = it.next();
            queryStringBuffer.append(urlEncodePair(param.key, param.value));
        }

        return queryStringBuffer.toString();
    }

    private static String urlEncodePair(String key, String value) throws UnsupportedEncodingException {
        return String.format("%s=%s", URLEncoder.encode(key, CHARSET), URLEncoder.encode(value, CHARSET));
    }

    private static List<Parameter> flattenParams(Map<String, Object> params) {
        return flattenParamsMap(params, null);
    }

    private static List<Parameter> flattenParamsMap(Map<String, Object> params, String keyPrefix) {
        List<Parameter> flatParams = new LinkedList<Parameter>();
        if (params == null) {
            return flatParams;
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            String newPrefix = key;
            if (keyPrefix != null) {
                newPrefix = String.format("%s[%s]", keyPrefix, key);
            }

            flatParams.addAll(flattenParamsValue(value, newPrefix));
        }

        return flatParams;
    }

    private static List<Parameter> flattenParamsValue(Object value, String keyPrefix) {
        List<Parameter> flatParams;

        if (value instanceof Map<?, ?>) {
            flatParams = flattenParamsMap((Map<String, Object>) value, keyPrefix);
        } else {
            flatParams = new LinkedList<>();
            flatParams.add(new Parameter(keyPrefix, value.toString()));
        }

        return flatParams;
    }

    private static <T> LobResponse makeURLConnectionRequest(APIResource.RequestMethod method, Class<T> clazz, String url, String query, RequestOptions options) throws APIException, RateLimitException, InvalidRequestException, IOException {
        java.net.HttpURLConnection conn = null;
        try {
            if (method == POST) {
                conn = createPostConnection(url, query, options);
            } else if (method == DELETE) {
                conn = createDeleteConnection(url, options);
            } else {
                conn = createGetConnection(url, query, options);
            }

            int responseCode = conn.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) {
                Map<String, List<String>> headers = conn.getHeaderFields();
                T value = MAPPER.readValue(conn.getInputStream(), clazz);

                return new LobResponse<T>(responseCode, value, headers);
            } else if (responseCode == 422) {
                throw MAPPER.readValue(conn.getErrorStream(), InvalidRequestException.class);
            } else if (responseCode == 429) {
                throw MAPPER.readValue(conn.getErrorStream(), RateLimitException.class);
            } else {
                throw MAPPER.readValue(conn.getErrorStream(), APIException.class);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static <T> LobResponse _request(APIResource.RequestMethod method,
                                  String url, Map<String, Object> params, Class<T> clazz,
                                  APIResource.RequestType type, RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        if (options == null) {
            options = RequestOptions.getDefault();
        }

        String apiKey = options.getApiKey();
        if (apiKey == null || apiKey.trim().length() == 0) {
            throw new AuthenticationException("Missing API Key. Make sure 'Lob.init(<API_KEY>)' is called with a key from your Dashboard.", null);
        }

        String lobURL = String.format("%s%s", Lob.API_BASE_URL, url);
        String query = createQuery(params);

        return makeURLConnectionRequest(method, clazz, lobURL, query, options);
    }

}

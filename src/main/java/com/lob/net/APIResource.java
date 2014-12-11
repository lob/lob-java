package com.lob.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lob.Lob;
import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.model.LobObject;

public abstract class APIResource extends LobObject {

    public static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    private static String className(Class<?> clazz) {
        return clazz.getSimpleName().toLowerCase().replace("$", "");
    }

    protected static String singleClassURL(Class<?> clazz) {
        if (className(clazz).contains("country"))
            return String.format("%s/v1/countrie", Lob.API_BASE, className(clazz));
        else
            return String.format("%s/v1/%s", Lob.API_BASE, className(clazz));
    }


    protected static String classURL(Class<?> clazz) {
        if (className(clazz).contains("address"))
            return String.format("%ses", singleClassURL(clazz));
        else
            return String.format("%ss", singleClassURL(clazz));
    }

    protected static String instanceURL(Class<?> clazz, String id) {
        return String.format("%s/%s", classURL(clazz), id);
    }

    public static final String CHARSET = "UTF-8";

    private static final String DNS_CACHE_TTL_PROPERTY_NAME = "networkaddress.cache.ttl";

    protected enum RequestMethod {
        GET, POST, DELETE
    }

    private static String urlEncodePair(String k, String v)
            throws UnsupportedEncodingException {
        return String.format("%s=%s", URLEncoder.encode(k, CHARSET),
                URLEncoder.encode(v, CHARSET));
    }

    static Map<String, String> getHeaders(String apiKey) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept-Charset", CHARSET);
        headers.put("User-Agent",
                String.format("Lob/v1 JavaBindings/%s", Lob.VERSION));

        if (apiKey == null) {
            apiKey = Lob.apiKey;
        }

        if (!apiKey.endsWith(":"))
            apiKey = apiKey + ":";

        headers.put("Authorization", "Basic " + apiKey);

        // debug headers
/*      String[] propertyNames = { "os.name", "os.version", "os.arch",
                "java.version", "java.vendor", "java.vm.version",
                "java.vm.vendor" };
        Map<String, String> propertyMap = new HashMap<String, String>();
        for (String propertyName : propertyNames) {
            propertyMap.put(propertyName, System.getProperty(propertyName));
        }
        propertyMap.put("bindings.version", Lob.VERSION);
        propertyMap.put("lang", "Java");
        propertyMap.put("publisher", "Lob");
        headers.put("X-Lob-Client-User-Agent", gson.toJson(propertyMap));
        if (Lob.apiVersion != null) {
            headers.put("Lob-Version", Lob.apiVersion);
        }
*/      return headers;
    }

    private static javax.net.ssl.HttpsURLConnection createLobConnection(
            String url, String apiKey) throws IOException {
        URL lobURL = new URL(url);

        javax.net.ssl.HttpsURLConnection conn = (javax.net.ssl.HttpsURLConnection) lobURL
                .openConnection(); // enforce
                                    // SSL
                                    // URLs
        conn.setConnectTimeout(30000); // 30 seconds
        conn.setReadTimeout(80000); // 80 seconds
        conn.setUseCaches(false);

        if (!apiKey.endsWith(":"))
            apiKey = apiKey + ":";

        byte[] authEncBytes = org.apache.commons.codec.binary.Base64.encodeBase64(apiKey.getBytes());
        String authStringEnc = new String(authEncBytes);

        conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

        return conn;
    }

    private static javax.net.ssl.HttpsURLConnection createGetConnection(
            String url, String query, String apiKey) throws IOException {
        String getURL;
        if (query != "")
            getURL = String.format("%s?%s", url, query);
        else
            getURL = url;

        javax.net.ssl.HttpsURLConnection conn = createLobConnection(getURL,
                apiKey);
        conn.setRequestMethod("GET");
        return conn;
    }

    private static HttpResponse createPostConnection(
            String url, String query, String apiKey, Map<String, Object> params) throws IOException {

        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(url);

        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

            Map<String, String> flatParams = flattenParams(params);
            for (Map.Entry<String, String> entry : flatParams.entrySet()) {
                String val = entry.getValue();
                if (val.startsWith("@"))
                {
                    String filename = val.substring(1);
                    java.io.File file = new java.io.File(filename);

                    java.io.FileInputStream fis = new java.io.FileInputStream(file);
                    java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
                    byte[] buf = new byte[1024];

                    for (int readNum; (readNum = fis.read(buf)) != -1;) {
                        bos.write(buf, 0, readNum); //no doubt here is 0
                            //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                            //System.out.println("read " + readNum + " bytes,");
                    }

                    org.apache.http.entity.mime.content.ContentBody contentPart =
                        new org.apache.http.entity.mime.content.ByteArrayBody(bos.toByteArray(), filename);

                    builder.addPart(entry.getKey(), contentPart);
                }
                else
                    builder.addTextBody(entry.getKey(), entry.getValue());
            }

            HttpEntity yourEntity = builder.build();
            httppost.setEntity(yourEntity);

            httppost.addHeader("User-Agent",
                    String.format("Lob/v1 JavaBindings/%s", Lob.VERSION));

        if (!apiKey.endsWith(":"))
                apiKey = apiKey + ":";

            byte[] authEncBytes = org.apache.commons.codec.binary.Base64.encodeBase64(apiKey.getBytes());
            String authStringEnc = new String(authEncBytes);

            httppost.addHeader("Authorization", "Basic " + authStringEnc);

            HttpResponse response = httpclient.execute(httppost);
            return response;

        }
        catch (InvalidRequestException e)
        {
            throw new IOException(e);
        }
    }

    private static javax.net.ssl.HttpsURLConnection createDeleteConnection(
            String url, String query, String apiKey) throws IOException {
        String deleteUrl = String.format("%s?%s", url, query);
        javax.net.ssl.HttpsURLConnection conn = createLobConnection(
                deleteUrl, apiKey);
        conn.setRequestMethod("DELETE");
        return conn;
    }

    private static String createQuery(Map<String, Object> params)
        throws UnsupportedEncodingException, InvalidRequestException {
        Map<String, String> flatParams = flattenParams(params);
        StringBuffer queryStringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : flatParams.entrySet()) {
            queryStringBuffer.append("&");
            queryStringBuffer.append(urlEncodePair(entry.getKey(),
                    entry.getValue()));
        }
        if (queryStringBuffer.length() > 0) {
            queryStringBuffer.deleteCharAt(0);
        }
        return queryStringBuffer.toString();
    }

    private static Map<String, String> flattenParams(Map<String, Object> params)
            throws InvalidRequestException {
        if (params == null) {
            return new HashMap<String, String>();
        }
        Map<String, String> flatParams = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map<?, ?>) {
                Map<String, Object> flatNestedMap = new HashMap<String, Object>();
                Map<?, ?> nestedMap = (Map<?, ?>) value;
                for (Map.Entry<?, ?> nestedEntry : nestedMap.entrySet()) {
                    flatNestedMap.put(
                            String.format("%s[%s]", key, nestedEntry.getKey()),
                            nestedEntry.getValue());
                }
                flatParams.putAll(flattenParams(flatNestedMap));
            } else if ("".equals(value)) {
                throw new InvalidRequestException("You cannot set '"+key+"' to an empty string. "+
                                  "We interpret empty strings as null in requests. "+
                                  "You may set '"+key+"' to null to delete the property.",
                                  key, null);
            } else if (value == null) {
                flatParams.put(key, "");
            } else if (value != null) {
                flatParams.put(key, value.toString());
            }
        }
        return flatParams;
    }

    // represents Errors returned as JSON
    private static class ErrorContainer {
        private List<APIResource.Error> errors;
    }

    private static class Error {
        String message;

        String status_code;
    }

    private static String getResponseBody(InputStream responseStream)
            throws IOException {
        String rBody = new Scanner(responseStream, CHARSET).useDelimiter("\\A")
                .next(); // \A is the beginning of
                            // the stream boundary
        responseStream.close();
        return rBody;
    }

    private static LobResponse makeURLConnectionRequest(
            APIResource.RequestMethod method, String url, String query,
            String apiKey, Map<String, Object> params) throws APIConnectionException {
        javax.net.ssl.HttpsURLConnection conn = null;
        try {
            switch (method) {
            case GET:
                conn = createGetConnection(url, query, apiKey);
                break;
            case POST:
                HttpResponse response = createPostConnection(url, query, apiKey, params);

                int rCode = response.getStatusLine().getStatusCode();
                String rBody = null;
                if (rCode >= 200 && rCode < 300) {
                    rBody = getResponseBody(response.getEntity().getContent());
                } else {
                    rBody = getResponseBody(response.getEntity().getContent());
                }
                return new LobResponse(rCode, rBody);

            case DELETE:
                conn = createDeleteConnection(url, query, apiKey);
                break;
            default:
                throw new APIConnectionException(
                        String.format(
                                "Unrecognized HTTP method %s. "
                                        + "This indicates a bug in the Lob bindings. Please contact "
                                        + "support@lob.com for assistance.",
                                method));
            }
            int rCode = conn.getResponseCode(); // triggers the request
            String rBody = null;
            if (rCode >= 200 && rCode < 300) {
                rBody = getResponseBody(conn.getInputStream());
            } else {
                rBody = getResponseBody(conn.getErrorStream());
            }
            return new LobResponse(rCode, rBody);
        } catch (IOException e) {
            throw new APIConnectionException(
                    String.format(
                            "Could not connect to Lob (%s). "
                                    + "Please check your internet connection and try again. If this problem persists,"
                                    + "you should check Lob's service status at https://twitter.com/lobstatus,"
                                    + " or let us know at support@lob.com.",
                            Lob.API_BASE), e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    protected static <T> T request(APIResource.RequestMethod method,
            String url, Map<String, Object> params, Class<T> clazz,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        String originalDNSCacheTTL = null;
        Boolean allowedToSetTTL = true;
        try {
            originalDNSCacheTTL = java.security.Security
                    .getProperty(DNS_CACHE_TTL_PROPERTY_NAME);
            // disable DNS cache
            java.security.Security
                    .setProperty(DNS_CACHE_TTL_PROPERTY_NAME, "0");
        } catch (SecurityException se) {
            allowedToSetTTL = false;
        }

        try {
            return _request(method, url, params, clazz, apiKey);
        } finally {
            if (allowedToSetTTL) {
                if (originalDNSCacheTTL == null) {
                    // value unspecified by implementation
                    java.security.Security.setProperty(
                            DNS_CACHE_TTL_PROPERTY_NAME, "-1"); // cache forever
                } else {
                    java.security.Security.setProperty(
                            DNS_CACHE_TTL_PROPERTY_NAME, originalDNSCacheTTL);
                }
            }
        }
    }

    protected static <T> T _request(APIResource.RequestMethod method,
            String url, Map<String, Object> params, Class<T> clazz,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        if ((Lob.apiKey == null || Lob.apiKey.length() == 0)
                && (apiKey == null || apiKey.length() == 0)) {
            throw new AuthenticationException(
                    "No API key provided. (HINT: set your API key using 'Lob.apiKey = <API-KEY>'. "
                            + "You can generate API keys from the Lob web interface. "
                            + "See https://lob.com/api for details or email support@lob.com if you have questions.");
        }

        if (apiKey == null) {
            apiKey = Lob.apiKey;
        }

        String query;

        try {
            query = createQuery(params);
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException("Unable to encode parameters to "
                    + CHARSET
                    + ". Please contact support@lob.com for assistance.",
                    null, e);
        }

        LobResponse response;
        try {
            // HTTPSURLConnection verifies SSL cert by default
            response = makeURLConnectionRequest(method, url, query, apiKey, params);
        } catch (ClassCastException ce) {
            // appengine doesn't have HTTPSConnection, use URLFetch API
            String appEngineEnv = System.getProperty(
                    "com.google.appengine.runtime.environment", null);
            if (appEngineEnv != null) {
                response = makeAppEngineRequest(method, url, query, apiKey);
            } else {
                // non-appengine ClassCastException
                throw ce;
            }
        }
        int rCode = response.getResponseCode();
        String rBody = response.getResponseBody();
        if (rCode < 200 || rCode >= 300) {
            handleAPIError(rBody, rCode);
        }
        return gson.fromJson(rBody, clazz);
    }

    private static void handleAPIError(String rBody, int rCode)
            throws InvalidRequestException, AuthenticationException,
            APIException {
        APIResource.Error error = gson.fromJson(rBody,
                APIResource.ErrorContainer.class).errors.get(0);
        switch (rCode) {
        case 404:
            throw new APIException(error.message, null);
        case 401:
            throw new AuthenticationException(error.message);

        default:
            throw new APIException(error.message, null);
        }
    }

    /*
     * This is slower than usual because of reflection but avoids having to
     * maintain AppEngine-specific JAR
     */
    private static LobResponse makeAppEngineRequest(RequestMethod method,
            String url, String query, String apiKey) throws APIException {
        String unknownErrorMessage = "Sorry, an unknown error occurred while trying to use the "
                + "Google App Engine runtime. Please contact support@lob.com for assistance.";
        try {
            if (method == RequestMethod.GET || method == RequestMethod.DELETE) {
                url = String.format("%s?%s", url, query);
            }
            URL fetchURL = new URL(url);

            Class<?> requestMethodClass = Class
                    .forName("com.google.appengine.api.urlfetch.HTTPMethod");
            Object httpMethod = requestMethodClass.getDeclaredField(
                    method.name()).get(null);

            Class<?> fetchOptionsBuilderClass = Class
                    .forName("com.google.appengine.api.urlfetch.FetchOptions$Builder");
            Object fetchOptions = null;
            try {
                fetchOptions = fetchOptionsBuilderClass.getDeclaredMethod(
                        "validateCertificate").invoke(null);
            } catch (NoSuchMethodException e) {
                System.err
                        .println("Warning: this App Engine SDK version does not allow verification of SSL certificates;"
                                + "this exposes you to a MITM attack. Please upgrade your App Engine SDK to >=1.5.0. "
                                + "If you have questions, contact support@lob.com.");
                fetchOptions = fetchOptionsBuilderClass.getDeclaredMethod(
                        "withDefaults").invoke(null);
            }

            Class<?> fetchOptionsClass = Class
                    .forName("com.google.appengine.api.urlfetch.FetchOptions");

            // GAE requests can time out after 60 seconds, so make sure we leave
            // some time for the application to handle a slow Lob
            fetchOptionsClass.getDeclaredMethod("setDeadline",
                    java.lang.Double.class)
                    .invoke(fetchOptions, new Double(55));

            Class<?> requestClass = Class
                    .forName("com.google.appengine.api.urlfetch.HTTPRequest");

            Object request = requestClass.getDeclaredConstructor(URL.class,
                    requestMethodClass, fetchOptionsClass).newInstance(
                    fetchURL, httpMethod, fetchOptions);

            if (method == RequestMethod.POST) {
                requestClass.getDeclaredMethod("setPayload", byte[].class)
                        .invoke(request, query.getBytes());
            }

            for (Map.Entry<String, String> header : getHeaders(apiKey)
                    .entrySet()) {
                Class<?> httpHeaderClass = Class
                        .forName("com.google.appengine.api.urlfetch.HTTPHeader");
                Object reqHeader = httpHeaderClass.getDeclaredConstructor(
                        String.class, String.class).newInstance(
                        header.getKey(), header.getValue());
                requestClass.getDeclaredMethod("setHeader", httpHeaderClass)
                        .invoke(request, reqHeader);
            }

            Class<?> urlFetchFactoryClass = Class
                    .forName("com.google.appengine.api.urlfetch.URLFetchServiceFactory");
            Object urlFetchService = urlFetchFactoryClass.getDeclaredMethod(
                    "getURLFetchService").invoke(null);

            Method fetchMethod = urlFetchService.getClass().getDeclaredMethod(
                    "fetch", requestClass);
            fetchMethod.setAccessible(true);
            Object response = fetchMethod.invoke(urlFetchService, request);

            int responseCode = (Integer) response.getClass()
                    .getDeclaredMethod("getResponseCode").invoke(response);
            String body = new String((byte[]) response.getClass()
                    .getDeclaredMethod("getContent").invoke(response), CHARSET);
            return new LobResponse(responseCode, body);
        } catch (InvocationTargetException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (MalformedURLException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (NoSuchFieldException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (SecurityException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (NoSuchMethodException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (ClassNotFoundException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (IllegalArgumentException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (IllegalAccessException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (InstantiationException e) {
            throw new APIException(unknownErrorMessage, e);
        } catch (UnsupportedEncodingException e) {
            throw new APIException(unknownErrorMessage, e);
        }
    }

}

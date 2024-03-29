/*
 * Lob
 * The Lob API is organized around REST. Our API is designed to have predictable, resource-oriented URLs and uses HTTP response codes to indicate any API errors. <p> Looking for our [previous documentation](https://lob.github.io/legacy-docs/)? 
 *
 * The version of the OpenAPI document: 1.3.0
 * Contact: lob-openapi@lob.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.lob.api;

import com.lob.api.auth.*;
import io.github.cdimascio.dotenv.Dotenv;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Configuration {
    private static ApiClient defaultApiClient = new ApiClient();
    private final static String BASE_PATH = "https://api.lob.com/v1";

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     */
    public static ApiClient getDefaultApiClient() {
        return defaultApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     */
    public static void setDefaultApiClient(ApiClient apiClient) {
        defaultApiClient = apiClient;
    }

    /**
     * Set a new API client, to be used with the integration tests
     * specifically grabs the test key from the env file
     *
     * @return Api client configured for integration tests
     */
    public static ApiClient getConfigForIntegration() {
        ApiClient apiClient = new ApiClient();

        HttpBasicAuth basicAuth = (HttpBasicAuth) apiClient.getAuthentication("basicAuth");
        String LOB_API_KEY = getEnvVariable("LOB_API_TEST_KEY");
        
        apiClient.setBasePath(BASE_PATH);
        basicAuth.setUsername(LOB_API_KEY);
        return apiClient;
    }

    /**
     * Set a new API client, to be used with the integration tests
     * specifically grabs the live key from the env file
     *
     * @return Api client configured for integration tests
     */
    public static ApiClient getConfigForLiveIntegration() {
        ApiClient apiClient = new ApiClient();

        HttpBasicAuth basicAuth = (HttpBasicAuth) apiClient.getAuthentication("basicAuth");
        String LOB_API_KEY = getEnvVariable("LOB_API_LIVE_KEY");

        apiClient.setBasePath(BASE_PATH);
        basicAuth.setUsername(LOB_API_KEY);
        return apiClient;
    }

    /**
    * Set a new API client, that has an incorrect USERNAME
    * to be used with integration testing
    *
    * @return Api client configured for with bad username
    */
    public static ApiClient getBadConfigForIntegration() {
        ApiClient apiClient = new ApiClient();

        HttpBasicAuth basicAuth = (HttpBasicAuth) apiClient.getAuthentication("basicAuth");
        
        apiClient.setBasePath(BASE_PATH);
        basicAuth.setUsername("BAD USERNAME");
        return apiClient;
    }

    private static String getEnvVariable(String key) {
        Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMalformed().ignoreIfMissing().load();
        return dotenv.get(key);
    }
}

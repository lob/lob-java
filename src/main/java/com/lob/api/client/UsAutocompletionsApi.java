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


package com.lob.api.client;

import com.lob.api.ApiCallback;
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.ApiResponse;
import com.lob.api.Configuration;
import com.lob.api.Pair;
import com.lob.api.ProgressRequestBody;
import com.lob.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.lob.model.LobError;
import com.lob.model.UsAutocompletions;
import com.lob.model.UsAutocompletionsWritable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsAutocompletionsApi {
    private ApiClient localVarApiClient;

    public UsAutocompletionsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UsAutocompletionsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for autocomplete
     * @param usAutocompletionsWritable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a US autocompletion object. </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call autocompleteCall(UsAutocompletionsWritable usAutocompletionsWritable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = usAutocompletionsWritable;

        // create path and map variables
        String localVarPath = "/us_autocompletions";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json", "application/x-www-form-urlencoded", "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call autocompleteValidateBeforeCall(UsAutocompletionsWritable usAutocompletionsWritable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'usAutocompletionsWritable' is set
        if (usAutocompletionsWritable == null) {
            throw new ApiException("Missing the required parameter 'usAutocompletionsWritable' when calling autocomplete(Async)");
        }
        

        okhttp3.Call localVarCall = autocompleteCall(usAutocompletionsWritable, _callback);
        return localVarCall;

    }

    /**
     * autocomplete
     * Given an address prefix consisting of a partial primary line, as well as optional input of city, state, and zip code, this functionality returns up to 10 full US address suggestions. Not all of them will turn out to be valid addresses; they&#39;ll need to be [verified](#operation/verification_us).
     * @param usAutocompletionsWritable  (required)
     * @return UsAutocompletions
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a US autocompletion object. </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public UsAutocompletions autocomplete(UsAutocompletionsWritable usAutocompletionsWritable) throws ApiException {
        try {
            ApiResponse<UsAutocompletions> localVarResp = autocompleteWithHttpInfo(usAutocompletionsWritable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * autocomplete
     * Given an address prefix consisting of a partial primary line, as well as optional input of city, state, and zip code, this functionality returns up to 10 full US address suggestions. Not all of them will turn out to be valid addresses; they&#39;ll need to be [verified](#operation/verification_us).
     * @param usAutocompletionsWritable  (required)
     * @return ApiResponse&lt;UsAutocompletions&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a US autocompletion object. </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UsAutocompletions> autocompleteWithHttpInfo(UsAutocompletionsWritable usAutocompletionsWritable) throws ApiException {
        try {
            okhttp3.Call localVarCall = autocompleteValidateBeforeCall(usAutocompletionsWritable, null);
            Type localVarReturnType = new TypeToken<UsAutocompletions>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * autocomplete (asynchronously)
     * Given an address prefix consisting of a partial primary line, as well as optional input of city, state, and zip code, this functionality returns up to 10 full US address suggestions. Not all of them will turn out to be valid addresses; they&#39;ll need to be [verified](#operation/verification_us).
     * @param usAutocompletionsWritable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a US autocompletion object. </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call autocompleteAsync(UsAutocompletionsWritable usAutocompletionsWritable, final ApiCallback<UsAutocompletions> _callback) throws ApiException {

        okhttp3.Call localVarCall = autocompleteValidateBeforeCall(usAutocompletionsWritable, _callback);
        Type localVarReturnType = new TypeToken<UsAutocompletions>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

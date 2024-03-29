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

import com.lob.model.CardOrder;
import com.lob.model.CardOrderEditable;
import com.lob.model.CardOrderList;
import com.lob.model.LobError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardOrdersApi {
    private ApiClient localVarApiClient;

    public CardOrdersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CardOrdersApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for create
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param cardOrderEditable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card order created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCall(String cardId, CardOrderEditable cardOrderEditable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cardOrderEditable;

        // create path and map variables
        String localVarPath = "/cards/{card_id}/orders"
            .replaceAll("\\{" + "card_id" + "\\}", localVarApiClient.escapeString(cardId.toString()));

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
    private okhttp3.Call createValidateBeforeCall(String cardId, CardOrderEditable cardOrderEditable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'cardId' is set
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling create(Async)");
        }
        
        // verify the required parameter 'cardOrderEditable' is set
        if (cardOrderEditable == null) {
            throw new ApiException("Missing the required parameter 'cardOrderEditable' when calling create(Async)");
        }
        

        okhttp3.Call localVarCall = createCall(cardId, cardOrderEditable, _callback);
        return localVarCall;

    }

    /**
     * create
     * Creates a new card order given information
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param cardOrderEditable  (required)
     * @return CardOrder
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card order created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public CardOrder create(String cardId, CardOrderEditable cardOrderEditable) throws ApiException {
        try {
            ApiResponse<CardOrder> localVarResp = createWithHttpInfo(cardId, cardOrderEditable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create
     * Creates a new card order given information
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param cardOrderEditable  (required)
     * @return ApiResponse&lt;CardOrder&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card order created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CardOrder> createWithHttpInfo(String cardId, CardOrderEditable cardOrderEditable) throws ApiException {
        try {
            okhttp3.Call localVarCall = createValidateBeforeCall(cardId, cardOrderEditable, null);
            Type localVarReturnType = new TypeToken<CardOrder>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create (asynchronously)
     * Creates a new card order given information
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param cardOrderEditable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card order created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAsync(String cardId, CardOrderEditable cardOrderEditable, final ApiCallback<CardOrder> _callback) throws ApiException {

        okhttp3.Call localVarCall = createValidateBeforeCall(cardId, cardOrderEditable, _callback);
        Type localVarReturnType = new TypeToken<CardOrder>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for get
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the card orders associated with the given card id </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCall(String cardId, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/cards/{card_id}/orders"
            .replaceAll("\\{" + "card_id" + "\\}", localVarApiClient.escapeString(cardId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (offset != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("offset", offset));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getValidateBeforeCall(String cardId, Integer limit, Integer offset, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'cardId' is set
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling get(Async)");
        }
        

        okhttp3.Call localVarCall = getCall(cardId, limit, offset, _callback);
        return localVarCall;

    }

    /**
     * get
     * Retrieves the card orders associated with the given card id.
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @return CardOrderList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the card orders associated with the given card id </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public CardOrderList get(String cardId, Integer limit, Integer offset) throws ApiException {
        try {
            ApiResponse<CardOrderList> localVarResp = getWithHttpInfo(cardId, limit, offset);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get
     * Retrieves the card orders associated with the given card id.
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @return ApiResponse&lt;CardOrderList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the card orders associated with the given card id </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CardOrderList> getWithHttpInfo(String cardId, Integer limit, Integer offset) throws ApiException {
        try {
            okhttp3.Call localVarCall = getValidateBeforeCall(cardId, limit, offset, null);
            Type localVarReturnType = new TypeToken<CardOrderList>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get (asynchronously)
     * Retrieves the card orders associated with the given card id.
     * @param cardId The ID of the card to which the card orders belong. (required)
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the card orders associated with the given card id </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAsync(String cardId, Integer limit, Integer offset, final ApiCallback<CardOrderList> _callback) throws ApiException {

        okhttp3.Call localVarCall = getValidateBeforeCall(cardId, limit, offset, _callback);
        Type localVarReturnType = new TypeToken<CardOrderList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

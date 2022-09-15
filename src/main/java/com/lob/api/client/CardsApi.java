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

import java.io.IOException;


import com.lob.model.Card;
import com.lob.model.CardDeletion;
import com.lob.model.CardEditable;
import com.lob.model.CardList;
import com.lob.model.CardUpdatable;
import com.lob.model.LobError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardsApi {
    private ApiClient localVarApiClient;

    public CardsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CardsApi(ApiClient apiClient) {
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
     * @param cardEditable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCall(CardEditable cardEditable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cardEditable;

        // create path and map variables
        String localVarPath = "/cards";

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
    private okhttp3.Call createValidateBeforeCall(CardEditable cardEditable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'cardEditable' is set
        if (cardEditable == null) {
            throw new ApiException("Missing the required parameter 'cardEditable' when calling create(Async)");
        }
        

        okhttp3.Call localVarCall = createCall(cardEditable, _callback);
        return localVarCall;

    }

    /**
     * create
     * Creates a new card given information
     * @param cardEditable  (required)
     * @return Card
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Card create(CardEditable cardEditable) throws ApiException {
        try {
            ApiResponse<Card> localVarResp = createWithHttpInfo(cardEditable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create
     * Creates a new card given information
     * @param cardEditable  (required)
     * @return ApiResponse&lt;Card&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Card> createWithHttpInfo(CardEditable cardEditable) throws ApiException {
        try {
            okhttp3.Call localVarCall = createValidateBeforeCall(cardEditable, null);
            Type localVarReturnType = new TypeToken<Card>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create (asynchronously)
     * Creates a new card given information
     * @param cardEditable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Card created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAsync(CardEditable cardEditable, final ApiCallback<Card> _callback) throws ApiException {

        okhttp3.Call localVarCall = createValidateBeforeCall(cardEditable, _callback);
        Type localVarReturnType = new TypeToken<Card>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for delete
     * @param cardId id of the card (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the card </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteCall(String cardId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/cards/{card_id}"
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
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteValidateBeforeCall(String cardId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'cardId' is set
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling delete(Async)");
        }
        

        okhttp3.Call localVarCall = deleteCall(cardId, _callback);
        return localVarCall;

    }

    /**
     * delete
     * Delete an existing card. You need only supply the unique identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @return CardDeletion
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the card </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public CardDeletion delete(String cardId) throws ApiException {
        try {
            ApiResponse<CardDeletion> localVarResp = deleteWithHttpInfo(cardId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * delete
     * Delete an existing card. You need only supply the unique identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @return ApiResponse&lt;CardDeletion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the card </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CardDeletion> deleteWithHttpInfo(String cardId) throws ApiException {
        try {
            okhttp3.Call localVarCall = deleteValidateBeforeCall(cardId, null);
            Type localVarReturnType = new TypeToken<CardDeletion>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * delete (asynchronously)
     * Delete an existing card. You need only supply the unique identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the card </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteAsync(String cardId, final ApiCallback<CardDeletion> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteValidateBeforeCall(cardId, _callback);
        Type localVarReturnType = new TypeToken<CardDeletion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for get
     * @param cardId id of the card (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCall(String cardId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/cards/{card_id}"
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
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getValidateBeforeCall(String cardId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'cardId' is set
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling get(Async)");
        }
        

        okhttp3.Call localVarCall = getCall(cardId, _callback);
        return localVarCall;

    }

    /**
     * get
     * Retrieves the details of an existing card. You need only supply the unique customer identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @return Card
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Card get(String cardId) throws ApiException {
        try {
            ApiResponse<Card> localVarResp = getWithHttpInfo(cardId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get
     * Retrieves the details of an existing card. You need only supply the unique customer identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @return ApiResponse&lt;Card&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Card> getWithHttpInfo(String cardId) throws ApiException {
        try {
            okhttp3.Call localVarCall = getValidateBeforeCall(cardId, null);
            Type localVarReturnType = new TypeToken<Card>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get (asynchronously)
     * Retrieves the details of an existing card. You need only supply the unique customer identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAsync(String cardId, final ApiCallback<Card> _callback) throws ApiException {

        okhttp3.Call localVarCall = getValidateBeforeCall(cardId, _callback);
        Type localVarReturnType = new TypeToken<Card>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for update
     * @param cardId id of the card (required)
     * @param cardUpdatable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateCall(String cardId, CardUpdatable cardUpdatable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cardUpdatable;

        // create path and map variables
        String localVarPath = "/cards/{card_id}"
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
    private okhttp3.Call updateValidateBeforeCall(String cardId, CardUpdatable cardUpdatable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'cardId' is set
        if (cardId == null) {
            throw new ApiException("Missing the required parameter 'cardId' when calling update(Async)");
        }
        
        // verify the required parameter 'cardUpdatable' is set
        if (cardUpdatable == null) {
            throw new ApiException("Missing the required parameter 'cardUpdatable' when calling update(Async)");
        }
        

        okhttp3.Call localVarCall = updateCall(cardId, cardUpdatable, _callback);
        return localVarCall;

    }

    /**
     * update
     * Update the details of an existing card. You need only supply the unique identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @param cardUpdatable  (required)
     * @return Card
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Card update(String cardId, CardUpdatable cardUpdatable) throws ApiException {
        try {
            ApiResponse<Card> localVarResp = updateWithHttpInfo(cardId, cardUpdatable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * update
     * Update the details of an existing card. You need only supply the unique identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @param cardUpdatable  (required)
     * @return ApiResponse&lt;Card&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Card> updateWithHttpInfo(String cardId, CardUpdatable cardUpdatable) throws ApiException {
        try {
            okhttp3.Call localVarCall = updateValidateBeforeCall(cardId, cardUpdatable, null);
            Type localVarReturnType = new TypeToken<Card>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * update (asynchronously)
     * Update the details of an existing card. You need only supply the unique identifier that was returned upon card creation.
     * @param cardId id of the card (required)
     * @param cardUpdatable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a card object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateAsync(String cardId, CardUpdatable cardUpdatable, final ApiCallback<Card> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateValidateBeforeCall(cardId, cardUpdatable, _callback);
        Type localVarReturnType = new TypeToken<Card>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for list
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of card objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCall(Integer limit, String before, String after, List<String> include, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/cards";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (before != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("before", before));
        }

        if (after != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("after", after));
        }

        if (include != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "include", include));
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
    private okhttp3.Call listValidateBeforeCall(Integer limit, String before, String after, List<String> include, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = listCall(limit, before, after, include, _callback);
        return localVarCall;

    }

    /**
     * list
     * Returns a list of your cards. The cards are returned sorted by creation date, with the most recently created addresses appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @return CardList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of card objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public CardList list(Integer limit, String before, String after, List<String> include) throws ApiException {
        try {
            ApiResponse<CardList> localVarResp = listWithHttpInfo(limit, before, after, include);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list
     * Returns a list of your cards. The cards are returned sorted by creation date, with the most recently created addresses appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @return ApiResponse&lt;CardList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of card objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CardList> listWithHttpInfo(Integer limit, String before, String after, List<String> include) throws ApiException {
        try {
            okhttp3.Call localVarCall = listValidateBeforeCall(limit, before, after, include, null);
            Type localVarReturnType = new TypeToken<CardList>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list (asynchronously)
     * Returns a list of your cards. The cards are returned sorted by creation date, with the most recently created addresses appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of card objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listAsync(Integer limit, String before, String after, List<String> include, final ApiCallback<CardList> _callback) throws ApiException {

        okhttp3.Call localVarCall = listValidateBeforeCall(limit, before, after, include, _callback);
        Type localVarReturnType = new TypeToken<CardList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

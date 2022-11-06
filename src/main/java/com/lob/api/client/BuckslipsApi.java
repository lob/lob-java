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


import com.lob.model.Buckslip;
import com.lob.model.BuckslipDeletion;
import com.lob.model.BuckslipEditable;
import com.lob.model.BuckslipUpdatable;
import com.lob.model.BuckslipsList;
import com.lob.model.LobError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuckslipsApi {
    private ApiClient localVarApiClient;

    public BuckslipsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BuckslipsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for Create
     * @param buckslipEditable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Buckslip created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call CreateCall(BuckslipEditable buckslipEditable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = buckslipEditable;

        // create path and map variables
        String localVarPath = "/buckslips";

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
    private okhttp3.Call CreateValidateBeforeCall(BuckslipEditable buckslipEditable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'buckslipEditable' is set
        if (buckslipEditable == null) {
            throw new ApiException("Missing the required parameter 'buckslipEditable' when calling Create(Async)");
        }
        

        okhttp3.Call localVarCall = CreateCall(buckslipEditable, _callback);
        return localVarCall;

    }

    /**
     * Create
     * Creates a new buckslip given information
     * @param buckslipEditable  (required)
     * @return Buckslip
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Buckslip created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Buckslip Create(BuckslipEditable buckslipEditable) throws ApiException {
        try {
            ApiResponse<Buckslip> localVarResp = CreateWithHttpInfo(buckslipEditable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Create
     * Creates a new buckslip given information
     * @param buckslipEditable  (required)
     * @return ApiResponse&lt;Buckslip&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Buckslip created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Buckslip> CreateWithHttpInfo(BuckslipEditable buckslipEditable) throws ApiException {
        try {
            okhttp3.Call localVarCall = CreateValidateBeforeCall(buckslipEditable, null);
            Type localVarReturnType = new TypeToken<Buckslip>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Create (asynchronously)
     * Creates a new buckslip given information
     * @param buckslipEditable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Buckslip created successfully </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call CreateAsync(BuckslipEditable buckslipEditable, final ApiCallback<Buckslip> _callback) throws ApiException {

        okhttp3.Call localVarCall = CreateValidateBeforeCall(buckslipEditable, _callback);
        Type localVarReturnType = new TypeToken<Buckslip>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for Delete
     * @param buckslipId id of the buckslip (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the buckslip </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call DeleteCall(String buckslipId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/buckslips/{buckslip_id}"
            .replaceAll("\\{" + "buckslip_id" + "\\}", localVarApiClient.escapeString(buckslipId.toString()));

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
    private okhttp3.Call DeleteValidateBeforeCall(String buckslipId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'buckslipId' is set
        if (buckslipId == null) {
            throw new ApiException("Missing the required parameter 'buckslipId' when calling Delete(Async)");
        }
        

        okhttp3.Call localVarCall = DeleteCall(buckslipId, _callback);
        return localVarCall;

    }

    /**
     * Delete
     * Delete an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @return BuckslipDeletion
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the buckslip </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BuckslipDeletion Delete(String buckslipId) throws ApiException {
        try {
            ApiResponse<BuckslipDeletion> localVarResp = DeleteWithHttpInfo(buckslipId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Delete
     * Delete an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @return ApiResponse&lt;BuckslipDeletion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the buckslip </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BuckslipDeletion> DeleteWithHttpInfo(String buckslipId) throws ApiException {
        try {
            okhttp3.Call localVarCall = DeleteValidateBeforeCall(buckslipId, null);
            Type localVarReturnType = new TypeToken<BuckslipDeletion>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Delete (asynchronously)
     * Delete an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted the buckslip </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call DeleteAsync(String buckslipId, final ApiCallback<BuckslipDeletion> _callback) throws ApiException {

        okhttp3.Call localVarCall = DeleteValidateBeforeCall(buckslipId, _callback);
        Type localVarReturnType = new TypeToken<BuckslipDeletion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for Retrieve
     * @param buckslipId id of the buckslip (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call RetrieveCall(String buckslipId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/buckslips/{buckslip_id}"
            .replaceAll("\\{" + "buckslip_id" + "\\}", localVarApiClient.escapeString(buckslipId.toString()));

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
    private okhttp3.Call RetrieveValidateBeforeCall(String buckslipId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'buckslipId' is set
        if (buckslipId == null) {
            throw new ApiException("Missing the required parameter 'buckslipId' when calling Retrieve(Async)");
        }
        

        okhttp3.Call localVarCall = RetrieveCall(buckslipId, _callback);
        return localVarCall;

    }

    /**
     * Retrieve
     * Retrieves the details of an existing buckslip. You need only supply the unique customer identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @return Buckslip
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Buckslip Retrieve(String buckslipId) throws ApiException {
        try {
            ApiResponse<Buckslip> localVarResp = RetrieveWithHttpInfo(buckslipId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Retrieve
     * Retrieves the details of an existing buckslip. You need only supply the unique customer identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @return ApiResponse&lt;Buckslip&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Buckslip> RetrieveWithHttpInfo(String buckslipId) throws ApiException {
        try {
            okhttp3.Call localVarCall = RetrieveValidateBeforeCall(buckslipId, null);
            Type localVarReturnType = new TypeToken<Buckslip>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Retrieve (asynchronously)
     * Retrieves the details of an existing buckslip. You need only supply the unique customer identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call RetrieveAsync(String buckslipId, final ApiCallback<Buckslip> _callback) throws ApiException {

        okhttp3.Call localVarCall = RetrieveValidateBeforeCall(buckslipId, _callback);
        Type localVarReturnType = new TypeToken<Buckslip>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for Update
     * @param buckslipId id of the buckslip (required)
     * @param buckslipUpdatable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call UpdateCall(String buckslipId, BuckslipUpdatable buckslipUpdatable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = buckslipUpdatable;

        // create path and map variables
        String localVarPath = "/buckslips/{buckslip_id}"
            .replaceAll("\\{" + "buckslip_id" + "\\}", localVarApiClient.escapeString(buckslipId.toString()));

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
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call UpdateValidateBeforeCall(String buckslipId, BuckslipUpdatable buckslipUpdatable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'buckslipId' is set
        if (buckslipId == null) {
            throw new ApiException("Missing the required parameter 'buckslipId' when calling Update(Async)");
        }
        
        // verify the required parameter 'buckslipUpdatable' is set
        if (buckslipUpdatable == null) {
            throw new ApiException("Missing the required parameter 'buckslipUpdatable' when calling Update(Async)");
        }
        

        okhttp3.Call localVarCall = UpdateCall(buckslipId, buckslipUpdatable, _callback);
        return localVarCall;

    }

    /**
     * Update
     * Update the details of an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @param buckslipUpdatable  (required)
     * @return Buckslip
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Buckslip Update(String buckslipId, BuckslipUpdatable buckslipUpdatable) throws ApiException {
        try {
            ApiResponse<Buckslip> localVarResp = UpdateWithHttpInfo(buckslipId, buckslipUpdatable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Update
     * Update the details of an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @param buckslipUpdatable  (required)
     * @return ApiResponse&lt;Buckslip&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Buckslip> UpdateWithHttpInfo(String buckslipId, BuckslipUpdatable buckslipUpdatable) throws ApiException {
        try {
            okhttp3.Call localVarCall = UpdateValidateBeforeCall(buckslipId, buckslipUpdatable, null);
            Type localVarReturnType = new TypeToken<Buckslip>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * Update (asynchronously)
     * Update the details of an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.
     * @param buckslipId id of the buckslip (required)
     * @param buckslipUpdatable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a buckslip object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call UpdateAsync(String buckslipId, BuckslipUpdatable buckslipUpdatable, final ApiCallback<Buckslip> _callback) throws ApiException {

        okhttp3.Call localVarCall = UpdateValidateBeforeCall(buckslipId, buckslipUpdatable, _callback);
        Type localVarReturnType = new TypeToken<Buckslip>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for List
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
        <tr><td> 200 </td><td> description: Returns a list of buckslip objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call ListCall(Integer limit, String before, String after, List<String> include, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/buckslips";

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
    private okhttp3.Call ListValidateBeforeCall(Integer limit, String before, String after, List<String> include, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = ListCall(limit, before, after, include, _callback);
        return localVarCall;

    }

    /**
     * List
     * Returns a list of your buckslips. The buckslips are returned sorted by creation date, with the most recently created buckslips appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @return BuckslipsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> description: Returns a list of buckslip objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BuckslipsList List(Integer limit, String before, String after, List<String> include) throws ApiException {
        try {
            ApiResponse<BuckslipsList> localVarResp = ListWithHttpInfo(limit, before, after, include);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * List
     * Returns a list of your buckslips. The buckslips are returned sorted by creation date, with the most recently created buckslips appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @return ApiResponse&lt;BuckslipsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> description: Returns a list of buckslip objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BuckslipsList> ListWithHttpInfo(Integer limit, String before, String after, List<String> include) throws ApiException {
        try {
            okhttp3.Call localVarCall = ListValidateBeforeCall(limit, before, after, include, null);
            Type localVarReturnType = new TypeToken<BuckslipsList>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * List (asynchronously)
     * Returns a list of your buckslips. The buckslips are returned sorted by creation date, with the most recently created buckslips appearing first.
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
        <tr><td> 200 </td><td> description: Returns a list of buckslip objects </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call ListAsync(Integer limit, String before, String after, List<String> include, final ApiCallback<BuckslipsList> _callback) throws ApiException {

        okhttp3.Call localVarCall = ListValidateBeforeCall(limit, before, after, include, _callback);
        Type localVarReturnType = new TypeToken<BuckslipsList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

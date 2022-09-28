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


import com.lob.model.BillingGroup;
import com.lob.model.BillingGroupEditable;
import com.lob.model.BillingGroupList;
import com.lob.model.LobError;
import java.time.OffsetDateTime;
import com.lob.model.SortByDateModified;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillingGroupsApi {
    private ApiClient localVarApiClient;

    public BillingGroupsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BillingGroupsApi(ApiClient apiClient) {
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
     * @param billingGroupEditable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCall(BillingGroupEditable billingGroupEditable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = billingGroupEditable;

        // create path and map variables
        String localVarPath = "/billing_groups";

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
    private okhttp3.Call createValidateBeforeCall(BillingGroupEditable billingGroupEditable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'billingGroupEditable' is set
        if (billingGroupEditable == null) {
            throw new ApiException("Missing the required parameter 'billingGroupEditable' when calling create(Async)");
        }
        

        okhttp3.Call localVarCall = createCall(billingGroupEditable, _callback);
        return localVarCall;

    }

    /**
     * create
     * Creates a new billing_group with the provided properties.
     * @param billingGroupEditable  (required)
     * @return BillingGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BillingGroup create(BillingGroupEditable billingGroupEditable) throws ApiException {
        try {
            ApiResponse<BillingGroup> localVarResp = createWithHttpInfo(billingGroupEditable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create
     * Creates a new billing_group with the provided properties.
     * @param billingGroupEditable  (required)
     * @return ApiResponse&lt;BillingGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BillingGroup> createWithHttpInfo(BillingGroupEditable billingGroupEditable) throws ApiException {
        try {
            okhttp3.Call localVarCall = createValidateBeforeCall(billingGroupEditable, null);
            Type localVarReturnType = new TypeToken<BillingGroup>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create (asynchronously)
     * Creates a new billing_group with the provided properties.
     * @param billingGroupEditable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAsync(BillingGroupEditable billingGroupEditable, final ApiCallback<BillingGroup> _callback) throws ApiException {

        okhttp3.Call localVarCall = createValidateBeforeCall(billingGroupEditable, _callback);
        Type localVarReturnType = new TypeToken<BillingGroup>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for get
     * @param bgId id of the billing_group (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing_group object. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCall(String bgId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/billing_groups/{bg_id}"
            .replaceAll("\\{" + "bg_id" + "\\}", localVarApiClient.escapeString(bgId.toString()));

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
    private okhttp3.Call getValidateBeforeCall(String bgId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'bgId' is set
        if (bgId == null) {
            throw new ApiException("Missing the required parameter 'bgId' when calling get(Async)");
        }
        

        okhttp3.Call localVarCall = getCall(bgId, _callback);
        return localVarCall;

    }

    /**
     * get
     * Retrieves the details of an existing billing_group. You need only supply the unique billing_group identifier that was returned upon billing_group creation.
     * @param bgId id of the billing_group (required)
     * @return BillingGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing_group object. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BillingGroup get(String bgId) throws ApiException {
        try {
            ApiResponse<BillingGroup> localVarResp = getWithHttpInfo(bgId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get
     * Retrieves the details of an existing billing_group. You need only supply the unique billing_group identifier that was returned upon billing_group creation.
     * @param bgId id of the billing_group (required)
     * @return ApiResponse&lt;BillingGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing_group object. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BillingGroup> getWithHttpInfo(String bgId) throws ApiException {
        try {
            okhttp3.Call localVarCall = getValidateBeforeCall(bgId, null);
            Type localVarReturnType = new TypeToken<BillingGroup>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get (asynchronously)
     * Retrieves the details of an existing billing_group. You need only supply the unique billing_group identifier that was returned upon billing_group creation.
     * @param bgId id of the billing_group (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing_group object. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAsync(String bgId, final ApiCallback<BillingGroup> _callback) throws ApiException {

        okhttp3.Call localVarCall = getValidateBeforeCall(bgId, _callback);
        Type localVarReturnType = new TypeToken<BillingGroup>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for update
     * @param bgId id of the billing_group (required)
     * @param billingGroupEditable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateCall(String bgId, BillingGroupEditable billingGroupEditable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = billingGroupEditable;

        // create path and map variables
        String localVarPath = "/billing_groups/{bg_id}"
            .replaceAll("\\{" + "bg_id" + "\\}", localVarApiClient.escapeString(bgId.toString()));

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
    private okhttp3.Call updateValidateBeforeCall(String bgId, BillingGroupEditable billingGroupEditable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'bgId' is set
        if (bgId == null) {
            throw new ApiException("Missing the required parameter 'bgId' when calling update(Async)");
        }
        
        // verify the required parameter 'billingGroupEditable' is set
        if (billingGroupEditable == null) {
            throw new ApiException("Missing the required parameter 'billingGroupEditable' when calling update(Async)");
        }
        

        okhttp3.Call localVarCall = updateCall(bgId, billingGroupEditable, _callback);
        return localVarCall;

    }

    /**
     * update
     * Updates all editable attributes of the billing_group with the given id.
     * @param bgId id of the billing_group (required)
     * @param billingGroupEditable  (required)
     * @return BillingGroup
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BillingGroup update(String bgId, BillingGroupEditable billingGroupEditable) throws ApiException {
        try {
            ApiResponse<BillingGroup> localVarResp = updateWithHttpInfo(bgId, billingGroupEditable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * update
     * Updates all editable attributes of the billing_group with the given id.
     * @param bgId id of the billing_group (required)
     * @param billingGroupEditable  (required)
     * @return ApiResponse&lt;BillingGroup&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BillingGroup> updateWithHttpInfo(String bgId, BillingGroupEditable billingGroupEditable) throws ApiException {
        try {
            okhttp3.Call localVarCall = updateValidateBeforeCall(bgId, billingGroupEditable, null);
            Type localVarReturnType = new TypeToken<BillingGroup>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * update (asynchronously)
     * Updates all editable attributes of the billing_group with the given id.
     * @param bgId id of the billing_group (required)
     * @param billingGroupEditable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a billing group object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateAsync(String bgId, BillingGroupEditable billingGroupEditable, final ApiCallback<BillingGroup> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateValidateBeforeCall(bgId, billingGroupEditable, _callback);
        Type localVarReturnType = new TypeToken<BillingGroup>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for list
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param dateModified Filter by date modified. (optional)
     * @param sortByDateModified Sorts items by ascending or descending dates. Use either &#x60;date_created&#x60; or &#x60;date_modfied&#x60;, not both.  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of billing_groups. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCall(Integer limit, Integer offset, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> dateModified, SortByDateModified sortByDateModified, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/billing_groups";

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

        if (include != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "include", include));
        }

        if (dateCreated != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("date_created", dateCreated));
        }

        if (dateModified != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("date_modified", dateModified));
        }

        if (sortByDateModified != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort_by_date_modified", sortByDateModified));
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
    private okhttp3.Call listValidateBeforeCall(Integer limit, Integer offset, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> dateModified, SortByDateModified sortByDateModified, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = listCall(limit, offset, include, dateCreated, dateModified, sortByDateModified, _callback);
        return localVarCall;

    }

    /**
     * list
     * Returns a list of your billing_groups. The billing_groups are returned sorted by creation date, with the most recently created billing_groups appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param dateModified Filter by date modified. (optional)
     * @param sortByDateModified Sorts items by ascending or descending dates. Use either &#x60;date_created&#x60; or &#x60;date_modfied&#x60;, not both.  (optional)
     * @return BillingGroupList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of billing_groups. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BillingGroupList list(Integer limit, Integer offset, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> dateModified, SortByDateModified sortByDateModified) throws ApiException {
        try {
            ApiResponse<BillingGroupList> localVarResp = listWithHttpInfo(limit, offset, include, dateCreated, dateModified, sortByDateModified);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list
     * Returns a list of your billing_groups. The billing_groups are returned sorted by creation date, with the most recently created billing_groups appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param dateModified Filter by date modified. (optional)
     * @param sortByDateModified Sorts items by ascending or descending dates. Use either &#x60;date_created&#x60; or &#x60;date_modfied&#x60;, not both.  (optional)
     * @return ApiResponse&lt;BillingGroupList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of billing_groups. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BillingGroupList> listWithHttpInfo(Integer limit, Integer offset, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> dateModified, SortByDateModified sortByDateModified) throws ApiException {
        try {
            okhttp3.Call localVarCall = listValidateBeforeCall(limit, offset, include, dateCreated, dateModified, sortByDateModified, null);
            Type localVarReturnType = new TypeToken<BillingGroupList>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list (asynchronously)
     * Returns a list of your billing_groups. The billing_groups are returned sorted by creation date, with the most recently created billing_groups appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param offset An integer that designates the offset at which to begin returning results. Defaults to 0. (optional, default to 0)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param dateModified Filter by date modified. (optional)
     * @param sortByDateModified Sorts items by ascending or descending dates. Use either &#x60;date_created&#x60; or &#x60;date_modfied&#x60;, not both.  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a list of billing_groups. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listAsync(Integer limit, Integer offset, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> dateModified, SortByDateModified sortByDateModified, final ApiCallback<BillingGroupList> _callback) throws ApiException {

        okhttp3.Call localVarCall = listValidateBeforeCall(limit, offset, include, dateCreated, dateModified, sortByDateModified, _callback);
        Type localVarReturnType = new TypeToken<BillingGroupList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

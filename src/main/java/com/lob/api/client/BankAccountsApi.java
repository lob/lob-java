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


import org.openapitools.client.model.BankAccount;
import org.openapitools.client.model.BankAccountDeletion;
import org.openapitools.client.model.BankAccountList;
import org.openapitools.client.model.BankAccountVerify;
import org.openapitools.client.model.BankAccountWritable;
import org.openapitools.client.model.LobError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountsApi {
    private ApiClient localVarApiClient;

    public BankAccountsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BankAccountsApi(ApiClient apiClient) {
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
     * @param bankAccountWritable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCall(BankAccountWritable bankAccountWritable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = bankAccountWritable;

        // create path and map variables
        String localVarPath = "/bank_accounts";

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
    private okhttp3.Call createValidateBeforeCall(BankAccountWritable bankAccountWritable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'bankAccountWritable' is set
        if (bankAccountWritable == null) {
            throw new ApiException("Missing the required parameter 'bankAccountWritable' when calling create(Async)");
        }
        

        okhttp3.Call localVarCall = createCall(bankAccountWritable, _callback);
        return localVarCall;

    }

    /**
     * create
     * Creates a new bank account with the provided properties. Bank accounts created in live mode will need to be verified via micro deposits before being able to send live checks. The deposits will appear in the bank account in 2-3 business days and have the description \&quot;VERIFICATION\&quot;.
     * @param bankAccountWritable  (required)
     * @return BankAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BankAccount create(BankAccountWritable bankAccountWritable) throws ApiException {
        try {
            ApiResponse<BankAccount> localVarResp = createWithHttpInfo(bankAccountWritable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create
     * Creates a new bank account with the provided properties. Bank accounts created in live mode will need to be verified via micro deposits before being able to send live checks. The deposits will appear in the bank account in 2-3 business days and have the description \&quot;VERIFICATION\&quot;.
     * @param bankAccountWritable  (required)
     * @return ApiResponse&lt;BankAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BankAccount> createWithHttpInfo(BankAccountWritable bankAccountWritable) throws ApiException {
        try {
            okhttp3.Call localVarCall = createValidateBeforeCall(bankAccountWritable, null);
            Type localVarReturnType = new TypeToken<BankAccount>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create (asynchronously)
     * Creates a new bank account with the provided properties. Bank accounts created in live mode will need to be verified via micro deposits before being able to send live checks. The deposits will appear in the bank account in 2-3 business days and have the description \&quot;VERIFICATION\&quot;.
     * @param bankAccountWritable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAsync(BankAccountWritable bankAccountWritable, final ApiCallback<BankAccount> _callback) throws ApiException {

        okhttp3.Call localVarCall = createValidateBeforeCall(bankAccountWritable, _callback);
        Type localVarReturnType = new TypeToken<BankAccount>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for delete
     * @param bankId id of the bank account (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteCall(String bankId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bank_accounts/{bank_id}"
            .replaceAll("\\{" + "bank_id" + "\\}", localVarApiClient.escapeString(bankId.toString()));

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
    private okhttp3.Call deleteValidateBeforeCall(String bankId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'bankId' is set
        if (bankId == null) {
            throw new ApiException("Missing the required parameter 'bankId' when calling delete(Async)");
        }
        

        okhttp3.Call localVarCall = deleteCall(bankId, _callback);
        return localVarCall;

    }

    /**
     * delete
     * Permanently deletes a bank account. It cannot be undone.
     * @param bankId id of the bank account (required)
     * @return BankAccountDeletion
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BankAccountDeletion delete(String bankId) throws ApiException {
        try {
            ApiResponse<BankAccountDeletion> localVarResp = deleteWithHttpInfo(bankId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * delete
     * Permanently deletes a bank account. It cannot be undone.
     * @param bankId id of the bank account (required)
     * @return ApiResponse&lt;BankAccountDeletion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BankAccountDeletion> deleteWithHttpInfo(String bankId) throws ApiException {
        try {
            okhttp3.Call localVarCall = deleteValidateBeforeCall(bankId, null);
            Type localVarReturnType = new TypeToken<BankAccountDeletion>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * delete (asynchronously)
     * Permanently deletes a bank account. It cannot be undone.
     * @param bankId id of the bank account (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteAsync(String bankId, final ApiCallback<BankAccountDeletion> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteValidateBeforeCall(bankId, _callback);
        Type localVarReturnType = new TypeToken<BankAccountDeletion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for get
     * @param bankId id of the bank account (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank account object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCall(String bankId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bank_accounts/{bank_id}"
            .replaceAll("\\{" + "bank_id" + "\\}", localVarApiClient.escapeString(bankId.toString()));

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
    private okhttp3.Call getValidateBeforeCall(String bankId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'bankId' is set
        if (bankId == null) {
            throw new ApiException("Missing the required parameter 'bankId' when calling get(Async)");
        }
        

        okhttp3.Call localVarCall = getCall(bankId, _callback);
        return localVarCall;

    }

    /**
     * get
     * Retrieves the details of an existing bank account. You need only supply the unique bank account identifier that was returned upon bank account creation.
     * @param bankId id of the bank account (required)
     * @return BankAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank account object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BankAccount get(String bankId) throws ApiException {
        try {
            ApiResponse<BankAccount> localVarResp = getWithHttpInfo(bankId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get
     * Retrieves the details of an existing bank account. You need only supply the unique bank account identifier that was returned upon bank account creation.
     * @param bankId id of the bank account (required)
     * @return ApiResponse&lt;BankAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank account object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BankAccount> getWithHttpInfo(String bankId) throws ApiException {
        try {
            okhttp3.Call localVarCall = getValidateBeforeCall(bankId, null);
            Type localVarReturnType = new TypeToken<BankAccount>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get (asynchronously)
     * Retrieves the details of an existing bank account. You need only supply the unique bank account identifier that was returned upon bank account creation.
     * @param bankId id of the bank account (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank account object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAsync(String bankId, final ApiCallback<BankAccount> _callback) throws ApiException {

        okhttp3.Call localVarCall = getValidateBeforeCall(bankId, _callback);
        Type localVarReturnType = new TypeToken<BankAccount>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for verify
     * @param bankId id of the bank account to be verified (required)
     * @param bankAccountVerify  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call verifyCall(String bankId, BankAccountVerify bankAccountVerify, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = bankAccountVerify;

        // create path and map variables
        String localVarPath = "/bank_accounts/{bank_id}/verify"
            .replaceAll("\\{" + "bank_id" + "\\}", localVarApiClient.escapeString(bankId.toString()));

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
    private okhttp3.Call verifyValidateBeforeCall(String bankId, BankAccountVerify bankAccountVerify, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'bankId' is set
        if (bankId == null) {
            throw new ApiException("Missing the required parameter 'bankId' when calling verify(Async)");
        }
        
        // verify the required parameter 'bankAccountVerify' is set
        if (bankAccountVerify == null) {
            throw new ApiException("Missing the required parameter 'bankAccountVerify' when calling verify(Async)");
        }
        

        okhttp3.Call localVarCall = verifyCall(bankId, bankAccountVerify, _callback);
        return localVarCall;

    }

    /**
     * verify
     * Verify a bank account in order to create a check.
     * @param bankId id of the bank account to be verified (required)
     * @param bankAccountVerify  (required)
     * @return BankAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BankAccount verify(String bankId, BankAccountVerify bankAccountVerify) throws ApiException {
        try {
            ApiResponse<BankAccount> localVarResp = verifyWithHttpInfo(bankId, bankAccountVerify);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * verify
     * Verify a bank account in order to create a check.
     * @param bankId id of the bank account to be verified (required)
     * @param bankAccountVerify  (required)
     * @return ApiResponse&lt;BankAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BankAccount> verifyWithHttpInfo(String bankId, BankAccountVerify bankAccountVerify) throws ApiException {
        try {
            okhttp3.Call localVarCall = verifyValidateBeforeCall(bankId, bankAccountVerify, null);
            Type localVarReturnType = new TypeToken<BankAccount>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * verify (asynchronously)
     * Verify a bank account in order to create a check.
     * @param bankId id of the bank account to be verified (required)
     * @param bankAccountVerify  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a bank_account object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call verifyAsync(String bankId, BankAccountVerify bankAccountVerify, final ApiCallback<BankAccount> _callback) throws ApiException {

        okhttp3.Call localVarCall = verifyValidateBeforeCall(bankId, bankAccountVerify, _callback);
        Type localVarReturnType = new TypeToken<BankAccount>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for list
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param metadata Filter by metadata key-value pair&#x60;. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; bank_accounts. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCall(Integer limit, String before, String after, List<String> include, Map<String, String> dateCreated, Map<String, String> metadata, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/bank_accounts";

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

        if (dateCreated != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("date_created", dateCreated));
        }

        if (metadata != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("metadata", metadata));
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
    private okhttp3.Call listValidateBeforeCall(Integer limit, String before, String after, List<String> include, Map<String, String> dateCreated, Map<String, String> metadata, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = listCall(limit, before, after, include, dateCreated, metadata, _callback);
        return localVarCall;

    }

    /**
     * list
     * Returns a list of your bank accounts. The bank accounts are returned sorted by creation date, with the most recently created bank accounts appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param metadata Filter by metadata key-value pair&#x60;. (optional)
     * @return BankAccountList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; bank_accounts. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public BankAccountList list(Integer limit, String before, String after, List<String> include, Map<String, String> dateCreated, Map<String, String> metadata) throws ApiException {
        try {
            ApiResponse<BankAccountList> localVarResp = listWithHttpInfo(limit, before, after, include, dateCreated, metadata);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list
     * Returns a list of your bank accounts. The bank accounts are returned sorted by creation date, with the most recently created bank accounts appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param metadata Filter by metadata key-value pair&#x60;. (optional)
     * @return ApiResponse&lt;BankAccountList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; bank_accounts. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<BankAccountList> listWithHttpInfo(Integer limit, String before, String after, List<String> include, Map<String, String> dateCreated, Map<String, String> metadata) throws ApiException {
        try {
            okhttp3.Call localVarCall = listValidateBeforeCall(limit, before, after, include, dateCreated, metadata, null);
            Type localVarReturnType = new TypeToken<BankAccountList>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list (asynchronously)
     * Returns a list of your bank accounts. The bank accounts are returned sorted by creation date, with the most recently created bank accounts appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param metadata Filter by metadata key-value pair&#x60;. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; bank_accounts. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listAsync(Integer limit, String before, String after, List<String> include, Map<String, String> dateCreated, Map<String, String> metadata, final ApiCallback<BankAccountList> _callback) throws ApiException {

        okhttp3.Call localVarCall = listValidateBeforeCall(limit, before, after, include, dateCreated, metadata, _callback);
        Type localVarReturnType = new TypeToken<BankAccountList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

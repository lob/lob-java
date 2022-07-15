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


import com.lob.model.LobError;
import java.time.OffsetDateTime;
import com.lob.model.Template;
import com.lob.model.TemplateDeletion;
import com.lob.model.TemplateList;
import com.lob.model.TemplateUpdate;
import com.lob.model.TemplateWritable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplatesApi {
    private ApiClient localVarApiClient;

    public TemplatesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TemplatesApi(ApiClient apiClient) {
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
     * @param templateWritable  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCall(TemplateWritable templateWritable, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = templateWritable;

        // create path and map variables
        String localVarPath = "/templates";

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
    private okhttp3.Call createValidateBeforeCall(TemplateWritable templateWritable, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'templateWritable' is set
        if (templateWritable == null) {
            throw new ApiException("Missing the required parameter 'templateWritable' when calling create(Async)");
        }
        

        okhttp3.Call localVarCall = createCall(templateWritable, _callback);
        return localVarCall;

    }

    /**
     * create
     * Creates a new template for use with the Print &amp; Mail API. In Live mode, you can only have as many non-deleted templates as allotted in your current [Print &amp; Mail Edition](https://dashboard.lob.com/#/settings/editions). If you attempt to create a template past your limit, you will receive a &#x60;403&#x60; error. There is no limit in Test mode.
     * @param templateWritable  (required)
     * @return Template
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Template create(TemplateWritable templateWritable) throws ApiException {
        try {
            ApiResponse<Template> localVarResp = createWithHttpInfo(templateWritable);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create
     * Creates a new template for use with the Print &amp; Mail API. In Live mode, you can only have as many non-deleted templates as allotted in your current [Print &amp; Mail Edition](https://dashboard.lob.com/#/settings/editions). If you attempt to create a template past your limit, you will receive a &#x60;403&#x60; error. There is no limit in Test mode.
     * @param templateWritable  (required)
     * @return ApiResponse&lt;Template&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Template> createWithHttpInfo(TemplateWritable templateWritable) throws ApiException {
        try {
            okhttp3.Call localVarCall = createValidateBeforeCall(templateWritable, null);
            Type localVarReturnType = new TypeToken<Template>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * create (asynchronously)
     * Creates a new template for use with the Print &amp; Mail API. In Live mode, you can only have as many non-deleted templates as allotted in your current [Print &amp; Mail Edition](https://dashboard.lob.com/#/settings/editions). If you attempt to create a template past your limit, you will receive a &#x60;403&#x60; error. There is no limit in Test mode.
     * @param templateWritable  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createAsync(TemplateWritable templateWritable, final ApiCallback<Template> _callback) throws ApiException {

        okhttp3.Call localVarCall = createValidateBeforeCall(templateWritable, _callback);
        Type localVarReturnType = new TypeToken<Template>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for delete
     * @param tmplId id of the template (required)
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
    public okhttp3.Call deleteCall(String tmplId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/templates/{tmpl_id}"
            .replaceAll("\\{" + "tmpl_id" + "\\}", localVarApiClient.escapeString(tmplId.toString()));

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
    private okhttp3.Call deleteValidateBeforeCall(String tmplId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'tmplId' is set
        if (tmplId == null) {
            throw new ApiException("Missing the required parameter 'tmplId' when calling delete(Async)");
        }
        

        okhttp3.Call localVarCall = deleteCall(tmplId, _callback);
        return localVarCall;

    }

    /**
     * delete
     * Permanently deletes a template.
     * @param tmplId id of the template (required)
     * @return TemplateDeletion
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public TemplateDeletion delete(String tmplId) throws ApiException {
        try {
            ApiResponse<TemplateDeletion> localVarResp = deleteWithHttpInfo(tmplId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * delete
     * Permanently deletes a template.
     * @param tmplId id of the template (required)
     * @return ApiResponse&lt;TemplateDeletion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Deleted </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TemplateDeletion> deleteWithHttpInfo(String tmplId) throws ApiException {
        try {
            okhttp3.Call localVarCall = deleteValidateBeforeCall(tmplId, null);
            Type localVarReturnType = new TypeToken<TemplateDeletion>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * delete (asynchronously)
     * Permanently deletes a template.
     * @param tmplId id of the template (required)
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
    public okhttp3.Call deleteAsync(String tmplId, final ApiCallback<TemplateDeletion> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteValidateBeforeCall(tmplId, _callback);
        Type localVarReturnType = new TypeToken<TemplateDeletion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for get
     * @param tmplId id of the template (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCall(String tmplId, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/templates/{tmpl_id}"
            .replaceAll("\\{" + "tmpl_id" + "\\}", localVarApiClient.escapeString(tmplId.toString()));

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
    private okhttp3.Call getValidateBeforeCall(String tmplId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'tmplId' is set
        if (tmplId == null) {
            throw new ApiException("Missing the required parameter 'tmplId' when calling get(Async)");
        }
        

        okhttp3.Call localVarCall = getCall(tmplId, _callback);
        return localVarCall;

    }

    /**
     * get
     * Retrieves the details of an existing template.
     * @param tmplId id of the template (required)
     * @return Template
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Template get(String tmplId) throws ApiException {
        try {
            ApiResponse<Template> localVarResp = getWithHttpInfo(tmplId);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get
     * Retrieves the details of an existing template.
     * @param tmplId id of the template (required)
     * @return ApiResponse&lt;Template&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Template> getWithHttpInfo(String tmplId) throws ApiException {
        try {
            okhttp3.Call localVarCall = getValidateBeforeCall(tmplId, null);
            Type localVarReturnType = new TypeToken<Template>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * get (asynchronously)
     * Retrieves the details of an existing template.
     * @param tmplId id of the template (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns a template object </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAsync(String tmplId, final ApiCallback<Template> _callback) throws ApiException {

        okhttp3.Call localVarCall = getValidateBeforeCall(tmplId, _callback);
        Type localVarReturnType = new TypeToken<Template>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for update
     * @param tmplId id of the template (required)
     * @param templateUpdate  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the updated template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateCall(String tmplId, TemplateUpdate templateUpdate, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = templateUpdate;

        // create path and map variables
        String localVarPath = "/templates/{tmpl_id}"
            .replaceAll("\\{" + "tmpl_id" + "\\}", localVarApiClient.escapeString(tmplId.toString()));

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
    private okhttp3.Call updateValidateBeforeCall(String tmplId, TemplateUpdate templateUpdate, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'tmplId' is set
        if (tmplId == null) {
            throw new ApiException("Missing the required parameter 'tmplId' when calling update(Async)");
        }
        
        // verify the required parameter 'templateUpdate' is set
        if (templateUpdate == null) {
            throw new ApiException("Missing the required parameter 'templateUpdate' when calling update(Async)");
        }
        

        okhttp3.Call localVarCall = updateCall(tmplId, templateUpdate, _callback);
        return localVarCall;

    }

    /**
     * update
     * Updates the description and/or published version of the template with the given id.
     * @param tmplId id of the template (required)
     * @param templateUpdate  (required)
     * @return Template
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the updated template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public Template update(String tmplId, TemplateUpdate templateUpdate) throws ApiException {
        try {
            ApiResponse<Template> localVarResp = updateWithHttpInfo(tmplId, templateUpdate);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * update
     * Updates the description and/or published version of the template with the given id.
     * @param tmplId id of the template (required)
     * @param templateUpdate  (required)
     * @return ApiResponse&lt;Template&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the updated template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Template> updateWithHttpInfo(String tmplId, TemplateUpdate templateUpdate) throws ApiException {
        try {
            okhttp3.Call localVarCall = updateValidateBeforeCall(tmplId, templateUpdate, null);
            Type localVarReturnType = new TypeToken<Template>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * update (asynchronously)
     * Updates the description and/or published version of the template with the given id.
     * @param tmplId id of the template (required)
     * @param templateUpdate  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the updated template object </td><td>  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateAsync(String tmplId, TemplateUpdate templateUpdate, final ApiCallback<Template> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateValidateBeforeCall(tmplId, templateUpdate, _callback);
        Type localVarReturnType = new TypeToken<Template>(){}.getType();
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
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; templates. Each entry in the array is a separate template. The previous and next page of templates can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively.&lt;br&gt;If no more templates are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCall(Integer limit, String before, String after, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> metadata, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/templates";

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
    private okhttp3.Call listValidateBeforeCall(Integer limit, String before, String after, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> metadata, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = listCall(limit, before, after, include, dateCreated, metadata, _callback);
        return localVarCall;

    }

    /**
     * list
     * Returns a list of your templates. The templates are returned sorted by creation date, with the most recently created templates appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param metadata Filter by metadata key-value pair&#x60;. (optional)
     * @return TemplateList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; templates. Each entry in the array is a separate template. The previous and next page of templates can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively.&lt;br&gt;If no more templates are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public TemplateList list(Integer limit, String before, String after, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> metadata) throws ApiException {
        try {
            ApiResponse<TemplateList> localVarResp = listWithHttpInfo(limit, before, after, include, dateCreated, metadata);
            return localVarResp.getData();
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list
     * Returns a list of your templates. The templates are returned sorted by creation date, with the most recently created templates appearing first.
     * @param limit How many results to return. (optional, default to 10)
     * @param before A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  (optional)
     * @param after A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  (optional)
     * @param include Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  (optional)
     * @param dateCreated Filter by date created. (optional)
     * @param metadata Filter by metadata key-value pair&#x60;. (optional)
     * @return ApiResponse&lt;TemplateList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; templates. Each entry in the array is a separate template. The previous and next page of templates can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively.&lt;br&gt;If no more templates are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TemplateList> listWithHttpInfo(Integer limit, String before, String after, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> metadata) throws ApiException {
        try {
            okhttp3.Call localVarCall = listValidateBeforeCall(limit, before, after, include, dateCreated, metadata, null);
            Type localVarReturnType = new TypeToken<TemplateList>(){}.getType();
            return localVarApiClient.execute(localVarCall, localVarReturnType);
        } catch (ApiException e) {
            throw e;
        }
    }

    /**
     * list (asynchronously)
     * Returns a list of your templates. The templates are returned sorted by creation date, with the most recently created templates appearing first.
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
        <tr><td> 200 </td><td> A dictionary with a data property that contains an array of up to &#x60;limit&#x60; templates. Each entry in the array is a separate template. The previous and next page of templates can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively.&lt;br&gt;If no more templates are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Lob uses RESTful HTTP response codes to indicate success or failure of an API request. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listAsync(Integer limit, String before, String after, List<String> include, Map<String, OffsetDateTime> dateCreated, Map<String, String> metadata, final ApiCallback<TemplateList> _callback) throws ApiException {

        okhttp3.Call localVarCall = listValidateBeforeCall(limit, before, after, include, dateCreated, metadata, _callback);
        Type localVarReturnType = new TypeToken<TemplateList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}

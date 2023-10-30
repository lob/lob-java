# TemplateVersionsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](TemplateVersionsApi.md#create) | **POST** /templates/{tmpl_id}/versions | create
[**delete**](TemplateVersionsApi.md#delete) | **DELETE** /templates/{tmpl_id}/versions/{vrsn_id} | delete
[**get**](TemplateVersionsApi.md#get) | **GET** /templates/{tmpl_id}/versions/{vrsn_id} | get
[**update**](TemplateVersionsApi.md#update) | **POST** /templates/{tmpl_id}/versions/{vrsn_id} | update
[**list**](TemplateVersionsApi.md#list) | **GET** /templates/{tmpl_id}/versions | list


<a name="create"></a>
# **create**
> TemplateVersion create(tmplId, templateVersionWritable)

create

Creates a new template version attached to the specified template.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    String tmplId = "tmplId_example"; // String | The ID of the template the new version will be attached to
    TemplateVersionWritable templateVersionWritable = new TemplateVersionWritable(); // TemplateVersionWritable | 
    try {
      TemplateVersion result = apiInstance.create(tmplId, templateVersionWritable);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#create");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tmplId** | **String**| The ID of the template the new version will be attached to |
 **templateVersionWritable** | [**TemplateVersionWritable**](TemplateVersionWritable.md)|  |

### Return type

[**TemplateVersion**](TemplateVersion.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns the template version with the given template and version ids. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="delete"></a>
# **delete**
> TemplateVersionDeletion delete(tmplId, vrsnId)

delete

Permanently deletes a template version. A template&#39;s &#x60;published_version&#x60; can not be deleted.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    String tmplId = "tmplId_example"; // String | The ID of the template to which the version belongs.
    String vrsnId = "vrsnId_example"; // String | id of the template_version
    try {
      TemplateVersionDeletion result = apiInstance.delete(tmplId, vrsnId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#delete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tmplId** | **String**| The ID of the template to which the version belongs. |
 **vrsnId** | **String**| id of the template_version |

### Return type

[**TemplateVersionDeletion**](TemplateVersionDeletion.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deleted |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="get"></a>
# **get**
> TemplateVersion get(tmplId, vrsnId)

get

Retrieves the template version with the given template and version ids.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    String tmplId = "tmplId_example"; // String | The ID of the template to which the version belongs.
    String vrsnId = "vrsnId_example"; // String | id of the template_version
    try {
      TemplateVersion result = apiInstance.get(tmplId, vrsnId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#get");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tmplId** | **String**| The ID of the template to which the version belongs. |
 **vrsnId** | **String**| id of the template_version |

### Return type

[**TemplateVersion**](TemplateVersion.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns the template version with the given template and version ids. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="update"></a>
# **update**
> TemplateVersion update(tmplId, vrsnId, templateVersionUpdatable)

update

Updates the template version with the given template and version ids.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    String tmplId = "tmplId_example"; // String | The ID of the template to which the version belongs.
    String vrsnId = "vrsnId_example"; // String | id of the template_version
    TemplateVersionUpdatable templateVersionUpdatable = new TemplateVersionUpdatable(); // TemplateVersionUpdatable | 
    try {
      TemplateVersion result = apiInstance.update(tmplId, vrsnId, templateVersionUpdatable);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#update");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tmplId** | **String**| The ID of the template to which the version belongs. |
 **vrsnId** | **String**| id of the template_version |
 **templateVersionUpdatable** | [**TemplateVersionUpdatable**](TemplateVersionUpdatable.md)|  |

### Return type

[**TemplateVersion**](TemplateVersion.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns the template version with the given template and version ids. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="list"></a>
# **list**
> TemplateVersionList list(tmplId, limit, before, after, include, dateCreated)

list

Returns a list of template versions for the given template ID. The template versions are sorted by creation date, with the most recently created appearing first. 

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplateVersionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplateVersionsApi apiInstance = new TemplateVersionsApi(defaultClient);
    String tmplId = "tmplId_example"; // String | The ID of the template associated with the retrieved versions
    Integer limit = 10; // Integer | How many results to return.
    String before = "before_example"; // String | A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the `previous_url` field in the return response. 
    String after = "after_example"; // String | A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the `next_url` field in the return response. 
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    Map<String, OffsetDateTime> dateCreated = new HashMap(); // Map<String, OffsetDateTime> | Filter by date created.
    try {
      TemplateVersionList result = apiInstance.list(tmplId, limit, before, after, include, dateCreated);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateVersionsApi#list");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tmplId** | **String**| The ID of the template associated with the retrieved versions |
 **limit** | **Integer**| How many results to return. | [optional] [default to 10]
 **before** | **String**| A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  | [optional]
 **after** | **String**| A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  | [optional]
 **include** | [**List&lt;String&gt;**](String.md)| Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  | [optional]
 **dateCreated** | [**Map&lt;String, OffsetDateTime&gt;**](OffsetDateTime.md)| Filter by date created. | [optional]

### Return type

[**TemplateVersionList**](TemplateVersionList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A dictionary with a data property that contains an array of up to &#x60;limit&#x60; template versions. Each entry in the array is a separate template version object. The previous and next page of template versions can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively.&lt;br&gt;If no more template versions are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


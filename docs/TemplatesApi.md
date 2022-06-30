# TemplatesApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](TemplatesApi.md#create) | **POST** /templates | create
[**delete**](TemplatesApi.md#delete) | **DELETE** /templates/{tmpl_id} | delete
[**get**](TemplatesApi.md#get) | **GET** /templates/{tmpl_id} | get
[**update**](TemplatesApi.md#update) | **POST** /templates/{tmpl_id} | update
[**list**](TemplatesApi.md#list) | **GET** /templates | list


<a name="create"></a>
# **create**
> Template create(templateWritable)

create

Creates a new template for use with the Print &amp; Mail API. In Live mode, you can only have as many non-deleted templates as allotted in your current [Print &amp; Mail Edition](https://dashboard.lob.com/#/settings/editions). If you attempt to create a template past your limit, you will receive a &#x60;403&#x60; error. There is no limit in Test mode.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    TemplateWritable templateWritable = new TemplateWritable(); // TemplateWritable | 
    try {
      Template result = apiInstance.create(templateWritable);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#create");
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
 **templateWritable** | [**TemplateWritable**](TemplateWritable.md)|  |

### Return type

[**Template**](Template.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a template object |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="delete"></a>
# **delete**
> TemplateDeletion delete(tmplId)

delete

Permanently deletes a template.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    String tmplId = "tmplId_example"; // String | id of the template
    try {
      TemplateDeletion result = apiInstance.delete(tmplId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#delete");
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
 **tmplId** | **String**| id of the template |

### Return type

[**TemplateDeletion**](TemplateDeletion.md)

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
> Template get(tmplId)

get

Retrieves the details of an existing template.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    String tmplId = "tmplId_example"; // String | id of the template
    try {
      Template result = apiInstance.get(tmplId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#get");
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
 **tmplId** | **String**| id of the template |

### Return type

[**Template**](Template.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a template object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="update"></a>
# **update**
> Template update(tmplId, templateUpdate)

update

Updates the description and/or published version of the template with the given id.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    String tmplId = "tmplId_example"; // String | id of the template
    TemplateUpdate templateUpdate = new TemplateUpdate(); // TemplateUpdate | 
    try {
      Template result = apiInstance.update(tmplId, templateUpdate);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#update");
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
 **tmplId** | **String**| id of the template |
 **templateUpdate** | [**TemplateUpdate**](TemplateUpdate.md)|  |

### Return type

[**Template**](Template.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns the updated template object |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="list"></a>
# **list**
> TemplateList list(limit, before, after, include, dateCreated, metadata)

list

Returns a list of your templates. The templates are returned sorted by creation date, with the most recently created templates appearing first.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.TemplatesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    TemplatesApi apiInstance = new TemplatesApi(defaultClient);
    Integer limit = 10; // Integer | How many results to return.
    String before = "before_example"; // String | A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the `previous_url` field in the return response. 
    String after = "after_example"; // String | A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the `next_url` field in the return response. 
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    Map<String, String> dateCreated = new HashMap(); // Map<String, String> | Filter by date created.
    Map<String, String> metadata = new HashMap(); // Map<String, String> | Filter by metadata key-value pair`.
    try {
      TemplateList result = apiInstance.list(limit, before, after, include, dateCreated, metadata);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplatesApi#list");
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
 **limit** | **Integer**| How many results to return. | [optional] [default to 10]
 **before** | **String**| A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  | [optional]
 **after** | **String**| A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  | [optional]
 **include** | [**List&lt;String&gt;**](String.md)| Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  | [optional]
 **dateCreated** | [**Map&lt;String, String&gt;**](String.md)| Filter by date created. | [optional]
 **metadata** | [**Map&lt;String, String&gt;**](String.md)| Filter by metadata key-value pair&#x60;. | [optional]

### Return type

[**TemplateList**](TemplateList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A dictionary with a data property that contains an array of up to &#x60;limit&#x60; templates. Each entry in the array is a separate template. The previous and next page of templates can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively.&lt;br&gt;If no more templates are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


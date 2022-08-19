# UploadsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_export**](UploadsApi.md#get_export) | **GET** /uploads/{upl_id}/exports/{ex_id} | get_export
[**create_upload**](UploadsApi.md#create_upload) | **POST** /uploads | create_upload
[**delete_upload**](UploadsApi.md#delete_upload) | **DELETE** /uploads/{upl_id} | delete_upload
[**create_export**](UploadsApi.md#create_export) | **POST** /uploads/{upl_id}/exports | create_export
[**get_upload**](UploadsApi.md#get_upload) | **GET** /uploads/{upl_id} | get_upload
[**update_upload**](UploadsApi.md#update_upload) | **PATCH** /uploads/{upl_id} | update_upload
[**list_upload**](UploadsApi.md#list_upload) | **GET** /uploads | list_upload


<a name="get_export"></a>
# **get_export**
> InlineResponse200 get_export(uplId, exId)

get_export

Retrieves the details of an existing export. You need only supply the unique export identifier that was returned upon export creation. If you try retrieving an export immediately after creating one (i.e., before we&#39;re done processing the export), you will get back an export object with &#x60;state &#x3D; in_progress&#x60;.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    String uplId = "uplId_example"; // String | ID of the upload
    String exId = "exId_example"; // String | ID of the export
    try {
      InlineResponse200 result = apiInstance.get_export(uplId, exId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#get_export");
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
 **uplId** | **String**| ID of the upload |
 **exId** | **String**| ID of the export |

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an export object |  -  |

<a name="create_upload"></a>
# **create_upload**
> Upload create_upload(uploadWritable)

create_upload

Creates a new upload with the provided properties.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    UploadWritable uploadWritable = new UploadWritable(); // UploadWritable | 
    try {
      Upload result = apiInstance.create_upload(uploadWritable);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#create_upload");
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
 **uploadWritable** | [**UploadWritable**](UploadWritable.md)|  |

### Return type

[**Upload**](Upload.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Upload created successfully |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="delete_upload"></a>
# **delete_upload**
> delete_upload(uplId)

delete_upload

Delete an existing upload. You need only supply the unique identifier that was returned upon upload creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    String uplId = "uplId_example"; // String | id of the upload
    try {
      apiInstance.delete_upload(uplId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#delete_upload");
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
 **uplId** | **String**| id of the upload |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Successful Response |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="create_export"></a>
# **create_export**
> UploadCreateExport create_export(uplId, exportModel)

create_export

Campaign Exports can help you understand exactly which records in a campaign could not be created. By initiating and retrieving an export, you will get row-by-row errors for your campaign. For a step-by-step walkthrough of creating a campaign and exporting failures, see our [Campaigns Guide](https://help.lob.com/best-practices/launching-your-first-campaign).  Create an export file associated with an upload.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    String uplId = "uplId_example"; // String | ID of the upload
    ExportModel exportModel = new ExportModel(); // ExportModel | 
    try {
      UploadCreateExport result = apiInstance.create_export(uplId, exportModel);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#create_export");
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
 **uplId** | **String**| ID of the upload |
 **exportModel** | [**ExportModel**](ExportModel.md)|  |

### Return type

[**UploadCreateExport**](UploadCreateExport.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful Response |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="get_upload"></a>
# **get_upload**
> Upload get_upload(uplId)

get_upload

Retrieves the details of an existing upload. You need only supply the unique upload identifier that was returned upon upload creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    String uplId = "uplId_example"; // String | id of the upload
    try {
      Upload result = apiInstance.get_upload(uplId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#get_upload");
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
 **uplId** | **String**| id of the upload |

### Return type

[**Upload**](Upload.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an upload object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="update_upload"></a>
# **update_upload**
> Upload update_upload(uplId, uploadUpdatable)

update_upload

Update the details of an existing upload. You need only supply the unique identifier that was returned upon upload creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    String uplId = "uplId_example"; // String | id of the upload
    UploadUpdatable uploadUpdatable = new UploadUpdatable(); // UploadUpdatable | 
    try {
      Upload result = apiInstance.update_upload(uplId, uploadUpdatable);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#update_upload");
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
 **uplId** | **String**| id of the upload |
 **uploadUpdatable** | [**UploadUpdatable**](UploadUpdatable.md)|  |

### Return type

[**Upload**](Upload.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an upload object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="list_upload"></a>
# **list_upload**
> UploadList list_upload(campaignId)

list_upload

Returns a list of your uploads. Optionally, filter uploads by campaign.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UploadsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UploadsApi apiInstance = new UploadsApi(defaultClient);
    String campaignId = "campaignId_example"; // String | id of the campaign
    try {
      UploadList result = apiInstance.list_upload(campaignId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#list_upload");
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
 **campaignId** | **String**| id of the campaign | [optional]

### Return type

[**UploadList**](UploadList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | An array of matching uploads. Each entry in the array is a separate upload. |  -  |


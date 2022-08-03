# UploadsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Retrieve Export**](UploadsApi.md#Retrieve Export) | **GET** /uploads/{upl_id}/exports/{ex_id} | Retrieve Export
[**Create**](UploadsApi.md#Create) | **POST** /uploads | Create
[**Delete**](UploadsApi.md#Delete) | **DELETE** /uploads/{upl_id} | Delete
[**Create Export**](UploadsApi.md#Create Export) | **POST** /uploads/{upl_id}/exports | Create Export
[**Upload file**](UploadsApi.md#Upload file) | **POST** /uploads/{upl_id}/file | Upload file
[**Retrieve**](UploadsApi.md#Retrieve) | **GET** /uploads/{upl_id} | Retrieve
[**Update**](UploadsApi.md#Update) | **PATCH** /uploads/{upl_id} | Update
[**List**](UploadsApi.md#List) | **GET** /uploads | List


<a name="Retrieve Export"></a>
# **Retrieve Export**
> InlineResponse200 Retrieve Export(uplId, exId)

Retrieve Export

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
      InlineResponse200 result = apiInstance.Retrieve Export(uplId, exId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Retrieve Export");
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

<a name="Create"></a>
# **Create**
> Upload Create(uploadWritable)

Create

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
      Upload result = apiInstance.Create(uploadWritable);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Create");
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

<a name="Delete"></a>
# **Delete**
> Delete(uplId)

Delete

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
      apiInstance.Delete(uplId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Delete");
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

<a name="Create Export"></a>
# **Create Export**
> UploadCreateExport Create Export(uplId, exportModel)

Create Export

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
      UploadCreateExport result = apiInstance.Create Export(uplId, exportModel);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Create Export");
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

<a name="Upload file"></a>
# **Upload file**
> UploadFile Upload file(uplId, file)

Upload file

Upload an [audience file](https://help.lob.com/best-practices/campaign-audience-guide) and associate it with an upload.

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
    File file = new File("/path/to/file"); // File | 
    try {
      UploadFile result = apiInstance.Upload file(uplId, file);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Upload file");
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
 **file** | **File**|  | [optional]

### Return type

[**UploadFile**](UploadFile.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | Successful Response |  -  |
**0** | Error Response |  -  |

<a name="Retrieve"></a>
# **Retrieve**
> Upload Retrieve(uplId)

Retrieve

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
      Upload result = apiInstance.Retrieve(uplId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Retrieve");
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

<a name="Update"></a>
# **Update**
> Upload Update(uplId, uploadUpdatable)

Update

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
      Upload result = apiInstance.Update(uplId, uploadUpdatable);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#Update");
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

<a name="List"></a>
# **List**
> UploadList List(campaignId)

List

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
      UploadList result = apiInstance.List(campaignId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UploadsApi#List");
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


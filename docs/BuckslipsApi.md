# BuckslipsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Create**](BuckslipsApi.md#Create) | **POST** /buckslips | Create
[**Delete**](BuckslipsApi.md#Delete) | **DELETE** /buckslips/{buckslip_id} | Delete
[**Retrieve**](BuckslipsApi.md#Retrieve) | **GET** /buckslips/{buckslip_id} | Retrieve
[**Update**](BuckslipsApi.md#Update) | **PATCH** /buckslips/{buckslip_id} | Update
[**List**](BuckslipsApi.md#List) | **GET** /buckslips | List


<a name="Create"></a>
# **Create**
> Buckslip Create(buckslipEditable)

Create

Creates a new buckslip given information

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipsApi apiInstance = new BuckslipsApi(defaultClient);
    BuckslipEditable buckslipEditable = new BuckslipEditable(); // BuckslipEditable | 
    try {
      Buckslip result = apiInstance.Create(buckslipEditable);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipsApi#Create");
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
 **buckslipEditable** | [**BuckslipEditable**](BuckslipEditable.md)|  |

### Return type

[**Buckslip**](Buckslip.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Buckslip created successfully |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="Delete"></a>
# **Delete**
> BuckslipDeletion Delete(buckslipId)

Delete

Delete an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipsApi apiInstance = new BuckslipsApi(defaultClient);
    String buckslipId = "buckslipId_example"; // String | id of the buckslip
    try {
      BuckslipDeletion result = apiInstance.Delete(buckslipId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipsApi#Delete");
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
 **buckslipId** | **String**| id of the buckslip |

### Return type

[**BuckslipDeletion**](BuckslipDeletion.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deleted the buckslip |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="Retrieve"></a>
# **Retrieve**
> Buckslip Retrieve(buckslipId)

Retrieve

Retrieves the details of an existing buckslip. You need only supply the unique customer identifier that was returned upon buckslip creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipsApi apiInstance = new BuckslipsApi(defaultClient);
    String buckslipId = "buckslipId_example"; // String | id of the buckslip
    try {
      Buckslip result = apiInstance.Retrieve(buckslipId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipsApi#Retrieve");
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
 **buckslipId** | **String**| id of the buckslip |

### Return type

[**Buckslip**](Buckslip.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a buckslip object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="Update"></a>
# **Update**
> Buckslip Update(buckslipId, buckslipUpdatable)

Update

Update the details of an existing buckslip. You need only supply the unique identifier that was returned upon buckslip creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipsApi apiInstance = new BuckslipsApi(defaultClient);
    String buckslipId = "buckslipId_example"; // String | id of the buckslip
    BuckslipUpdatable buckslipUpdatable = new BuckslipUpdatable(); // BuckslipUpdatable | 
    try {
      Buckslip result = apiInstance.Update(buckslipId, buckslipUpdatable);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipsApi#Update");
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
 **buckslipId** | **String**| id of the buckslip |
 **buckslipUpdatable** | [**BuckslipUpdatable**](BuckslipUpdatable.md)|  |

### Return type

[**Buckslip**](Buckslip.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a buckslip object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="List"></a>
# **List**
> BuckslipsList List(limit, before, after, include)

List

Returns a list of your buckslips. The buckslips are returned sorted by creation date, with the most recently created buckslips appearing first.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipsApi apiInstance = new BuckslipsApi(defaultClient);
    Integer limit = 10; // Integer | How many results to return.
    String before = "before_example"; // String | A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the `previous_url` field in the return response. 
    String after = "after_example"; // String | A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the `next_url` field in the return response. 
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    try {
      BuckslipsList result = apiInstance.List(limit, before, after, include);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipsApi#List");
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

### Return type

[**BuckslipsList**](BuckslipsList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | description: Returns a list of buckslip objects |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


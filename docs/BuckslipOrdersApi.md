# BuckslipOrdersApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](BuckslipOrdersApi.md#create) | **POST** /buckslips/{buckslip_id}/orders | create
[**get**](BuckslipOrdersApi.md#get) | **GET** /buckslips/{buckslip_id}/orders | get


<a name="create"></a>
# **create**
> BuckslipOrder create(buckslipId, buckslipOrderEditable)

create

Creates a new buckslip order given information

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipOrdersApi apiInstance = new BuckslipOrdersApi(defaultClient);
    String buckslipId = "buckslipId_example"; // String | The ID of the buckslip to which the buckslip orders belong.
    BuckslipOrderEditable buckslipOrderEditable = new BuckslipOrderEditable(); // BuckslipOrderEditable | 
    try {
      BuckslipOrder result = apiInstance.create(buckslipId, buckslipOrderEditable);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipOrdersApi#create");
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
 **buckslipId** | **String**| The ID of the buckslip to which the buckslip orders belong. |
 **buckslipOrderEditable** | [**BuckslipOrderEditable**](BuckslipOrderEditable.md)|  |

### Return type

[**BuckslipOrder**](BuckslipOrder.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Buckslip order created successfully |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="get"></a>
# **get**
> BuckslipOrdersList get(buckslipId, limit, offset)

get

Retrieves the buckslip orders associated with the given buckslip id.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BuckslipOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BuckslipOrdersApi apiInstance = new BuckslipOrdersApi(defaultClient);
    String buckslipId = "buckslipId_example"; // String | The ID of the buckslip to which the buckslip orders belong.
    Integer limit = 10; // Integer | How many results to return.
    Integer offset = 0; // Integer | An integer that designates the offset at which to begin returning results. Defaults to 0.
    try {
      BuckslipOrdersList result = apiInstance.get(buckslipId, limit, offset);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuckslipOrdersApi#get");
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
 **buckslipId** | **String**| The ID of the buckslip to which the buckslip orders belong. |
 **limit** | **Integer**| How many results to return. | [optional] [default to 10]
 **offset** | **Integer**| An integer that designates the offset at which to begin returning results. Defaults to 0. | [optional] [default to 0]

### Return type

[**BuckslipOrdersList**](BuckslipOrdersList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns the buckslip orders associated with the given buckslip id |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


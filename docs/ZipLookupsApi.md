# ZipLookupsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**lookup**](ZipLookupsApi.md#lookup) | **POST** /us_zip_lookups | lookup


<a name="lookup"></a>
# **lookup**
> Zip lookup(zipEditable)

lookup

Returns information about a ZIP code

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.ZipLookupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    ZipLookupsApi apiInstance = new ZipLookupsApi(defaultClient);
    ZipEditable zipEditable = new ZipEditable(); // ZipEditable | 
    try {
      Zip result = apiInstance.lookup(zipEditable);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ZipLookupsApi#lookup");
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
 **zipEditable** | [**ZipEditable**](ZipEditable.md)|  |

### Return type

[**Zip**](Zip.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a zip lookup object if a valid zip was provided. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


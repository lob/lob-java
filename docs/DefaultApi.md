# DefaultApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**placeholder_no_call**](DefaultApi.md#placeholder_no_call) | **GET** /shared_dont_call | placeholder_no_call


<a name="placeholder_no_call"></a>
# **placeholder_no_call**
> PlaceholderModel placeholder_no_call()

placeholder_no_call

Don&#39;t call this. It&#39;s so that the right models can be generated.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      PlaceholderModel result = apiInstance.placeholder_no_call();
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#placeholder_no_call");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PlaceholderModel**](PlaceholderModel.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Uncallable, used for generating missing models |  -  |


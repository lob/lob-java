# UsAutocompletionsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocomplete**](UsAutocompletionsApi.md#autocomplete) | **POST** /us_autocompletions | autocomplete


<a name="autocomplete"></a>
# **autocomplete**
> UsAutocompletions autocomplete(usAutocompletionsWritable)

autocomplete

Given an address prefix consisting of a partial primary line, as well as optional input of city, state, and zip code, this functionality returns up to 10 full US address suggestions. Not all of them will turn out to be valid addresses; they&#39;ll need to be [verified](#operation/verification_us).

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UsAutocompletionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UsAutocompletionsApi apiInstance = new UsAutocompletionsApi(defaultClient);
    UsAutocompletionsWritable usAutocompletionsWritable = new UsAutocompletionsWritable(); // UsAutocompletionsWritable | 
    try {
      UsAutocompletions result = apiInstance.autocomplete(usAutocompletionsWritable);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsAutocompletionsApi#autocomplete");
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
 **usAutocompletionsWritable** | [**UsAutocompletionsWritable**](UsAutocompletionsWritable.md)|  |

### Return type

[**UsAutocompletions**](UsAutocompletions.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a US autocompletion object. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


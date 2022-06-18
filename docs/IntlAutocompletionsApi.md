# IntlAutocompletionsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**autocomplete**](IntlAutocompletionsApi.md#autocomplete) | **POST** /intl_autocompletions | autocomplete


<a name="autocomplete"></a>
# **autocomplete**
> IntlAutocompletions autocomplete(intlAutocompletionsWritable, xLangOutput)

autocomplete

Given an address prefix consisting of a partial primary line and country, as well as optional input of city, state, and zip code, this functionality returns up to 10 full International address suggestions. Not all of them will turn out to be valid addresses; they&#39;ll need to be [verified](#operation/intl_verification).

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.IntlAutocompletionsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    IntlAutocompletionsApi apiInstance = new IntlAutocompletionsApi(defaultClient);
    IntlAutocompletionsWritable intlAutocompletionsWritable = new IntlAutocompletionsWritable(); // IntlAutocompletionsWritable | 
    String xLangOutput = "native"; // String | * `native` - Translate response to the native language of the country in the request * `match` - match the response to the language in the request  Default response is in English. 
    try {
      IntlAutocompletions result = apiInstance.autocomplete(intlAutocompletionsWritable, xLangOutput);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IntlAutocompletionsApi#autocomplete");
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
 **intlAutocompletionsWritable** | [**IntlAutocompletionsWritable**](IntlAutocompletionsWritable.md)|  |
 **xLangOutput** | **String**| * &#x60;native&#x60; - Translate response to the native language of the country in the request * &#x60;match&#x60; - match the response to the language in the request  Default response is in English.  | [optional] [enum: native, match]

### Return type

[**IntlAutocompletions**](IntlAutocompletions.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an international autocompletions object. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


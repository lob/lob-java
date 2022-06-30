# IntlVerificationsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**verifyBulk**](IntlVerificationsApi.md#verifyBulk) | **POST** /bulk/intl_verifications | verifyBulk
[**verifySingle**](IntlVerificationsApi.md#verifySingle) | **POST** /intl_verifications | verifySingle


<a name="verifyBulk"></a>
# **verifyBulk**
> IntlVerifications verifyBulk(intlVerificationsPayload)

verifyBulk

Verify a list of international (except US or US territories) address with a live API key.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.IntlVerificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    IntlVerificationsApi apiInstance = new IntlVerificationsApi(defaultClient);
    IntlVerificationsPayload intlVerificationsPayload = new IntlVerificationsPayload(); // IntlVerificationsPayload | 
    try {
      IntlVerifications result = apiInstance.verifyBulk(intlVerificationsPayload);
    } catch (ApiException e) {
      System.err.println("Exception when calling IntlVerificationsApi#verifyBulk");
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
 **intlVerificationsPayload** | [**IntlVerificationsPayload**](IntlVerificationsPayload.md)|  |

### Return type

[**IntlVerifications**](IntlVerifications.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an array of international verification objects. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="verifySingle"></a>
# **verifySingle**
> IntlVerification verifySingle(intlVerificationWritable, xLangOutput)

verifySingle

Verify an international (except US or US territories) address with a live API key.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.IntlVerificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    IntlVerificationsApi apiInstance = new IntlVerificationsApi(defaultClient);
    IntlVerificationWritable intlVerificationWritable = new IntlVerificationWritable(); // IntlVerificationWritable | 
    String xLangOutput = "native"; // String | * `native` - Translate response to the native language of the country in the request * `match` - match the response to the language in the request  Default response is in English. 
    try {
      IntlVerification result = apiInstance.verifySingle(intlVerificationWritable, xLangOutput);
    } catch (ApiException e) {
      System.err.println("Exception when calling IntlVerificationsApi#verifySingle");
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
 **intlVerificationWritable** | [**IntlVerificationWritable**](IntlVerificationWritable.md)|  |
 **xLangOutput** | **String**| * &#x60;native&#x60; - Translate response to the native language of the country in the request * &#x60;match&#x60; - match the response to the language in the request  Default response is in English.  | [optional] [enum: native, match]

### Return type

[**IntlVerification**](IntlVerification.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an international verification object. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


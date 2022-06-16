# UsVerificationsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**verifyBulk**](UsVerificationsApi.md#verifyBulk) | **POST** /bulk/us_verifications | verifyBulk
[**verifySingle**](UsVerificationsApi.md#verifySingle) | **POST** /us_verifications | verifySingle


<a name="verifyBulk"></a>
# **verifyBulk**
> UsVerifications verifyBulk(multipleComponentsList, _case)

verifyBulk

Verify a list of US or US territory addresses with a live API key.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UsVerificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UsVerificationsApi apiInstance = new UsVerificationsApi(defaultClient);
    MultipleComponentsList multipleComponentsList = new MultipleComponentsList(); // MultipleComponentsList | 
    String _case = "upper"; // String | Casing of the verified address. Possible values are `upper` and `proper` for uppercased (e.g. \"PO BOX\") and proper-cased (e.g. \"PO Box\"), respectively.
    try {
      UsVerifications result = apiInstance.verifyBulk(multipleComponentsList, _case);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsVerificationsApi#verifyBulk");
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
 **multipleComponentsList** | [**MultipleComponentsList**](MultipleComponentsList.md)|  |
 **_case** | **String**| Casing of the verified address. Possible values are &#x60;upper&#x60; and &#x60;proper&#x60; for uppercased (e.g. \&quot;PO BOX\&quot;) and proper-cased (e.g. \&quot;PO Box\&quot;), respectively. | [optional] [default to upper] [enum: upper, proper]

### Return type

[**UsVerifications**](UsVerifications.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a list of US verification objects. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="verifySingle"></a>
# **verifySingle**
> UsVerification verifySingle(usVerificationsWritable, _case)

verifySingle

Verify a US or US territory address with a live API key.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.UsVerificationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    UsVerificationsApi apiInstance = new UsVerificationsApi(defaultClient);
    UsVerificationsWritable usVerificationsWritable = new UsVerificationsWritable(); // UsVerificationsWritable | 
    String _case = "upper"; // String | Casing of the verified address. Possible values are `upper` and `proper` for uppercased (e.g. \"PO BOX\") and proper-cased (e.g. \"PO Box\"), respectively.
    try {
      UsVerification result = apiInstance.verifySingle(usVerificationsWritable, _case);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsVerificationsApi#verifySingle");
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
 **usVerificationsWritable** | [**UsVerificationsWritable**](UsVerificationsWritable.md)|  |
 **_case** | **String**| Casing of the verified address. Possible values are &#x60;upper&#x60; and &#x60;proper&#x60; for uppercased (e.g. \&quot;PO BOX\&quot;) and proper-cased (e.g. \&quot;PO Box\&quot;), respectively. | [optional] [default to upper] [enum: upper, proper]

### Return type

[**UsVerification**](UsVerification.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a US verification object. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


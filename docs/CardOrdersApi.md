# CardOrdersApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cardOrderCreate**](CardOrdersApi.md#cardOrderCreate) | **POST** /cards/{card_id}/orders | create
[**cardOrdersRetrieve**](CardOrdersApi.md#cardOrdersRetrieve) | **GET** /cards/{card_id}/orders | get


<a name="cardOrderCreate"></a>
# **cardOrderCreate**
> CardOrder cardOrderCreate(cardId, cardOrderEditable)

create

Creates a new card order given information

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    CardOrdersApi apiInstance = new CardOrdersApi(defaultClient);
    String cardId = "cardId_example"; // String | The ID of the card to which the card orders belong.
    CardOrderEditable cardOrderEditable = new CardOrderEditable(); // CardOrderEditable | 
    try {
      CardOrder result = apiInstance.cardOrderCreate(cardId, cardOrderEditable);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardOrdersApi#cardOrderCreate");
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
 **cardId** | **String**| The ID of the card to which the card orders belong. |
 **cardOrderEditable** | [**CardOrderEditable**](CardOrderEditable.md)|  |

### Return type

[**CardOrder**](CardOrder.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Card order created successfully |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="cardOrdersRetrieve"></a>
# **cardOrdersRetrieve**
> InlineResponse200 cardOrdersRetrieve(cardId)

get

Retrieves the card orders associated with the given card id.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    CardOrdersApi apiInstance = new CardOrdersApi(defaultClient);
    String cardId = "cardId_example"; // String | The ID of the card to which the card orders belong.
    try {
      InlineResponse200 result = apiInstance.cardOrdersRetrieve(cardId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardOrdersApi#cardOrdersRetrieve");
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
 **cardId** | **String**| The ID of the card to which the card orders belong. |

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
**200** | Returns the card orders associated with the given card id |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


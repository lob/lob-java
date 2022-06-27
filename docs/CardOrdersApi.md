# CardOrdersApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](CardOrdersApi.md#create) | **POST** /cards/{card_id}/orders | create
[**get**](CardOrdersApi.md#get) | **GET** /cards/{card_id}/orders | get


<a name="create"></a>
# **create**
> CardOrder create(cardId, cardOrderEditable)

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
    basicAuth.setUsername("LOB_API_KEY");

    CardOrdersApi apiInstance = new CardOrdersApi(defaultClient);
    String cardId = "cardId_example"; // String | The ID of the card to which the card orders belong.
    CardOrderEditable cardOrderEditable = new CardOrderEditable(); // CardOrderEditable | 
    try {
      CardOrder result = apiInstance.create(cardId, cardOrderEditable);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardOrdersApi#create");
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

<a name="get"></a>
# **get**
> CardOrderList get(cardId, limit, offset)

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
    basicAuth.setUsername("LOB_API_KEY");

    CardOrdersApi apiInstance = new CardOrdersApi(defaultClient);
    String cardId = "cardId_example"; // String | The ID of the card to which the card orders belong.
    Integer limit = 10; // Integer | How many results to return.
    Integer offset = 0; // Integer | An integer that designates the offset at which to begin returning results. Defaults to 0.
    try {
      CardOrderList result = apiInstance.get(cardId, limit, offset);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardOrdersApi#get");
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
 **limit** | **Integer**| How many results to return. | [optional] [default to 10]
 **offset** | **Integer**| An integer that designates the offset at which to begin returning results. Defaults to 0. | [optional] [default to 0]

### Return type

[**CardOrderList**](CardOrderList.md)

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


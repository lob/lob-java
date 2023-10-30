# CardsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](CardsApi.md#create) | **POST** /cards | create
[**delete**](CardsApi.md#delete) | **DELETE** /cards/{card_id} | delete
[**get**](CardsApi.md#get) | **GET** /cards/{card_id} | get
[**update**](CardsApi.md#update) | **POST** /cards/{card_id} | update
[**list**](CardsApi.md#list) | **GET** /cards | list


<a name="create"></a>
# **create**
> Card create(cardEditable)

create

Creates a new card given information

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CardsApi apiInstance = new CardsApi(defaultClient);
    CardEditable cardEditable = new CardEditable(); // CardEditable | 
    try {
      Card result = apiInstance.create(cardEditable);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardsApi#create");
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
 **cardEditable** | [**CardEditable**](CardEditable.md)|  |

### Return type

[**Card**](Card.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Card created successfully |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="delete"></a>
# **delete**
> CardDeletion delete(cardId)

delete

Delete an existing card. You need only supply the unique identifier that was returned upon card creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CardsApi apiInstance = new CardsApi(defaultClient);
    String cardId = "cardId_example"; // String | id of the card
    try {
      CardDeletion result = apiInstance.delete(cardId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardsApi#delete");
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
 **cardId** | **String**| id of the card |

### Return type

[**CardDeletion**](CardDeletion.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deleted the card |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="get"></a>
# **get**
> Card get(cardId)

get

Retrieves the details of an existing card. You need only supply the unique customer identifier that was returned upon card creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CardsApi apiInstance = new CardsApi(defaultClient);
    String cardId = "cardId_example"; // String | id of the card
    try {
      Card result = apiInstance.get(cardId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardsApi#get");
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
 **cardId** | **String**| id of the card |

### Return type

[**Card**](Card.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a card object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="update"></a>
# **update**
> Card update(cardId, cardUpdatable)

update

Update the details of an existing card. You need only supply the unique identifier that was returned upon card creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CardsApi apiInstance = new CardsApi(defaultClient);
    String cardId = "cardId_example"; // String | id of the card
    CardUpdatable cardUpdatable = new CardUpdatable(); // CardUpdatable | 
    try {
      Card result = apiInstance.update(cardId, cardUpdatable);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardsApi#update");
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
 **cardId** | **String**| id of the card |
 **cardUpdatable** | [**CardUpdatable**](CardUpdatable.md)|  |

### Return type

[**Card**](Card.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a card object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="list"></a>
# **list**
> CardList list(limit, before, after, include)

list

Returns a list of your cards. The cards are returned sorted by creation date, with the most recently created addresses appearing first.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CardsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CardsApi apiInstance = new CardsApi(defaultClient);
    Integer limit = 10; // Integer | How many results to return.
    String before = "before_example"; // String | A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the `previous_url` field in the return response. 
    String after = "after_example"; // String | A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the `next_url` field in the return response. 
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    try {
      CardList result = apiInstance.list(limit, before, after, include);
    } catch (ApiException e) {
      System.err.println("Exception when calling CardsApi#list");
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

[**CardList**](CardList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a list of card objects |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


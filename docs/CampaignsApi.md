# CampaignsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Create**](CampaignsApi.md#Create) | **POST** /campaigns | Create
[**Delete**](CampaignsApi.md#Delete) | **DELETE** /campaigns/{cmp_id} | Delete
[**Retrieve**](CampaignsApi.md#Retrieve) | **GET** /campaigns/{cmp_id} | Retrieve
[**Update**](CampaignsApi.md#Update) | **PATCH** /campaigns/{cmp_id} | Update
[**List**](CampaignsApi.md#List) | **GET** /campaigns | List


<a name="Create"></a>
# **Create**
> Campaign Create(campaignWritable, xLangOutput)

Create

Creates a new campaign with the provided properties. See how to launch your first campaign [here](https://help.lob.com/best-practices/launching-your-first-campaign).

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CampaignsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CampaignsApi apiInstance = new CampaignsApi(defaultClient);
    CampaignWritable campaignWritable = new CampaignWritable(); // CampaignWritable | 
    String xLangOutput = "native"; // String | * `native` - Translate response to the native language of the country in the request * `match` - match the response to the language in the request  Default response is in English. 
    try {
      Campaign result = apiInstance.Create(campaignWritable, xLangOutput);
    } catch (ApiException e) {
      System.err.println("Exception when calling CampaignsApi#Create");
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
 **campaignWritable** | [**CampaignWritable**](CampaignWritable.md)|  |
 **xLangOutput** | **String**| * &#x60;native&#x60; - Translate response to the native language of the country in the request * &#x60;match&#x60; - match the response to the language in the request  Default response is in English.  | [optional] [enum: native, match]

### Return type

[**Campaign**](Campaign.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Campaign created successfully |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="Delete"></a>
# **Delete**
> Object Delete(cmpId)

Delete

Delete an existing campaign. You need only supply the unique identifier that was returned upon campaign creation. Deleting a campaign also deletes any associated mail pieces that have been created but not sent. A campaign&#39;s &#x60;send_date&#x60; matches its associated mail pieces&#39; &#x60;send_date&#x60;s.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CampaignsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CampaignsApi apiInstance = new CampaignsApi(defaultClient);
    String cmpId = "cmpId_example"; // String | id of the campaign
    try {
      Object result = apiInstance.Delete(cmpId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CampaignsApi#Delete");
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
 **cmpId** | **String**| id of the campaign |

### Return type

**Object**

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Deleted the campaign. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="Retrieve"></a>
# **Retrieve**
> Campaign Retrieve(cmpId)

Retrieve

Retrieves the details of an existing campaign. You need only supply the unique campaign identifier that was returned upon campaign creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CampaignsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CampaignsApi apiInstance = new CampaignsApi(defaultClient);
    String cmpId = "cmpId_example"; // String | id of the campaign
    try {
      Campaign result = apiInstance.Retrieve(cmpId);
    } catch (ApiException e) {
      System.err.println("Exception when calling CampaignsApi#Retrieve");
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
 **cmpId** | **String**| id of the campaign |

### Return type

[**Campaign**](Campaign.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a campaign object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="Update"></a>
# **Update**
> Campaign Update(cmpId, campaignUpdatable)

Update

Update the details of an existing campaign. You need only supply the unique identifier that was returned upon campaign creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CampaignsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CampaignsApi apiInstance = new CampaignsApi(defaultClient);
    String cmpId = "cmpId_example"; // String | id of the campaign
    CampaignUpdatable campaignUpdatable = new CampaignUpdatable(); // CampaignUpdatable | 
    try {
      Campaign result = apiInstance.Update(cmpId, campaignUpdatable);
    } catch (ApiException e) {
      System.err.println("Exception when calling CampaignsApi#Update");
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
 **cmpId** | **String**| id of the campaign |
 **campaignUpdatable** | [**CampaignUpdatable**](CampaignUpdatable.md)|  |

### Return type

[**Campaign**](Campaign.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a campaign object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="List"></a>
# **List**
> CampaignsList List(limit, include, before, after)

List

Returns a list of your campaigns. The campaigns are returned sorted by creation date, with the most recently created campaigns appearing first.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.CampaignsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    CampaignsApi apiInstance = new CampaignsApi(defaultClient);
    Integer limit = 10; // Integer | How many results to return.
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    String before = "before_example"; // String | A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the `previous_url` field in the return response. 
    String after = "after_example"; // String | A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the `next_url` field in the return response. 
    try {
      CampaignsList result = apiInstance.List(limit, include, before, after);
    } catch (ApiException e) {
      System.err.println("Exception when calling CampaignsApi#List");
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
 **include** | [**List&lt;String&gt;**](String.md)| Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  | [optional]
 **before** | **String**| A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the &#x60;previous_url&#x60; field in the return response.  | [optional]
 **after** | **String**| A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the &#x60;next_url&#x60; field in the return response.  | [optional]

### Return type

[**CampaignsList**](CampaignsList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A dictionary with a data property that contains an array of up to &#x60;limit&#x60; campaigns. Each entry in the array is a separate letter. The previous and next page of campaigns can be retrieved by calling the endpoint contained in the &#x60;previous_url&#x60; and &#x60;next_url&#x60; fields in the API response respectively. If no more campaigns are available beyond the current set of returned results, the &#x60;next_url&#x60; field will be empty. |  -  |


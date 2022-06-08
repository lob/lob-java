# BillingGroupsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create**](BillingGroupsApi.md#create) | **POST** /billing_groups | create
[**get**](BillingGroupsApi.md#get) | **GET** /billing_groups/{bg_id} | get
[**update**](BillingGroupsApi.md#update) | **POST** /billing_groups/{bg_id} | update
[**list**](BillingGroupsApi.md#list) | **GET** /billing_groups | list


<a name="create"></a>
# **create**
> BillingGroup create(billingGroupEditable)

create

Creates a new billing_group with the provided properties.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BillingGroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BillingGroupsApi apiInstance = new BillingGroupsApi(defaultClient);
    BillingGroupEditable billingGroupEditable = new BillingGroupEditable(); // BillingGroupEditable | 
    try {
      BillingGroup result = apiInstance.create(billingGroupEditable);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BillingGroupsApi#create");
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
 **billingGroupEditable** | [**BillingGroupEditable**](BillingGroupEditable.md)|  |

### Return type

[**BillingGroup**](BillingGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a billing group object |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="get"></a>
# **get**
> BillingGroup get(bgId)

get

Retrieves the details of an existing billing_group. You need only supply the unique billing_group identifier that was returned upon billing_group creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BillingGroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BillingGroupsApi apiInstance = new BillingGroupsApi(defaultClient);
    String bgId = "bgId_example"; // String | id of the billing_group
    try {
      BillingGroup result = apiInstance.get(bgId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BillingGroupsApi#get");
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
 **bgId** | **String**| id of the billing_group |

### Return type

[**BillingGroup**](BillingGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a billing_group object. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="update"></a>
# **update**
> BillingGroup update(bgId, billingGroupEditable)

update

Updates all editable attributes of the billing_group with the given id.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BillingGroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BillingGroupsApi apiInstance = new BillingGroupsApi(defaultClient);
    String bgId = "bgId_example"; // String | id of the billing_group
    BillingGroupEditable billingGroupEditable = new BillingGroupEditable(); // BillingGroupEditable | 
    try {
      BillingGroup result = apiInstance.update(bgId, billingGroupEditable);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BillingGroupsApi#update");
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
 **bgId** | **String**| id of the billing_group |
 **billingGroupEditable** | [**BillingGroupEditable**](BillingGroupEditable.md)|  |

### Return type

[**BillingGroup**](BillingGroup.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a billing group object |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="list"></a>
# **list**
> BillingGroupList list(limit, offset, include, dateCreated, dateModified, sortBy)

list

Returns a list of your billing_groups. The billing_groups are returned sorted by creation date, with the most recently created billing_groups appearing first.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.BillingGroupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    BillingGroupsApi apiInstance = new BillingGroupsApi(defaultClient);
    Integer limit = 10; // Integer | How many results to return.
    Integer offset = 0; // Integer | An integer that designates the offset at which to begin returning results. Defaults to 0.
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    Map<String, String> dateCreated = new HashMap(); // Map<String, String> | Filter by date created.
    Map<String, String> dateModified = new HashMap(); // Map<String, String> | Filter by date modified.
    SortBy5 sortBy = new HashMap(); // SortBy5 | Sorts items by ascending or descending dates. Use either `date_created` or `send_date`, not both. 
    try {
      BillingGroupList result = apiInstance.list(limit, offset, include, dateCreated, dateModified, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BillingGroupsApi#list");
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
 **offset** | **Integer**| An integer that designates the offset at which to begin returning results. Defaults to 0. | [optional] [default to 0]
 **include** | [**List&lt;String&gt;**](String.md)| Request that the response include the total count by specifying &#x60;include[]&#x3D;total_count&#x60;.  | [optional]
 **dateCreated** | [**Map&lt;String, String&gt;**](String.md)| Filter by date created. | [optional]
 **dateModified** | [**Map&lt;String, String&gt;**](String.md)| Filter by date modified. | [optional]
 **sortBy** | [**SortBy5**](.md)| Sorts items by ascending or descending dates. Use either &#x60;date_created&#x60; or &#x60;send_date&#x60;, not both.  | [optional]

### Return type

[**BillingGroupList**](BillingGroupList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a list of billing_groups. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


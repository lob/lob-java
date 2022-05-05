# SelfMailersApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**selfMailerCreate**](SelfMailersApi.md#selfMailerCreate) | **POST** /self_mailers | create
[**selfMailerDelete**](SelfMailersApi.md#selfMailerDelete) | **DELETE** /self_mailers/{sfm_id} | delete
[**selfMailerRetrieve**](SelfMailersApi.md#selfMailerRetrieve) | **GET** /self_mailers/{sfm_id} | get
[**selfMailersList**](SelfMailersApi.md#selfMailersList) | **GET** /self_mailers | list


<a name="selfMailerCreate"></a>
# **selfMailerCreate**
> SelfMailer selfMailerCreate(selfMailerEditable, idempotencyKey)

create

Creates a new self_mailer given information

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.SelfMailersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    SelfMailersApi apiInstance = new SelfMailersApi(defaultClient);
    SelfMailerEditable selfMailerEditable = new SelfMailerEditable(); // SelfMailerEditable | 
    String idempotencyKey = "idempotencyKey_example"; // String | A string of no longer than 256 characters that uniquely identifies this resource. For more help integrating idempotency keys, refer to our [implementation guide](https://www.lob.com/guides#idempotent_request). 
    try {
      SelfMailer result = apiInstance.selfMailerCreate(selfMailerEditable, idempotencyKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SelfMailersApi#selfMailerCreate");
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
 **selfMailerEditable** | [**SelfMailerEditable**](SelfMailerEditable.md)|  |
 **idempotencyKey** | **String**| A string of no longer than 256 characters that uniquely identifies this resource. For more help integrating idempotency keys, refer to our [implementation guide](https://www.lob.com/guides#idempotent_request).  | [optional]

### Return type

[**SelfMailer**](SelfMailer.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a self_mailer object |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="selfMailerDelete"></a>
# **selfMailerDelete**
> SelfMailerDeletion selfMailerDelete(sfmId)

delete

Completely removes a self mailer from production. This can only be done if the self mailer&#39;s &#x60;send_date&#x60; has not yet passed.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.SelfMailersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    SelfMailersApi apiInstance = new SelfMailersApi(defaultClient);
    String sfmId = "sfmId_example"; // String | id of the self_mailer
    try {
      SelfMailerDeletion result = apiInstance.selfMailerDelete(sfmId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SelfMailersApi#selfMailerDelete");
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
 **sfmId** | **String**| id of the self_mailer |

### Return type

[**SelfMailerDeletion**](SelfMailerDeletion.md)

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

<a name="selfMailerRetrieve"></a>
# **selfMailerRetrieve**
> SelfMailer selfMailerRetrieve(sfmId)

get

Retrieves the details of an existing self_mailer. You need only supply the unique self_mailer identifier that was returned upon self_mailer creation.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.SelfMailersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    SelfMailersApi apiInstance = new SelfMailersApi(defaultClient);
    String sfmId = "sfmId_example"; // String | id of the self_mailer
    try {
      SelfMailer result = apiInstance.selfMailerRetrieve(sfmId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SelfMailersApi#selfMailerRetrieve");
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
 **sfmId** | **String**| id of the self_mailer |

### Return type

[**SelfMailer**](SelfMailer.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a self_mailer object |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |

<a name="selfMailersList"></a>
# **selfMailersList**
> SelfMailerList selfMailersList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy)

list

Returns a list of your self_mailers. The self_mailers are returned sorted by creation date, with the most recently created self_mailers appearing first.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.SelfMailersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    SelfMailersApi apiInstance = new SelfMailersApi(defaultClient);
    Integer limit = 10; // Integer | How many results to return.
    String before = "before_example"; // String | A reference to a list entry used for paginating to the previous set of entries. This field is pre-populated in the `previous_url` field in the return response. 
    String after = "after_example"; // String | A reference to a list entry used for paginating to the next set of entries. This field is pre-populated in the `next_url` field in the return response. 
    List<String> include = Arrays.asList(); // List<String> | Request that the response include the total count by specifying `include[]=total_count`. 
    Map<String, String> dateCreated = new HashMap(); // Map<String, String> | Filter by date created.
    Map<String, String> metadata = new HashMap(); // Map<String, String> | Filter by metadata key-value pair`.
    SelfMailerSize size = SelfMailerSize.fromValue("6x18_bifold"); // SelfMailerSize | The self mailer sizes to be returned.
    Boolean scheduled = true; // Boolean | * `true` - only return orders (past or future) where `send_date` is greater than `date_created` * `false` - only return orders where `send_date` is equal to `date_created` 
    SendDate sendDate = new SendDate(); // SendDate | Filter by ISO-8601 date or datetime, e.g. `{ gt: '2012-01-01', lt: '2012-01-31T12:34:56Z' }` where `gt` is >, `lt` is <, `gte` is ≥, and `lte` is ≤. 
    MailType mailType = MailType.fromValue("usps_first_class"); // MailType | A string designating the mail postage type: * `usps_first_class` - (default) * `usps_standard` - a [cheaper option](https://lob.com/pricing/print-mail#compare) which is less predictable and takes longer to deliver. `usps_standard` cannot be used with `4x6` postcards or for any postcards sent outside of the United States. 
    SortBy5 sortBy = new SortBy5(); // SortBy5 | Sorts items by ascending or descending dates. Use either `date_created` or `send_date`, not both. 
    try {
      SelfMailerList result = apiInstance.selfMailersList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SelfMailersApi#selfMailersList");
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
 **dateCreated** | [**Map&lt;String, String&gt;**](String.md)| Filter by date created. | [optional]
 **metadata** | [**Map&lt;String, String&gt;**](String.md)| Filter by metadata key-value pair&#x60;. | [optional]
 **size** | [**SelfMailerSize**](.md)| The self mailer sizes to be returned. | [optional] [enum: 6x18_bifold, 11x9_bifold, 12x9_bifold]
 **scheduled** | **Boolean**| * &#x60;true&#x60; - only return orders (past or future) where &#x60;send_date&#x60; is greater than &#x60;date_created&#x60; * &#x60;false&#x60; - only return orders where &#x60;send_date&#x60; is equal to &#x60;date_created&#x60;  | [optional]
 **sendDate** | [**SendDate**](.md)| Filter by ISO-8601 date or datetime, e.g. &#x60;{ gt: &#39;2012-01-01&#39;, lt: &#39;2012-01-31T12:34:56Z&#39; }&#x60; where &#x60;gt&#x60; is &gt;, &#x60;lt&#x60; is &lt;, &#x60;gte&#x60; is ≥, and &#x60;lte&#x60; is ≤.  | [optional]
 **mailType** | [**MailType**](.md)| A string designating the mail postage type: * &#x60;usps_first_class&#x60; - (default) * &#x60;usps_standard&#x60; - a [cheaper option](https://lob.com/pricing/print-mail#compare) which is less predictable and takes longer to deliver. &#x60;usps_standard&#x60; cannot be used with &#x60;4x6&#x60; postcards or for any postcards sent outside of the United States.  | [optional] [enum: usps_first_class, usps_standard]
 **sortBy** | [**SortBy5**](.md)| Sorts items by ascending or descending dates. Use either &#x60;date_created&#x60; or &#x60;send_date&#x60;, not both.  | [optional]

### Return type

[**SelfMailerList**](SelfMailerList.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | A dictionary with a data property that contains an array of up to &#x60;limit&#x60; self_mailers. |  -  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


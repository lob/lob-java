# ReverseGeocodeLookupsApi

All URIs are relative to *https://api.lob.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**lookup**](ReverseGeocodeLookupsApi.md#lookup) | **POST** /us_reverse_geocode_lookups | lookup


<a name="lookup"></a>
# **lookup**
> ReverseGeocode lookup(location, size)

lookup

Reverse geocode a valid US location with a live API key.

### Example
```java
// Import classes:
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.*;
import com.lob.api.models.*;
import com.lob.api.client.ReverseGeocodeLookupsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.lob.com/v1");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("LOB_API_KEY");

    ReverseGeocodeLookupsApi apiInstance = new ReverseGeocodeLookupsApi(defaultClient);
    Location location = new Location(); // Location | 
    Integer size = 5; // Integer | Determines the number of locations returned. Possible values are between 1 and 50 and any number higher will be rounded down to 50. Default size is a list of 5 reverse geocoded locations.
    try {
      ReverseGeocode result = apiInstance.lookup(location, size);
    } catch (ApiException e) {
      System.err.println("Exception when calling ReverseGeocodeLookupsApi#lookup");
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
 **location** | [**Location**](Location.md)|  |
 **size** | **Integer**| Determines the number of locations returned. Possible values are between 1 and 50 and any number higher will be rounded down to 50. Default size is a list of 5 reverse geocoded locations. | [optional] [default to 5]

### Return type

[**ReverseGeocode**](ReverseGeocode.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a zip lookup object if a valid zip was provided. |  * ratelimit-limit -  <br>  * ratelimit-remaining -  <br>  * ratelimit-reset -  <br>  |
**0** | Lob uses RESTful HTTP response codes to indicate success or failure of an API request. |  -  |


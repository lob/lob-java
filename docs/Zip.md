

# Zip


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**zipCode** | **String** | A 5-digit ZIP code. |  [optional]
**id** | **String** | Unique identifier prefixed with &#x60;us_zip_&#x60;. |  [optional]
**cities** | [**List&lt;ZipLookupCity&gt;**](ZipLookupCity.md) | An array of city objects containing valid cities for the &#x60;zip_code&#x60;. Multiple cities will be returned if more than one city is associated with the input ZIP code.  |  [optional]
**zipCodeType** | **ZipCodeType** |  |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
US_ZIP_LOOKUP | &quot;us_zip_lookup&quot;




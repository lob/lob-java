

# IntlVerificationOrError

A model used to represent an entry in a result list where the entry can either be a intl_verification or an Error. The SDK will perform necessary casting into the correct corresponding type. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;intl_ver_&#x60;. |  [optional]
**recipient** | **String** | The intended recipient, typically a person&#39;s or firm&#39;s name. |  [optional]
**primaryLine** | **String** |  |  [optional]
**secondaryLine** | **String** | The secondary delivery line of the address. This field is typically empty but may contain information if &#x60;primary_line&#x60; is too long.  |  [optional]
**lastLine** | **String** |  |  [optional]
**country** | **String** |  |  [optional]
**coverage** | [**CoverageEnum**](#CoverageEnum) |  |  [optional]
**deliverability** | [**DeliverabilityEnum**](#DeliverabilityEnum) |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**components** | [**IntlComponents**](IntlComponents.md) |  |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**error** | [**BulkError**](BulkError.md) |  |  [optional]



## Enum: CoverageEnum

Name | Value
---- | -----
SUBBUILDING | &quot;SUBBUILDING&quot;
HOUSENUMBER_BUILDING | &quot;HOUSENUMBER/BUILDING&quot;
STREET | &quot;STREET&quot;
LOCALITY | &quot;LOCALITY&quot;
SPARSE | &quot;SPARSE&quot;



## Enum: DeliverabilityEnum

Name | Value
---- | -----
DELIVERABLE | &quot;deliverable&quot;
DELIVERABLE_MISSING_INFO | &quot;deliverable_missing_info&quot;
UNDELIVERABLE | &quot;undeliverable&quot;
NO_MATCH | &quot;no_match&quot;



## Enum: StatusEnum

Name | Value
---- | -----
LV4 | &quot;LV4&quot;
LV3 | &quot;LV3&quot;
LV2 | &quot;LV2&quot;
LV1 | &quot;LV1&quot;
LF4 | &quot;LF4&quot;
LF3 | &quot;LF3&quot;
LF2 | &quot;LF2&quot;
LF1 | &quot;LF1&quot;
LM4 | &quot;LM4&quot;
LM3 | &quot;LM3&quot;
LM2 | &quot;LM2&quot;
LU1 | &quot;LU1&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
INTL_VERIFICATION | &quot;intl_verification&quot;




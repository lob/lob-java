

# UsVerificationOrError

A model used to represent an entry in a result list where the entry can either be a us_verification or an Error. The SDK will perform necessary casting into the correct corresponding type. 

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;us_ver_&#x60;. |  [optional]
**recipient** | **String** | The intended recipient, typically a person&#39;s or firm&#39;s name. |  [optional]
**primaryLine** | **String** | The primary delivery line (usually the street address) of the address. Combination of the following applicable &#x60;components&#x60;: * &#x60;primary_number&#x60; * &#x60;street_predirection&#x60; * &#x60;street_name&#x60; * &#x60;street_suffix&#x60; * &#x60;street_postdirection&#x60; * &#x60;secondary_designator&#x60; * &#x60;secondary_number&#x60; * &#x60;pmb_designator&#x60; * &#x60;pmb_number&#x60;  |  [optional]
**secondaryLine** | **String** | The secondary delivery line of the address. This field is typically empty but may contain information if &#x60;primary_line&#x60; is too long.  |  [optional]
**urbanization** | **String** | Only present for addresses in Puerto Rico. An urbanization refers to an area, sector, or development within a city. See [USPS documentation](https://pe.usps.com/text/pub28/28api_008.htm#:~:text&#x3D;I51.,-4%20Urbanizations&amp;text&#x3D;In%20Puerto%20Rico%2C%20identical%20street,placed%20before%20the%20urbanization%20name.) for clarification.  |  [optional]
**lastLine** | **String** |  |  [optional]
**deliverability** | [**DeliverabilityEnum**](#DeliverabilityEnum) |  |  [optional]
**components** | [**UsComponents**](UsComponents.md) |  |  [optional]
**deliverabilityAnalysis** | [**DeliverabilityAnalysis**](DeliverabilityAnalysis.md) |  |  [optional]
**lobConfidenceScore** | [**LobConfidenceScore**](LobConfidenceScore.md) |  |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**transientId** | **String** | ID that is returned in the response body for the verification  |  [optional]
**error** | [**BulkError**](BulkError.md) |  |  [optional]



## Enum: DeliverabilityEnum

Name | Value
---- | -----
DELIVERABLE | &quot;deliverable&quot;
DELIVERABLE_UNNECESSARY_UNIT | &quot;deliverable_unnecessary_unit&quot;
DELIVERABLE_INCORRECT_UNIT | &quot;deliverable_incorrect_unit&quot;
DELIVERABLE_MISSING_UNIT | &quot;deliverable_missing_unit&quot;
UNDELIVERABLE | &quot;undeliverable&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
US_VERIFICATION | &quot;us_verification&quot;






# Suggestions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**primaryLine** | **String** | The primary delivery line (usually the street address) of the address. Combination of the following applicable &#x60;components&#x60; (primary number &amp; secondary information may be missing or inaccurate): * &#x60;primary_number&#x60; * &#x60;street_predirection&#x60; * &#x60;street_name&#x60; * &#x60;street_suffix&#x60; * &#x60;street_postdirection&#x60; * &#x60;secondary_designator&#x60; * &#x60;secondary_number&#x60; * &#x60;pmb_designator&#x60; * &#x60;pmb_number&#x60;  |  [optional]
**city** | **String** |  |  [optional]
**state** | **String** | The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state.  |  [optional]
**zipCode** | **String** | Required if &#x60;city&#x60; and &#x60;state&#x60; are not passed in. If included, must be formatted as a US ZIP or ZIP+4 (e.g. &#x60;94107&#x60;, &#x60;941072282&#x60;, &#x60;94107-2282&#x60;). |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
US_AUTOCOMPLETION | &quot;us_autocompletion&quot;




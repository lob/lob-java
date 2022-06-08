

# IntlSuggestions


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**primaryNumberRange** | **String** | The primary number range of the address that identifies a building at street level.  |  [optional]
**primaryLine** | **String** | The primary delivery line (usually the street address) of the address. Combination of the following applicable &#x60;components&#x60; (primary number &amp; secondary information may be missing or inaccurate): * &#x60;primary_number&#x60; * &#x60;street_predirection&#x60; * &#x60;street_name&#x60; * &#x60;street_suffix&#x60; * &#x60;street_postdirection&#x60; * &#x60;secondary_designator&#x60; * &#x60;secondary_number&#x60; * &#x60;pmb_designator&#x60; * &#x60;pmb_number&#x60;  |  [optional]
**city** | **String** |  |  [optional]
**state** | **String** | The [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) two letter code for the state.  |  [optional]
**country** | **CountryExtended** |  |  [optional]
**zipCode** | **String** | A 5-digit zip code. Left empty if a test key is used. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
INTL_AUTOCOMPLETION | &quot;intl_autocompletion&quot;






# LetterRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | **Object** | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**resourceType** | [**ResourceTypeEnum**](#ResourceTypeEnum) | Mailpiece type for the creative |  [optional]
**campaignId** | **String** | Unique identifier prefixed with &#x60;cmp_&#x60;. |  [optional]
**details** | [**LetterDetailsWritable**](LetterDetailsWritable.md) |  |  [optional]
**file** | **String** | PDF file containing the letter&#39;s formatting. |  [optional]



## Enum: ResourceTypeEnum

Name | Value
---- | -----
LETTER | &quot;letter&quot;




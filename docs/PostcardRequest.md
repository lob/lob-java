

# PostcardRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | **Object** | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**campaignId** | **String** | Unique identifier prefixed with &#x60;cmp_&#x60;. |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**details** | [**PostcardDetailsWritable**](PostcardDetailsWritable.md) |  |  [optional]
**resourceType** | [**ResourceTypeEnum**](#ResourceTypeEnum) | Mailpiece type for the creative |  [optional]
**front** | **String** | The artwork to use as the front of your postcard.  |  [optional]
**back** | **String** | The artwork to use as the back of your postcard.  |  [optional]



## Enum: ResourceTypeEnum

Name | Value
---- | -----
POSTCARD | &quot;postcard&quot;




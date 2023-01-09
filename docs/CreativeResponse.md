

# CreativeResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;crv_&#x60;. |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**from** | **Object** | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**resourceType** | [**ResourceTypeEnum**](#ResourceTypeEnum) | Mailpiece type for the creative |  [optional]
**details** | **Object** | Either PostcardDetailsReturned or LetterDetailsReturned |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**templatePreviewUrls** | **Object** | Preview URLs associated with a creative&#39;s artwork asset(s) if the creative uses HTML templates as assets. |  [optional]
**templatePreviews** | **List&lt;Object&gt;** | A list of template preview objects if the creative uses HTML template(s) as artwork asset(s). |  [optional]
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**campaigns** | [**List&lt;Campaign&gt;**](Campaign.md) | Array of campaigns associated with the creative ID |  [optional]
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. |  [optional]
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. |  [optional]



## Enum: ResourceTypeEnum

Name | Value
---- | -----
LETTER | &quot;letter&quot;
POSTCARD | &quot;postcard&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
CREATIVE | &quot;creative&quot;




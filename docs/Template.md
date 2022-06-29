

# Template


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**id** | **String** | Unique identifier prefixed with &#x60;tmpl_&#x60;. ID of a saved [HTML template](#section/HTML-Templates). | 
**versions** | [**List&lt;TemplateVersion&gt;**](TemplateVersion.md) | An array of all non-deleted [version objects](#tag/Template-Versions) associated with the template. | 
**publishedVersion** | [**TemplateVersion**](TemplateVersion.md) |  | 
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. |  [optional]
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. |  [optional]
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
TEMPLATE | &quot;template&quot;




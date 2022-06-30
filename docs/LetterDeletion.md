

# LetterDeletion

Lob uses RESTful HTTP response codes to indicate success or failure of an API request. In general, 2xx indicates success, 4xx indicate an input error, and 5xx indicates an error on Lob's end.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;ltr_&#x60;. |  [optional]
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is type of resource. |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
LETTER_DELETED | &quot;letter_deleted&quot;




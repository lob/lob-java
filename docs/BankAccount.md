

# BankAccount


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**routingNumber** | **String** | Must be a [valid US routing number](https://www.frbservices.org/index.html). |  [optional]
**accountNumber** | **String** |  |  [optional]
**accountType** | [**AccountTypeEnum**](#AccountTypeEnum) | The type of entity that holds the account. |  [optional]
**signatory** | **String** | The signatory associated with your account. This name will be printed on checks created with this bank account. If you prefer to use a custom signature image on your checks instead, please create your bank account from the [Dashboard](https://dashboard.lob.com/#/login). |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**id** | **String** | Unique identifier prefixed with &#x60;bank_&#x60;. |  [optional]
**signatureUrl** | **String** | A signed link to the signature image. will be generated. |  [optional]
**bankName** | **String** | The name of the bank based on the provided routing number, e.g. &#x60;JPMORGAN CHASE BANK&#x60;. |  [optional]
**verified** | **Boolean** | A bank account must be verified before a check can be created. |  [optional]
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. |  [optional]
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. |  [optional]
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]



## Enum: AccountTypeEnum

Name | Value
---- | -----
COMPANY | &quot;company&quot;
INDIVIDUAL | &quot;individual&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
BANK_ACCOUNT | &quot;bank_account&quot;




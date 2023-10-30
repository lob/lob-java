

# Events


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;evt_&#x60;. | 
**body** | **Object** | The body of the associated resource as they were at the time of the event, i.e. the [postcard object](https://docs.lob.com/#tag/Postcards/operation/postcard_retrieve), [the letter object](https://docs.lob.com/#tag/Letters/operation/letter_retrieve), [the check object](https://docs.lob.com/#tag/Checks/operation/check_retrieve), [the address object](https://docs.lob.com/#tag/Addresses/operation/address_retrieve), or [the bank account object](https://docs.lob.com/#tag/Bank-Accounts/operation/bank_account_retrieve). For &#x60;.deleted&#x60; events, the body matches the response for the corresponding delete endpoint for that resource (e.g. the [postcard cancel response](https://docs.lob.com/#tag/Postcards/operation/postcard_delete)). | 
**referenceId** | **String** | Unique identifier of the related resource for the event. | 
**eventType** | [**EventType**](EventType.md) |  | 
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. | 
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. | 



## Enum: ObjectEnum

Name | Value
---- | -----
EVENT | &quot;event&quot;




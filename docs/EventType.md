

# EventType


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional]
**enabledForTest** | **Boolean** | Value is &#x60;true&#x60; if the event type is enabled in both the test and live environments. |  [optional]
**resource** | [**ResourceEnum**](#ResourceEnum) |  |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. |  [optional]



## Enum: ResourceEnum

Name | Value
---- | -----
POSTCARDS | &quot;postcards&quot;
SELF_MAILERS | &quot;self mailers&quot;
LETTERS | &quot;letters&quot;
CHECKS | &quot;checks&quot;
ADDRESSES | &quot;addresses&quot;
BANK_ACCOUNTS | &quot;bank accounts&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
EVENT_TYPE | &quot;event_type&quot;




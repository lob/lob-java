

# Campaign


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**billingGroupId** | **String** | Unique identifier prefixed with &#x60;bg_&#x60;. |  [optional]
**name** | **String** | Name of the campaign. | 
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**scheduleType** | **CmpScheduleType** |  | 
**targetDeliveryDate** | **OffsetDateTime** | If &#x60;schedule_type&#x60; is &#x60;target_delivery_date&#x60;, provide a targeted delivery date for mail pieces in this campaign. |  [optional]
**sendDate** | **OffsetDateTime** | If &#x60;schedule_type&#x60; is &#x60;scheduled_send_date&#x60;, provide a date to send this campaign. |  [optional]
**cancelWindowCampaignMinutes** | **Integer** | A window, in minutes, within which the campaign can be canceled. |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**useType** | **CmpUseType** |  | 
**autoCancelIfNcoa** | **Boolean** | Whether or not a mail piece should be automatically canceled and not sent if the address is updated via NCOA. | 
**id** | **String** | Unique identifier prefixed with &#x60;cmp_&#x60;. | 
**accountId** | **String** | Account ID that this campaign is associated with. |  [optional]
**isDraft** | **Boolean** | Whether or not the campaign is still a draft. | 
**creatives** | [**List&lt;CampaignCreative&gt;**](CampaignCreative.md) | An array of creatives that have been associated with this campaign. | 
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. | 
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. | 
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. | 



## Enum: ObjectEnum

Name | Value
---- | -----
CAMPAIGN | &quot;campaign&quot;




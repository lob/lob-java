

# CampaignUpdatable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** |  |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**scheduleType** | **CmpScheduleType** |  |  [optional]
**targetDeliveryDate** | **OffsetDateTime** | If &#x60;schedule_type&#x60; is &#x60;target_delivery_date&#x60;, provide a targeted delivery date for mail pieces in this campaign. |  [optional]
**sendDate** | **OffsetDateTime** | If &#x60;schedule_type&#x60; is &#x60;scheduled_send_date&#x60;, provide a date to send this campaign. |  [optional]
**cancelWindowCampaignMinutes** | **Integer** | A window, in minutes, within which the campaign can be canceled. |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**isDraft** | **Boolean** | Whether or not the campaign is still a draft. |  [optional]
**useType** | **CmpUseType** |  |  [optional]
**autoCancelIfNcoa** | **Boolean** | Whether or not a mail piece should be automatically canceled and not sent if the address is updated via NCOA. |  [optional]




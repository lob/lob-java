

# Card


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;card_&#x60;. | 
**url** | **URI** | The signed link for the card. | 
**autoReorder** | **Boolean** | True if the cards should be auto-reordered. | 
**reorderQuantity** | **Integer** | The number of cards to be reordered. Only present when auto_reorder is True. |  [optional]
**rawUrl** | **URI** | The raw URL of the card. | 
**frontOriginalUrl** | **URI** | The original URL of the front template. | 
**backOriginalUrl** | **URI** | The original URL of the back template. | 
**thumbnails** | [**List&lt;Thumbnail&gt;**](Thumbnail.md) |  | 
**availableQuantity** | **Integer** | The available quantity of cards. | 
**pendingQuantity** | **Integer** | The pending quantity of cards. | 
**status** | [**StatusEnum**](#StatusEnum) |  | 
**orientation** | [**OrientationEnum**](#OrientationEnum) | The orientation of the card. | 
**thresholdAmount** | **Integer** | The threshold amount of the card | 
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. | 
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. | 
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | object | 
**description** | **String** | Description of the card. |  [optional]
**size** | [**SizeEnum**](#SizeEnum) | The size of the card |  [optional]



## Enum: StatusEnum

Name | Value
---- | -----
PROCESSED | &quot;processed&quot;
RENDERED | &quot;rendered&quot;



## Enum: OrientationEnum

Name | Value
---- | -----
HORIZONTAL | &quot;horizontal&quot;
VERTICAL | &quot;vertical&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
CARD | &quot;card&quot;



## Enum: SizeEnum

Name | Value
---- | -----
_3_375X2_125 | &quot;3.375x2.125&quot;
_2_125X3_375 | &quot;2.125x3.375&quot;




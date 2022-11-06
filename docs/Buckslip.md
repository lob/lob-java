

# Buckslip


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;bck_&#x60;. | 
**autoReorder** | **Boolean** | True if the buckslips should be auto-reordered. | 
**reorderQuantity** | **Integer** | The number of buckslips to be reordered. | 
**thresholdAmount** | **Integer** | The threshold amount of the buckslip | 
**url** | **URI** | The signed link for the buckslip. | 
**rawUrl** | **URI** | The raw URL of the buckslip. | 
**frontOriginalUrl** | **URI** | The original URL of the front template. | 
**backOriginalUrl** | **URI** | The original URL of the back template. | 
**thumbnails** | [**List&lt;Thumbnail&gt;**](Thumbnail.md) |  | 
**availableQuantity** | **BigDecimal** | The available quantity of buckslips. | 
**allocatedQuantity** | **BigDecimal** | The allocated quantity of buckslips. | 
**onhandQuantity** | **BigDecimal** | The onhand quantity of buckslips. | 
**pendingQuantity** | **BigDecimal** | The pending quantity of buckslips. | 
**projectedQuantity** | **BigDecimal** | The sum of pending and onhand quantities of buckslips. | 
**buckslipOrders** | [**List&lt;BuckslipOrder&gt;**](BuckslipOrder.md) | An array of buckslip orders that are associated with the buckslip. | 
**stock** | [**StockEnum**](#StockEnum) |  | 
**weight** | [**WeightEnum**](#WeightEnum) |  | 
**finish** | [**FinishEnum**](#FinishEnum) |  | 
**status** | [**StatusEnum**](#StatusEnum) |  | 
**_object** | [**ObjectEnum**](#ObjectEnum) | object | 
**description** | **String** | Description of the buckslip. | 
**size** | [**SizeEnum**](#SizeEnum) | The size of the buckslip |  [optional]



## Enum: StockEnum

Name | Value
---- | -----
TEXT | &quot;text&quot;
COVER | &quot;cover&quot;



## Enum: WeightEnum

Name | Value
---- | -----
_80_ | &quot;80#&quot;



## Enum: FinishEnum

Name | Value
---- | -----
GLOSS | &quot;gloss&quot;
MATTE | &quot;matte&quot;



## Enum: StatusEnum

Name | Value
---- | -----
PROCESSED | &quot;processed&quot;
RENDERED | &quot;rendered&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
BUCKSLIP | &quot;buckslip&quot;



## Enum: SizeEnum

Name | Value
---- | -----
_8_75X3_75 | &quot;8.75x3.75&quot;






# LetterDetailsWritable

Properties that the letters in your Creative should have.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressPlacement** | [**AddressPlacementEnum**](#AddressPlacementEnum) | Specifies the location of the address information that will show through the double-window envelope.  |  [optional]
**cards** | **List&lt;String&gt;** | A single-element array containing an existing card id in a string format. See [cards](#tag/Cards) for more information. | 
**color** | **Boolean** | Set this key to &#x60;true&#x60; if you would like to print in color. Set to &#x60;false&#x60; if you would like to print in black and white. | 
**doubleSided** | **Boolean** | Set this attribute to &#x60;true&#x60; for double sided printing, or &#x60;false&#x60; for for single sided printing. Defaults to &#x60;true&#x60;. |  [optional]
**extraService** | **String** | Add an extra service to your letter. |  [optional]
**mailType** | **MailType** |  |  [optional]
**returnEnvelope** | **Boolean** |  |  [optional]
**customEnvelope** | **String** | Accepts an envelope ID for any customized envelope with available inventory. |  [optional]



## Enum: AddressPlacementEnum

Name | Value
---- | -----
TOP_FIRST_PAGE | &quot;top_first_page&quot;
INSERT_BLANK_PAGE | &quot;insert_blank_page&quot;
BOTTOM_FIRST_PAGE_CENTER | &quot;bottom_first_page_center&quot;
BOTTOM_FIRST_PAGE | &quot;bottom_first_page&quot;




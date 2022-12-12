

# LetterDetailsReturned

Properties that the letters in your Creative should have.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**color** | **Boolean** | Set this key to &#x60;true&#x60; if you would like to print in color, false for black and white. | 
**cards** | **List&lt;String&gt;** | A single-element array containing an existing card id in a string format. See [cards](#tag/Cards) for more information. | 
**addressPlacement** | [**AddressPlacementEnum**](#AddressPlacementEnum) | Specifies the location of the address information that will show through the double-window envelope.  |  [optional]
**customEnvelope** | [**CustomEnvelopeReturned**](CustomEnvelopeReturned.md) |  |  [optional]
**doubleSided** | **Boolean** | Set this attribute to &#x60;true&#x60; for double sided printing,  &#x60;false&#x60; for for single sided printing. |  [optional]
**extraService** | **String** | Add an extra service to your letter. |  [optional]
**mailType** | **MailType** |  |  [optional]
**returnEnvelope** | **Object** |  |  [optional]
**bleed** | **Boolean** | Allows for letter bleed. Enabled only with specific feature flags. |  [optional]
**fileOriginalUrl** | **String** |  |  [optional]



## Enum: AddressPlacementEnum

Name | Value
---- | -----
TOP_FIRST_PAGE | &quot;top_first_page&quot;
INSERT_BLANK_PAGE | &quot;insert_blank_page&quot;
BOTTOM_FIRST_PAGE_CENTER | &quot;bottom_first_page_center&quot;
BOTTOM_FIRST_PAGE | &quot;bottom_first_page&quot;




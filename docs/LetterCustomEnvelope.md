

# LetterCustomEnvelope

A nested custom envelope object containing more information about the custom envelope used or `null` if a custom envelope was not used.  Accepts an envelope ID for any customized envelope with available inventory. If no inventory is available for the specified ID, the letter will not be sent, and an error will be returned. If the letter has more than 6 sheets, it will be sent in a blank flat envelope. Custom envelopes may be created and ordered from the dashboard. This feature is exclusive to certain customers. Upgrade to the appropriate [Print & Mail Edition](https://dashboard.lob.com/#/settings/editions) to gain access.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The unique identifier of the custom envelope used. |  [optional]
**url** | **String** | The url of the envelope asset used. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
ENVELOPE | &quot;envelope&quot;




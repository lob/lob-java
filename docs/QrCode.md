

# QrCode

Customize and place a QR code on the creative at the required position.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**position** | [**PositionEnum**](#PositionEnum) | Sets how a QR code is being positioned in the document. | 
**top** | **String** | Vertical distance(in inches) to place QR code from the top. |  [optional]
**right** | **String** | Horizonal distance(in inches) to place QR code from the right. |  [optional]
**left** | **String** | Horizonal distance(in inches) to place QR code from the left. |  [optional]
**bottom** | **String** | Vertical distance(in inches) to place QR code from the bottom. |  [optional]
**redirectUrl** | **String** | The url to redirect the user when a QR code is scanned. The url must start with &#x60;https://&#x60; | 
**width** | **String** | The size(in inches) of the QR code. All QR codes are generated as a square. | 



## Enum: PositionEnum

Name | Value
---- | -----
FIXED | &quot;fixed&quot;
RELATIVE | &quot;relative&quot;




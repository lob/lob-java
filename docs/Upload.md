

# Upload


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;upl_&#x60;. | 
**accountId** | **String** | Account ID that made the request | 
**mode** | [**ModeEnum**](#ModeEnum) | The environment in which the mailpieces were created. Today, will only be &#x60;live&#x60;. | 
**campaignId** | **String** | Campaign ID associated with the upload | 
**failuresUrl** | **String** | Url where your campaign mailpiece failures can be retrieved |  [optional]
**originalFilename** | **String** | Filename of the upload |  [optional]
**state** | **UploadState** |  | 
**totalMailpieces** | **Integer** | Total number of recipients for the campaign | 
**failedMailpieces** | **Integer** | Number of mailpieces that failed to create | 
**validatedMailpieces** | **Integer** | Number of mailpieces that were successfully created | 
**bytesProcessed** | **Integer** | Number of bytes processed in your CSV | 
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the upload was created | 
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the upload was last modified | 
**requiredAddressColumnMapping** | [**RequiredAddressColumnMapping**](RequiredAddressColumnMapping.md) |  | 
**optionalAddressColumnMapping** | [**OptionalAddressColumnMapping**](OptionalAddressColumnMapping.md) |  | 
**metadata** | [**UploadsMetadata**](UploadsMetadata.md) |  | 
**mergeVariableColumnMapping** | **Object** | The mapping of column headers in your file to the merge variables present in your creative. See our &lt;a href&#x3D;\&quot;https://help.lob.com/print-and-mail/building-a-mail-strategy/campaign-or-triggered-sends/campaign-audience-guide#step-3-map-merge-variable-data-if-applicable-7\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Campaign Audience Guide&lt;/a&gt; for additional details. &lt;br /&gt;If a merge variable has the same \&quot;name\&quot; as a \&quot;key\&quot; in the &#x60;requiredAddressColumnMapping&#x60; or &#x60;optionalAddressColumnMapping&#x60; objects, then they **CANNOT** have a different value in this object. If a different value is provided, then when the campaign is processing it will get overwritten with the mapped value present in the &#x60;requiredAddressColumnMapping&#x60; or &#x60;optionalAddressColumnMapping&#x60; objects. | 



## Enum: ModeEnum

Name | Value
---- | -----
TEST | &quot;test&quot;
LIVE | &quot;live&quot;




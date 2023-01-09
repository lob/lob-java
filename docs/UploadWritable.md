

# UploadWritable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**campaignId** | [**String**](String.md) |  | 
**requiredAddressColumnMapping** | [**RequiredAddressColumnMapping**](RequiredAddressColumnMapping.md) |  |  [optional]
**optionalAddressColumnMapping** | [**OptionalAddressColumnMapping**](OptionalAddressColumnMapping.md) |  |  [optional]
**metadata** | [**UploadsMetadata**](UploadsMetadata.md) |  |  [optional]
**mergeVariableColumnMapping** | **Object** | The mapping of column headers in your file to the merge variables present in your creative. See our &lt;a href&#x3D;\&quot;https://help.lob.com/print-and-mail/building-a-mail-strategy/campaign-or-triggered-sends/campaign-audience-guide#step-3-map-merge-variable-data-if-applicable-7\&quot; target&#x3D;\&quot;_blank\&quot;&gt;Campaign Audience Guide&lt;/a&gt; for additional details. &lt;br /&gt;If a merge variable has the same \&quot;name\&quot; as a \&quot;key\&quot; in the &#x60;requiredAddressColumnMapping&#x60; or &#x60;optionalAddressColumnMapping&#x60; objects, then they **CANNOT** have a different value in this object. If a different value is provided, then when the campaign is processing it will get overwritten with the mapped value present in the &#x60;requiredAddressColumnMapping&#x60; or &#x60;optionalAddressColumnMapping&#x60; objects. |  [optional]




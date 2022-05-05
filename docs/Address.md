

# Address


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;adr_&#x60;. |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**name** | **String** | name associated with address |  [optional]
**company** | **String** | Either &#x60;name&#x60; or &#x60;company&#x60; is required, you may also add both. |  [optional]
**phone** | **String** | Must be no longer than 40 characters. |  [optional]
**email** | **String** | Must be no longer than 100 characters. |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**addressLine1** | **String** |  |  [optional]
**addressLine2** | **String** |  |  [optional]
**addressCity** | **String** |  |  [optional]
**addressState** | **String** | 2 letter state short-name code |  [optional]
**addressZip** | **String** | Must follow the ZIP format of &#x60;12345&#x60; or ZIP+4 format of &#x60;12345-1234&#x60;.  |  [optional]
**addressCountry** | **CountryExtendedExpanded** |  |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional]
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. |  [optional]
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. |  [optional]
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**recipientMoved** | **Boolean** | Only returned for accounts on certain &lt;a href&#x3D;\&quot;https://dashboard.lob.com/#/settings/editions\&quot;&gt;Print &amp;amp; Mail Editions&lt;/a&gt;. Value is &#x60;true&#x60; if the address was altered because the recipient filed for a &lt;a href&#x3D;\&quot;#ncoa\&quot;&gt;National Change of Address (NCOA)&lt;/a&gt;, &#x60;false&#x60; if the NCOA check was run but no altered address was found, and &#x60;null&#x60; if the NCOA check was not run. The NCOA check does not happen for non-US addresses, for non-deliverable US addresses, or for addresses created before the NCOA feature was added to your account.  |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
ADDRESS | &quot;address&quot;




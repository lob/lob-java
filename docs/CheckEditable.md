

# CheckEditable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from** | [**OneOfstringaddressDomestic**](OneOfstringaddressDomestic.md) | Required if &#x60;to&#x60; address is international. Must either be an address ID or an inline object with correct address parameters. |  [optional]
**to** | [**OneOfstringaddressDomestic**](OneOfstringaddressDomestic.md) | Required if &#x60;to&#x60; address is international. Must either be an address ID or an inline object with correct address parameters. |  [optional]
**bankAccount** | **String** |  |  [optional]
**amount** | **Float** | The payment amount to be sent in US dollars. |  [optional]
**logo** | **Object** | Accepts a remote URL or local file upload to an image to print (in grayscale) in the upper-left corner of your check. |  [optional]
**checkBottom** | [**CheckBottom**](CheckBottom.md) |  |  [optional]
**attachment** | [**OneOfstringstringstringstring**](OneOfstringstringstringstring.md) | A document to include with the check. |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**mergeVariables** | **Object** | You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: &#x60;{{variable_name}}&#x60;, pass in &#x60;{\&quot;variable_name\&quot;: \&quot;Harry\&quot;}&#x60; to render &#x60;Harry&#x60;. &#x60;merge_variables&#x60; must be an object. Any type of value is accepted as long as the object is valid JSON; you can use &#x60;strings&#x60;, &#x60;numbers&#x60;, &#x60;booleans&#x60;, &#x60;arrays&#x60;, &#x60;objects&#x60;, or &#x60;null&#x60;. The max length of the object is 25,000 characters. If you call &#x60;JSON.stringify&#x60; on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: &#x60;!&#x60;, &#x60;\&quot;&#x60;, &#x60;#&#x60;, &#x60;%&#x60;, &#x60;&amp;&#x60;, &#x60;&#39;&#x60;, &#x60;(&#x60;, &#x60;)&#x60;, &#x60;*&#x60;, &#x60;+&#x60;, &#x60;,&#x60;, &#x60;/&#x60;, &#x60;;&#x60;, &#x60;&lt;&#x60;, &#x60;&#x3D;&#x60;, &#x60;&gt;&#x60;, &#x60;@&#x60;, &#x60;[&#x60;, &#x60;\\&#x60;, &#x60;]&#x60;, &#x60;^&#x60;, &#x60;&#x60; &#x60; &#x60;&#x60;, &#x60;{&#x60;, &#x60;|&#x60;, &#x60;}&#x60;, &#x60;~&#x60;. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string. |  [optional]
**sendDate** | [**SendDate**](SendDate.md) |  |  [optional]
**mailType** | [**MailTypeEnum**](#MailTypeEnum) | Checks must be sent &#x60;usps_first_class&#x60; |  [optional]
**memo** | **String** | Text to include on the memo line of the check. |  [optional]
**checkNumber** | **Integer** | An integer that designates the check number. |  [optional]
**message** | **String** | Max of 400 characters to be included at the bottom of the check page. |  [optional]
**billingGroupId** | **String** | An optional string with the billing group ID to tag your usage with. Is used for billing purposes. Requires special activation to use. See [Billing Group API](https://lob.github.io/lob-openapi/#tag/Billing-Groups) for more information. |  [optional]



## Enum: MailTypeEnum

Name | Value
---- | -----
USPS_FIRST_CLASS | &quot;usps_first_class&quot;



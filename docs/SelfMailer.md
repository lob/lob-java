

# SelfMailer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Unique identifier prefixed with &#x60;sfm_&#x60;. |  [optional]
**to** | [**OneOfstringaddressEditable**](OneOfstringaddressEditable.md) | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**from** | [**OneOfstringaddressEditable**](OneOfstringaddressEditable.md) | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**size** | **SelfMailerSize** |  |  [optional]
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**mailType** | **MailType** |  |  [optional]
**mergeVariables** | **Object** | You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: &#x60;{{variable_name}}&#x60;, pass in &#x60;{\&quot;variable_name\&quot;: \&quot;Harry\&quot;}&#x60; to render &#x60;Harry&#x60;. &#x60;merge_variables&#x60; must be an object. Any type of value is accepted as long as the object is valid JSON; you can use &#x60;strings&#x60;, &#x60;numbers&#x60;, &#x60;booleans&#x60;, &#x60;arrays&#x60;, &#x60;objects&#x60;, or &#x60;null&#x60;. The max length of the object is 25,000 characters. If you call &#x60;JSON.stringify&#x60; on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: &#x60;!&#x60;, &#x60;\&quot;&#x60;, &#x60;#&#x60;, &#x60;%&#x60;, &#x60;&amp;&#x60;, &#x60;&#39;&#x60;, &#x60;(&#x60;, &#x60;)&#x60;, &#x60;*&#x60;, &#x60;+&#x60;, &#x60;,&#x60;, &#x60;/&#x60;, &#x60;;&#x60;, &#x60;&lt;&#x60;, &#x60;&#x3D;&#x60;, &#x60;&gt;&#x60;, &#x60;@&#x60;, &#x60;[&#x60;, &#x60;\\&#x60;, &#x60;]&#x60;, &#x60;^&#x60;, &#x60;&#x60; &#x60; &#x60;&#x60;, &#x60;{&#x60;, &#x60;|&#x60;, &#x60;}&#x60;, &#x60;~&#x60;. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string. |  [optional]
**sendDate** | [**SendDate**](SendDate.md) |  |  [optional]
**outsideTemplateId** | [**String**](String.md) | The unique ID of the HTML template used for the outside of the self mailer. |  [optional]
**insideTemplateId** | [**String**](String.md) | The unique ID of the HTML template used for the inside of the self mailer. |  [optional]
**outsideTemplateVersionId** | [**String**](String.md) | The unique ID of the specific version of the HTML template used for the outside of the self mailer. |  [optional]
**insideTemplateVersionId** | [**String**](String.md) | The unique ID of the specific version of the HTML template used for the inside of the self mailer. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) | Value is resource type. |  [optional]
**trackingEvents** | [**List&lt;TrackingEventCertified&gt;**](TrackingEventCertified.md) | An array of certified tracking events ordered by ascending &#x60;time&#x60;. Not populated in test mode. |  [optional]
**url** | **String** | A [signed link](#section/Asset-URLs) served over HTTPS. The link returned will expire in 30 days to prevent mis-sharing. Each time a GET request is initiated, a new signed URL will be generated. |  [optional]



## Enum: ObjectEnum

Name | Value
---- | -----
SELF_MAILER | &quot;self_mailer&quot;




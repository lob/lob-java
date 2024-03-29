

# Letter


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**to** | [**Address**](Address.md) |  | 
**from** | [**Address**](Address.md) |  | 
**carrier** | [**CarrierEnum**](#CarrierEnum) |  |  [optional]
**thumbnails** | [**List&lt;Thumbnail&gt;**](Thumbnail.md) |  |  [optional]
**expectedDeliveryDate** | **LocalDate** | A date in YYYY-MM-DD format of the mailpiece&#39;s expected delivery date based on its &#x60;send_date&#x60;. |  [optional]
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. | 
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. | 
**deleted** | **Boolean** | Only returned if the resource has been successfully deleted. |  [optional]
**id** | **String** | Unique identifier prefixed with &#x60;ltr_&#x60;. | 
**templateId** | **String** | Unique identifier prefixed with &#x60;tmpl_&#x60;. ID of a saved [HTML template](#section/HTML-Templates). |  [optional]
**templateVersionId** | **String** | Unique identifier prefixed with &#x60;vrsn_&#x60;. |  [optional]
**url** | **String** | A [signed link](#section/Asset-URLs) served over HTTPS. The link returned will expire in 30 days to prevent mis-sharing. Each time a GET request is initiated, a new signed URL will be generated. |  [optional]
**_object** | [**ObjectEnum**](#ObjectEnum) |  | 
**description** | **String** | An internal description that identifies this resource. Must be no longer than 255 characters.  |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Use metadata to store custom information for tagging and labeling back to your internal systems. Must be an object with up to 20 key-value pairs. Keys must be at most 40 characters and values must be at most 500 characters. Neither can contain the characters &#x60;\&quot;&#x60; and &#x60;\\&#x60;. i.e. &#39;{\&quot;customer_id\&quot; : \&quot;NEWYORK2015\&quot;}&#39; Nested objects are not supported.  See [Metadata](#section/Metadata) for more information. |  [optional]
**mergeVariables** | **Object** | You can input a merge variable payload object to your template to render dynamic content. For example, if you have a template like: &#x60;{{variable_name}}&#x60;, pass in &#x60;{\&quot;variable_name\&quot;: \&quot;Harry\&quot;}&#x60; to render &#x60;Harry&#x60;. &#x60;merge_variables&#x60; must be an object. Any type of value is accepted as long as the object is valid JSON; you can use &#x60;strings&#x60;, &#x60;numbers&#x60;, &#x60;booleans&#x60;, &#x60;arrays&#x60;, &#x60;objects&#x60;, or &#x60;null&#x60;. The max length of the object is 25,000 characters. If you call &#x60;JSON.stringify&#x60; on your object, it can be no longer than 25,000 characters. Your variable names cannot contain any whitespace or any of the following special characters: &#x60;!&#x60;, &#x60;\&quot;&#x60;, &#x60;#&#x60;, &#x60;%&#x60;, &#x60;&amp;&#x60;, &#x60;&#39;&#x60;, &#x60;(&#x60;, &#x60;)&#x60;, &#x60;*&#x60;, &#x60;+&#x60;, &#x60;,&#x60;, &#x60;/&#x60;, &#x60;;&#x60;, &#x60;&lt;&#x60;, &#x60;&#x3D;&#x60;, &#x60;&gt;&#x60;, &#x60;@&#x60;, &#x60;[&#x60;, &#x60;\\&#x60;, &#x60;]&#x60;, &#x60;^&#x60;, &#x60;&#x60; &#x60; &#x60;&#x60;, &#x60;{&#x60;, &#x60;|&#x60;, &#x60;}&#x60;, &#x60;~&#x60;. More instructions can be found in [our guide to using html and merge variables](https://lob.com/resources/guides/general/using-html-and-merge-variables). Depending on your [Merge Variable strictness](https://dashboard.lob.com/#/settings/account) setting, if you define variables in your HTML but do not pass them here, you will either receive an error or the variable will render as an empty string. |  [optional]
**sendDate** | **OffsetDateTime** | A timestamp in ISO 8601 format which specifies a date after the current time and up to 180 days in the future to send the letter off for production. Setting a send date overrides the default [cancellation window](#section/Cancellation-Windows) applied to the mailpiece. Until the &#x60;send_date&#x60; has passed, the mailpiece can be canceled. If a date in the format &#x60;2017-11-01&#x60; is passed, it will evaluate to midnight UTC of that date (&#x60;2017-11-01T00:00:00.000Z&#x60;). If a datetime is passed, that exact time will be used. A &#x60;send_date&#x60; passed with no time zone will default to UTC, while a &#x60;send_date&#x60; passed with a time zone will be converted to UTC. |  [optional]
**extraService** | **String** | Add an extra service to your letter. See [pricing](https://www.lob.com/pricing/print-mail#compare) for extra costs incurred. |  [optional]
**trackingNumber** | **String** | The tracking number, if applicable, will appear here when it becomes available. Dummy tracking numbers are not created in test mode. |  [optional]
**trackingEvents** | [**List&lt;TrackingEventNormal&gt;**](TrackingEventNormal.md) | Tracking events are not populated for registered or regular (no extra service) letters. |  [optional]
**returnAddress** | **Object** | Specifies the address the return envelope will be sent back to. This is an optional argument that is available if an account is signed up for the return envelope tracking beta, and has &#x60;return_envelope&#x60;, and &#x60;perforated_page&#x60; fields populated in the API request. |  [optional]
**mailType** | **MailType** |  |  [optional]
**color** | **Boolean** | Set this key to &#x60;true&#x60; if you would like to print in color. Set to &#x60;false&#x60; if you would like to print in black and white. |  [optional]
**doubleSided** | **Boolean** | Set this attribute to &#x60;true&#x60; for double sided printing, or &#x60;false&#x60; for for single sided printing. Defaults to &#x60;true&#x60;. |  [optional]
**addressPlacement** | [**AddressPlacementEnum**](#AddressPlacementEnum) | Specifies the location of the address information that will show through the double-window envelope.  |  [optional]
**returnEnvelope** | **Object** |  | 
**perforatedPage** | **Integer** | Required if &#x60;return_envelope&#x60; is &#x60;true&#x60;. The number of the page that should be perforated for use with the return envelope. Must be greater than or equal to &#x60;1&#x60;. The blank page added by &#x60;address_placement&#x3D;insert_blank_page&#x60; will be ignored when considering the perforated page number. To see how perforation will impact your letter design, view our [perforation guide](https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/letter_perf_template.pdf). |  [optional]
**customEnvelope** | [**LetterCustomEnvelope**](LetterCustomEnvelope.md) |  |  [optional]



## Enum: CarrierEnum

Name | Value
---- | -----
USPS | &quot;USPS&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
LETTER | &quot;letter&quot;



## Enum: AddressPlacementEnum

Name | Value
---- | -----
TOP_FIRST_PAGE | &quot;top_first_page&quot;
INSERT_BLANK_PAGE | &quot;insert_blank_page&quot;
BOTTOM_FIRST_PAGE_CENTER | &quot;bottom_first_page_center&quot;
BOTTOM_FIRST_PAGE | &quot;bottom_first_page&quot;




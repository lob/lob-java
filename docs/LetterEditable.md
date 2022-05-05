

# LetterEditable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**mailType** | **MailType** |  |  [optional]
**color** | **Boolean** | Set this key to &#x60;true&#x60; if you would like to print in color. Set to &#x60;false&#x60; if you would like to print in black and white. |  [optional]
**doubleSided** | **Boolean** | Set this attribute to &#x60;true&#x60; for double sided printing, or &#x60;false&#x60; for for single sided printing. Defaults to &#x60;true&#x60;. |  [optional]
**addressPlacement** | [**AddressPlacementEnum**](#AddressPlacementEnum) | Specifies the location of the address information that will show through the double-window envelope. To see how this will impact your letter design, view our letter template.   * &#x60;top_first_page&#x60; - (default) print address information at the top of your provided first page   * &#x60;insert_blank_page&#x60; - insert a blank address page at the beginning of your file (you will be charged for the extra page)   * &#x60;bottom_first_page_center&#x60; - **(deprecation planned within a few months)** print address information at the bottom center of your provided first page   * &#x60;bottom_first_page&#x60; - print address information at the bottom of your provided first page  |  [optional]
**returnEnvelope** | [**OneOfbooleanstring**](OneOfbooleanstring.md) | indicates if a return envelope is requested for the letter. The value corresponding to this field is by default a boolean. But if the account is signed up for custom return envelopes, the value is of type string and is &#x60;no_9_single_window&#x60; for a standard return envelope and a custom &#x60;return_envelope_id&#x60; for non-standard return envelopes.  To include a return envelope with your letter, set to &#x60;true&#x60; and specify the &#x60;perforated_page&#x60;. See [pricing](https://www.lob.com/pricing/print-mail#compare) for extra costs incurred. |  [optional]
**perforatedPage** | **Integer** | Required if &#x60;return_envelope&#x60; is &#x60;true&#x60;. The number of the page that should be perforated for use with the return envelope. Must be greater than or equal to &#x60;1&#x60;. The blank page added by &#x60;address_placement&#x3D;insert_blank_page&#x60; will be ignored when considering the perforated page number. To see how perforation will impact your letter design, view our [perforation guide](https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/letter_perf_template.pdf). |  [optional]
**customEnvelope** | [**LetterCustomEnvelope**](LetterCustomEnvelope.md) |  |  [optional]
**to** | [**OneOfstringaddressEditable**](OneOfstringaddressEditable.md) | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**from** | [**OneOfstringaddressEditable**](OneOfstringaddressEditable.md) | Must either be an address ID or an inline object with correct address parameters. |  [optional]
**file** | [**OneOfstringstringstringstring**](OneOfstringstringstringstring.md) | PDF file containing the letter&#39;s formatting. |  [optional]
**extraService** | [**ExtraServiceEnum**](#ExtraServiceEnum) | Add an extra service to your letter:   * &#x60;certified&#x60; - track and confirm delivery for domestic destinations. An extra sheet (1 PDF page single-sided or 2 PDF pages double-sided) is added to the beginning of your letter for address and barcode information. See here for templates: [#10 envelope](https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/letter_certified_template.pdf) and [flat envelope](https://s3-us-west-2.amazonaws.com/public.lob.com/assets/templates/letter_certified_flat_template.pdf) (used for letters over 6 pages single-sided or 12 pages double-sided). You will not be charged for this extra sheet.   * &#x60;certified_return_receipt&#x60; - request an electronic copy of the recipient&#39;s signature to prove delivery of your certified letter   * &#x60;registered&#x60; - provides tracking and confirmation for international addresses  |  [optional]
**cards** | **List&lt;String&gt;** | A single-element array containing an existing card id in a string format. See [cards](#tag/Cards) for more information. |  [optional]
**billingGroupId** | **String** | An optional string with the billing group ID to tag your usage with. Is used for billing purposes. Requires special activation to use. See [Billing Group API](https://lob.github.io/lob-openapi/#tag/Billing-Groups) for more information. |  [optional]



## Enum: AddressPlacementEnum

Name | Value
---- | -----
TOP_FIRST_PAGE | &quot;top_first_page&quot;
INSERT_BLANK_PAGE | &quot;insert_blank_page&quot;
BOTTOM_FIRST_PAGE_CENTER | &quot;bottom_first_page_center&quot;
BOTTOM_FIRST_PAGE | &quot;bottom_first_page&quot;



## Enum: ExtraServiceEnum

Name | Value
---- | -----
CERTIFIED | &quot;certified&quot;
CERTIFIED_RETURN_RECEIPT | &quot;certified_return_receipt&quot;
REGISTERED | &quot;registered&quot;
NULL | &quot;null&quot;






# DeliverabilityAnalysis

A nested object containing a breakdown of the deliverability of an address.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dpvConfirmation** | [**DpvConfirmationEnum**](#DpvConfirmationEnum) | Result of Delivery Point Validation (DPV), which determines whether or not the address is deliverable by the USPS. Possible values are: * &#x60;Y&#x60; –– The address is deliverable by the USPS. * &#x60;S&#x60; –– The address is deliverable by removing the provided secondary unit designator. This information may be incorrect or unnecessary. * &#x60;D&#x60; –– The address is deliverable to the building&#39;s default address but is missing a secondary unit designator and/or number.   There is a chance the mail will not reach the intended recipient. * &#x60;N&#x60; –– The address is not deliverable according to the USPS, but parts of the address are valid (such as the street and ZIP code). * &#x60;&#39;&#39;&#x60; –– This address is not deliverable. No matching street could be found within the city or ZIP code.  | 
**dpvCmra** | [**DpvCmraEnum**](#DpvCmraEnum) | indicates whether or not the address is [CMRA-authorized](https://en.wikipedia.org/wiki/Commercial_mail_receiving_agency). Possible values are: * &#x60;Y&#x60; –– Address is CMRA-authorized. * &#x60;N&#x60; –– Address is not CMRA-authorized. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvVacant** | [**DpvVacantEnum**](#DpvVacantEnum) | indicates that an address was once deliverable, but has become vacant and is no longer receiving deliveries. Possible values are: * &#x60;Y&#x60; –– Address is vacant. * &#x60;N&#x60; –– Address is not vacant. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvActive** | [**DpvActiveEnum**](#DpvActiveEnum) | Corresponds to the USPS field &#x60;dpv_no_stat&#x60;. Indicates that an address has been vacated in the recent past, and is no longer receiving deliveries. If it&#39;s been unoccupied for 90+ days, or temporarily vacant, this will be flagged. Possible values are: * &#x60;Y&#x60; –– Address is active. * &#x60;N&#x60; –– Address is not active. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvInactiveReason** | [**DpvInactiveReasonEnum**](#DpvInactiveReasonEnum) | Indicates the reason why an address is vacant or no longer receiving deliveries. Possible values are: * &#x60;01&#x60; –– Address does not receive mail from the USPS directly, but is serviced by a drop address. * &#x60;02&#x60; –– Address not yet deliverable. * &#x60;03&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string). * &#x60;04&#x60; –– Address is a College, Military Zone, or other type. * &#x60;05&#x60; –– Address no longer receives deliveries. * &#x60;06&#x60; –– Address is missing required secondary information. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made or the address is active.  | 
**dpvThrowback** | [**DpvThrowbackEnum**](#DpvThrowbackEnum) | Indicates a street address for which mail is delivered to a PO Box. Possible values are: * &#x60;Y&#x60; –– Address is a PO Box throwback delivery point. * &#x60;N&#x60; –– Address is not a PO Box throwback delivery point. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvNonDeliveryDayFlag** | [**DpvNonDeliveryDayFlagEnum**](#DpvNonDeliveryDayFlagEnum) | Indicates whether deliveries are not performed on one or more days of the week at an address. Possible values are: * &#x60;Y&#x60; –– Mail delivery does not occur on some days of the week. * &#x60;N&#x60; –– Mail delivery occurs every day of the week. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvNonDeliveryDayValues** | **String** | Indicates days of the week (starting on Sunday) deliveries are not performed at an address. For example: * &#x60;YNNNNNN&#x60; –– Mail delivery does not occur on Sunday&#39;s. * &#x60;NYNNNYN&#x60; –– Mail delivery does not occur on Monday&#39;s or Friday&#39;s. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string) or address receives mail every day of the week (&#x60;deliverability_analysis[dpv_non_delivery_day_flag]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvNoSecureLocation** | [**DpvNoSecureLocationEnum**](#DpvNoSecureLocationEnum) | Indicates packages to this address will not be left due to security concerns. Possible values are: * &#x60;Y&#x60; –– Address does not have a secure mailbox. * &#x60;N&#x60; –– Address has a secure mailbox. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvDoorNotAccessible** | [**DpvDoorNotAccessibleEnum**](#DpvDoorNotAccessibleEnum) | Indicates the door of the address is not accessible for mail delivery. Possible values are: * &#x60;Y&#x60; –– Door is not accessible. * &#x60;N&#x60; –– Door is accessible. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**dpvFootnotes** | **List&lt;DpvFootnote&gt;** | An array of 2-character strings that gives more insight into how &#x60;deliverability_analysis[dpv_confirmation]&#x60; was determined. Will always include at least 1 string, and can include up to 3. For details, see [US Verification Details](#tag/US-Verification-Types).  | 
**ewsMatch** | **Boolean** | indicates whether or not an address has been flagged in the [Early Warning System](https://docs.informatica.com/data-engineering/data-engineering-quality/10-4-0/address-validator-port-reference/postal-carrier-certification-data-ports/early-warning-system-return-code.html), meaning the address is under development and not yet ready to receive mail. However, it should become available in a few months.  | 
**lacsIndicator** | [**LacsIndicatorEnum**](#LacsIndicatorEnum) | indicates whether this address has been converted by [LACS&lt;sup&gt;Link&lt;/sup&gt;](https://postalpro.usps.com/address-quality/lacslink). LACS&lt;sup&gt;Link&lt;/sup&gt; corrects outdated addresses into their modern counterparts. Possible values are: * &#x60;Y&#x60; –– New address produced with a matching record in LACS&lt;sup&gt;Link&lt;/sup&gt;. * &#x60;N&#x60; –– New address could not be produced with a matching record in LACS&lt;sup&gt;Link&lt;/sup&gt;. * &#x60;&#39;&#39;&#x60; –– A DPV match is not made (&#x60;deliverability_analysis[dpv_confirmation]&#x60; is &#x60;N&#x60; or an empty string).  | 
**lacsReturnCode** | **String** | A code indicating how &#x60;deliverability_analysis[lacs_indicator]&#x60; was determined. Possible values are: * &#x60;A&#x60; — A new address was produced because a match was found in LACS&lt;sup&gt;Link&lt;/sup&gt;. * &#x60;92&#x60; — A LACS&lt;sup&gt;Link&lt;/sup&gt; record was matched after dropping secondary information. * &#x60;14&#x60; — A match was found in LACS&lt;sup&gt;Link&lt;/sup&gt;, but could not be converted to a deliverable address. * &#x60;00&#x60; — A match was not found in LACS&lt;sup&gt;Link&lt;/sup&gt;, and no new address was produced. * &#x60;&#39;&#39;&#x60; — LACS&lt;sup&gt;Link&lt;/sup&gt; was not attempted.  | 
**suiteReturnCode** | [**SuiteReturnCodeEnum**](#SuiteReturnCodeEnum) | A return code that indicates whether the address was matched and corrected by [Suite&lt;sup&gt;Link&lt;/sup&gt;](https://postalpro.usps.com/address-quality-solutions/suitelink). Suite&lt;sup&gt;Link&lt;/sup&gt; attempts to provide secondary information to business addresses. Possible values are: * &#x60;A&#x60; –– A Suite&lt;sup&gt;Link&lt;/sup&gt; match was found and secondary information was added. * &#x60;00&#x60; –– A Suite&lt;sup&gt;Link&lt;/sup&gt; match could not be found and no secondary information was added. * &#x60;&#39;&#39;&#x60; –– Suite&lt;sup&gt;Link&lt;/sup&gt; lookup was not attempted.  | 



## Enum: DpvConfirmationEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
S | &quot;S&quot;
D | &quot;D&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvCmraEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvVacantEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvActiveEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvInactiveReasonEnum

Name | Value
---- | -----
_01 | &quot;01&quot;
_02 | &quot;02&quot;
_03 | &quot;03&quot;
_04 | &quot;04&quot;
_05 | &quot;05&quot;
_06 | &quot;06&quot;
EMPTY | &quot;&quot;



## Enum: DpvThrowbackEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvNonDeliveryDayFlagEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvNoSecureLocationEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: DpvDoorNotAccessibleEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: LacsIndicatorEnum

Name | Value
---- | -----
Y | &quot;Y&quot;
N | &quot;N&quot;
EMPTY | &quot;&quot;



## Enum: SuiteReturnCodeEnum

Name | Value
---- | -----
A | &quot;A&quot;
_00 | &quot;00&quot;
EMPTY | &quot;&quot;




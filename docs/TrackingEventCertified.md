

# TrackingEventCertified


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) | a Certified letter tracking event | 
**name** | [**NameEnum**](#NameEnum) | Name of tracking event for Certified letters. Letters sent with USPS Certified Mail are fully tracked by USPS, therefore their tracking events have an additional details object with more detailed information about the tracking event. Some certified tracking event names have multiple meanings, noted in the list here. See the description of the details object for the full set of combined certified tracking event name meanings.    * &#x60;Mailed&#x60; - Package has been accepted into the carrier network for delivery.    * &#x60;In Transit&#x60; - Maps to four distinct stages of transit.    * &#x60;In Local Area&#x60; - Package is at a location near the end destination.    * &#x60;Processed for Delivery&#x60; - Maps to two distinct stages of delivery.    * &#x60;Pickup Available&#x60; - Package is available for pickup at carrier location.    * &#x60;Delivered&#x60; - Package has been delivered.    * &#x60;Re-Routed&#x60; - Package has been forwarded.    * &#x60;Returned to Sender&#x60; - Package is to be returned to sender.    * &#x60;Issue&#x60; - Maps to (at least) 15 possible issues, some of which are actionable.  | 
**details** | [**TrackingEventDetails**](TrackingEventDetails.md) |  |  [optional]
**location** | **String** | The zip code in which the event occurred if it exists, otherwise will be the name of a Regional Distribution Center if it exists, otherwise will be null.  |  [optional]
**id** | **String** | Unique identifier prefixed with &#x60;evnt_&#x60;. | 
**time** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date USPS registered the event. |  [optional]
**dateCreated** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was created. | 
**dateModified** | **OffsetDateTime** | A timestamp in ISO 8601 format of the date the resource was last modified. | 
**_object** | [**ObjectEnum**](#ObjectEnum) |  | 



## Enum: TypeEnum

Name | Value
---- | -----
CERTIFIED | &quot;certified&quot;



## Enum: NameEnum

Name | Value
---- | -----
MAILED | &quot;Mailed&quot;
IN_TRANSIT | &quot;In Transit&quot;
IN_LOCAL_AREA | &quot;In Local Area&quot;
PROCESSED_FOR_DELIVERY | &quot;Processed for Delivery&quot;
PICKUP_AVAILABLE | &quot;Pickup Available&quot;
DELIVERED | &quot;Delivered&quot;
RE_ROUTED | &quot;Re-Routed&quot;
RETURNED_TO_SENDER | &quot;Returned to Sender&quot;
ISSUE | &quot;Issue&quot;



## Enum: ObjectEnum

Name | Value
---- | -----
TRACKING_EVENT | &quot;tracking_event&quot;




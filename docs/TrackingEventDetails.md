

# TrackingEventDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**event** | [**EventEnum**](#EventEnum) | Find the full table [here](#tag/Tracking-Events). A detailed substatus about the event: * &#x60;package_accepted&#x60; - Package has been accepted into the carrier network for delivery. * &#x60;package_arrived&#x60; - Package has arrived at an intermediate location in the carrier network. * &#x60;package_departed&#x60; - Package has departed from an intermediate location in the carrier network. * &#x60;package_processing&#x60; - Package is processing at an intermediate location in the carrier network. * &#x60;package_processed&#x60; - Package has been processed at an intermediate location. * &#x60;package_in_local_area&#x60; - Package is at a location near the end destination. * &#x60;delivery_scheduled&#x60; - Package is scheduled for delivery. * &#x60;out_for_delivery&#x60; - Package is out for delivery. * &#x60;pickup_available&#x60; - Package is available for pickup at carrier location. * &#x60;delivered&#x60; - Package has been delivered. * &#x60;package_forwarded&#x60; - Package has been forwarded. * &#x60;returned_to_sender&#x60; - Package is to be returned to sender. * &#x60;address_issue&#x60; - Address information is incorrect. Contact carrier to ensure delivery. * &#x60;contact_carrier&#x60; - Contact the carrier for more information. * &#x60;delayed&#x60; - Delivery of package is delayed. * &#x60;delivery_attempted&#x60; - Delivery of package has been attempted. Contact carrier to ensure delivery. * &#x60;delivery_rescheduled&#x60; - Delivery of package has been rescheduled. * &#x60;location_inaccessible&#x60; - Delivery location inaccessible to carrier. Contact carrier to ensure delivery. * &#x60;notice_left&#x60; - Carrier left notice during attempted delivery. Follow carrier instructions on notice. * &#x60;package_damaged&#x60; - Package has been damaged. Contact carrier for more details. * &#x60;package_disposed&#x60; - Package has been disposed. * &#x60;package_held&#x60; - Package held at carrier location. Contact carrier for more details. * &#x60;package_lost&#x60; - Package has been lost. Contact carrier for more details. * &#x60;package_unclaimed&#x60; - Package is unclaimed. * &#x60;package_undeliverable&#x60; - Package is not able to be delivered. * &#x60;reschedule_delivery&#x60; - Contact carrier to reschedule delivery. * &#x60;other&#x60; - Unrecognized carrier status.  | 
**description** | **String** | The description as listed in the description for event. | 
**notes** | **String** | Event-specific notes from USPS about the tracking event. |  [optional]
**actionRequired** | **Boolean** | &#x60;true&#x60; if action is required by the end recipient, &#x60;false&#x60; otherwise.  | 



## Enum: EventEnum

Name | Value
---- | -----
PACKAGE_ACCEPTED | &quot;package_accepted&quot;
PACKAGE_ARRIVED | &quot;package_arrived&quot;
PACKAGE_DEPARTED | &quot;package_departed&quot;
PACKAGE_PROCESSING | &quot;package_processing&quot;
PACKAGE_PROCESSED | &quot;package_processed&quot;
PACKAGE_IN_LOCAL_AREA | &quot;package_in_local_area&quot;
DELIVERY_SCHEDULED | &quot;delivery_scheduled&quot;
OUT_FOR_DELIVERY | &quot;out_for_delivery&quot;
PICKUP_AVAILABLE | &quot;pickup_available&quot;
DELIVERED | &quot;delivered&quot;
PACKAGE_FORWARDED | &quot;package_forwarded&quot;
RETURNED_TO_SENDER | &quot;returned_to_sender&quot;
ADDRESS_ISSUE | &quot;address_issue&quot;
CONTACT_CARRIER | &quot;contact_carrier&quot;
DELAYED | &quot;delayed&quot;
DELIVERY_ATTEMPTED | &quot;delivery_attempted&quot;
DELIVERY_RESCHEDULED | &quot;delivery_rescheduled&quot;
LOCATION_INACCESSIBLE | &quot;location_inaccessible&quot;
NOTICE_LEFT | &quot;notice_left&quot;
PACKAGE_DAMAGED | &quot;package_damaged&quot;
PACKAGE_DISPOSED | &quot;package_disposed&quot;
PACKAGE_HELD | &quot;package_held&quot;
PACKAGE_LOST | &quot;package_lost&quot;
PACKAGE_UNCLAIMED | &quot;package_unclaimed&quot;
PACKAGE_UNDELIVERABLE | &quot;package_undeliverable&quot;
RESCHEDULE_DELIVERY | &quot;reschedule_delivery&quot;
OTHER | &quot;other&quot;




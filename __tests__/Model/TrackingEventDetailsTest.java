package Model;

import org.openapitools.client.model.TrackingEventDetails;

import org.testng.annotations.*;
import org.testng.Assert;

public class TrackingEventDetailsTest {
    @DataProvider (name = "tracking-event-details-data-provider")
    public Object[][] trackingEventDetailsDpMethod(){
        return new Object[][] {
            {"event", TrackingEventDetails.EventEnum.DELIVERED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_ACCEPTED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_ARRIVED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_DEPARTED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_PROCESSING},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_PROCESSED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_IN_LOCAL_AREA},
            {"event", TrackingEventDetails.EventEnum.DELIVERY_SCHEDULED},
            {"event", TrackingEventDetails.EventEnum.OUT_FOR_DELIVERY},
            {"event", TrackingEventDetails.EventEnum.PICKUP_AVAILABLE},
            {"event", TrackingEventDetails.EventEnum.DELIVERED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_FORWARDED},
            {"event", TrackingEventDetails.EventEnum.RETURNED_TO_SENDER},
            {"event", TrackingEventDetails.EventEnum.ADDRESS_ISSUE},
            {"event", TrackingEventDetails.EventEnum.CONTACT_CARRIER},
            {"event", TrackingEventDetails.EventEnum.DELAYED},
            {"event", TrackingEventDetails.EventEnum.DELIVERY_ATTEMPTED},
            {"event", TrackingEventDetails.EventEnum.DELIVERY_RESCHEDULED},
            {"event", TrackingEventDetails.EventEnum.LOCATION_INACCESSIBLE},
            {"event", TrackingEventDetails.EventEnum.NOTICE_LEFT},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_DAMAGED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_DISPOSED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_HELD},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_LOST},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_UNCLAIMED},
            {"event", TrackingEventDetails.EventEnum.PACKAGE_UNDELIVERABLE},
            {"event", TrackingEventDetails.EventEnum.RESCHEDULE_DELIVERY},
            {"event", TrackingEventDetails.EventEnum.OTHER},
            {"description", "fake description"},
            {"notes", "fake notes"},
            {"action_required", true},
            {"action_required", false},
        };
    }

    @Test(enabled=true, dataProvider = "tracking-event-details-data-provider")
    public void trackingEventDetailsTestWithProvidedValue(String prop, Object val) throws Exception {
        TrackingEventDetails rec = new TrackingEventDetails();

        switch (prop) {
            case "event": {
                TrackingEventDetails.EventEnum castedVal = (TrackingEventDetails.EventEnum)val;
                rec.setEvent(castedVal);
                Assert.assertEquals(rec.getEvent(), castedVal);
                break;
            }
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "notes": {
                String castedVal = (String)val;
                rec.setNotes(castedVal);
                Assert.assertEquals(rec.getNotes(), castedVal);
                break;
            }
            case "action_required": {
                Boolean castedVal = (Boolean)val;
                rec.setActionRequired(castedVal);
                Assert.assertEquals(rec.getActionRequired(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

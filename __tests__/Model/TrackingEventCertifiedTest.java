package Model;

import org.openapitools.client.model.TrackingEventCertified;
import org.openapitools.client.model.TrackingEventDetails;

import org.threeten.bp.OffsetDateTime;

import org.testng.annotations.*;
import org.testng.Assert;

public class TrackingEventCertifiedTest {
    @DataProvider (name = "tracking-event-certified-data-provider")
    public Object[][] trackingEventCertifiedDpMethod() {
        return new Object[][] {
            {"type", TrackingEventCertified.TypeEnum.CERTIFIED},
            {"name", TrackingEventCertified.NameEnum.IN_TRANSIT},
            {"name", TrackingEventCertified.NameEnum.MAILED},
            {"name", TrackingEventCertified.NameEnum.IN_LOCAL_AREA},
            {"name", TrackingEventCertified.NameEnum.PROCESSED_FOR_DELIVERY},
            {"name", TrackingEventCertified.NameEnum.PICKUP_AVAILABLE},
            {"name", TrackingEventCertified.NameEnum.DELIVERED},
            {"name", TrackingEventCertified.NameEnum.RE_ROUTED},
            {"name", TrackingEventCertified.NameEnum.RETURNED_TO_SENDER},
            {"name", TrackingEventCertified.NameEnum.ISSUE},
            {"details", new TrackingEventDetails()},
            {"location", "fake location"},
            {"id", "evnt_fakeId"},
            {"time", OffsetDateTime.now()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"object", TrackingEventCertified.ObjectEnum.TRACKING_EVENT},
        };
    }

    @Test(enabled=true, dataProvider = "tracking-event-certified-data-provider")
    public void trackingEventCertifiedTestWithProvidedValue(String prop, Object val) throws Exception {
        TrackingEventCertified rec = new TrackingEventCertified();

        switch (prop) {
            case "type": {
                TrackingEventCertified.TypeEnum castedVal = (TrackingEventCertified.TypeEnum)val;
                rec.setType(castedVal);
                Assert.assertEquals(rec.getType(), castedVal);
                break;
            }
            case "name": {
                TrackingEventCertified.NameEnum castedVal = (TrackingEventCertified.NameEnum)val;
                rec.setName(castedVal);
                Assert.assertEquals(rec.getName(), castedVal);
                break;
            }
            case "details": {
                TrackingEventDetails castedVal = (TrackingEventDetails)val;
                rec.setDetails(castedVal);
                Assert.assertEquals(rec.getDetails(), castedVal);
                break;
            }
            case "location": {
                String castedVal = (String)val;
                rec.setLocation(castedVal);
                Assert.assertEquals(rec.getLocation(), castedVal);
                break;
            }
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "time": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setTime(castedVal);
                Assert.assertEquals(rec.getTime(), castedVal);
                break;
            }
            case "date_created": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateCreated(castedVal);
                Assert.assertEquals(rec.getDateCreated(), castedVal);
                break;
            }
            case "date_modified": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateModified(castedVal);
                Assert.assertEquals(rec.getDateModified(), castedVal);
                break;
            }
            case "object": {
                TrackingEventCertified.ObjectEnum castedVal = (TrackingEventCertified.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void trackingEventCertifiedTestInvalidId() {
        TrackingEventCertified rec = new TrackingEventCertified();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

package Model;

import org.openapitools.client.model.TrackingEventNormal;

import org.threeten.bp.OffsetDateTime;

import org.testng.annotations.*;
import org.testng.Assert;

public class TrackingEventNormalTest {
@DataProvider (name = "tracking-event-normal-data-provider")
    public Object[][] trackingEventNormalDpMethod(){
        return new Object[][] {
            {"id", "evnt_fakeId"},
            {"type", TrackingEventNormal.TypeEnum.NORMAL},
            {"name", TrackingEventNormal.NameEnum.IN_TRANSIT},
            {"name", TrackingEventNormal.NameEnum.MAILED},
            {"name", TrackingEventNormal.NameEnum.RE_ROUTED},
            {"name", TrackingEventNormal.NameEnum.PROCESSED_FOR_DELIVERY},
            {"name", TrackingEventNormal.NameEnum.IN_LOCAL_AREA},
            {"name", TrackingEventNormal.NameEnum.RETURNED_TO_SENDER},
            // {"details", TrackingEventNormal.DetailsEnum.NULL}, // TODO: DXP-920
            {"location", "fake location"},
            {"location", null},
            {"time", OffsetDateTime.now()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"object", TrackingEventNormal.ObjectEnum.TRACKING_EVENT},
        };
    }

    @Test(enabled=true, dataProvider = "tracking-event-normal-data-provider")
    public void trackingEventNormalTestWithProvidedValue(String prop, Object val) throws Exception {
        TrackingEventNormal rec = new TrackingEventNormal();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "type": {
                TrackingEventNormal.TypeEnum castedVal = (TrackingEventNormal.TypeEnum)val;
                rec.setType(castedVal);
                Assert.assertEquals(rec.getType(), castedVal);
                break;
            }
            case "name": {
                TrackingEventNormal.NameEnum castedVal = (TrackingEventNormal.NameEnum)val;
                rec.setName(castedVal);
                Assert.assertEquals(rec.getName(), castedVal);
                break;
            }
            // case "details": { // TODO: DXP-920
            //     TrackingEventDetails castedVal = (TrackingEventDetails)val;
            //     rec.setDetails(castedVal);
            //     Assert.assertEquals(rec.getDetails(), castedVal);
            //     break;
            // }
            case "location": {
                String castedVal = (String)val;
                rec.setLocation(castedVal);
                Assert.assertEquals(rec.getLocation(), castedVal);
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
                TrackingEventNormal.ObjectEnum castedVal = (TrackingEventNormal.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void trackingEventNormalTestInvalidId() {
        TrackingEventNormal rec = new TrackingEventNormal();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

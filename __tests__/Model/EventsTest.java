package Model;

import com.lob.model.Events;
import com.lob.model.EventType;

import org.threeten.bp.OffsetDateTime;

import org.testng.annotations.*;
import org.testng.Assert;

public class EventsTest {
    @DataProvider (name = "events-data-provider")
    public Object[][] eventsDpMethod(){
        return new Object[][] {
            {"id", "evt_fakeId"},
            {"body", new Object()},
            {"reference_id", "fake reference id"},
            {"event_type", new EventType()},
            {"date_created", OffsetDateTime.now()},
            {"object", Events.ObjectEnum.EVENT},
        };
    }

    @Test(enabled=true, dataProvider = "events-data-provider")
    public void eventsTestWithProvidedValue(String prop, Object val) throws Exception {
        Events rec = new Events();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "body": {
                Object castedVal = (Object)val;
                rec.setBody(castedVal);
                Assert.assertEquals(rec.getBody(), castedVal);
                break;
            }
            case "reference_id": {
                String castedVal = (String)val;
                rec.setReferenceId(castedVal);
                Assert.assertEquals(rec.getReferenceId(), castedVal);
                break;
            }
            case "event_type": {
                EventType castedVal = (EventType)val;
                rec.setEventType(castedVal);
                Assert.assertEquals(rec.getEventType(), castedVal);
                break;
            }
            case "date_created": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateCreated(castedVal);
                Assert.assertEquals(rec.getDateCreated(), castedVal);
                break;
            }
            case "object": {
                Events.ObjectEnum castedVal = (Events.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void eventsTestInvalidId() {
        Events rec = new Events();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

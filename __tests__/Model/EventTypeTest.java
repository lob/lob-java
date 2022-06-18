package Model;

import com.lob.model.EventType;

import org.testng.annotations.*;
import org.testng.Assert;

public class EventTypeTest {
    @DataProvider (name = "event-type-data-provider")
    public Object[][] eventTypeDpMethod() {
        return new Object[][] {
            {"id", "fake id"},
            {"enabled_for_test", true},
            {"enabled_for_test", false},
            {"resource", EventType.ResourceEnum.ADDRESSES},
            {"resource", EventType.ResourceEnum.CHECKS},
            {"resource", EventType.ResourceEnum.BANK_ACCOUNTS},
            {"resource", EventType.ResourceEnum.LETTERS},
            {"resource", EventType.ResourceEnum.POSTCARDS},
            {"resource", EventType.ResourceEnum.SELF_MAILERS},
            {"object", EventType.ObjectEnum.EVENT_TYPE},
        };
    }

    @Test(enabled=true, dataProvider = "event-type-data-provider")
    public void eventTypeTestWithProvidedValue(String prop, Object val) throws Exception {
        EventType rec = new EventType();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "enabled_for_test": {
                Boolean castedVal = (Boolean)val;
                rec.setEnabledForTest(castedVal);
                Assert.assertEquals(rec.getEnabledForTest(), castedVal);
                break;
            }
            case "resource": {
                EventType.ResourceEnum castedVal = (EventType.ResourceEnum)val;
                rec.setResource(castedVal);
                Assert.assertEquals(rec.getResource(), castedVal);
                break;
            }
            case "object": {
                EventType.ObjectEnum castedVal = (EventType.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

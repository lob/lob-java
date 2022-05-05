package Model;

import org.openapitools.client.model.CardEditable;
import org.openapitools.client.model.Card;

import org.testng.annotations.*;
import org.testng.Assert;

public class CardEditableTest {
    @DataProvider (name = "card-editable-data-provider")
    public Object[][] cardEditableDpMethod() {
        return new Object[][] {
            {"front", "fake front"},
            {"back", "fake back"},
            {"description", "fake description"},
            {"size", CardEditable.SizeEnum._3_375X2_125},
            {"size", CardEditable.SizeEnum._2_125X3_375},
        };
    }

    @Test(enabled=true, dataProvider = "card-editable-data-provider")
    public void cardEditableTestWithProvidedValue(String prop, Object val) throws Exception {
        CardEditable rec = new CardEditable();

        switch (prop) {
            case "front": {
                String castedVal = (String)val;
                rec.setFront(castedVal);
                Assert.assertEquals(rec.getFront(), castedVal);
                break;
            }
            case "back": {
                String castedVal = (String)val;
                rec.setBack(castedVal);
                Assert.assertEquals(rec.getBack(), castedVal);
                break;
            }
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "size": {
                CardEditable.SizeEnum castedVal = (CardEditable.SizeEnum)val;
                rec.setSize(castedVal);
                Assert.assertEquals(rec.getSize(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

package Model;

import com.lob.model.CardUpdatable;
import java.math.BigDecimal;

import org.testng.annotations.*;
import org.testng.Assert;

public class CardUpdatableTest {
    @DataProvider (name = "card-updatable-data-provider")
    public Object[][] cardUpdatableDpMethod() {
        return new Object[][] {
            {"description", "fake description"},
            {"auto_reorder", true},
            {"auto_reorder", false},
            {"reorder_quantity", new BigDecimal("1000")},
        };
    }

    @Test(enabled=true, dataProvider = "card-updatable-data-provider")
    public void cardUpdatableTestWithProvidedValue(String prop, Object val) throws Exception {
        CardUpdatable rec = new CardUpdatable();

        switch (prop) {
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "auto_reorder": {
                Boolean castedVal = (Boolean)val;
                rec.setAutoReorder(castedVal);
                Assert.assertEquals(rec.getAutoReorder(), castedVal);
                break;
            }
            case "reorder_quantity": {
                BigDecimal castedVal = (BigDecimal)val;
                rec.setReorderQuantity(castedVal);
                Assert.assertEquals(rec.getReorderQuantity(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

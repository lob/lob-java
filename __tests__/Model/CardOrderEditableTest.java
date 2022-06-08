package Model;

import com.lob.model.CardOrderEditable;

import org.testng.annotations.*;
import org.testng.Assert;

public class CardOrderEditableTest {
    @Test(enabled=true)
    public void cardOrderEditableTestWithProvidedValue() {
        CardOrderEditable rec = new CardOrderEditable();

        Integer testVal = 10;
        rec.setQuantity(testVal);
        Assert.assertEquals(rec.getQuantity(), testVal);
    }
}

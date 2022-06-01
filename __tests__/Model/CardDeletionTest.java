package Model;

import com.lob.model.CardDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class CardDeletionTest {
    @DataProvider (name = "card-deletion-data-provider")
    public Object[][] cardDeletionDpMethod(){
        return new Object[][] {
            {"id", "card_fakeId"},
            {"object", CardDeletion.ObjectEnum.CARD_DELETED},
            {"deleted", true},
            {"deleted", false},
        };
    }

    @Test(enabled=true, dataProvider = "card-deletion-data-provider")
    public void cardDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        CardDeletion rec = new CardDeletion();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "object": {
                CardDeletion.ObjectEnum castedVal = (CardDeletion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "deleted": {
                Boolean castedVal = (Boolean)val;
                rec.setDeleted(castedVal);
                Assert.assertEquals(rec.getDeleted(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void cardDeletionTestCatchesInvalidId() {
        CardDeletion rec = new CardDeletion();
        Assert.assertNull(rec.getId());

        String invalidValue = "Nope";
        try {
            rec.setId(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

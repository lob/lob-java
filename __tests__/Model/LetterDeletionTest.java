package Model;

import com.lob.model.LetterDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class LetterDeletionTest {
    @DataProvider (name = "letter-delete-data-provider")
    public Object[][] letterDeleteDpMethod(){
        return new Object[][] {
            {"id", "ltr_fakeId"},
            {"deleted", true},
            {"deleted", false},
            {"object", LetterDeletion.ObjectEnum.LETTER_DELETED},
        };
    }

    @Test(enabled=true, dataProvider="letter-delete-data-provider")
    public void letterDeleteTestWithProvidedValue(String prop, Object val) throws Exception {
        LetterDeletion rec = new LetterDeletion();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "deleted": {
                Boolean castedVal = (Boolean)val;
                rec.setDeleted(castedVal);
                Assert.assertEquals(rec.getDeleted(), castedVal);
                break;
            }
            case "object": {
                LetterDeletion.ObjectEnum castedVal = (LetterDeletion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void letterDeleteTestInvalidId() {
        LetterDeletion rec = new LetterDeletion();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

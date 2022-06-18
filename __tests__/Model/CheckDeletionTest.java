package Model;

import com.lob.model.CheckDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class CheckDeletionTest {
    @DataProvider (name = "check-deletion-data-provider")
    public Object[][] checkDeletionDpMethod(){
        return new Object[][] {
            {"id", "chk_fakeId"},
            {"deleted", true},
            {"deleted", false},
            {"object", CheckDeletion.ObjectEnum.CHECK_DELETED},
        };
    }

    @Test(enabled=true, dataProvider = "check-deletion-data-provider")
    public void checkDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        CheckDeletion rec = new CheckDeletion();

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
                CheckDeletion.ObjectEnum castedVal = (CheckDeletion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void checkDeletionTestCatchesInvalidId() {
        CheckDeletion rec = new CheckDeletion();
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

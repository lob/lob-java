package Model;

import com.lob.model.SelfMailerDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class SelfMailerDeletionTest {
    @DataProvider (name = "self-mailer-deletion-data-provider")
    public Object[][] selfMailerDeletionDpMethod(){
        return new Object[][] {
            {"id", "sfm_fakeId"},
            {"deleted", true},
            {"deleted", false},
            {"object", SelfMailerDeletion.ObjectEnum.SELF_MAILER_DELETED},
        };
    }

    @Test(enabled=true, dataProvider = "self-mailer-deletion-data-provider")
    public void selfMailerDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        SelfMailerDeletion rec = new SelfMailerDeletion();

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
                SelfMailerDeletion.ObjectEnum castedVal = (SelfMailerDeletion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void selfMailerDeletionTestInvalidId() {
        SelfMailerDeletion rec = new SelfMailerDeletion();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

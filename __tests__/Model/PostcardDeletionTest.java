package Model;

import org.openapitools.client.model.PostcardDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class PostcardDeletionTest {
    @DataProvider (name = "postcard-deletion-data-provider")
    public Object[][] postcardDeletionDpMethod(){
        return new Object[][] {
            {"id", "psc_fakeId"},
            {"deleted", true},
            {"deleted", false},
            {"object", PostcardDeletion.ObjectEnum.POSTCARD_DELETED},
        };
    }

    @Test(enabled=true, dataProvider="postcard-deletion-data-provider")
    public void postcardDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        PostcardDeletion rec = new PostcardDeletion();

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
                PostcardDeletion.ObjectEnum castedVal = (PostcardDeletion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void postcardDeletionTestCatchesInvalidId() {
        PostcardDeletion rec = new PostcardDeletion();
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

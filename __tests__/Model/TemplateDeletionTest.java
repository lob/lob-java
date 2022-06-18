package Model;

import com.lob.model.TemplateDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateDeletionTest {
    @DataProvider (name = "template-deletion-data-provider")
    public Object[][] templateDeletionDpMethod(){
        return new Object[][] {
            {"id", "tmpl_fakeId"},
            {"object", TemplateDeletion.ObjectEnum.TEMPLATE_DELETED},
            {"deleted", true},
            {"deleted", false},
        };
    }

    @Test(enabled=true, dataProvider = "template-deletion-data-provider")
    public void templateDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateDeletion rec = new TemplateDeletion();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "object": {
                TemplateDeletion.ObjectEnum castedVal = (TemplateDeletion.ObjectEnum)val;
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
    public void templateDeletionTestInvalidId() {
        TemplateDeletion rec = new TemplateDeletion();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

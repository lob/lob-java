package Model;

import com.lob.model.TemplateVersionDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateVersionDeletionTest {
    @DataProvider (name = "template-version-deletion-data-provider")
    public Object[][] templateVersionDeletionDpMethod(){
        return new Object[][] {
            {"id", "vrsn_fakeId"},
            {"object", TemplateVersionDeletion.ObjectEnum.TEMPLATE_VERSION_DELETED},
            {"deleted", true},
            {"deleted", false},
        };
    }

    @Test(enabled=true, dataProvider = "template-version-deletion-data-provider")
    public void templateVersionDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateVersionDeletion rec = new TemplateVersionDeletion();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "object": {
                TemplateVersionDeletion.ObjectEnum castedVal = (TemplateVersionDeletion.ObjectEnum)val;
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
    public void templateVersionDeletionTestInvalidId() {
        TemplateVersionDeletion rec = new TemplateVersionDeletion();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

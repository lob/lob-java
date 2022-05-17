package Model;

import org.openapitools.client.model.Template;
import org.openapitools.client.model.TemplateVersion;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.threeten.bp.OffsetDateTime;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateTest {
    @DataProvider (name = "template-data-provider")
    public Object[][] templateDpMethod(){
        List<TemplateVersion> templVersions = new ArrayList<TemplateVersion>();
        templVersions.add(new TemplateVersion());

        return new Object[][] {
            {"id", "tmpl_fakeId"},
            {"description", "fake description"},
            {"versions", templVersions},
            {"published_version", new TemplateVersion()},
            {"object", Template.ObjectEnum.TEMPLATE},
            {"metadata", new HashMap<String, String>()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
        };
    }

    @Test(enabled=true, dataProvider = "template-data-provider")
    public void templateTestWithProvidedValue(String prop, Object val) throws Exception {
        Template rec = new Template();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "versions": {
                List<TemplateVersion> castedVal = (ArrayList<TemplateVersion>)val;
                rec.setVersions(castedVal);
                // Assert.assertEquals(rec.getVersions(), castedVal); // TODO: DXP-920
                break;
            }
            case "published_version": {
                TemplateVersion castedVal = (TemplateVersion)val;
                rec.setPublishedVersion(castedVal);
                Assert.assertEquals(rec.getPublishedVersion(), castedVal);
                break;
            }
            case "object": {
                Template.ObjectEnum castedVal = (Template.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "metadata": {
                Map<String, String> castedVal = (HashMap<String, String>)val;
                rec.setMetadata(castedVal);
                // Assert.assertEquals(rec.getMetadata(), castedVal); // TODO: DXP-920
                break;
            }
            case "date_created": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateCreated(castedVal);
                Assert.assertEquals(rec.getDateCreated(), castedVal);
                break;
            }
            case "date_modified": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateModified(castedVal);
                Assert.assertEquals(rec.getDateModified(), castedVal);
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
    public void templateTestInvalidId() {
        Template rec = new Template();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

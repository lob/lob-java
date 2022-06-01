package Model;

import com.lob.model.TemplateVersion;
import com.lob.model.EngineHtml;

import org.threeten.bp.OffsetDateTime;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateVersionTest {
    @DataProvider (name = "template-version-data-provider")
    public Object[][] templateVersionDpMethod(){
        return new Object[][] {
            {"id", "vrsn_fakeId"},
            {"description", "fake description"},
            {"html", "fake html"},
            {"engine", EngineHtml.LEGACY},
            {"engine", EngineHtml.HANDLEBARS},
            {"engine", null},
            {"suggest_json_editor", true},
            {"suggest_json_editor", false},
            {"merge_variables", new Object()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
            {"object", TemplateVersion.ObjectEnum.VERSION},
        };
    }

    @Test(enabled=true, dataProvider = "template-version-data-provider")
    public void templateVersionTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateVersion rec = new TemplateVersion();

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
            case "html": {
                String castedVal = (String)val;
                rec.setHtml(castedVal);
                Assert.assertEquals(rec.getHtml(), castedVal);
                break;
            }
            case "engine": {
                EngineHtml castedVal = (EngineHtml)val;
                rec.setEngine(castedVal);
                Assert.assertEquals(rec.getEngine(), castedVal);
                break;
            }
            case "suggest_json_editor": {
                Boolean castedVal = (Boolean)val;
                rec.setSuggestJsonEditor(castedVal);
                Assert.assertEquals(rec.getSuggestJsonEditor(), castedVal);
                break;
            }
            case "merge_variables": {
                Object castedVal = (Object)val;
                rec.setMergeVariables(castedVal);
                Assert.assertEquals(rec.getMergeVariables(), castedVal);
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
            case "object": {
                TemplateVersion.ObjectEnum castedVal = (TemplateVersion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void templateVersionTestInvalidId() {
        TemplateVersion rec = new TemplateVersion();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

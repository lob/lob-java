package Model;

import com.lob.model.TemplateVersionWritable;

import com.lob.model.EngineHtml;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateVersionWritableTest {
    @DataProvider (name = "template-version-writable-data-provider")
    public Object[][] templateVersionWritableDpMethod(){
        return new Object[][] {
            {"description", "fake description"},
            {"html", "fake html"},
            {"engine", EngineHtml.LEGACY},
            {"engine", EngineHtml.HANDLEBARS},
            {"engine", null},
        };
    }

    @Test(enabled=true, dataProvider = "template-version-writable-data-provider")
    public void templateVersionWritableTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateVersionWritable rec = new TemplateVersionWritable();

        switch (prop) {
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
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

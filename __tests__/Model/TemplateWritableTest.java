package Model;

import org.openapitools.client.model.TemplateWritable;
import org.openapitools.client.model.EngineHtml;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateWritableTest {
    @DataProvider (name = "template-writable-data-provider")
    public Object[][] templateWritableDpMethod(){
        return new Object[][] {
            {"description", "fake description"},
            {"html", "fake html"},
            {"metadata", new HashMap<String, String>()},
            {"engine", EngineHtml.LEGACY},
            {"engine", EngineHtml.HANDLEBARS},
            {"engine", null},
        };
    }

    @Test(enabled=true, dataProvider = "template-writable-data-provider")
    public void templateWritableTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateWritable rec = new TemplateWritable();

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
            case "metadata": {
                @SuppressWarnings("unchecked")
                Map<String, String> castedVal = (HashMap<String, String>)val;
                rec.setMetadata(castedVal);
                Assert.assertEquals(rec.getMetadata(), castedVal); // TODO: DXP-920
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

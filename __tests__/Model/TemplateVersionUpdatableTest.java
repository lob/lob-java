package Model;

import com.lob.model.TemplateVersionUpdatable;
import com.lob.model.EngineHtml;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateVersionUpdatableTest {
    @DataProvider (name = "template-version-updatable-data-provider")
    public Object[][] templateVersionUpdatableDpMethod(){
        return new Object[][] {
            {"description", "fake description"},
            {"engine", EngineHtml.LEGACY},
            {"engine", EngineHtml.HANDLEBARS},
            {"engine", null},
        };
    }

    @Test(enabled=true, dataProvider = "template-version-updatable-data-provider")
    public void templateVersionUpdatableTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateVersionUpdatable rec = new TemplateVersionUpdatable();

        switch (prop) {
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
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

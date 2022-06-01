package Model;

import com.lob.model.Suggestions;

import org.testng.annotations.*;
import org.testng.Assert;

public class SuggestionsTest {
    @DataProvider (name = "suggestions-data-provider")
    public Object[][] suggestionsDpMethod(){
        return new Object[][] {
            {"primary_line", ""},
            {"city", ""},
            {"state", ""},
            {"zip_code", "11111"},
            {"object", Suggestions.ObjectEnum.US_AUTOCOMPLETION},
        };
    }

    @Test(enabled=true, dataProvider = "suggestions-data-provider")
    public void suggestionsTestWithProvidedValue(String prop, Object val) {
        Suggestions rec = new Suggestions();

        if (prop == "object") {
            Suggestions.ObjectEnum castedVal = (Suggestions.ObjectEnum)val;
            rec.setObject(castedVal);
            Assert.assertEquals(rec.getObject(), castedVal);
        } else {
            String castedVal = (String)val;
            switch (prop) {
                case "primary_line":
                    rec.setPrimaryLine(castedVal);
                    Assert.assertEquals(rec.getPrimaryLine(), castedVal);
                    break;
                case "city":
                    rec.setCity(castedVal);
                    Assert.assertEquals(rec.getCity(), castedVal);
                    break;
                case "state":
                    rec.setState(castedVal);
                    Assert.assertEquals(rec.getState(), castedVal);
                    break;
                case "zip_code":
                    rec.setZipCode(castedVal);
                    Assert.assertEquals(rec.getZipCode(), castedVal);
                    break;
                default:
            }
        }
    }
}

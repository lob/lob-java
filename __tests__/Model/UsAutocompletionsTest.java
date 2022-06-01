package Model;

import com.lob.model.UsAutocompletions;
import com.lob.model.Suggestions;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class UsAutocompletionsTest {
    @DataProvider (name = "us-autocompletions-data-provider")
    public Object[][] usAutocompletionsDpMethod(){
        List<Suggestions> suggestionsList = new ArrayList<Suggestions>();
        suggestionsList.add(new Suggestions());

        return new Object[][] {
            {"id", "us_auto_fakeId"},
            {"suggestions", suggestionsList},
            {"object", UsAutocompletions.ObjectEnum.US_AUTOCOMPLETION},
        };
    }

    @Test(enabled=true, dataProvider = "us-autocompletions-data-provider")
    public void usAutocompletionsTestWithProvidedValue(String prop, Object val) throws Exception {
        UsAutocompletions rec = new UsAutocompletions();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "suggestions": {
                List<Suggestions> castedVal = (ArrayList<Suggestions>)val;
                rec.setSuggestions(castedVal);
                Assert.assertEquals(rec.getSuggestions(), castedVal);
                break;
            }
            case "object": {
                UsAutocompletions.ObjectEnum castedVal = (UsAutocompletions.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void usAutoCompletionsTestInvalidId() {
        UsAutocompletions rec = new UsAutocompletions();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

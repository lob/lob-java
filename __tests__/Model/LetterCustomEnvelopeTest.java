package Model;

import com.lob.model.LetterCustomEnvelope;
import org.testng.annotations.Test;

import org.testng.annotations.*;
import org.testng.Assert;

public class LetterCustomEnvelopeTest {
    @DataProvider (name = "letter-custom-envelope-data-provider")
    public Object[][] letterCustomEnvelopeDpMethod(){
        return new Object[][] {
            {"id", "fake id"},
            {"url", "fake url"},
            {"object", LetterCustomEnvelope.ObjectEnum.ENVELOPE},
        };
    }

    @Test(enabled=true, dataProvider="letter-custom-envelope-data-provider")
    public void letterCustomEnvelopeTestWithProvidedValue(String prop, Object val) throws Exception {
        LetterCustomEnvelope rec = new LetterCustomEnvelope();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "url": {
                String castedVal = (String)val;
                rec.setUrl(castedVal);
                Assert.assertEquals(rec.getUrl(), castedVal);
                break;
            }
            case "object": {
                LetterCustomEnvelope.ObjectEnum castedVal = (LetterCustomEnvelope.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }
}

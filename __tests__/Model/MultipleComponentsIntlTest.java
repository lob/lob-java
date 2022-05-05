package Model;

import org.openapitools.client.model.MultipleComponentsIntl;
import org.openapitools.client.model.CountryExtended;

import org.testng.annotations.*;
import org.testng.Assert;

public class MultipleComponentsIntlTest {
    @DataProvider (name = "multiple-components-intl-data-provider")
    public Object[][] multipleComponentsIntlDpMethod(){
        return new Object[][] {
            {"recipient", "fake recipient"},
            {"recipient", null},
            {"primary_line", "fake primary_line"},
            {"secondary_line", "fake secondary_line"},
            {"city", "fake city"},
            {"state", "fake state"},
            {"postal_code", "fake postal_code"},
            {"country", CountryExtended.AD},
        };
    }

    @Test(enabled=true, dataProvider = "multiple-components-intl-data-provider")
    public void multipleComponentsIntlTestWithProvidedValue(String prop, Object val) throws Exception {
        MultipleComponentsIntl rec = new MultipleComponentsIntl();

        if (prop == "country") {
            CountryExtended castedVal = (CountryExtended)val;
            rec.setCountry(castedVal);
            Assert.assertEquals(rec.getCountry(), castedVal);
            return;
        }

        String castedVal = (String)val;
        switch (prop) {
            case "recipient": {
                rec.setRecipient(castedVal);
                Assert.assertEquals(rec.getRecipient(), castedVal);
                break;
            }
            case "primary_line": {
                rec.setPrimaryLine(castedVal);
                Assert.assertEquals(rec.getPrimaryLine(), castedVal);
                break;
            }
            case "secondary_line": {
                rec.setSecondaryLine(castedVal);
                Assert.assertEquals(rec.getSecondaryLine(), castedVal);
                break;
            }
            case "city": {
                rec.setCity(castedVal);
                Assert.assertEquals(rec.getCity(), castedVal);
                break;
            }
            case "state": {
                rec.setState(castedVal);
                Assert.assertEquals(rec.getState(), castedVal);
                break;
            }
            case "postal_code": {
                rec.setPostalCode(castedVal);
                Assert.assertEquals(rec.getPostalCode(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }
}

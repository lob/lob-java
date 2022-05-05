package Model;

import org.openapitools.client.model.IntlVerificationWritable;
import org.openapitools.client.model.CountryExtended;

import org.testng.annotations.*;
import org.testng.Assert;

public class IntlVerificationWritableTest {
    @DataProvider (name = "intl-verification-writable-data-provider")
    public Object[][] intlVerificationWritableDpMethod(){
        return new Object[][] {
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary"},
            {"secondary_line", "fake secondary"},
            {"country", CountryExtended.AD},
            {"city", "fake city"},
            {"state", "fake state"},
            {"postal_code", "fake postal_code"},
            {"address", "fake address"},
        };
    }

    @Test(enabled=true, dataProvider = "intl-verification-writable-data-provider")
    public void intlVerificationWritableTestWithProvidedValue(String prop, Object val) throws Exception {
        IntlVerificationWritable rec = new IntlVerificationWritable();

        if (prop == "country") {
            CountryExtended country = (CountryExtended)val;
            rec.setCountry(country);
            Assert.assertEquals(rec.getCountry(), country);
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
            case "address": {
                rec.setAddress(castedVal);
                Assert.assertEquals(rec.getAddress(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }
}

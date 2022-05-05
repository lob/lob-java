package Model;

import org.openapitools.client.model.IntlComponents;

import org.testng.annotations.*;
import org.testng.Assert;

public class IntlComponentsTest {
    @DataProvider (name = "intl-components-data-provider")
    public Object[][] intlComponentsDpMethod(){
        return new Object[][] {
            {"primary_number", "fake primary number"},
            {"street_name", "fake street"},
            {"city", "fake city"},
            {"state", "fake state"},
            {"postal_code", "fake postal"},
        };
    }

    @Test(enabled=true, dataProvider = "intl-components-data-provider")
    public void intlComponentsTestWithProvidedValue(String prop, String val) throws Exception {
        IntlComponents rec = new IntlComponents();

        switch (prop) {
            case "primary_number": {
                rec.setPrimaryNumber(val);
                Assert.assertEquals(rec.getPrimaryNumber(), val);
                break;
            }
            case "street_name": {
                rec.setStreetName(val);
                Assert.assertEquals(rec.getStreetName(), val);
                break;
            }
            case "city": {
                rec.setCity(val);
                Assert.assertEquals(rec.getCity(), val);
                break;
            }
            case "state": {
                rec.setState(val);
                Assert.assertEquals(rec.getState(), val);
                break;
            }
            case "postal_code": {
                rec.setPostalCode(val);
                Assert.assertEquals(rec.getPostalCode(), val);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }
}

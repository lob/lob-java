package Model;

import com.lob.model.MultipleComponents;

import org.testng.annotations.*;
import org.testng.Assert;

public class MultipleComponentsTest {
    @DataProvider (name = "multiple-components-data-provider")
    public Object[][] multipleComponentsDpMethod(){
        return new Object[][] {
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary_line"},
            {"secondary_line", "fake secondary_line"},
            {"urbanization", "fake urbanization"},
            {"city", "fake city"},
            {"state", "fake state"},
            {"zip_code", "11111"},
        };
    }

    @Test(enabled=true, dataProvider = "multiple-components-data-provider")
    public void multipleComponentsTestWithProvidedValue(String prop, String val) throws Exception {
        MultipleComponents rec = new MultipleComponents();

        switch (prop) {
            case "recipient": {
                rec.setRecipient(val);
                Assert.assertEquals(rec.getRecipient(), val);
                break;
            }
            case "primary_line": {
                rec.setPrimaryLine(val);
                Assert.assertEquals(rec.getPrimaryLine(), val);
                break;
            }
            case "secondary_line": {
                rec.setSecondaryLine(val);
                Assert.assertEquals(rec.getSecondaryLine(), val);
                break;
            }
            case "urbanization": {
                rec.setUrbanization(val);
                Assert.assertEquals(rec.getUrbanization(), val);
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
            case "zip_code": {
                rec.setZipCode(val);
                Assert.assertEquals(rec.getZipCode(), val);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void multipleComponentsTestCatchesException() {
        MultipleComponents rec = new MultipleComponents();
        Assert.assertNull(rec.getZipCode());

        try {
            rec.setZipCode("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code provided");
        }
    }
}

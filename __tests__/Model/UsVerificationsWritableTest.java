package Model;

import com.lob.model.UsVerificationsWritable;

import org.testng.annotations.*;
import org.testng.Assert;

public class UsVerificationsWritableTest {
    @DataProvider (name = "us-verifications-writable-data-provider")
    public Object[][] usVerificationsWritableDpMethod(){
        return new Object[][] {
            {"address", "fake address"},
            {"recipient", "fake recipient"},
            {"primary_line", "fake primary"},
            {"secondary_line", "fake secondary"},
            {"urbanization", "fake urbanization"},
            {"city", "fake city"},
            {"state", "fake state"},
            {"zip_code", "78725"},
        };
    }

    @Test(enabled=true, dataProvider = "us-verifications-writable-data-provider")
    public void usVerificationsWritableTestWithProvidedValue(String prop, String val) {
        UsVerificationsWritable rec = new UsVerificationsWritable();

        switch (prop) {
            case "address":
                rec.setAddress(val);
                Assert.assertEquals(rec.getAddress(), val);
                break;
            case "recipient":
                rec.setRecipient(val);
                Assert.assertEquals(rec.getRecipient(), val);
                break;
            case "primary_line":
                rec.setPrimaryLine(val);
                Assert.assertEquals(rec.getPrimaryLine(), val);
                break;
            case "secondary_line":
                rec.setSecondaryLine(val);
                Assert.assertEquals(rec.getSecondaryLine(), val);
                break;
            case "urbanization":
                rec.setUrbanization(val);
                Assert.assertEquals(rec.getUrbanization(), val);
                break;
            case "city":
                rec.setCity(val);
                Assert.assertEquals(rec.getCity(), val);
                break;
            case "state":
                rec.setState(val);
                Assert.assertEquals(rec.getState(), val);
                break;
            case "zip_code":
                rec.setZipCode(val);
                Assert.assertEquals(rec.getZipCode(), val);
                break;
            default:
        }
    }

    @Test(enabled=true)
    public void usVerificationsWritableTestCatchesException() {
        UsVerificationsWritable rec = new UsVerificationsWritable();
        Assert.assertNull(rec.getZipCode());

        try {
            rec.setZipCode("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code provided");
        }
    }
}

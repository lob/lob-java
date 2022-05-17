package Model;

import org.openapitools.client.model.ZipEditable;

import org.testng.annotations.*;
import org.testng.Assert;

public class ZipEditableTest {
    @Test(enabled=true)
    public void zipEditableTestWithProvidedValue() {
        ZipEditable rec = new ZipEditable();

        String zipCode = "11111";
        rec.setZipCode(zipCode);
        Assert.assertEquals(rec.getZipCode(), zipCode);
    }

    @Test(enabled=true)
    public void zipEditableTestInvalidZipCode() {
        ZipEditable rec = new ZipEditable();
        Assert.assertNull(rec.getZipCode());

        try {
            rec.setZipCode("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code provided");
        }
    }
}

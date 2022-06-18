package Model;

import com.lob.model.GeocodeComponents;

import org.testng.annotations.*;
import org.testng.Assert;

public class GeocodeComponentsTest {
    @Test(enabled=true)
    public void geocodeComponentsCreateTest() {
        GeocodeComponents rec1 = new GeocodeComponents();
        String zipCode = "11111";
        rec1.setZipCode(zipCode);
        Assert.assertEquals(rec1.getZipCode(), zipCode);

        GeocodeComponents rec2 = new GeocodeComponents();
        String zipCodePlus4 = "1111";
        rec2.setZipCodePlus4(zipCodePlus4);
        Assert.assertEquals(rec2.getZipCodePlus4(), zipCodePlus4);
    }

    @Test(enabled=true)
    public void geocodeComponentsTestInvalidZipCode() {
        GeocodeComponents rec = new GeocodeComponents();
        Assert.assertNull(rec.getZipCode());

        try {
            rec.setZipCode("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code provided");
        }
    }

    @Test(enabled=true)
    public void geocodeComponentsTestInvalidZipCodePlus4() {
        GeocodeComponents rec = new GeocodeComponents();
        Assert.assertNull(rec.getZipCodePlus4());

        try {
            rec.setZipCodePlus4("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code_plus_4 provided");
        }
    }
}

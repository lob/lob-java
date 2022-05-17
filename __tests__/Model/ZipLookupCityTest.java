package Model;

import org.openapitools.client.model.ZipLookupCity;

import org.testng.annotations.*;
import org.testng.Assert;

public class ZipLookupCityTest {
    @DataProvider (name = "zip-lookup-city-data-provider")
    public Object[][] zipLookupCityDpMethod(){
        return new Object[][] {
            {"city", "fake city"},
            {"state", "fake state"},
            {"county", "fake country"},
            {"county_fips", "11111"},
            {"preferred", true},
            {"preferred", false},
        };
    }

    @Test(enabled=true, dataProvider = "zip-lookup-city-data-provider")
    public void zipLookupCityTestWithProvidedValue(String prop, Object val) throws Exception {
        ZipLookupCity rec = new ZipLookupCity();

        if (prop == "preferred") {
            Boolean castedVal = (Boolean)val;
            rec.setPreferred(castedVal);
            Assert.assertEquals(rec.getPreferred(), castedVal);
        } else {
            String castedVal = (String)val;
            switch (prop) {
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
            case "county": {
                rec.setCounty(castedVal);
                Assert.assertEquals(rec.getCounty(), castedVal);
                break;
            }
            case "county_fips": {
                rec.setCountyFips(castedVal);
                Assert.assertEquals(rec.getCountyFips(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
            }
        }
    }

    @Test(enabled=true)
    public void zipLookupCityTestInvalidCountyFips() {
        ZipLookupCity rec = new ZipLookupCity();
        Assert.assertNull(rec.getCountyFips());

        try {
            rec.setCountyFips("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid county_fips provided");
        }
    }
}

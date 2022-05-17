package Model;

import org.openapitools.client.model.UsAutocompletionsWritable;

import org.testng.annotations.*;
import org.testng.Assert;

public class UsAutocompletionsWritableTest {
    @DataProvider (name = "us-autocompletions-writable-data-provider")
    public Object[][] usAutoCompletionsWritableDpMethod(){
        return new Object[][] {
            {"address_prefix", "fake prefix"},
            {"city", "fake city"},
            {"state", "fake state"},
            {"zip_code", "fake zip"},
            {"geo_ip_sort", true},
            {"geo_ip_sort", false},
        };
    }

    @Test(enabled=true, dataProvider = "us-autocompletions-writable-data-provider")
    public void usAutoCompletionsWritableTestWithProvidedValue(String prop, Object val) throws Exception {
        UsAutocompletionsWritable rec = new UsAutocompletionsWritable();

        switch (prop) {
            case "address_prefix": {
                String castedVal = (String)val;
                rec.setAddressPrefix(castedVal);
                Assert.assertEquals(rec.getAddressPrefix(), castedVal);
                break;
            }
            case "city": {
                String castedVal = (String)val;
                rec.setCity(castedVal);
                Assert.assertEquals(rec.getCity(), castedVal);
                break;
            }
            case "state": {
                String castedVal = (String)val;
                rec.setState(castedVal);
                Assert.assertEquals(rec.getState(), castedVal);
                break;
            }
            case "zip_code": {
                String castedVal = (String)val;
                rec.setZipCode(castedVal);
                Assert.assertEquals(rec.getZipCode(), castedVal);
                break;
            }
            case "geo_ip_sort": {
                Boolean castedVal = (Boolean)val;
                rec.setGeoIpSort(castedVal);
                Assert.assertEquals(rec.getGeoIpSort(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

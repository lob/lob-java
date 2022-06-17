package Model;

import com.lob.model.ReverseGeocode;
import com.lob.model.GeocodeAddresses;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class ReverseGeocodeTest {
    @DataProvider (name = "reverse-geocode-data-provider")
    public Object[][] reverseGeocodeDpMethod(){
        List<GeocodeAddresses> geocodeAddrs = new ArrayList<GeocodeAddresses>();
        geocodeAddrs.add(new GeocodeAddresses());

        return new Object[][] {
            {"id", "us_reverse_geocode_fakeId"},
            {"addresses", geocodeAddrs},
            {"object", ReverseGeocode.ObjectEnum.US_REVERSE_GEOCODE_LOOKUP},
        };
    }

    @Test(enabled=true, dataProvider = "reverse-geocode-data-provider")
    public void reverseGeocodeTestWithProvidedValue(String prop, Object val) throws Exception {
        ReverseGeocode rec = new ReverseGeocode();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "addresses": {
                List<GeocodeAddresses> castedVal = (ArrayList<GeocodeAddresses>)val;
                rec.setAddresses(castedVal);
                Assert.assertEquals(rec.getAddresses(), castedVal);
                break;
            }
            case "object": {
                ReverseGeocode.ObjectEnum castedVal = (ReverseGeocode.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void reverseGeocodeTestInvalidId() {
        ReverseGeocode rec = new ReverseGeocode();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

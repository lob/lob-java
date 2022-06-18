package Model;

import com.lob.model.GeocodeAddresses;
import com.lob.model.GeocodeComponents;
import com.lob.model.LocationAnalysis;

import org.testng.annotations.*;
import org.testng.Assert;

public class GeocodeAddressesTest {
    GeocodeAddresses rec;
    @BeforeTest
    public void before_test()
    {
        rec = new GeocodeAddresses();
    }

    @Test(enabled=true)
    public void geocodeAddressesCreateTestWithGeocodeComponent() {
        GeocodeComponents geoComp = new GeocodeComponents();
        rec.setComponents(geoComp);
        Assert.assertEquals(rec.getComponents(), geoComp);
    }

    @Test(enabled=true)
    public void geocodeAddressesCreateTestWithLocationAnalysis() {
        LocationAnalysis locAnalysis = new LocationAnalysis();
        rec.setLocationAnalysis(locAnalysis);
        Assert.assertEquals(rec.getLocationAnalysis(), locAnalysis);
    }
}

package Model;

import com.lob.model.Location;

import org.testng.annotations.*;
import org.testng.Assert;

public class LocationTest {
    @Test(enabled=true)
    public void locationCreateTest() {
        Location rec1 = new Location();
        Float latitudeOrLongitude = 1f;
        rec1.setLatitude(latitudeOrLongitude);
        Assert.assertEquals(rec1.getLatitude(), latitudeOrLongitude);

        Location rec2 = new Location();
        rec1.setLongitude(latitudeOrLongitude);
        Assert.assertEquals(rec1.getLongitude(), latitudeOrLongitude);
    }
}

package Model;

import com.lob.model.LocationAnalysis;

import org.testng.annotations.*;
import org.testng.Assert;

public class LocationAnalysisTest {
    @DataProvider (name = "location-analysis-data-provider")
    public Object[][] locationAnalysisDpMethod(){
        return new Object[][] {
            {"latitude", 1f},
            {"longitude", 2f},
            {"distance", 3f},
        };
    }

    @Test(enabled=true, dataProvider = "location-analysis-data-provider")
    public void locationAnalysisTestWithProvidedValue(String prop, Float val) throws Exception {
        LocationAnalysis rec = new LocationAnalysis();

        switch (prop) {
            case "latitude": {
                rec.setLatitude(val);
                Assert.assertEquals(rec.getLatitude(), val);
                break;
            }
            case "longitude": {
                rec.setLongitude(val);
                Assert.assertEquals(rec.getLongitude(), val);
                break;
            }
            case "distance": {
                rec.setDistance(val);
                Assert.assertEquals(rec.getDistance(), val);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

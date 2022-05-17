package Integration;

import org.openapitools.client.model.Location;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.ReverseGeocodeLookupsApi;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReverseGeoCodeApiSpecTest {
    private ReverseGeocodeLookupsApi validApi;
   
@BeforeClass

public void before_class()
    {
        validApi = new ReverseGeocodeLookupsApi(Configuration.getConfigForIntegration());
    }
    
    @Test(
        enabled=true,
        groups={"Integration", "Reverse Geocode", "Valid"}
    )
    public void ReverseGeoCodeTest() throws ApiException {
        validApi = new ReverseGeocodeLookupsApi(Configuration.getConfigForIntegration());

        Assert.assertNotNull(validApi);
    }

    @Test(
        enabled=true,
        groups={"Integration", "Lookup", "Reverse Geocode"}
    )

    public void  ReverseGeoCodeLookupTest() throws ApiException {
        validApi = new ReverseGeocodeLookupsApi(Configuration.getConfigForIntegration());
        Location location = new Location();
        Float latitude=37.777456f;
        Float longitude=-122.393039f;

        location.setLatitude(latitude);
        location.setLongitude(longitude);

        Assert.assertNotNull(validApi.lookup(location,1));
    }

    @Test(
        enabled=true,
        groups={"Integration", "Lookup", "Reverse Geocode"}
    )

        public void  ReverseGeoCodeLookupInputTest() throws ApiException {
            validApi = new ReverseGeocodeLookupsApi(Configuration.getConfigForIntegration());
            Location location = new Location();
            Float latitude=37.777456f;
            Float longitude=-122.393039f;
           
            location.setLatitude(latitude);
            location.setLongitude(longitude);

            //Assert.assertNotNull(response.getAddresses);
            // Need Get Addresses method
    }


}
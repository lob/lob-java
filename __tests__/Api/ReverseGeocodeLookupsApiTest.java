package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lob.api.ApiException;
import com.lob.api.client.ReverseGeocodeLookupsApi;

import org.openapitools.client.model.Location;
import org.openapitools.client.model.ReverseGeocode;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "Reverse GeoCode"})
public class ReverseGeocodeLookupsApiTest {
    @Test(enabled=true, groups={"Unit", "Lookup", "Reverse Geocode", "Valid"})
    public void reverseGeocodeLookupTest() throws ApiException {
        ReverseGeocodeLookupsApi reverseGeocodeLookupApiMock = mock(ReverseGeocodeLookupsApi.class);
        ReverseGeocode reverseGeocode = new ReverseGeocode();
        Location location = new Location();

        reverseGeocode.setId("us_reverse_geocode_reverse_geocode_fakeId");

        when(reverseGeocodeLookupApiMock.reverseGeocodeLookup(location, 2)).thenReturn(reverseGeocode);
        ReverseGeocode response = reverseGeocodeLookupApiMock.reverseGeocodeLookup(location, 2);

        Assert.assertEquals(reverseGeocode.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Lookup", "Reverse Geocode", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void reverseGeocodeLookupTestCatchesException() throws ApiException {
        ReverseGeocodeLookupsApi reverseGeocodeLookupApiMock = mock(ReverseGeocodeLookupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(reverseGeocodeLookupApiMock.reverseGeocodeLookup(null, null)).thenThrow(error);
        reverseGeocodeLookupApiMock.reverseGeocodeLookup(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Lookup", "Reverse Geocode", "Invalid"}, expectedExceptions = {ApiException.class})
    public void reverseGeocodeLookupTestCatchesExceptionWithResponseBody () throws ApiException {
        ReverseGeocodeLookupsApi reverseGeocodeLookupApiMock = mock(ReverseGeocodeLookupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(reverseGeocodeLookupApiMock.reverseGeocodeLookup(null, null)).thenThrow(error);

        reverseGeocodeLookupApiMock.reverseGeocodeLookup(null, null);

        Assert.fail("This should not happen");   
    }   
    
}

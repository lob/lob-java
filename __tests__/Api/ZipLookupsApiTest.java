package Api;

import com.lob.api.ApiException;
import com.lob.api.client.ZipLookupsApi;

import com.lob.model.Zip;
import com.lob.model.ZipEditable;

import org.testng.annotations.*;
import org.testng.Assert;
import static org.mockito.Mockito.*;

@Test(enabled=true,  groups={"Unit", "Atlas", "Zip Lookup"})
public class ZipLookupsApiTest {
    private final ZipEditable zipEditable = new ZipEditable();
    public ZipLookupsApiTest() {
        zipEditable.setZipCode("07090");
    }

    @Test(enabled=true, groups={"Unit", "Lookup", "Zip", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void zipLookupTestCatchesException() throws ApiException {
        ZipLookupsApi zipLookupsApiMock = mock(ZipLookupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(zipLookupsApiMock.lookup(zipEditable)).thenThrow(error);
        zipLookupsApiMock.lookup(zipEditable);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Lookup", "Zip", "Invalid"}, expectedExceptions = {ApiException.class})
    public void zipLookupTestCatchesExceptionWithResponseBody () throws ApiException {
        ZipLookupsApi zipLookupsApiMock = mock(ZipLookupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");

        when(zipLookupsApiMock.lookup(zipEditable)).thenThrow(error);
        zipLookupsApiMock.lookup(zipEditable);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Lookup", "Zip", "Valid"})
    public void zipLookupIntlAddrTest () throws ApiException {
        ZipLookupsApi zipLookupsApiMock = mock(ZipLookupsApi.class);
        Zip fakeZip = new Zip();

        fakeZip.setId("us_zip_fakeId");

        when(zipLookupsApiMock.lookup(zipEditable)).thenReturn(fakeZip);
        Zip response = zipLookupsApiMock.lookup(zipEditable);

        Assert.assertEquals(fakeZip.getId(), response.getId());
    }
}

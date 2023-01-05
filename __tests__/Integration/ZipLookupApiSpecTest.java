package Integration;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.ZipLookupsApi;

import com.lob.model.Zip;
import com.lob.model.ZipEditable;

import org.testng.Assert;
import org.testng.annotations.Test;



public class ZipLookupApiSpecTest {
    private ZipLookupsApi validApi = new ZipLookupsApi(Configuration.getConfigForLiveIntegration());

    @Test(
        enabled=true,
        groups={"Integration", "Lookup", "ZipLookup", "Valid"}
    )
    public void lookupTest() throws ApiException {
        ZipEditable lookupInput = new ZipEditable();
        lookupInput.setZipCode("94107");

        Zip response = validApi.lookup(lookupInput);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getId().contains("us_zip"));
    }


    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*invalid zip code.*",
        groups={"Integration", "Lookup", "ZipLookup", "Invalid"}
    )
    public void lookupTestBadParameter() throws ApiException {
        ZipEditable lookupInput = new ZipEditable();
        lookupInput.setZipCode("00000");

        Zip response = validApi.lookup(lookupInput);
    }
}

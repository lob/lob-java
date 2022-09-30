package Integration;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.IdentityValidationApi;

import com.lob.model.IdentityValidation;
import com.lob.model.MultiLineAddress;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IdentityValidationApiSpecTest {
    private IdentityValidationApi validApi = new IdentityValidationApi(Configuration.getConfigForLiveIntegration());

    @Test(
        enabled=true,
        groups={"Integration", "Validate", "IdentityValidation", "Valid"}
    )
    public void validationTestWithCityState() throws ApiException {
        MultiLineAddress cityStateMultiLineAddress = new MultiLineAddress();
        cityStateMultiLineAddress.setRecipient("Lob.com");
        cityStateMultiLineAddress.setPrimaryLine("210 King St");
        cityStateMultiLineAddress.setCity("San Francisco");
        cityStateMultiLineAddress.setState("CA");

        IdentityValidation response = validApi.validate(cityStateMultiLineAddress);
        Assert.assertNotNull(response.getId());
    }

    @Test(
        enabled=true,
        groups={"Integration", "Validate", "IdentityValidation", "Valid"}
    )
    public void validationTestWithZipCode() throws ApiException {
        MultiLineAddress zipCodeMultiLineAddress = new MultiLineAddress();
        zipCodeMultiLineAddress.setRecipient("Lob.com");
        zipCodeMultiLineAddress.setPrimaryLine("210 King St");
        zipCodeMultiLineAddress.setZipCode("94107");

        IdentityValidation response = validApi.validate(zipCodeMultiLineAddress);
        Assert.assertNotNull(response.getId());
    }

    @Test(
        enabled=true,
        groups={"Integration", "Validate", "IdentityValidation", "Valid"}
    )
    public void validationTestWithTestKey() throws ApiException {
        MultiLineAddress cityStateMultiLineAddress = new MultiLineAddress();
        cityStateMultiLineAddress.setRecipient("Lob.com");
        cityStateMultiLineAddress.setPrimaryLine("210 King St");
        cityStateMultiLineAddress.setCity("San Francisco");
        cityStateMultiLineAddress.setState("CA");

        IdentityValidationApi api = new IdentityValidationApi(Configuration.getConfigForIntegration());
        IdentityValidation response = api.validate(cityStateMultiLineAddress);
        Assert.assertEquals(response.getRecipient(), "TEST KEYS DO NOT VERIFY ADDRESSES");
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*recipient is required.*",
        groups={"Integration", "Validate", "IdentityValidation", "Invalid"}
    )
    public void validationTestBadParameter() throws ApiException {
        MultiLineAddress invalidAddress = new MultiLineAddress();
        invalidAddress.setPrimaryLine("210 King St");
        invalidAddress.setZipCode("94107");
        IdentityValidation response = validApi.validate(invalidAddress);
    }
}

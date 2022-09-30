package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lob.api.ApiException;
import com.lob.api.client.IdentityValidationApi;

import com.lob.model.IdentityValidation;
import com.lob.model.MultiLineAddress;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "Atlas", "Identity Validation"})
public class IdentityValidationApiTest {
    @Test(enabled=true, groups={"Unit", "Identity Validation", "Valid"})
    public void validationTest() throws ApiException {
        IdentityValidationApi identityValidationApiMock = mock(IdentityValidationApi.class);
        IdentityValidation fakeIdentityValidation = new IdentityValidation();
        MultiLineAddress multilineAddress = new MultiLineAddress();

        fakeIdentityValidation.setId("id_validation_fakeId");

        when(identityValidationApiMock.validate(multilineAddress)).thenReturn(fakeIdentityValidation);
        IdentityValidation response = identityValidationApiMock.validate(multilineAddress);

        Assert.assertEquals(fakeIdentityValidation.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Identity Validation", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void validationTestCatchesException() throws ApiException {
        IdentityValidationApi identityValidationApiMock = mock(IdentityValidationApi.class);
        ApiException error = new ApiException("error reported by API");

        when(identityValidationApiMock.validate(null)).thenThrow(error);
        identityValidationApiMock.validate(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Identity Validation", "Invalid"}, expectedExceptions = {ApiException.class})
    public void validationTestCatchesExceptionWithResponseBody () throws ApiException {
        IdentityValidationApi identityValidationApiMock = mock(IdentityValidationApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(identityValidationApiMock.validate(null)).thenThrow(error);

        identityValidationApiMock.validate(null);

        Assert.fail("This should not happen");
    }
}

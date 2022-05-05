package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.client.IntlVerificationsApi;

import org.openapitools.client.model.IntlVerification;
import org.openapitools.client.model.IntlVerificationOrError;
import org.openapitools.client.model.IntlVerificationWritable;
import org.openapitools.client.model.IntlVerifications;
import org.openapitools.client.model.IntlVerificationsPayload;
import org.openapitools.client.model.MultipleComponentsIntl;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Atlas", "Intl Verification"})
public class IntlVerificationsApiTest {    
    @Test(enabled=true, groups={"Unit", "Bulk", "Intl Verification", "Valid"})
    public void bulkIntlVerificationsTest() throws ApiException {
        IntlVerificationsApi intlVerificationsApiMock = mock(IntlVerificationsApi.class);

        IntlVerifications fakeIntlVerifications = new IntlVerifications();

        IntlVerificationsPayload intlVerificationsPayload =  new IntlVerificationsPayload();
        List<MultipleComponentsIntl> data = new ArrayList<MultipleComponentsIntl>();
        MultipleComponentsIntl data1 = new MultipleComponentsIntl();
        MultipleComponentsIntl data2 = new MultipleComponentsIntl();
        IntlVerificationOrError intlVerificationData1 = new IntlVerificationOrError();
        IntlVerificationOrError intlVerificationData2 = new IntlVerificationOrError();
        List<IntlVerificationOrError> intlVerificationOrErrors = new ArrayList<IntlVerificationOrError>();
        intlVerificationOrErrors.add(intlVerificationData1);
        intlVerificationOrErrors.add(intlVerificationData2);

        fakeIntlVerifications.setAddresses(intlVerificationOrErrors);
        data.add(data1);
        data.add(data2);
        intlVerificationsPayload.setAddresses(data);

        when(intlVerificationsApiMock.bulkIntlVerifications(intlVerificationsPayload)).thenReturn(fakeIntlVerifications);
        IntlVerifications response = intlVerificationsApiMock.bulkIntlVerifications(intlVerificationsPayload);

        Assert.assertEquals(fakeIntlVerifications.getClass(), response.getClass());
    }

    @Test(enabled=true, groups={"Unit", "Bulk", "Intl Verification", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void bulkIntlVerificationsTestCatchesException() throws ApiException {
        IntlVerificationsApi intlVerificationsApiMock = mock(IntlVerificationsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(intlVerificationsApiMock.bulkIntlVerifications(null)).thenThrow(error);
        intlVerificationsApiMock.bulkIntlVerifications(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Bulk", "Intl Verification", "Invalid"}, expectedExceptions = {ApiException.class})
    public void bulkIntlVerificationsTestCatchesExceptionWithResponseBody() throws ApiException {
        IntlVerificationsApi intlVerificationsApiMock= mock(IntlVerificationsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(intlVerificationsApiMock.bulkIntlVerifications(null)).thenThrow(error);

        intlVerificationsApiMock.bulkIntlVerifications(null);

        Assert.fail("This should not happen");   
    } 
    
    @Test(enabled=true, groups={"Unit", "Intl Verification", "Valid"})
    public void intlVerificationTest() throws ApiException {
        IntlVerificationsApi intlVerificationsApiMock = mock(IntlVerificationsApi.class);
        IntlVerificationWritable intlVerificationWritable = new IntlVerificationWritable();
        String xLangOutput = null;
        IntlVerification fakeIntlVerification = new IntlVerification();

        fakeIntlVerification.setId("intl_ver_Id");
            
        when(intlVerificationsApiMock.intlVerification(intlVerificationWritable, xLangOutput)).thenReturn(fakeIntlVerification);
        IntlVerification response = intlVerificationsApiMock.intlVerification(intlVerificationWritable, xLangOutput);

        Assert.assertEquals(fakeIntlVerification.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Intl Verification", "Invalid"},  expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void intlVerificationTestCatchesException() throws ApiException {
        IntlVerificationsApi intlVerificationsApiMock = mock(IntlVerificationsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(intlVerificationsApiMock.intlVerification(null, null)).thenThrow(error);
        intlVerificationsApiMock.intlVerification(null,null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true,groups={"Unit", "Intl Verification", "Invalid"}, expectedExceptions = {ApiException.class})
    public void intlVerificationTestCatchesExceptionWithResponseBody() throws ApiException {
        IntlVerificationsApi intlVerificationsApiMock = mock(IntlVerificationsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        
        when(intlVerificationsApiMock.intlVerification(null, null)).thenThrow(error);
        intlVerificationsApiMock.intlVerification(null, null);

        Assert.fail("This should not happen");   
    }
    
}

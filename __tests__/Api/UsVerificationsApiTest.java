package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.client.UsVerificationsApi;

import org.openapitools.client.model.MultipleComponents;
import org.openapitools.client.model.MultipleComponentsList;
import org.openapitools.client.model.UsVerification;
import org.openapitools.client.model.UsVerifications;
import org.openapitools.client.model.UsVerificationsWritable;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Atlas", "Us Verification"})
public class UsVerificationsApiTest {
    @Test(enabled=true, groups={"Unit", "Bulk", "Us Autocompletion", "Valid"})
    public void bulkUsVerificationsTest() throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        UsVerifications fakeUsVerifications = new UsVerifications();
        MultipleComponentsList multipleComponentsList = new MultipleComponentsList();
        List<MultipleComponents> data =  new ArrayList<MultipleComponents>();
        MultipleComponents data1 = new MultipleComponents();
        MultipleComponents data2 = new MultipleComponents();

        data1.setPrimaryLine("370 Water Street");
        data1.setZipCode("07090");
        data2.setPrimaryLine("012 PLACEHOLDER ST");
        data2.setZipCode("65692");
        data.add(data1);
        data.add(data2);
        multipleComponentsList.setAddresses(data);

        when(usVerificationApiMock.verifyBulk(multipleComponentsList, "proper")).thenReturn(fakeUsVerifications);
        UsVerifications response = usVerificationApiMock.verifyBulk(multipleComponentsList, "proper");

        Assert.assertEquals(fakeUsVerifications.getClass(), response.getClass());
    }

    @Test(enabled=true, groups={"Unit", "Bulk", "Us Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void bulkVerificationsTestCatchesException() throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        ApiException error = new ApiException("error reported by API");

        when( usVerificationApiMock.verifyBulk(null, null)).thenThrow(error);
        usVerificationApiMock.verifyBulk(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Bulk", "Us Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class})
    public void bulkVerificationsTestCatchesExceptionWithResponseBody () throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");

        when( usVerificationApiMock.verifyBulk(null, null)).thenThrow(error);
        usVerificationApiMock.verifyBulk(null, null);

        Assert.fail("This should not happen");   
    }   

    @Test(enabled=true, groups={"Unit", "Us Autocompletion", "Valid"})
    public void usVerificationTest() throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        UsVerification fakeUsVerification = new UsVerification();
        UsVerificationsWritable usVerificationsWritable = new  UsVerificationsWritable();
        UsVerification.DeliverabilityEnum deliverable = UsVerification.DeliverabilityEnum.DELIVERABLE;
        

        fakeUsVerification.setDeliverability(deliverable);
        
        when(usVerificationApiMock.verifySingle(usVerificationsWritable, "proper")).thenReturn(fakeUsVerification);
        UsVerification response = usVerificationApiMock.verifySingle(usVerificationsWritable, "proper");

        Assert.assertEquals(fakeUsVerification.getDeliverability(), response.getDeliverability());
    }

    @Test(enabled=true, groups={"Unit", "Us Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void UsVerificationTestCatchesException() throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        ApiException error = new ApiException("error reported by API");

        when( usVerificationApiMock.verifySingle(null, null)).thenThrow(error);
        usVerificationApiMock.verifySingle(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Us Autocompletion", "Invalid"}, expectedExceptions = {ApiException.class})
    public void UsVerificationTestCatchesExceptionWithResponseBody () throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");

        when( usVerificationApiMock.verifySingle(null, null)).thenThrow(error);
        usVerificationApiMock.verifySingle(null, null);

        Assert.fail("This should not happen");   
    }   
    
}

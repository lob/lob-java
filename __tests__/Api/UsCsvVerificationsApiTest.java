package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.client.UsVerificationsApi;

import org.openapitools.client.model.UsCsvVerificationsResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit",  "Us  Csv Verification"})
public class UsCsvVerificationsApiTest {
    @Test(enabled=true, groups={"Unit",  "Us Csv Verification", "Valid"})
    public void UsCsvVerificationsResponseTest() throws ApiException {
        UsVerificationsApi usVerificationApiMock = mock (UsVerificationsApi.class);
        
        UsCsvVerificationsResponse UsCsvResponse = new UsCsvVerificationsResponse();

        when(usVerificationApiMock.UsCsvVerificationsResponse(1, 2, 3, 4, 5, 6)).thenReturn(UsCsvResponse);  
        UsCsvVerificationsResponse response = usVerificationApiMock.UsCsvVerificationsResponse(1, 2, 3, 4, 5, 6);

        Assert.assertEquals(UsCsvResponse, response);
    }

    @Test(enabled=true, groups={"Unit", "Us Csv Verification", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void usCsvVerificationsTestCatchesException() throws ApiException {
        UsVerificationsApi usVerificationsApiMock = mock(UsVerificationsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(usVerificationsApiMock.UsCsvVerificationsResponse(0,0,0,0,0,0)).thenThrow(error);
        usVerificationsApiMock.UsCsvVerificationsResponse(0,0,0,0,0,0);

        Assert.fail("This should not happen");
    }

}  
   
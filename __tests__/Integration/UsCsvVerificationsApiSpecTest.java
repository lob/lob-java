package Integration;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.UsVerificationsApi;

import org.openapitools.client.model.UsCsvVerificationsResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.UsCsvVerificationResponseTest;




public class UsCsvVerificationsApiSpecTest {
    
    private UsVerificationsApi validApi = new UsVerificationsApi(Configuration.getConfigForIntegration()); 


    @Test(
        enabled=true,
        groups={"Integration", "Us Csv Verification", "Valid"}
    )
    public void UsCsvVerificationsTest() throws ApiException {

        UsCsvVerificationsResponse response = validApi.UsCsvVerificationsResponse(1,2,3,4,5,6);

        Assert.assertNotNull(response);
    }

    

    
}

package Model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.model.UsCsvVerificationsResponse;

import org.testng.Assert;
import org.testng.annotations.Test;


public class UsCsvVerificationResponseTest {
    private final UsCsvVerificationsResponse model = new UsCsvVerificationsResponse();  

    @Test
    public void testResponse() {
            Assert.assertNotNull(model);
    }

    @Test
    public void idTest() {
        model.setCsvId("csv_ver_fakeId");

        Assert.assertNotNull(model.getCsvId());
        Assert.assertEquals(model.getCsvId(), "us_zip_fakeId" );
    }

    @Test
    public void statusTest() {
        model.setStatus("Received");

        Assert.assertNotNull(model.getStatus());
        Assert.assertEquals(model.getStatus(), "Received" );
    }

    //No error handling

}
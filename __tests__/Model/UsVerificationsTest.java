package Model;

import org.openapitools.client.model.UsVerifications;

import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;
import java.util.ArrayList;

import org.openapitools.client.model.UsVerificationOrError;

@SuppressWarnings("unchecked")
public class UsVerificationsTest {
    @DataProvider (name = "us-verifications-data-provider")
    public Object[][] usVerificationsDpMethod(){
        List<UsVerificationOrError> addresses = new ArrayList<UsVerificationOrError>();
        UsVerificationOrError usVerObj = new UsVerificationOrError();
        usVerObj.setId("us_ver_fakeId");
        addresses.add(usVerObj);

        return new Object[][] {
            {"addresses", addresses},
            {"errors", true},
            {"errors", false},
        };
    }

    @Test(enabled=true, dataProvider = "us-verifications-data-provider")
    public void usVerificationsTestWithProvidedValue(String prop, Object val) {
        UsVerifications rec = new UsVerifications();

        if (prop == "addresses") {
            List<UsVerificationOrError> castedVal = (ArrayList<UsVerificationOrError>)val;
            rec.setAddresses(castedVal);
            Assert.assertEquals(rec.getAddresses(), castedVal);
        } else {
            Boolean castedVal = (Boolean)val;
            rec.setErrors(castedVal);
            Assert.assertEquals(rec.getErrors(), castedVal);
        }
    }
}

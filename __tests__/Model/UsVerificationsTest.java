package Model;

import org.openapitools.client.model.UsVerifications;

import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.openapitools.client.model.LobError;
import org.openapitools.client.model.UsVerificationOrError;

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
            // Assert.assertEquals(rec.getAddresses(), castedVal); // TODO: DXP-920
        } else {
            Boolean castedVal = (Boolean)val;
            rec.setErrors(castedVal);
            Assert.assertEquals(rec.getErrors(), castedVal);
        }
    }

    @Test(enabled=true)
    public void usVerificationsTestErrObjsInErrArr() {
        UsVerifications rec = new UsVerifications();
        LobError.StatusCodeEnum tmp = (LobError.StatusCodeEnum)LobError.StatusCodeEnum.NUMBER_500;
        Integer castedVal = (Integer)(tmp.getValue());
        UsVerificationOrError lobError = new UsVerificationOrError();
        lobError.setStatusCode(castedVal);

        rec.addAddressesItem(lobError);

        Assert.assertNotNull(rec);

        String recAsStr = rec.toString();
        String[] arrOfStr = recAsStr.split("(    addresses: |    errors: )", 0);

        List<String> addresses = new ArrayList<String>(Arrays.asList(arrOfStr[1].split(", class", 0)));
        List<String> errorAddresses = new ArrayList<String>(Arrays.asList(arrOfStr[2].split(", class", 0)));

        Assert.assertEquals(addresses.size(), 1);
        Assert.assertEquals(errorAddresses.size(), 1);
    }
}

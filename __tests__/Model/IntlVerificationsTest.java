package Model;

import com.lob.model.IntlVerifications;

import com.lob.model.IntlVerificationOrError;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class IntlVerificationsTest {
    @DataProvider (name = "intl-verifications-data-provider")
    public Object[][] intlVerificationsDpMethod(){
        List<IntlVerificationOrError> addresses = new ArrayList<IntlVerificationOrError>();
        IntlVerificationOrError intlVerObj = new IntlVerificationOrError();
        intlVerObj.setId("intl_ver_fakeId");
        addresses.add(intlVerObj);

        return new Object[][] {
            {"addresses", addresses},
            {"errors", true},
            {"errors", false},
        };
    }

    @Test(enabled=true, dataProvider = "intl-verifications-data-provider")
    public void intlVerificationsTestWithProvidedValue(String prop, Object val) throws Exception {
        IntlVerifications rec = new IntlVerifications();

        if (prop == "addresses") {
            List<IntlVerificationOrError> castedVal = (ArrayList<IntlVerificationOrError>)val;
            rec.setAddresses(castedVal);
            Assert.assertEquals(rec.getAddresses(), castedVal);
        } else {
            Boolean castedVal = (Boolean)val;
            rec.setErrors(castedVal);
            Assert.assertEquals(rec.getErrors(), castedVal);
        }
    }
}

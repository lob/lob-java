package Model;

import com.lob.model.BankAccountWritable;
import com.lob.model.BankTypeEnum;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;
import org.testng.Assert;

public class BankAccountWritableTest {
    @DataProvider (name = "bank-account-writable-data-provider")
    public Object[][] bankAccountWritableDpMethod() {
        return new Object[][] {
            {"description", "fake description"},
            {"routing_number", "fake routing"},
            {"account_number", "fake account"},
            {"account_type", BankTypeEnum.COMPANY},
            {"signatory", "fake signatory"},
            {"metadata", new HashMap<String, String>()},
        };
    }

    @Test(enabled=true, dataProvider = "bank-account-writable-data-provider")
    public void bankAccountWritableTestWithProvidedValue(String prop, Object val) throws Exception {
        BankAccountWritable rec = new BankAccountWritable();

        switch (prop) {
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "routing_number": {
                String castedVal = (String)val;
                rec.setRoutingNumber(castedVal);
                Assert.assertEquals(rec.getRoutingNumber(), castedVal);
                break;
            }
            case "account_number": {
                String castedVal = (String)val;
                rec.setAccountNumber(castedVal);
                Assert.assertEquals(rec.getAccountNumber(), castedVal);
                break;
            }
            case "account_type": {
                BankTypeEnum castedVal = (BankTypeEnum)val;
                rec.setAccountType(castedVal);
                Assert.assertEquals(rec.getAccountType(), castedVal);
                break;
            }
            case "signatory": {
                String castedVal = (String)val;
                rec.setSignatory(castedVal);
                Assert.assertEquals(rec.getSignatory(), castedVal);
                break;
            }
            case "metadata": {
                @SuppressWarnings("unchecked")
                Map<String, String> castedVal = (HashMap<String, String>)val;
                rec.setMetadata(castedVal);
                Assert.assertEquals(rec.getMetadata(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

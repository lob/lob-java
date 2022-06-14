package Model;

import com.lob.model.BankAccountDeletion;

import org.testng.annotations.*;
import org.testng.Assert;

public class BankAccountDeletionTest {
    @DataProvider (name = "bank-account-deletion-data-provider")
    public Object[][] bankAccountDeletionDpMethod() {
        return new Object[][] {
            {"id", "bank_fakeId"},
            {"deleted", true},
            {"object", BankAccountDeletion.ObjectEnum.BANK_ACCOUNT_DELETED},
        };
    }

    @Test(enabled=true, dataProvider = "bank-account-deletion-data-provider")
    public void bankAccountDeletionTestWithProvidedValue(String prop, Object val) throws Exception {
        BankAccountDeletion rec = new BankAccountDeletion();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "deleted": {
                Boolean castedVal = (Boolean)val;
                rec.setDeleted(castedVal);
                Assert.assertEquals(rec.getDeleted(), castedVal);
                break;
            }
            case "object": {
                BankAccountDeletion.ObjectEnum castedVal = (BankAccountDeletion.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void bankAccountDeletionTestCatchesInvalidId() {
        BankAccountDeletion rec = new BankAccountDeletion();
        Assert.assertNull(rec.getId());

        String invalidValue = "Nope";
        try {
            rec.setId(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }
}

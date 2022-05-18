package Model;

import org.openapitools.client.model.BankAccount;

import org.testng.annotations.*;
import org.testng.Assert;

import org.threeten.bp.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import Helper.*;

@SuppressWarnings("unchecked")
public class BankAccountTest {
    @DataProvider (name = "bank-account-data-provider")
    public Object[][] bankAccountDpMethod() {
        return new Object[][] {
            {"id", "bank_fakeId"},
            {"description", "fake description"},
            {"routing_number", "fake routing"},
            {"account_number", "fake account"},
            {"account_type", BankAccount.AccountTypeEnum.COMPANY},
            {"account_type", BankAccount.AccountTypeEnum.INDIVIDUAL},
            {"signatory", "fake signatory"},
            {"metadata", new HashMap<String, String>()},
            {"signature_url", new TestFixtures().get_URL_VALID()},
            {"bank_name", "Bank"},
            {"verified", false},
            {"verified", true},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", false},
            {"deleted", true},
            {"object", BankAccount.ObjectEnum.BANK_ACCOUNT},
        };
    }

    @Test(enabled=true, dataProvider = "bank-account-data-provider")
    public void bankAccountTestWithProvidedValue(String prop, Object val) throws Exception {
        BankAccount rec = new BankAccount();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
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
                BankAccount.AccountTypeEnum castedVal = (BankAccount.AccountTypeEnum)val;
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
                Map<String, String> castedVal = (HashMap<String, String>)val;
                rec.setMetadata(castedVal);
                Assert.assertEquals(rec.getMetadata(), castedVal);
                break;
            }
            case "signature_url": {
                String castedVal = (String)val;
                rec.setSignatureUrl(castedVal);
                Assert.assertEquals(rec.getSignatureUrl(), castedVal);
                break;
            }
            case "bank_name": {
                String castedVal = (String)val;
                rec.setBankName(castedVal);
                Assert.assertEquals(rec.getBankName(), castedVal);
                break;
            }
            case "verified": {
                Boolean castedVal = (Boolean)val;
                rec.setVerified(castedVal);
                Assert.assertEquals(rec.getVerified(), castedVal);
                break;
            }
            case "date_created": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateCreated(castedVal);
                Assert.assertEquals(rec.getDateCreated(), castedVal);
                break;
            }
            case "date_modified": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setDateModified(castedVal);
                Assert.assertEquals(rec.getDateModified(), castedVal);
                break;
            }
            case "deleted": {
                Boolean castedVal = (Boolean)val;
                rec.setDeleted(castedVal);
                Assert.assertEquals(rec.getDeleted(), castedVal);
                break;
            }
            case "object": {
                BankAccount.ObjectEnum castedVal = (BankAccount.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void bankAccountTestCatchesInvalidId() {
        BankAccount rec = new BankAccount();
        Assert.assertNull(rec.getId());

        String invalidValue = "Nope";
        try {
            rec.setId(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }

    @Test(enabled=true)
    public void bankAccountTestCatchesInvalidSignatureUrl() {
        BankAccount rec = new BankAccount();
        Assert.assertNull(rec.getSignatureUrl());

        String invalidValue = "Nope";
        try {
            rec.setSignatureUrl(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid signature_url provided");
        }
    }
}

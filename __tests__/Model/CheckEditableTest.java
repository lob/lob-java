package Model;

import org.openapitools.client.model.CheckEditable;
import org.openapitools.client.model.AddressEditable;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;
import org.threeten.bp.OffsetDateTime;
import org.testng.Assert;

public class CheckEditableTest {
    @DataProvider (name = "check-editable-data-provider")
    public Object[][] checkEditableDpMethod(){
        return new Object[][] {
            {"from", new AddressEditable()},
            {"to", new AddressEditable()},
            {"bank_account", "fake account"},
            {"amount", 111f},
            {"logo", "fake logo"},
            {"check_bottom", "fake bottom"},
            {"attachment", "fake attachment"},
            {"description", "fake description"},
            {"metadata", new HashMap<String, String>()},
            {"merge_variables", new Object()},
            {"send_date",OffsetDateTime.now()},
            {"mail_type", CheckEditable.MailTypeEnum.USPS_FIRST_CLASS},
            {"memo", "fake memo"},
            {"check_number", 123456},
            {"message", "fake message"},
            {"billing_group_id", "fake billing group"},
        };
    }

    @Test(enabled=true, dataProvider = "check-editable-data-provider")
    public void checkEditableTestWithProvidedValue(String prop, Object val) throws Exception {
        CheckEditable rec = new CheckEditable();

        switch (prop) {
            case "from": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setFrom(castedVal);
                Assert.assertEquals(rec.getFrom(), castedVal.toString());
                break;
            }
            case "to": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setTo(castedVal);
                Assert.assertEquals(rec.getTo(), castedVal.toString());
                break;
            }
            case "bank_account": {
                String castedVal = (String)val;
                rec.setBankAccount(castedVal);
                Assert.assertEquals(rec.getBankAccount(), castedVal);
                break;
            }
            case "amount": {
                Float castedVal = (Float)val;
                rec.setAmount(castedVal);
                Assert.assertEquals(rec.getAmount(), castedVal);
                break;
            }
            case "logo": {
                String castedVal = (String)val;
                rec.setLogo(castedVal);
                Assert.assertEquals(rec.getLogo(), castedVal);
                break;
            }
            case "check_bottom": {
                String castedVal = (String)val;
                rec.setCheckBottom(castedVal);
                Assert.assertEquals(rec.getCheckBottom(), castedVal);
                break;
            }
            case "attachment": {
                String castedVal = (String)val;
                rec.setAttachment(castedVal);
                Assert.assertEquals(rec.getAttachment(), castedVal);
                break;
            }
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "metadata": {
                Map<String, String> castedVal = (HashMap<String, String>)val;
                rec.setMetadata(castedVal);
                Assert.assertEquals(rec.getMetadata(), castedVal);
                break;
            }
            case "merge_variables": {
                Object castedVal = (Object)val;
                rec.setMergeVariables(castedVal);
                Assert.assertEquals(rec.getMergeVariables(), castedVal);
                break;
            }
            case "mail_type": {
                CheckEditable.MailTypeEnum castedVal = (CheckEditable.MailTypeEnum)val;
                rec.setMailType(castedVal);
                Assert.assertEquals(rec.getMailType(), castedVal);
                break;
            }
            case "memo": {
                String castedVal = (String)val;
                rec.setMemo(castedVal);
                Assert.assertEquals(rec.getMemo(), castedVal);
                break;
            }
            case "check_number": {
                Integer castedVal = (Integer)val;
                rec.setCheckNumber(castedVal);
                Assert.assertEquals(rec.getCheckNumber(), castedVal);
                break;
            }
            case "message": {
                String castedVal = (String)val;
                rec.setMessage(castedVal);
                Assert.assertEquals(rec.getMessage(), castedVal);
                break;
            }
            case "billing_group_id": {
                String castedVal = (String)val;
                rec.setBillingGroupId(castedVal);
                Assert.assertEquals(rec.getBillingGroupId(), castedVal);
                break;
            }
            case "send_date": {
                OffsetDateTime castedVal = (OffsetDateTime) val;
                rec.setSendDate(castedVal);
                Assert.assertEquals(rec.getSendDate(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }
}

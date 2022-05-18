package Model;

import java.util.HashMap;
import java.util.Map;

import org.openapitools.client.model.AddressEditable;
import org.openapitools.client.model.MailType;
import org.openapitools.client.model.SelfMailerEditable;
import org.openapitools.client.model.SelfMailerSize;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.threeten.bp.OffsetDateTime;

@SuppressWarnings("unchecked")
public class SelfMailerEditableTest {
    @DataProvider (name = "self-mailer-editable-data-provider")
    public Object[][] selfMailerEditableDpMethod(){
        return new Object[][] {
            {"to", new AddressEditable()},
            {"from", new AddressEditable()},
            {"size", SelfMailerSize._11X9_BIFOLD},
            {"size", SelfMailerSize._12X9_BIFOLD},
            {"size", SelfMailerSize._6X18_BIFOLD},
            {"description", "fake description"},
            {"metadata", new HashMap<String, String>()},
            {"mail_type", MailType.STANDARD},
            {"mail_type", MailType.FIRST_CLASS},
            {"merge_variables", new Object()},
            {"send_date", OffsetDateTime.now()},
            {"inside", "fake inside"},
            {"outside", "fake outside"},
            {"billing_group_id", "fake billing_group_id"},
        };
    }

    @Test(enabled=true, dataProvider = "self-mailer-editable-data-provider")
    public void selfMailerEditableTestWithProvidedValue(String prop, Object val) throws Exception {
        SelfMailerEditable rec = new SelfMailerEditable();

        switch (prop) {
            case "to": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setTo(castedVal);
                Assert.assertEquals(rec.getTo(), castedVal.toString());
                break;
            }
            case "from": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setFrom(castedVal);
                Assert.assertEquals(rec.getFrom(), castedVal.toString());
                break;
            }
            case "size": {
                SelfMailerSize castedVal = (SelfMailerSize)val;
                rec.setSize(castedVal);
                Assert.assertEquals(rec.getSize(), castedVal);
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
            case "mail_type": {
                MailType castedVal = (MailType)val;
                rec.setMailType(castedVal);
                Assert.assertEquals(rec.getMailType(), castedVal);
                break;
            }
            case "merge_variables": {
                Object castedVal = (Object)val;
                rec.setMergeVariables(castedVal);
                Assert.assertEquals(rec.getMergeVariables(), castedVal);
                break;
            }
            case "send_date": {
                OffsetDateTime castedVal = (OffsetDateTime) val;
                rec.setSendDate(castedVal);
                Assert.assertEquals(rec.getSendDate(), castedVal);
                break;
            }
            case "inside": {
                String castedVal = (String)val;
                rec.setInside(castedVal);
                Assert.assertEquals(rec.getInside(), castedVal);
                break;
            }
            case "outside": {
                String castedVal = (String)val;
                rec.setOutside(castedVal);
                Assert.assertEquals(rec.getOutside(), castedVal);
                break;
            }
            case "billing_group_id": {
                String castedVal = (String)val;
                rec.setBillingGroupId(castedVal);
                Assert.assertEquals(rec.getBillingGroupId(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }
}

package Model;

import org.openapitools.client.model.PostcardEditable;
import org.openapitools.client.model.AddressEditable;
import org.openapitools.client.model.PostcardSize;
import org.openapitools.client.model.MailType;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class PostcardEditableTest {
    @DataProvider (name = "postcard-editable-data-provider")
    public Object[][] postcardEditableDpMethod(){
        return new Object[][] {
            {"to", new AddressEditable()},
            {"from", new AddressEditable()},
            {"size", PostcardSize._6X9},
            {"size", PostcardSize._6X11},
            {"size", PostcardSize._4X6},
            {"description", "fake description"},
            {"metadata", new HashMap<String, String>()},
            {"mail_type", MailType.STANDARD},
            {"mail_type", MailType.FIRST_CLASS},
            {"merge_variables", new Object()},
            {"front", "fake front"},
            {"back", "fake back"},
            {"billing_group_id", "fake billing group"},
        };
    }

    @Test(enabled=true, dataProvider = "postcard-editable-data-provider")
    public void postcardEditableTestWithProvidedValue(String prop, Object val) throws Exception {
        PostcardEditable rec = new PostcardEditable();
        Gson gson = new Gson();
        switch (prop) {
            case "to": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setTo(castedVal);
                Assert.assertEquals(rec.getTo(), gson.toJson(castedVal));
                break;
            }
            case "from": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setFrom(castedVal);
                Assert.assertEquals(rec.getFrom(), gson.toJson(castedVal));
                break;
            }
            case "size": {
                PostcardSize castedVal = (PostcardSize)val;
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
            case "front": {
                String castedVal = (String)val;
                rec.setFront(castedVal);
                Assert.assertEquals(rec.getFront(), castedVal);
                break;
            }
            case "back": {
                String castedVal = (String)val;
                rec.setBack(castedVal);
                Assert.assertEquals(rec.getBack(), castedVal);
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

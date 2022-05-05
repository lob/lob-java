package Model;

import org.openapitools.client.model.LetterEditable;
import org.openapitools.client.model.LetterCustomEnvelope;
import org.openapitools.client.model.MailType;
import org.openapitools.client.model.AddressEditable;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class LetterEditableTest {
    @DataProvider (name = "letter-editable-data-provider")
    public Object[][] letterEditableDpMethod(){
        List<String> cards = new ArrayList<String>();
        cards.add("fake card");

        return new Object[][] {
            {"mail_type", MailType.STANDARD},
            {"mail_type", MailType.FIRST_CLASS},
            {"color", true},
            {"color", false},
            {"double_sided", true},
            {"double_sided", false},
            {"address_placement", LetterEditable.AddressPlacementEnum.BOTTOM_FIRST_PAGE_CENTER},
            {"address_placement", LetterEditable.AddressPlacementEnum.INSERT_BLANK_PAGE},
            {"address_placement", LetterEditable.AddressPlacementEnum.BOTTOM_FIRST_PAGE},
            {"address_placement", LetterEditable.AddressPlacementEnum.TOP_FIRST_PAGE},
            {"return_envelope", "true"},
            {"return_envelope", "false"},
            {"perforated_page", 11},
            {"custom_envelope", new LetterCustomEnvelope()},
            {"to", new AddressEditable()},
            {"from", new AddressEditable()},
            {"file", "fake file"},
            {"extra_service", LetterEditable.ExtraServiceEnum.NULL},
            {"cards", cards},
            {"billing_group_id", "fake billing group"},
        };
    }

    @Test(enabled=true, dataProvider="letter-editable-data-provider")
    public void letterEditableTestWithProvidedValue(String prop, Object val) throws Exception {
        LetterEditable rec = new LetterEditable();

        switch (prop) {
            case "mail_type": {
                MailType castedVal = (MailType)val;
                rec.setMailType(castedVal);
                Assert.assertEquals(rec.getMailType(), castedVal);
                break;
            }
            case "color": {
                Boolean castedVal = (Boolean)val;
                rec.setColor(castedVal);
                Assert.assertEquals(rec.getColor(), castedVal);
                break;
            }
            case "double_sided": {
                Boolean castedVal = (Boolean)val;
                rec.setDoubleSided(castedVal);
                Assert.assertEquals(rec.getDoubleSided(), castedVal);
                break;
            }
            case "address_placement": {
                LetterEditable.AddressPlacementEnum castedVal = (LetterEditable.AddressPlacementEnum)val;
                rec.setAddressPlacement(castedVal);
                Assert.assertEquals(rec.getAddressPlacement(), castedVal);
                break;
            }
            case "return_envelope": {
                String castedVal = (String)val;
                rec.setReturnEnvelope(castedVal);
                Assert.assertEquals(rec.getReturnEnvelope(), castedVal);
                break;
            }
            case "perforated_page": {
                Integer castedVal = (Integer)val;
                rec.setPerforatedPage(castedVal);
                Assert.assertEquals(rec.getPerforatedPage(), castedVal);
                break;
            }
            case "custom_envelope": {
                LetterCustomEnvelope castedVal = (LetterCustomEnvelope)val;
                rec.setCustomEnvelope(castedVal);
                Assert.assertEquals(rec.getCustomEnvelope(), castedVal);
                break;
            }
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
            case "file": {
                String castedVal = (String)val;
                rec.setFile(castedVal);
                Assert.assertEquals(rec.getFile(), castedVal);
                break;
            }
            case "extra_service": {
                LetterEditable.ExtraServiceEnum castedVal = (LetterEditable.ExtraServiceEnum)val;
                rec.setExtraService(castedVal);
                Assert.assertEquals(rec.getExtraService(), castedVal);
                break;
            }
            case "cards": {
                List<String> castedVal = (ArrayList<String>)val;
                rec.setCards(castedVal);
                Assert.assertEquals(rec.getCards(), castedVal);
                break;
            }
            case "billing_group_id": {
                String castedVal = (String)val;
                rec.setBillingGroupId(castedVal);
                Assert.assertEquals(rec.getBillingGroupId(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name");
        }
    }
}

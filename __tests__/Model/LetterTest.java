package Model;

import org.openapitools.client.model.Letter;
import org.openapitools.client.model.Address;
import org.openapitools.client.model.Thumbnail;
import org.openapitools.client.model.MailType;
import org.openapitools.client.model.LetterCustomEnvelope;
import org.openapitools.client.model.TrackingEventNormal;
import org.openapitools.client.model.SendDate;
import org.openapitools.client.model.AddressEditable;

import java.util.Map;
import java.util.HashMap;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class LetterTest {
    @DataProvider (name = "letter-create-data-provider")
    public Object[][] letterCreateDpMethod(){
        ArrayList<Thumbnail> thumbnails =  new ArrayList<Thumbnail>();
        thumbnails.add(new Thumbnail());

        List<TrackingEventNormal> trackingEvents = new ArrayList<TrackingEventNormal>();
        TrackingEventNormal trackingEvent = new TrackingEventNormal();
        trackingEvent.setId("evnt_fakeId");
        trackingEvents.add(trackingEvent);

        // SendDate sendDate = new SendDate();
        // sendDate.setSendDate(OffsetDateTime.now().toString());

        return new Object[][] {
            {"id", "ltr_fakeId"},
            {"to", new Address()},
            {"from", new Address()},
            {"carrier", Letter.CarrierEnum.USPS},
            {"thumbnails", thumbnails},
            {"expected_delivery_date", LocalDate.now()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
            {"template_id", "tmpl_fakeId"},
            {"template_version_id", "vrsn_fakeId"},
            {"object", Letter.ObjectEnum.LETTER},
            {"description", "fake description"},
            {"metadata", new HashMap<String, String>()},
            {"merge_variables", new HashMap<String, String>()},
            // {"send_date", sendDate}, // TODO: DXP-978
            {"extra_service", "fake extra service"},
            {"tracking_number", "fake tracking"},
            {"tracking_events", trackingEvents},
            {"return_address", new AddressEditable()},
            {"mail_type", MailType.STANDARD},
            {"mail_type", MailType.FIRST_CLASS},
            {"color", true},
            {"color", false},
            {"double_sided", true},
            {"double_sided", false},
            {"address_placement", Letter.AddressPlacementEnum.BOTTOM_FIRST_PAGE_CENTER},
            {"address_placement", Letter.AddressPlacementEnum.INSERT_BLANK_PAGE},
            {"address_placement", Letter.AddressPlacementEnum.BOTTOM_FIRST_PAGE},
            {"address_placement", Letter.AddressPlacementEnum.TOP_FIRST_PAGE},
            {"return_envelope", "true"},
            {"return_envelope", "false"},
            {"perforated_page", 11},
            {"custom_envelope", new LetterCustomEnvelope()},
        };
    }

    @Test(enabled=true, dataProvider="letter-create-data-provider")
    public void letterCreateTestWithProvidedValue(String prop, Object val) throws Exception {
        Letter rec = new Letter();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "to": {
                Address castedVal = (Address)val;
                rec.setTo(castedVal);
                Assert.assertEquals(rec.getTo(), castedVal);
                break;
            }
            case "from": {
                Address castedVal = (Address)val;
                rec.setFrom(castedVal);
                Assert.assertEquals(rec.getFrom(), castedVal);
                break;
            }
            case "carrier": {
                Letter.CarrierEnum castedVal = (Letter.CarrierEnum)val;
                rec.setCarrier(castedVal);
                Assert.assertEquals(rec.getCarrier(), castedVal);
                break;
            }
            case "thumbnails": {
                List<Thumbnail> castedVal = (ArrayList<Thumbnail>)val;
                rec.setThumbnails(castedVal);
                Assert.assertEquals(rec.getThumbnails(), castedVal);
                break;
            }
            case "expected_delivery_date": {
                LocalDate castedVal = (LocalDate)val;
                rec.setExpectedDeliveryDate(castedVal);
                Assert.assertEquals(rec.getExpectedDeliveryDate(), castedVal);
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
            case "template_id": {
                String castedVal = (String)val;
                rec.setTemplateId(castedVal);
                Assert.assertEquals(rec.getTemplateId(), castedVal);
                break;
            }
            case "template_version_id": {
                String castedVal = (String)val;
                rec.setTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getTemplateVersionId(), castedVal);
                break;
            }
            case "object": {
                Letter.ObjectEnum castedVal = (Letter.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
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
                Map<String, String> castedVal = (HashMap<String, String>)val;
                rec.setMergeVariables(castedVal);
                Assert.assertEquals(rec.getMergeVariables(), castedVal);
                break;
            }
            // case "send_date": { // TODO: DXP-978
            //     SendDate castedVal = (SendDate)val;
            //     rec.setSendDate(castedVal);
            //     Assert.assertEquals(rec.getSendDate(), castedVal);
            //     break;
            // }
            case "extra_service": {
                String castedVal = (String)val;
                rec.setExtraService(castedVal);
                Assert.assertEquals(rec.getExtraService(), castedVal);
                break;
            }
            case "tracking_number": {
                String castedVal = (String)val;
                rec.setTrackingNumber(castedVal);
                Assert.assertEquals(rec.getTrackingNumber(), castedVal);
                break;
            }
            case "tracking_events": {
                List<TrackingEventNormal> castedVal = (ArrayList<TrackingEventNormal>)val;
                rec.setTrackingEvents(castedVal);
                Assert.assertEquals(rec.getTrackingEvents(), castedVal);
                break;
            }
            case "return_address": {
                AddressEditable castedVal = (AddressEditable)val;
                rec.setReturnAddress(castedVal);
                Assert.assertEquals(rec.getReturnAddress(), castedVal.toString());
                break;
            }
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
                Letter.AddressPlacementEnum castedVal = (Letter.AddressPlacementEnum)val;
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
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void letterCreateTestInvalidId() {
        Letter rec = new Letter();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }

    @Test(enabled=true)
    public void letterCreateTestInvalidTemplateId() {
        Letter rec = new Letter();
        Assert.assertNull(rec.getTemplateId());

        try {
            rec.setTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid template_id provided");
        }
    }

    @Test(enabled=true)
    public void letterCreateTestInvalidTemplateVersionId() {
        Letter rec = new Letter();
        Assert.assertNull(rec.getTemplateVersionId());

        try {
            rec.setTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid template_version_id provided");
        }
    }
}

package Model;

import org.openapitools.client.model.Postcard;
import org.openapitools.client.model.PostcardSize;
import org.openapitools.client.model.AddressDomesticExpanded;
import org.openapitools.client.model.Address;
import org.openapitools.client.model.Thumbnail;
import org.openapitools.client.model.TrackingEventNormal;
import org.openapitools.client.model.MailType;

import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import Helper.TestFixtures;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class PostcardTest {
    @DataProvider (name = "postcard-data-provider")
    public Object[][] postcardDpMethod() {
        List<Thumbnail> thumbnails = new ArrayList<Thumbnail>();
        thumbnails.add(new Thumbnail());

        List<TrackingEventNormal> trackingEvents = new ArrayList<TrackingEventNormal>();
        trackingEvents.add(new TrackingEventNormal());

        return new Object[][] {
            {"id", "psc_fakeId"},
            {"to", new Address()},
            {"from", new AddressDomesticExpanded()},
            {"carrier", Postcard.CarrierEnum.USPS},
            {"thumbnails", thumbnails},
            {"size", PostcardSize._6X9},
            {"size", PostcardSize._6X11},
            {"size", PostcardSize._4X6},
            {"expected_delivery_date", LocalDate.now()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
            {"front_template_id", "tmpl_fakeId"},
            {"back_template_id", "tmpl_fakeId"},
            {"front_template_version_id", "vrsn_fakeId"},
            {"back_template_version_id", "vrsn_fakeId"},
            {"tracking_events", trackingEvents},
            {"object", Postcard.ObjectEnum.POSTCARD},
            {"url", new TestFixtures().get_URL_VALID()},
            {"description", "fake description"},
            {"metadata", new HashMap<String, String>()},
            {"mail_type", MailType.STANDARD},
            {"mail_type", MailType.FIRST_CLASS},
            {"merge_variables", new Object()},
        };
    }

    @Test(enabled=true, dataProvider = "postcard-data-provider")
    public void postcardTestWithProvidedValue(String prop, Object val) throws Exception {
        Postcard rec = new Postcard();

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
                AddressDomesticExpanded castedVal = (AddressDomesticExpanded)val;
                rec.setFrom(castedVal);
                Assert.assertEquals(rec.getFrom(), castedVal);
                break;
            }
            case "carrier": {
                Postcard.CarrierEnum castedVal = (Postcard.CarrierEnum)val;
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
            case "size": {
                PostcardSize castedVal = (PostcardSize)val;
                rec.setSize(castedVal);
                Assert.assertEquals(rec.getSize(), castedVal);
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
            case "front_template_id": {
                String castedVal = (String)val;
                rec.setFrontTemplateId(castedVal);
                Assert.assertEquals(rec.getFrontTemplateId(), castedVal);
                break;
            }
            case "back_template_id": {
                String castedVal = (String)val;
                rec.setBackTemplateId(castedVal);
                Assert.assertEquals(rec.getBackTemplateId(), castedVal);
                break;
            }
            case "front_template_version_id": {
                String castedVal = (String)val;
                rec.setFrontTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getFrontTemplateVersionId(), castedVal);
                break;
            }
            case "back_template_version_id": {
                String castedVal = (String)val;
                rec.setBackTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getBackTemplateVersionId(), castedVal);
                break;
            }
            case "tracking_events": {
                List<TrackingEventNormal> castedVal = (ArrayList<TrackingEventNormal>)val;
                rec.setTrackingEvents(castedVal);
                Assert.assertEquals(rec.getTrackingEvents(), castedVal);
                break;
            }
            case "object": {
                Postcard.ObjectEnum castedVal = (Postcard.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "url": {
                String castedVal = (String)val;
                rec.setUrl(castedVal);
                Assert.assertEquals(rec.getUrl(), castedVal);
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
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void postcardTestInvalidId() {
        Postcard rec = new Postcard();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }

    @Test(enabled=true)
    public void postcardTestInvalidFrontTemplateId() {
        Postcard rec = new Postcard();
        Assert.assertNull(rec.getFrontTemplateId());

        try {
            rec.setFrontTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid front_template_id provided");
        }
    }

    @Test(enabled=true)
    public void postcardTestInvalidBackTemplateId() {
        Postcard rec = new Postcard();
        Assert.assertNull(rec.getBackTemplateId());

        try {
            rec.setBackTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid back_template_id provided");
        }
    }

    @Test(enabled=true)
    public void postcardTestInvalidFrontTemplateVersionId() {
        Postcard rec = new Postcard();
        Assert.assertNull(rec.getFrontTemplateVersionId());

        try {
            rec.setFrontTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid front_template_version_id provided");
        }
    }

    @Test(enabled=true)
    public void postcardTestInvalidBackTemplateVersionId() {
        Postcard rec = new Postcard();
        Assert.assertNull(rec.getBackTemplateVersionId());

        try {
            rec.setBackTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid back_template_version_id provided");
        }
    }

    @Test(enabled=true)
    public void postcardTestInvalidUrl() {
        Postcard rec = new Postcard();
        Assert.assertNull(rec.getUrl());

        try {
            rec.setUrl("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid url provided");
        }
    }
}

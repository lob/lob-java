package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.threeten.bp.OffsetDateTime;
import org.openapitools.client.model.AddressEditable;
import org.openapitools.client.model.MailType;
import org.openapitools.client.model.SelfMailer;
import org.openapitools.client.model.SelfMailerSize;
import org.openapitools.client.model.TrackingEventCertified;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.TestFixtures;

@SuppressWarnings("unchecked")
public class SelfMailerTest {
    @DataProvider (name = "self-mailer-data-provider")
    public Object[][] selfMailerDpMethod(){
        return new Object[][] {
            {"id", "sfm_fakeId"},
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
            {"outside_template_id", "tmpl_outsideFakeId"},
            {"inside_template_id", "tmpl_insideFakeId"},
            {"outside_template_version_id", "vrsn_outsideFakeId"},
            {"inside_template_version_id", "vrsn_insideFakeId"},
            {"object", SelfMailer.ObjectEnum.SELF_MAILER},
            {"tracking_events", new ArrayList<TrackingEventCertified>()},
            {"url", new TestFixtures().get_URL_VALID()},
        };
    }

    @Test(enabled=true, dataProvider = "self-mailer-data-provider")
    public void selfMailerTestWithProvidedValue(String prop, Object val) throws Exception {
        SelfMailer rec = new SelfMailer();
        Gson gson = new Gson();
        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
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
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setSendDate(castedVal);
                Assert.assertEquals(rec.getSendDate(), castedVal);
                break;
            }
            case "outside_template_id": {
                String castedVal = (String)val;
                rec.setOutsideTemplateId(castedVal);
                Assert.assertEquals(rec.getOutsideTemplateId(), castedVal);
                break;
            }
            case "inside_template_id": {
                String castedVal = (String)val;
                rec.setInsideTemplateId(castedVal);
                Assert.assertEquals(rec.getInsideTemplateId(), castedVal);
                break;
            }
            case "outside_template_version_id": {
                String castedVal = (String)val;
                rec.setOutsideTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getOutsideTemplateVersionId(), castedVal);
                break;
            }
            case "inside_template_version_id": {
                String castedVal = (String)val;
                rec.setInsideTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getInsideTemplateVersionId(), castedVal);
                break;
            }
            case "object": {
                SelfMailer.ObjectEnum castedVal = (SelfMailer.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "tracking_events": {
                List<TrackingEventCertified> castedVal = (ArrayList<TrackingEventCertified>)val;
                rec.setTrackingEvents(castedVal);
                Assert.assertEquals(rec.getTrackingEvents(), castedVal);
                break;
            }
            case "url": {
                String castedVal = (String)val;
                rec.setUrl(castedVal);
                Assert.assertEquals(rec.getUrl(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void selfMailerTestInvalidId() {
        SelfMailer rec = new SelfMailer();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }

    @Test(enabled=true)
    public void selfMailerTestInvalidUrl() {
        SelfMailer rec = new SelfMailer();
        Assert.assertNull(rec.getUrl());

        try {
            rec.setUrl("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid url provided");
        }
    }

    @Test(enabled=true)
    public void selfMailerTestInvalidOutsideTemplateId() {
        SelfMailer rec = new SelfMailer();
        Assert.assertNull(rec.getOutsideTemplateId());

        try {
            rec.setOutsideTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid outside_template_id provided");
        }
    }

    @Test(enabled=true)
    public void selfMailerTestInvalidInsideTemplateId() {
        SelfMailer rec = new SelfMailer();
        Assert.assertNull(rec.getInsideTemplateId());

        try {
            rec.setInsideTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid inside_template_id provided");
        }
    }

    @Test(enabled=true)
    public void selfMailerTestInvalidOutsideTemplateVersionId() {
        SelfMailer rec = new SelfMailer();
        Assert.assertNull(rec.getOutsideTemplateVersionId());

        try {
            rec.setOutsideTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid outside_template_version_id provided");
        }
    }

    @Test(enabled=true)
    public void selfMailerTestInvalidInsideTemplateVersionId() {
        SelfMailer rec = new SelfMailer();
        Assert.assertNull(rec.getInsideTemplateVersionId());

        try {
            rec.setInsideTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid inside_template_version_id provided");
        }
    }
}

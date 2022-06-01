package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import com.lob.model.Address;
import com.lob.model.BankAccount;
import com.lob.model.Check;
import com.lob.model.Thumbnail;
import com.lob.model.TrackingEventNormal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;


import Helper.*;

@SuppressWarnings("unchecked")
public class CheckTest {
    @DataProvider (name = "check-data-provider")
    public Object[][] checkDpMethod(){

        BankAccount bankAcc = new BankAccount();
        bankAcc.setAccountNumber("123456");

        Address to = new Address();
        to.setAddressLine1("fake to");

        Address from = new Address();
        from.setAddressLine1("fake from");

        return new Object[][] {
            {"id", "chk_fakeId"},
            {"to", to},
            {"from", from},
            {"description", "fake description"},
            {"metadata", new HashMap()}, 
            {"merge_variables", new HashMap()},
            {"send_date", OffsetDateTime.now()},
            {"mail_type", Check.MailTypeEnum.USPS_FIRST_CLASS},
            {"memo", "fake memo"},
            {"check_number", 123456},
            {"message", "fake message"},
            {"amount", 71.0f},
            {"bank_account", bankAcc},
            {"check_bottom_template_id", "tmpl_fakeId"},
            {"attachment_template_id", "tmpl_fakeId"},
            {"check_bottom_template_version_id", "vrsn_fakeId"},
            {"attachment_template_version_id", "vrsn_fakeId"},
            {"url", new TestFixtures().get_URL_VALID()},
            {"carrier", Check.CarrierEnum.USPS},
            {"thumbnails", new ArrayList<Thumbnail>()},
            {"expected_delivery_date", LocalDate.now()},
            {"tracking_events", new ArrayList<TrackingEventNormal>()},
            {"object", Check.ObjectEnum.CHECK},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
        };
    }

    @Test(enabled=true, dataProvider = "check-data-provider")
    public void checkTestWithProvidedValue(String prop, Object val) throws Exception {
        Check rec = new Check();

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
            case "send_date": { 
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setSendDate(castedVal);
                Assert.assertEquals(rec.getSendDate(), castedVal);
                break;
            }
            case "mail_type": {
                Check.MailTypeEnum castedVal = (Check.MailTypeEnum)val;
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
            case "amount": {
                Float castedVal = (Float)val;
                rec.setAmount(castedVal);
                Assert.assertEquals(rec.getAmount(), castedVal);
                break;
            }
            case "bank_account": {
                BankAccount castedVal = (BankAccount)val;
                rec.setBankAccount(castedVal);
                Assert.assertEquals(rec.getBankAccount(), castedVal);
                break;
            }
            case "check_bottom_template_id": {
                String castedVal = (String)val;
                rec.setCheckBottomTemplateId(castedVal);
                Assert.assertEquals(rec.getCheckBottomTemplateId(), castedVal);
                break;
            }
            case "attachment_template_id": {
                String castedVal = (String)val;
                rec.setAttachmentTemplateId(castedVal);
                Assert.assertEquals(rec.getAttachmentTemplateId(), castedVal);
                break;
            }
            case "check_bottom_template_version_id": {
                String castedVal = (String)val;
                rec.setCheckBottomTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getCheckBottomTemplateVersionId(), castedVal);
                break;
            }
            case "attachment_template_version_id": {
                String castedVal = (String)val;
                rec.setAttachmentTemplateVersionId(castedVal);
                Assert.assertEquals(rec.getAttachmentTemplateVersionId(), castedVal);
                break;
            }
            case "url": {
                String castedVal = (String)val;
                rec.setUrl(castedVal);
                Assert.assertEquals(rec.getUrl(), castedVal);
                break;
            }
            case "carrier": {
                Check.CarrierEnum castedVal = (Check.CarrierEnum)val;
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
            case "tracking_events": {
                List<TrackingEventNormal> castedVal = (ArrayList<TrackingEventNormal>)val;
                rec.setTrackingEvents(castedVal);
                Assert.assertEquals(rec.getTrackingEvents(), castedVal);
                break;
            }
            case "object": {
                Check.ObjectEnum castedVal = (Check.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
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
            default:
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void checkTestInvalidId() {
        Check rec = new Check();
        Assert.assertNull(rec.getId());

        try {
            rec.setId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid id provided");
        }
    }

    @Test(enabled=true)
    public void checkTestInvalidCheckBtmTemplateId() {
        Check rec = new Check();
        Assert.assertNull(rec.getCheckBottomTemplateId());

        try {
            rec.setCheckBottomTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid check_bottom_template_id provided");
        }
    }

    @Test(enabled=true)
    public void checkTestInvalidAttachmentTemplateID() {
        Check rec = new Check();
        Assert.assertNull(rec.getAttachmentTemplateId());

        try {
            rec.setAttachmentTemplateId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid attachment_template_id provided");
        }
    }

    @Test(enabled=true)
    public void checkTestInvalidCheckBtmTemplateVersionId() {
        Check rec = new Check();
        Assert.assertNull(rec.getCheckBottomTemplateVersionId());

        try {
            rec.setCheckBottomTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid check_bottom_template_version_id provided");
        }
    }

    @Test(enabled=true)
    public void checkTestInvalidAttachmentTemplateVersionId() {
        Check rec = new Check();
        Assert.assertNull(rec.getAttachmentTemplateVersionId());

        try {
            rec.setAttachmentTemplateVersionId("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid attachment_template_version_id provided");
        }
    }

    @Test(enabled=true)
    public void checkTestInvalidUrl() {
        Check rec = new Check();
        Assert.assertNull(rec.getUrl());

        try {
            rec.setUrl("Nope");
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid url provided");
        }
    }
}

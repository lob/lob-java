package Model;

import org.openapitools.client.model.Card;
import org.openapitools.client.model.Thumbnail;

import org.testng.annotations.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import org.threeten.bp.OffsetDateTime;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;
import Helper.*;

public class CardTest {
    @DataProvider (name = "card-data-provider")
    public Object[][] cardDpMethod() throws Exception {
        String validUrl = new TestFixtures().get_URL_VALID();

        String encodedUrlStr = URLEncoder.encode("some url", StandardCharsets.UTF_8.toString());
        URI encodedUrl = new URI(encodedUrlStr);

        return new Object[][] {
            {"id", "card_fakeId"},
            {"url", new URI(validUrl)},
            {"auto_reorder", true},
            {"auto_reorder", false},
            {"reorder_quantity", 1000},
            {"raw_url", encodedUrl},
            {"front_original_url", encodedUrl},
            {"back_original_url", encodedUrl},
            {"back_original_url", encodedUrl},
            {"thumbnails", new ArrayList<Thumbnail>()},
            {"available_quantity", 1},
            {"pending_quantity", 20},
            {"status", Card.StatusEnum.RENDERED},
            {"status", Card.StatusEnum.PROCESSED},
            {"orientation", Card.OrientationEnum.VERTICAL},
            {"orientation", Card.OrientationEnum.HORIZONTAL},
            {"threshold_amount", 1},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
            {"object", Card.ObjectEnum.CARD},
            {"description", "fake description"},
            {"size", Card.SizeEnum._3_375X2_125},
            {"size", Card.SizeEnum._2_125X3_375},
        };
    }

    @Test(enabled=true, dataProvider = "card-data-provider")
    public void cardTestWithProvidedValue(String prop, Object val) throws Exception {
        Card rec = new Card();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "url": {
                URI castedVal = (URI)val;
                rec.setUrl(castedVal);
                Assert.assertEquals(rec.getUrl(), castedVal);
                break;
            }
            case "auto_reorder": {
                Boolean castedVal = (Boolean)val;
                rec.setAutoReorder(castedVal);
                Assert.assertEquals(rec.getAutoReorder(), castedVal);
                break;
            }
            case "reorder_quantity": {
                Integer castedVal = (Integer)val;
                rec.setReorderQuantity(castedVal);
                Assert.assertEquals(rec.getReorderQuantity(), castedVal);
                break;
            }
            case "raw_url": {
                URI castedVal = (URI)val;
                rec.setRawUrl(castedVal);
                Assert.assertEquals(rec.getRawUrl(), castedVal);
                break;
            }
            case "front_original_url": {
                URI castedVal = (URI)val;
                rec.setFrontOriginalUrl(castedVal);
                Assert.assertEquals(rec.getFrontOriginalUrl(), castedVal);
                break;
            }
            case "back_original_url": {
                URI castedVal = (URI)val;
                rec.setBackOriginalUrl(castedVal);
                Assert.assertEquals(rec.getBackOriginalUrl(), castedVal);
                break;
            }
            case "thumbnails": {
                List<Thumbnail> castedVal = (ArrayList<Thumbnail>)val;
                rec.setThumbnails(castedVal);
                Assert.assertEquals(rec.getThumbnails(), castedVal);
                break;
            }
            case "available_quantity": {
                Integer castedVal = (Integer)val;
                rec.setAvailableQuantity(castedVal);
                Assert.assertEquals(rec.getAvailableQuantity(), castedVal);
                break;
            }
            case "pending_quantity": {
                Integer castedVal = (Integer)val;
                rec.setPendingQuantity(castedVal);
                Assert.assertEquals(rec.getPendingQuantity(), castedVal);
                break;
            }
            case "status": {
                Card.StatusEnum castedVal = (Card.StatusEnum)val;
                rec.setStatus(castedVal);
                Assert.assertEquals(rec.getStatus(), castedVal);
                break;
            }
            case "orientation": {
                Card.OrientationEnum castedVal = (Card.OrientationEnum)val;
                rec.setOrientation(castedVal);
                Assert.assertEquals(rec.getOrientation(), castedVal);
                break;
            }
            case "threshold_amount": {
                Integer castedVal = (Integer)val;
                rec.setThresholdAmount(castedVal);
                Assert.assertEquals(rec.getThresholdAmount(), castedVal);
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
                Card.ObjectEnum castedVal = (Card.ObjectEnum)val;
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
            case "size": {
                Card.SizeEnum castedVal = (Card.SizeEnum)val;
                rec.setSize(castedVal);
                Assert.assertEquals(rec.getSize(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void cardTestCatchesInvalidId() {
        Card rec = new Card();
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

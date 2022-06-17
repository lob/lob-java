package Model;

import com.lob.model.CardOrder;

import java.time.OffsetDateTime;
import java.math.BigDecimal;

import org.testng.annotations.*;
import org.testng.Assert;

public class CardOrderTest {
    @DataProvider (name = "card-order-data-provider")
    public Object[][] cardOrderDpMethod() {
        return new Object[][] {
            {"id", "co_fakeId"},
            {"card_id", "card_fakeId"},
            {"status", CardOrder.StatusEnum.CANCELLED},
            {"status", CardOrder.StatusEnum.DEPLETED},
            {"status", CardOrder.StatusEnum.PENDING},
            {"status", CardOrder.StatusEnum.AVAILABLE},
            {"status", CardOrder.StatusEnum.PRINTING},
            {"inventory", new BigDecimal("17")},
            {"quantity_ordered", new BigDecimal("42")},
            {"unit_price", new BigDecimal("100")},
            {"cancelled_reason", "fake reason"},
            {"availability_date", OffsetDateTime.now()},
            {"expected_availability_date", OffsetDateTime.now()},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"deleted", true},
            {"deleted", false},
            {"object", "CardOrder"},
        };
    }

    @Test(enabled=true, dataProvider = "card-order-data-provider")
    public void cardOrderTestWithProvidedValue(String prop, Object val) throws Exception {
        CardOrder rec = new CardOrder();

        switch (prop) {
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
                break;
            }
            case "card_id": {
                String castedVal = (String)val;
                rec.setCardId(castedVal);
                Assert.assertEquals(rec.getCardId(), castedVal);
                break;
            }
            case "status": {
                CardOrder.StatusEnum castedVal = (CardOrder.StatusEnum)val;
                rec.setStatus(castedVal);
                Assert.assertEquals(rec.getStatus(), castedVal);
                break;
            }
            case "inventory": {
                BigDecimal castedVal = (BigDecimal)val;
                rec.setInventory(castedVal);
                Assert.assertEquals(rec.getInventory(), castedVal);
                break;
            }
            case "quantity_ordered": {
                BigDecimal castedVal = (BigDecimal)val;
                rec.setQuantityOrdered(castedVal);
                Assert.assertEquals(rec.getQuantityOrdered(), castedVal);
                break;
            }
            case "unit_price": {
                BigDecimal castedVal = (BigDecimal)val;
                rec.setUnitPrice(castedVal);
                Assert.assertEquals(rec.getUnitPrice(), castedVal);
                break;
            }
            case "cancelled_reason": {
                String castedVal = (String)val;
                rec.setCancelledReason(castedVal);
                Assert.assertEquals(rec.getCancelledReason(), castedVal);
                break;
            }
            case "availability_date": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setAvailabilityDate(castedVal);
                Assert.assertEquals(rec.getAvailabilityDate(), castedVal);
                break;
            }
            case "expected_availability_date": {
                OffsetDateTime castedVal = (OffsetDateTime)val;
                rec.setExpectedAvailabilityDate(castedVal);
                Assert.assertEquals(rec.getExpectedAvailabilityDate(), castedVal);
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
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void cardOrderTestCatchesInvalidId() {
        CardOrder rec = new CardOrder();
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
    public void cardOrderTestCatchesInvalidCardId() {
        CardOrder rec = new CardOrder();
        Assert.assertNull(rec.getCardId());

        String invalidValue = "Nope";
        try {
            rec.setCardId(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid card_id provided");
        }
    }
}

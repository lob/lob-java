package Model;

import org.openapitools.client.model.BillingGroup;

import org.threeten.bp.OffsetDateTime;

import org.testng.annotations.*;
import org.testng.Assert;

public class BillingGroupTest {
    @DataProvider (name = "billing-group-data-provider")
    public Object[][] billingGroupDpMethod() {
        return new Object[][] {
            {"description", "fake description"},
            {"name", "fake name"},
            {"id", "bg_fakeId"},
            {"date_created", OffsetDateTime.now()},
            {"date_modified", OffsetDateTime.now()},
            {"object", BillingGroup.ObjectEnum.BILLING_GROUP},
        };
    }

    @Test(enabled=true, dataProvider = "billing-group-data-provider")
    public void billingGroupTestWithProvidedValue(String prop, Object val) throws Exception {
        BillingGroup rec = new BillingGroup();

        switch (prop) {
            case "description": {
                String castedVal = (String)val;
                rec.setDescription(castedVal);
                Assert.assertEquals(rec.getDescription(), castedVal);
                break;
            }
            case "name": {
                String castedVal = (String)val;
                rec.setName(castedVal);
                Assert.assertEquals(rec.getName(), castedVal);
                break;
            }
            case "id": {
                String castedVal = (String)val;
                rec.setId(castedVal);
                Assert.assertEquals(rec.getId(), castedVal);
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
            case "object": {
                BillingGroup.ObjectEnum castedVal = (BillingGroup.ObjectEnum)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void billingGroupTestCatchesInvalidId() {
        BillingGroup rec = new BillingGroup();
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

package Model;

import org.openapitools.client.model.BillingGroupList;
import org.openapitools.client.model.BillingGroup;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class BillingGroupListTest {
    @DataProvider (name = "billing-group-list-data-provider")
    public Object[][] billingGroupListDpMethod() {
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
        };
    }

    @Test(enabled=true, dataProvider = "billing-group-list-data-provider")
    public void billingGroupListTestWithProvidedValue(String prop, Object val) throws Exception {
        BillingGroupList rec = new BillingGroupList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<BillingGroup> castedVal = (ArrayList<BillingGroup>)val;
                rec.setData(castedVal);
                // Assert.assertEquals(rec.getData(), castedVal); // TODO: DXP-920
                break;
            }
            case "next_url": {
                String castedVal = (String)val;
                rec.setNextUrl(castedVal);
                Assert.assertEquals(rec.getNextUrl(), castedVal);
                break;
            }
            case "previous_url": {
                String castedVal = (String)val;
                rec.setPreviousUrl(castedVal);
                Assert.assertEquals(rec.getPreviousUrl(), castedVal);
                break;
            }
            case "count": {
                Integer castedVal = (Integer)val;
                rec.setCount(castedVal);
                Assert.assertEquals(rec.getCount(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void billingGroupListNextPageTokenGetterTest() {
        BillingGroupList rec = new BillingGroupList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");
        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void billingGroupListNextPageTokenGetterTestMisingVal() {
        BillingGroupList rec = new BillingGroupList();
        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void billingGroupListPrevPageTokenGetterTest() {
        BillingGroupList rec = new BillingGroupList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");
        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void billingGroupListPrevPageTokenGetterTestMisingVal() {
        BillingGroupList rec = new BillingGroupList();
        Assert.assertNull(rec.getPreviousPageToken());
    }
}

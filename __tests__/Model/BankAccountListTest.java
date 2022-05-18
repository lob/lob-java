package Model;

import org.openapitools.client.model.BankAccountList;
import org.openapitools.client.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class BankAccountListTest {
    @DataProvider (name = "bank-account-list-data-provider")
    public Object[][] bankAccountListDpMethod() {
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<BankAccount>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider = "bank-account-list-data-provider")
    public void bankAccountListTestWithProvidedValue(String prop, Object val) throws Exception {
        BankAccountList rec = new BankAccountList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<BankAccount> castedVal = (List<BankAccount>)val;
                rec.setData(castedVal);
                Assert.assertEquals(rec.getData(), castedVal);
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
            case "total_count": {
                Integer castedVal = (Integer)val;
                rec.setTotalCount(castedVal);
                Assert.assertEquals(rec.getTotalCount(), castedVal);
                break;
            }
            default:
                throw new Exception("Wrong prop name: " + prop);
        }
    }

    @Test(enabled=true)
    public void bankAccountListNextPageTokenGetterTest() {
        BankAccountList rec = new BankAccountList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");
        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void bankAccountListNextPageTokenGetterTestMisingVal() {
        BankAccountList rec = new BankAccountList();
        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void bankAccountListPrevPageTokenGetterTest() {
        BankAccountList rec = new BankAccountList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");
        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void bankAccountListPrevPageTokenGetterTestMisingVal() {
        BankAccountList rec = new BankAccountList();
        Assert.assertNull(rec.getPreviousPageToken());
    }
}

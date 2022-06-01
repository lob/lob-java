package Model;

import com.lob.model.CardList;
import com.lob.model.Card;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class CardListTest {
    @DataProvider (name = "card-list-data-provider")
    public Object[][] cardListDpMethod() {
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<Card>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider = "card-list-data-provider")
    public void cardListTestWithProvidedValue(String prop, Object val) throws Exception {
        CardList rec = new CardList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<Card> castedVal = (ArrayList<Card>)val;
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
    public void cardListNextPageTokenGetterTest() {
        CardList rec = new CardList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");
        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void cardListNextPageTokenGetterTestMisingVal() {
        CardList rec = new CardList();
        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void checkListPrevPageTokenGetterTest() {
        CardList rec = new CardList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");
        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void cardListPrevPageTokenGetterTestMisingVal() {
        CardList rec = new CardList();
        Assert.assertNull(rec.getPreviousPageToken());
    }
}

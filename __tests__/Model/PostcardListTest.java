package Model;

import org.openapitools.client.model.PostcardList;
import org.openapitools.client.model.Postcard;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class PostcardListTest {
    @DataProvider (name = "postcard-list-data-provider")
    public Object[][] postcardListDpMethod(){
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<Postcard>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider = "postcard-list-data-provider")
    public void postcardListTestWithProvidedValue(String prop, Object val) throws Exception {
        PostcardList rec = new PostcardList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<Postcard> castedVal = (ArrayList<Postcard>)val;
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
    public void postcardListNextPageTokenGetterTest() {
        PostcardList rec = new PostcardList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");
        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void postcardListNextPageTokenGetterTestMisingVal() {
        PostcardList rec = new PostcardList();
        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void postcardListPrevPageTokenGetterTest() {
        PostcardList rec = new PostcardList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");
        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void postcardListPrevPageTokenGetterTestMisingVal() {
        PostcardList rec = new PostcardList();
        Assert.assertNull(rec.getPreviousPageToken());
    }
}

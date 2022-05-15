package Model;

import org.openapitools.client.model.LetterList;
import org.openapitools.client.model.Letter;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class LetterListTest {
    @DataProvider (name = "letter-list-data-provider")
    public Object[][] letterListDpMethod(){
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<Letter>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider="letter-list-data-provider")
    public void letterListTestWithProvidedValue(String prop, Object val) throws Exception {
        LetterList rec = new LetterList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<Letter> castedVal = (ArrayList<Letter>)val;
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
                throw new Exception("Wrong prop name");
        }
    }

    @Test(enabled=true)
    public void letterListNextPageTokenGetterTest() {
        LetterList rec = new LetterList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");

        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void letterListNextPageTokenGetterTestMissingNextURL() {
        LetterList rec = new LetterList();
        rec.setNextUrl(null);

        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void letterListPrevPageTokenGetterTest() {
        LetterList rec = new LetterList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");

        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void letterListPrevPageTokenGetterTestMissingNextURL() {
        LetterList rec = new LetterList();
        rec.setPreviousUrl(null);

        Assert.assertNull(rec.getPreviousPageToken());
    }
}

package Model;

import org.openapitools.client.model.CheckList;
import org.openapitools.client.model.Check;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

@SuppressWarnings("unchecked")
public class CheckListTest {
    @DataProvider (name = "check-list-data-provider")
    public Object[][] checkListAnalysisDpMethod(){
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<Check>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider = "check-list-data-provider")
    public void checkListTestWithProvidedValue(String prop, Object val) throws Exception {
        CheckList rec = new CheckList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<Check> castedVal = (ArrayList<Check>)val;
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
    public void checkListNextPageTokenGetterTest() {
        CheckList rec = new CheckList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");

        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void checkListPrevPageTokenGetterTest() {
        CheckList rec = new CheckList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");

        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }
}

package Model;

import org.openapitools.client.model.TemplateList;
import org.openapitools.client.model.Template;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateListTest {
    @DataProvider (name = "template-list-data-provider")
    public Object[][] templateListDpMethod(){
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<TemplateList>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider = "template-list-data-provider")
    public void templateListTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateList rec = new TemplateList();

        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<Template> castedVal = (ArrayList<Template>)val;
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
    public void templateListNextPageTokenGetterTest() {
        TemplateList rec = new TemplateList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");
        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void templateListNextPageTokenGetterTestMisingVal() {
        TemplateList rec = new TemplateList();
        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void templateListPrevPageTokenGetterTest() {
        TemplateList rec = new TemplateList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");
        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void templateListPrevPageTokenGetterTestMisingVal() {
        TemplateList rec = new TemplateList();
        Assert.assertNull(rec.getPreviousPageToken());
    }
}

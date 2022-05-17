package Model;

import org.openapitools.client.model.TemplateVersionList;
import org.openapitools.client.model.TemplateVersion;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class TemplateVersionListTest {
    @DataProvider (name = "template-version-data-provider")
    public Object[][] templateVersionDpMethod(){
        return new Object[][] {
            {"object", "Address"},
            {"data", new ArrayList<TemplateVersion>()},
            {"next_url", "some url"},
            {"previous_url", "some url"},
            {"count", 1},
            {"total_count", 100},
        };
    }

    @Test(enabled=true, dataProvider = "template-version-data-provider")
    public void templateVersionTestWithProvidedValue(String prop, Object val) throws Exception {
        TemplateVersionList rec = new TemplateVersionList();
        switch (prop) {
            case "object": {
                String castedVal = (String)val;
                rec.setObject(castedVal);
                Assert.assertEquals(rec.getObject(), castedVal);
                break;
            }
            case "data": {
                List<TemplateVersion> castedVal = (ArrayList<TemplateVersion>)val;
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
    public void templateVersionListNextPageTokenGetterTest() {
        TemplateVersionList rec = new TemplateVersionList();
        rec.setNextUrl("https://fake.com?param1=example&after=token");
        Assert.assertEquals(rec.getNextPageToken(), "token");
    }

    @Test(enabled=true)
    public void templateVersionListNextPageTokenGetterTestMisingVal() {
        TemplateVersionList rec = new TemplateVersionList();
        Assert.assertNull(rec.getNextPageToken());
    }

    @Test(enabled=true)
    public void templateVersionListPrevPageTokenGetterTest() {
        TemplateVersionList rec = new TemplateVersionList();
        rec.setPreviousUrl("https://fake.com?param1=example&before=token");
        Assert.assertEquals(rec.getPreviousPageToken(), "token");
    }

    @Test(enabled=true)
    public void templateVersionListPrevPageTokenGetterTestMisingVal() {
        TemplateVersionList rec = new TemplateVersionList();
        Assert.assertNull(rec.getPreviousPageToken());
    }
}

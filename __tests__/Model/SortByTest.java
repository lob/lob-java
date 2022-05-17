package Model;

import org.openapitools.client.model.SortBy;

import org.testng.annotations.*;
import org.testng.Assert;

public class SortByTest {
    @DataProvider (name = "sort-by-data-provider")
    public Object[][] sortByDpMethod(){
        return new Object[][] {
            {"date_created", SortBy.DateCreatedEnum.ASC},
            {"date_created", SortBy.DateCreatedEnum.DESC},
            {"send_date", SortBy.SendDateEnum.ASC},
            {"send_date", SortBy.SendDateEnum.DESC},
        };
    }

    @Test(enabled=true, dataProvider = "sort-by-data-provider")
    public void sortByTestWithProvidedValue(String prop, Object val) {
        SortBy rec = new SortBy();

        if (prop == "date_created") {
            SortBy.DateCreatedEnum castedVal = (SortBy.DateCreatedEnum)val;
            rec.setDateCreated(castedVal);
            Assert.assertEquals(rec.getDateCreated(), castedVal);
        } else {
            SortBy.SendDateEnum castedVal = (SortBy.SendDateEnum)val;
            rec.setSendDate(castedVal);
            Assert.assertEquals(rec.getSendDate(), castedVal);
        }
    }
}

package Model;

import org.openapitools.client.model.SortBy1;

import org.testng.annotations.*;
import org.testng.Assert;

public class SortBy1Test {
    @DataProvider (name = "sort-by-1-data-provider")
    public Object[][] sortBy1DpMethod(){
        return new Object[][] {
            {"date_created", SortBy1.DateCreatedEnum.ASC},
            {"date_created", SortBy1.DateCreatedEnum.DESC},
            {"send_date", SortBy1.SendDateEnum.ASC},
            {"send_date", SortBy1.SendDateEnum.DESC},
        };
    }

    @Test(enabled=true, dataProvider = "sort-by-1-data-provider")
    public void sortBy1TestWithProvidedValue(String prop, Object val) {
        SortBy1 rec = new SortBy1();

        if (prop == "date_created") {
            SortBy1.DateCreatedEnum castedVal = (SortBy1.DateCreatedEnum)val;
            rec.setDateCreated(castedVal);
            Assert.assertEquals(rec.getDateCreated(), castedVal);
        } else {
            SortBy1.SendDateEnum castedVal = (SortBy1.SendDateEnum)val;
            rec.setSendDate(castedVal);
            Assert.assertEquals(rec.getSendDate(), castedVal);
        }
    }
}

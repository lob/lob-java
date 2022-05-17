package Model;

import org.openapitools.client.model.SortBy5;

import org.testng.annotations.*;
import org.testng.Assert;

public class SortBy5Test {
    @DataProvider (name = "sort-by-5-data-provider")
    public Object[][] SortBy5DpMethod(){
        return new Object[][] {
            {"date_created", SortBy5.DateCreatedEnum.ASC},
            {"date_created", SortBy5.DateCreatedEnum.DESC},
            {"send_date", SortBy5.SendDateEnum.ASC},
            {"send_date", SortBy5.SendDateEnum.DESC},
        };
    }

    @Test(enabled=true, dataProvider = "sort-by-5-data-provider")
    public void SortBy5TestWithProvidedValue(String prop, Object val) {
        SortBy5 rec = new SortBy5();

        if (prop == "date_created") {
            SortBy5.DateCreatedEnum castedVal = (SortBy5.DateCreatedEnum)val;
            rec.setDateCreated(castedVal);
            Assert.assertEquals(rec.getDateCreated(), castedVal);
        } else {
            SortBy5.SendDateEnum castedVal = (SortBy5.SendDateEnum)val;
            rec.setSendDate(castedVal);
            Assert.assertEquals(rec.getSendDate(), castedVal);
        }
    }
}

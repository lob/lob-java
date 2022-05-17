package Model;

import org.openapitools.client.model.SortBy3;

import org.testng.annotations.*;
import org.testng.Assert;

public class SortBy3Test {
    @DataProvider (name = "sort-by-3-data-provider")
    public Object[][] SortBy3DpMethod(){
        return new Object[][] {
            {"date_created", SortBy3.DateCreatedEnum.ASC},
            {"date_created", SortBy3.DateCreatedEnum.DESC},
            {"send_date", SortBy3.SendDateEnum.ASC},
            {"send_date", SortBy3.SendDateEnum.DESC},
        };
    }

    @Test(enabled=true, dataProvider = "sort-by-3-data-provider")
    public void SortBy3TestWithProvidedValue(String prop, Object val) {
        SortBy3 rec = new SortBy3();

        if (prop == "date_created") {
            SortBy3.DateCreatedEnum castedVal = (SortBy3.DateCreatedEnum)val;
            rec.setDateCreated(castedVal);
            Assert.assertEquals(rec.getDateCreated(), castedVal);
        } else {
            SortBy3.SendDateEnum castedVal = (SortBy3.SendDateEnum)val;
            rec.setSendDate(castedVal);
            Assert.assertEquals(rec.getSendDate(), castedVal);
        }
    }
}

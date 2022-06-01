package Model;

import com.lob.model.SortBy4;

import org.testng.annotations.*;
import org.testng.Assert;

public class SortBy4Test {
    @DataProvider (name = "sort-by-4-data-provider")
    public Object[][] SortBy4DpMethod(){
        return new Object[][] {
            {"date_created", SortBy4.DateCreatedEnum.ASC},
            {"date_created", SortBy4.DateCreatedEnum.DESC},
            {"send_date", SortBy4.SendDateEnum.ASC},
            {"send_date", SortBy4.SendDateEnum.DESC},
        };
    }

    @Test(enabled=true, dataProvider = "sort-by-4-data-provider")
    public void SortBy4TestWithProvidedValue(String prop, Object val) {
        SortBy4 rec = new SortBy4();

        if (prop == "date_created") {
            SortBy4.DateCreatedEnum castedVal = (SortBy4.DateCreatedEnum)val;
            rec.setDateCreated(castedVal);
            Assert.assertEquals(rec.getDateCreated(), castedVal);
        } else {
            SortBy4.SendDateEnum castedVal = (SortBy4.SendDateEnum)val;
            rec.setSendDate(castedVal);
            Assert.assertEquals(rec.getSendDate(), castedVal);
        }
    }
}

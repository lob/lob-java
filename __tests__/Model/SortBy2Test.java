package Model;

import com.lob.model.SortBy2;

import org.testng.annotations.*;
import org.testng.Assert;

public class SortBy2Test {
    @DataProvider (name = "sort-by-2-data-provider")
    public Object[][] SortBy2DpMethod(){
        return new Object[][] {
            {"date_created", SortBy2.DateCreatedEnum.ASC},
            {"date_created", SortBy2.DateCreatedEnum.DESC},
            {"send_date", SortBy2.SendDateEnum.ASC},
            {"send_date", SortBy2.SendDateEnum.DESC},
        };
    }

    @Test(enabled=true, dataProvider = "sort-by-2-data-provider")
    public void SortBy2TestWithProvidedValue(String prop, Object val) {
        SortBy2 rec = new SortBy2();

        if (prop == "date_created") {
            SortBy2.DateCreatedEnum castedVal = (SortBy2.DateCreatedEnum)val;
            rec.setDateCreated(castedVal);
            Assert.assertEquals(rec.getDateCreated(), castedVal);
        } else {
            SortBy2.SendDateEnum castedVal = (SortBy2.SendDateEnum)val;
            rec.setSendDate(castedVal);
            Assert.assertEquals(rec.getSendDate(), castedVal);
        }
    }
}

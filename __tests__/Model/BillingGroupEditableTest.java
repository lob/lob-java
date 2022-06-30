package Model;

import com.lob.model.BillingGroupEditable;

import org.testng.annotations.*;
import org.testng.Assert;

public class BillingGroupEditableTest {
    @Test(enabled=true)
    public void billingGroupEditableTestWithProvidedValue() {
        BillingGroupEditable rec1 = new BillingGroupEditable();

        String testVal1 = "fake description";
        rec1.setDescription(testVal1);
        Assert.assertEquals(rec1.getDescription(), testVal1);

        BillingGroupEditable rec2 = new BillingGroupEditable();

        String testVal2 = "fake name";
        rec2.setName(testVal2);
        Assert.assertEquals(rec2.getName(), testVal2);
    }
}

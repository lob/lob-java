package Model;

import com.lob.model.BankAccountVerify;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class BankAccountVerifyTest {
    @Test(enabled=true)
    public void bankAccountVerifyTest() {
        BankAccountVerify rec = new BankAccountVerify();

        List<Integer> amounts = new ArrayList<Integer>();
        amounts.add(1);
        amounts.add(2);
        rec.setAmounts(amounts);
        Assert.assertEquals(rec.getAmounts(), amounts);
    }
}

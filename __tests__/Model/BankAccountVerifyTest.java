package Model;

import com.lob.model.BankAccountVerify;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.*;
import org.testng.Assert;

public class BankAccountVerifyTest {
    @Test(enabled=true)
    public void bankAccountVerifyWithAmountsTest() {
        BankAccountVerify rec = new BankAccountVerify();

        List<Integer> amounts = new ArrayList<Integer>();
        amounts.add(1);
        amounts.add(2);
        rec.setAmounts(amounts);
        Assert.assertEquals(rec.getAmounts(), amounts);
        Assert.assertNull(rec.getDescriptorCode());
        Assert.assertTrue(rec.isValid());
    }

    @Test(enabled=true)
    public void bankAccountVerifyWithDescriptorCodeTest() {
        BankAccountVerify rec = new BankAccountVerify();
        rec.setDescriptorCode("SM11AA");
        Assert.assertEquals(rec.getDescriptorCode(), "SM11AA");
        Assert.assertNull(rec.getAmounts());
        Assert.assertTrue(rec.isValid());
    }

    @Test(enabled=true)
    public void bankAccountVerifyInvalidWhenNeitherSetTest() {
        BankAccountVerify rec = new BankAccountVerify();
        Assert.assertFalse(rec.isValid());
    }

    @Test(enabled=true)
    public void bankAccountVerifyInvalidWhenBothSetTest() {
        BankAccountVerify rec = new BankAccountVerify();
        List<Integer> amounts = new ArrayList<Integer>();
        amounts.add(1);
        amounts.add(2);
        rec.setAmounts(amounts);
        rec.setDescriptorCode("SM11AA");
        Assert.assertFalse(rec.isValid());
    }

    @Test(enabled=true, expectedExceptions = {IllegalArgumentException.class})
    public void bankAccountVerifyInvalidDescriptorCodePatternTest() {
        BankAccountVerify rec = new BankAccountVerify();
        rec.setDescriptorCode("INVALID");
    }

    @Test(enabled=true, expectedExceptions = {IllegalArgumentException.class})
    public void bankAccountVerifyDescriptorCodeTooShortTest() {
        BankAccountVerify rec = new BankAccountVerify();
        rec.setDescriptorCode("SM1");
    }
}

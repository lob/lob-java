package Model;

import com.lob.model.IntlVerificationsPayload;
import com.lob.model.MultipleComponentsIntl;

import java.util.List;
import java.util.ArrayList;

import org.testng.annotations.*;
import org.testng.Assert;

public class IntlVerificationsPayloadTest {
    @Test(enabled=true)
    public void intlVerificationsTestWithProvidedValue() {
        IntlVerificationsPayload rec = new IntlVerificationsPayload();
        List<MultipleComponentsIntl> addresses = new ArrayList<MultipleComponentsIntl>();
        addresses.add(new MultipleComponentsIntl());
        rec.setAddresses(addresses);

        Assert.assertEquals(rec.getAddresses(), addresses);
    }
}

package Model;

import org.openapitools.client.model.MultipleComponentsList;
import org.openapitools.client.model.MultipleComponents;

import org.testng.annotations.*;
import org.testng.Assert;

import java.util.List;
import java.util.ArrayList;

public class MultipleComponentsListTest {
    @Test(enabled=true)
    public void multipleComponentsTestWithProvidedValue() {
        MultipleComponentsList rec = new MultipleComponentsList();
        List<MultipleComponents> addresses = new ArrayList<MultipleComponents>();
        addresses.add(new MultipleComponents());
        rec.setAddresses(addresses);

        // Assert.assertEquals(rec.getAddresses(), addresses); // TODO: DXP-920
    }
}

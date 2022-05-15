package Model;

import java.util.ArrayList;
import java.util.List;


import org.openapitools.client.model.AddressList;
import org.openapitools.client.model.Address;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressListTest {
    private final AddressList model = new AddressList();

    @Test
    public void testAddressList() {
        
        Assert.assertNotNull(model);

    }

    @Test
    public void dataTest() {
        List<Address> data = new ArrayList<Address>();

        model.setData(data);
        Assert.assertEquals(model.getData(), data);
    }

    @Test
    public void _objectTest() {

        model.setObject("Address");
        
        Assert.assertNotNull(model.getObject());
        Assert.assertEquals(model.getObject(), "Address");
    }

    @Test
    public void nextUrlTest() {

        model.setNextUrl("some url"); 
        
        Assert.assertNotNull(model.getNextUrl());
        Assert.assertEquals(model.getNextUrl(), "some url");
    }

    @Test
    public void previousUrlTest() {

        model.setPreviousUrl("some url"); 
        
        Assert.assertNotNull(model.getPreviousUrl());
        Assert.assertEquals(model.getPreviousUrl(), "some url");
    }

    @Test
    public void countTest() {
        Integer count = 1;

        model.setCount(count); 
        
        Assert.assertNotNull(model.getCount());
        Assert.assertEquals(model.getCount(), count);
    }

    @Test
    public void totalCountTest() {
        Integer totalCount = 100;
        model.setTotalCount(totalCount); 
        
        Assert.assertNotNull(model.getTotalCount());
        Assert.assertEquals(model.getTotalCount(), totalCount);
    }

}

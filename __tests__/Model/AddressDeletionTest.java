package Model;

import com.lob.model.AddressDeletion;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddressDeletionTest {
    private final AddressDeletion model = new AddressDeletion();

    @Test(enabled=true)
    public void testAddressDeletion() {
        AddressDeletion addressDeletion = new AddressDeletion();
        Boolean deleted = true;
        model.setId("adr_fakeId");
        model.setDeleted(deleted);
    
        Assert.assertNotNull(addressDeletion);
        Assert.assertNotNull(model.getId());
        Assert.assertNotNull( model.getDeleted());
        Assert.assertNotNull(model.getObject());
        Assert.assertEquals(model.getId(), "adr_fakeId");
        Assert.assertEquals(model.getDeleted(), deleted);
    }

    
    @Test(enabled=true)
    public void idTest() {
        AddressDeletion addressDeletion = new AddressDeletion();

        Assert.assertNull(addressDeletion.getId());
       
        
    }

    @Test(enabled=true,  expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = "Invalid id provided")
    public void idTestCatchesException() throws IllegalArgumentException {
        AddressDeletion addressDeletion= new AddressDeletion();

        addressDeletion.setId("Nope");
    }
    
    @Test(enabled=true)
    public void deletedTest() {
        AddressDeletion addressDeletion = new AddressDeletion();
       

        Assert.assertNull(addressDeletion.getDeleted());
       
    }

    @Test(enabled=true)
    public void _objectTest() {
        AddressDeletion addressDeletion = new AddressDeletion();
        AddressDeletion.ObjectEnum object = AddressDeletion.ObjectEnum.ADDRESS_DELETED;

        Assert.assertNotNull(addressDeletion.getObject());
        Assert.assertEquals(addressDeletion.getObject(), object);
    }

}

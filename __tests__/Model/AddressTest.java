package Model;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;

import com.lob.model.Address;
import com.lob.model.CountryExtendedExpanded;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AddressTest {
    private final Address model = new Address();

    @Test
    public void testAddress() {

        Assert.assertNotNull(model);

    }

    @Test
    public void idTest() {

        model.setId("adr_fakeId");

        Assert.assertNotNull(model.getId());
        Assert.assertEquals(model.getId(), "adr_fakeId" );

    }

    @Test
    public void descriptionTest() {

        model.setDescription("fake description");

        Assert.assertNotNull(model.getDescription());
        Assert.assertEquals(model.getDescription(), "fake description" );

    }

    @Test
    public void nameTest() {

        model.setName("fake description");

        Assert.assertNotNull(model.getName());
        Assert.assertEquals(model.getName(), "fake description" );

    }

    @Test
    public void companyTest() {

        model.setCompany("fake company");

        Assert.assertNotNull(model.getCompany());
        Assert.assertEquals(model.getCompany(), "fake company" );
     
    }

    @Test
    public void phoneTest() {

        model.setPhone("000-000-0000");

        Assert.assertNotNull(model.getPhone());
        Assert.assertEquals(model.getPhone(), "000-000-0000" );
      
    }

    @Test
    public void emailTest() {

        model.setEmail("fake@gmail.com");

        Assert.assertNotNull(model.getEmail());
        Assert.assertEquals(model.getEmail(), "fake@gmail.com" );
        
    }

    @Test
    public void metadataTest() {
        Map<String, String> map = Collections.emptyMap();

        model.setMetadata(map);

        Assert.assertEquals(model.getMetadata(), map);
    }

    @Test
    public void addressLine1Test() {

        model.setAddressLine1("address line 1");

        Assert.assertNotNull(model.getAddressLine1());
        Assert.assertEquals(model.getAddressLine1(), "address line 1");
  
    }

    @Test
    public void addressLine2Test() {

        model.setAddressLine2("address line 2");

        Assert.assertNotNull(model.getAddressLine2());
        Assert.assertEquals(model.getAddressLine2(), "address line 2");
       
    }

    @Test
    public void addressCityTest() {

        model.setAddressCity("Some City");

        Assert.assertNotNull(model.getAddressCity());
        Assert.assertEquals(model.getAddressCity(), "Some City");
       
    }

    @Test
    public void addressStateTest() {

        model.setAddressState("CA");

        Assert.assertNotNull(model.getAddressState());
        Assert.assertEquals(model.getAddressState(), "CA");
       
    }

    @Test
    public void addressZipTest() {
    
        model.setAddressZip("11111");

        Assert.assertNotNull(model.getAddressZip());
        Assert.assertEquals(model.getAddressZip(), "11111");

    }

    @Test
    public void addressCountryTest() {
        CountryExtendedExpanded US = CountryExtendedExpanded.UNITED_STATES;

        model.setAddressCountry(US);

        Assert.assertNotNull(model.getAddressCountry());
        Assert.assertEquals(model.getAddressCountry(), US);
     
    }

    @Test
    public void _objectTest() {
        Address.ObjectEnum object = Address.ObjectEnum.ADDRESS;

        model.setObject(object);

        Assert.assertNotNull(model.getObject());
        Assert.assertEquals(model.getObject(), object);

    }

    @Test
    public void dateCreatedTest() {
        OffsetDateTime date = OffsetDateTime.now();
         

        model.setDateCreated(date);

        Assert.assertNotNull(model.getDateCreated());
        Assert.assertEquals(model.getDateCreated(), date);

    }

    @Test
    public void dateModifiedTest() {
        OffsetDateTime date = OffsetDateTime.now();


        model.setDateModified(date);

        Assert.assertNotNull(model.getDateModified());
        Assert.assertEquals(model.getDateModified(), date);
    }

    @Test
    public void deletedTest() {
        Boolean deleted = true;

        model.setDeleted(true);

        Assert.assertNotNull(model.getDeleted());
        Assert.assertEquals(model.getDeleted(), deleted);
        
    }

    @Test
    public void notDeletedTest() {
        Boolean deleted = false;

        model.setDeleted(deleted);

        Assert.assertNotNull(model.getDeleted());
        Assert.assertEquals(model.getDeleted(), deleted);
    }

    @Test
    public void recipientMovedTest() {
        Boolean moved = true;


        model.setRecipientMoved(moved);

        Assert.assertNotNull(model.getRecipientMoved());
        Assert.assertEquals(model.getRecipientMoved(), moved);
    }

    @Test
    public void recipientMovedFalseTest() {
        Boolean moved = false;

        model.setDeleted(moved);

        Assert.assertNotNull(model.getDeleted());
        Assert.assertEquals(model.getDeleted(), moved);
    }

}

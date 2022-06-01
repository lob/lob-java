package Model;

import java.util.Collections;
import java.util.Map;


import com.lob.model.AddressEditable;
import com.lob.model.CountryExtended;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddressEditableTest {
    private final AddressEditable model = new AddressEditable();

    @Test(enabled = true)
    public void testAddressEditable() {

        Assert.assertNotNull(model);
    }

    @Test
    public void addressLine1Test() {

        model.setAddressLine1("addressLine1");

        Assert.assertNotNull(model.getAddressLine1());
        Assert.assertEquals(model.getAddressLine1(),"addressLine1");
    }
    
    @Test
    public void addressLine2Test() {

        model.setAddressLine2("addressLine2");

        Assert.assertNotNull(model.getAddressLine2());
        Assert.assertEquals(model.getAddressLine2(),"addressLine2");
    }

    @Test
    public void addressCityTest() {

        model.setAddressCity("Some City");

        Assert.assertNotNull(model.getAddressCity());
        Assert.assertEquals(model.getAddressCity(),"Some City");
    }

    @Test
    public void addressStateTest() {

        model.setAddressCity("Some City");

        Assert.assertNotNull(model.getAddressCity());
        Assert.assertEquals(model.getAddressCity(),"Some City");
    }

    @Test
    public void addressZipTest() {

        model.setAddressZip("11111");

        Assert.assertNotNull(model.getAddressZip());
        Assert.assertEquals(model.getAddressZip(),"11111");
    }

    @Test
    public void addressCountryTest() {

        CountryExtended US = CountryExtended.US;
        
        model.setAddressCountry(US);

        Assert.assertNotNull(model.getAddressCountry());
        Assert.assertEquals(model.getAddressCountry(),US);
    }

    @Test
    public void descriptionTest() {

        model.setDescription("description");

        Assert.assertNotNull(model.getDescription());
        Assert.assertEquals(model.getDescription(),"description"); 
    }

    @Test
    public void nameTest() {

        model.setName("fake name");

        Assert.assertNotNull(model.getName());
        Assert.assertEquals(model.getName(),"fake name");
    }

    @Test
    public void companyTest() {

        model.setCompany("fake company");

        Assert.assertNotNull(model.getCompany());
        Assert.assertEquals(model.getCompany(),"fake company");
    }

    @Test
    public void phoneTest() {

        model.setPhone("000-000-0000");

        Assert.assertNotNull(model.getPhone());
        Assert.assertEquals(model.getPhone(), "000-000-0000"); 
    }

    @Test
    public void emailTest() {

        model.setEmail("fake@email.com");

        Assert.assertNotNull(model.getEmail());
        Assert.assertEquals(model.getEmail(), "fake@email.com");
    }

    @Test
    public void metadataTest() {

        Map<String, String> map = Collections.emptyMap();

        model.setMetadata(map);
        Assert.assertEquals(model.getMetadata(), map);
    }

}

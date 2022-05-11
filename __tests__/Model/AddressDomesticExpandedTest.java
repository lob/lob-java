package Model;
import java.util.Collections;
import java.util.Map;

import org.openapitools.client.model.AddressDomesticExpanded;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressDomesticExpandedTest {
    private final AddressDomesticExpanded model = new AddressDomesticExpanded();
    
    @Test
    public void testAddressDomesticExpanded() {
        
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

        model.setAddressCity("someCity");

        Assert.assertNotNull(model.getAddressCity());
        Assert.assertEquals(model.getAddressCity(),"someCity");
    }

    @Test
    public void addressStateTest() {

        model.setAddressState("CA");

        Assert.assertNotNull(model.getAddressState());
        Assert.assertEquals(model.getAddressState(),"CA");
    }

    
    @Test
    public void addressZipTest() {

        model.setAddressZip("11111");

        Assert.assertNotNull(model.getAddressZip());
        Assert.assertEquals(model.getAddressZip(),"11111");
    }

    @Test
    public void descriptionTest() {

        model.setDescription("description");

        Assert.assertNotNull(model.getDescription()); 
        Assert.assertEquals(model.getDescription(),"description");
    }

    @Test
    public void nameTest() {

        model.setName("fake_name");
    
        Assert.assertNotNull(model.getName());
        Assert.assertEquals(model.getName(), "fake_name");
    }

    @Test
    public void companyTest() {

        model.setCompany("fake_company");
    
        Assert.assertNotNull(model.getCompany());
        Assert.assertEquals(model.getCompany(), "fake_company");
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

    @Test(enabled=true)
    public void addressCountryTest() throws IllegalArgumentException {
        AddressDomesticExpanded addressDomesticExpanded = new AddressDomesticExpanded();
        
        Assert.assertNull(addressDomesticExpanded.getAddressCountry());
        
        addressDomesticExpanded.setAddressCountry("UNITED STATES"); 
        
        Assert.assertNotNull(addressDomesticExpanded.getAddressCountry());
        Assert.assertEquals(addressDomesticExpanded.getAddressCountry(), "UNITED STATES");
}

    @Test(enabled=true,  expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = "Invalid address_country provided")
    public void addressCountryTestCatchesExceptiom() {  
        AddressDomesticExpanded addressDomesticExpanded = new AddressDomesticExpanded();

        addressDomesticExpanded.setAddressCountry("NOPE");
    }

    @Test
        public void metadataTest() {
            
            Map<String, String> map = Collections.emptyMap();

            model.setMetadata(map);

            Assert.assertNotNull(model.getMetadata());
            Assert.assertEquals(model.getMetadata(), map);
        }

}

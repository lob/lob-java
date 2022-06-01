package Model;

import java.util.ArrayList;
import java.util.List;

import com.lob.model.Zip;
import com.lob.model.ZipCodeType;
import com.lob.model.ZipLookupCity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipTest {
    private final Zip model = new Zip();
    
    @Test
    public void testZip() {
    
        Assert.assertNotNull(model);
   
    }

    @Test
    public void zipCodeTest() {
    
        model.setZipCode("11111");

        Assert.assertNotNull(model.getZipCode());
        Assert.assertEquals(model.getZipCode(), "11111" );

    }

    @Test
    public void idTest() {
    
        model.setId("us_zip_fakeId");

        Assert.assertNotNull(model.getId());
        Assert.assertEquals(model.getId(), "us_zip_fakeId" );
    
    }

    @Test
    public void citiesTest() {
        List<ZipLookupCity> fakeCity = new ArrayList<ZipLookupCity>();

         model.setCities(fakeCity);

        Assert.assertNotNull(model.getCities());
        Assert.assertEquals(model.getCities(), fakeCity);
    }

    @Test
    public void zipCodeTypeTest() {
        ZipCodeType unique = ZipCodeType.UNIQUE;
        ZipCodeType poBox = ZipCodeType.PO_BOX;
        ZipCodeType standard = ZipCodeType.STANDARD;
        ZipCodeType empty = ZipCodeType.EMPTY;

        model.setZipCodeType(unique);

        Assert.assertNotNull(model.getZipCodeType());
        Assert.assertEquals(model.getZipCodeType(), unique);

        model.setZipCodeType(poBox);
        Assert.assertEquals(model.getZipCodeType(), poBox);

        model.setZipCodeType(standard);
        Assert.assertEquals(model.getZipCodeType(), standard);

        model.setZipCodeType(empty);
        Assert.assertEquals(model.getZipCodeType(), empty);
    }

    @Test
    public void _objectTest() {
        Zip.ObjectEnum object = Zip.ObjectEnum.US_ZIP_LOOKUP;

        model.setObject(object);

        Assert.assertNotNull(model.getObject());
        Assert.assertEquals(model.getObject(), object);
    }

}

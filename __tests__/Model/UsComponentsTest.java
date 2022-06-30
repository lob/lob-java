package Model;

import com.lob.model.UsComponents;
import com.lob.model.ZipCodeType;

import org.testng.annotations.*;
import org.testng.Assert;

public class UsComponentsTest {
   @DataProvider (name = "us-components-data-provider")
    public Object[][] usComponentsDpMethod(){
        return new Object[][] {
            {"primary_number", "fake primary number"},
            {"street_predirection", UsComponents.StreetPredirectionEnum.N},
            {"street_predirection", UsComponents.StreetPredirectionEnum.S},
            {"street_predirection", UsComponents.StreetPredirectionEnum.E},
            {"street_predirection", UsComponents.StreetPredirectionEnum.W},
            {"street_predirection", UsComponents.StreetPredirectionEnum.NW},
            {"street_predirection", UsComponents.StreetPredirectionEnum.NE},
            {"street_predirection", UsComponents.StreetPredirectionEnum.SW},
            {"street_predirection", UsComponents.StreetPredirectionEnum.SE},
            {"street_predirection", UsComponents.StreetPredirectionEnum.EMPTY},
            {"street_name", "fake name"},
            {"street_suffix", "fake suffix"},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.N},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.S},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.E},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.W},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.NW},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.NE},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.SW},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.SE},
            {"street_postdirection", UsComponents.StreetPostdirectionEnum.EMPTY},
            {"secondary_designator", "fake designator"},
            {"secondary_number", "fake secondary number"},
            {"pmb_designator", "fake pmb designator"},
            {"pmb_number", "fake pmb number"},
            {"extra_secondary_designator", "fake extra designator"},
            {"extra_secondary_number", "fake extra number"},
            {"city", "fake city"},
            {"state", "fake state"},
            {"zip_code", "11111"},
            {"zip_code_plus_4", "1111"},
            {"zip_code_type", ZipCodeType.EMPTY},
            {"zip_code_type", ZipCodeType.PO_BOX},
            {"zip_code_type", ZipCodeType.MILITARY},
            {"zip_code_type", ZipCodeType.UNIQUE},
            {"zip_code_type", ZipCodeType.STANDARD},
            {"delivery_point_barcode", "fake barcode"},
            {"address_type", UsComponents.AddressTypeEnum.EMPTY},
            {"address_type", UsComponents.AddressTypeEnum.COMMERCIAL},
            {"address_type", UsComponents.AddressTypeEnum.RESIDENTIAL},
            {"record_type", UsComponents.RecordTypeEnum.EMPTY},
            {"record_type", UsComponents.RecordTypeEnum.PO_BOX},
            {"record_type", UsComponents.RecordTypeEnum.FIRM},
            {"record_type", UsComponents.RecordTypeEnum.HIGHRISE},
            {"record_type", UsComponents.RecordTypeEnum.STREET},
            {"record_type", UsComponents.RecordTypeEnum.GENERAL_DELIVERY},
            {"record_type", UsComponents.RecordTypeEnum.RURAL_ROUTE},
            {"default_building_address", true},
            {"default_building_address", false},
            {"county", "fake country"},
            {"county_fips", "11111"},
            {"carrier_route", "fake route"},
            {"carrier_route_type", UsComponents.CarrierRouteTypeEnum.RURAL_ROUTE},
            {"carrier_route_type", UsComponents.CarrierRouteTypeEnum.GENERAL_DELIVERY},
            {"carrier_route_type", UsComponents.CarrierRouteTypeEnum.PO_BOX},
            {"carrier_route_type", UsComponents.CarrierRouteTypeEnum.CITY_DELIVERY},
            {"carrier_route_type", UsComponents.CarrierRouteTypeEnum.HIGHWAY_CONTRACT},
            {"latitude", 123.0f},
            {"latitude", null},
            {"longitude", 123.0f},
            {"longitude", null},
        };
    }

    @Test(enabled=true, dataProvider = "us-components-data-provider")
    public void usComponentsTestWithProvidedValue(String prop, Object val) {
        UsComponents rec = new UsComponents();

        switch (prop) {
            case "primary_number": {
                String castedVal = (String)val;
                rec.setPrimaryNumber(castedVal);
                Assert.assertEquals(rec.getPrimaryNumber(), castedVal);
                break;
            }
            case "street_predirection": {
                UsComponents.StreetPredirectionEnum castedVal = (UsComponents.StreetPredirectionEnum)val;
                rec.setStreetPredirection(castedVal);
                Assert.assertEquals(rec.getStreetPredirection(), castedVal);
                break;
            }
            case "street_name": {
                String castedVal = (String)val;
                rec.setStreetName(castedVal);
                Assert.assertEquals(rec.getStreetName(), castedVal);
                break;
            }
            case "street_suffix": {
                String castedVal = (String)val;
                rec.setStreetSuffix(castedVal);
                Assert.assertEquals(rec.getStreetSuffix(), castedVal);
                break;
            }
            case "street_postdirection": {
                UsComponents.StreetPostdirectionEnum castedVal = (UsComponents.StreetPostdirectionEnum)val;
                rec.setStreetPostdirection(castedVal);
                Assert.assertEquals(rec.getStreetPostdirection(), castedVal);
                break;
            }
            case "secondary_designator": {
                String castedVal = (String)val;
                rec.setSecondaryDesignator(castedVal);
                Assert.assertEquals(rec.getSecondaryDesignator(), castedVal);
                break;
            }
            case "secondary_number": {
                String castedVal = (String)val;
                rec.setSecondaryNumber(castedVal);
                Assert.assertEquals(rec.getSecondaryNumber(), castedVal);
                break;
            }
            case "pmb_designator": {
                String castedVal = (String)val;
                rec.setPmbDesignator(castedVal);
                Assert.assertEquals(rec.getPmbDesignator(), castedVal);
                break;
            }
            case "pmb_number": {
                String castedVal = (String)val;
                rec.setPmbNumber(castedVal);
                Assert.assertEquals(rec.getPmbNumber(), castedVal);
                break;
            }
            case "extra_secondary_designator": {
                String castedVal = (String)val;
                rec.setExtraSecondaryDesignator(castedVal);
                Assert.assertEquals(rec.getExtraSecondaryDesignator(), castedVal);
                break;
            }
            case "extra_secondary_number": {
                String castedVal = (String)val;
                rec.setExtraSecondaryNumber(castedVal);
                Assert.assertEquals(rec.getExtraSecondaryNumber(), castedVal);
                break;
            }
            case "city": {
                String castedVal = (String)val;
                rec.setCity(castedVal);
                Assert.assertEquals(rec.getCity(), castedVal);
                break;
            }
            case "state": {
                String castedVal = (String)val;
                rec.setState(castedVal);
                Assert.assertEquals(rec.getState(), castedVal);
                break;
            }
            case "zip_code": {
                String castedVal = (String)val;
                rec.setZipCode(castedVal);
                Assert.assertEquals(rec.getZipCode(), castedVal);
                break;
            }
            case "zip_code_plus_4": {
                String castedVal = (String)val;
                rec.setZipCodePlus4(castedVal);
                Assert.assertEquals(rec.getZipCodePlus4(), castedVal);
                break;
            }
            case "zip_code_type": {
                ZipCodeType castedVal = (ZipCodeType)val;
                rec.setZipCodeType(castedVal);
                Assert.assertEquals(rec.getZipCodeType(), castedVal);
                break;
            }
            case "delivery_point_barcode": {
                String castedVal = (String)val;
                rec.setDeliveryPointBarcode(castedVal);
                Assert.assertEquals(rec.getDeliveryPointBarcode(), castedVal);
                break;
            }
            case "address_type": {
                UsComponents.AddressTypeEnum castedVal = (UsComponents.AddressTypeEnum)val;
                rec.setAddressType(castedVal);
                Assert.assertEquals(rec.getAddressType(), castedVal);
                break;
            }
            case "record_type": {
                UsComponents.RecordTypeEnum castedVal = (UsComponents.RecordTypeEnum)val;
                rec.setRecordType(castedVal);
                Assert.assertEquals(rec.getRecordType(), castedVal);
                break;
            }
            case "default_building_address": {
                Boolean castedVal = (Boolean)val;
                rec.setDefaultBuildingAddress(castedVal);
                Assert.assertEquals(rec.getDefaultBuildingAddress(), castedVal);
                break;
            }
            case "county": {
                String castedVal = (String)val;
                rec.setCounty(castedVal);
                Assert.assertEquals(rec.getCounty(), castedVal);
                break;
            }
            case "county_fips": {
                String castedVal = (String)val;
                rec.setCountyFips(castedVal);
                Assert.assertEquals(rec.getCountyFips(), castedVal);
                break;
            }
            case "carrier_route": {
                String castedVal = (String)val;
                rec.setCarrierRoute(castedVal);
                Assert.assertEquals(rec.getCarrierRoute(), castedVal);
                break;
            }
            case "carrier_route_type": {
                UsComponents.CarrierRouteTypeEnum castedVal = (UsComponents.CarrierRouteTypeEnum)val;
                rec.setCarrierRouteType(castedVal);
                Assert.assertEquals(rec.getCarrierRouteType(), castedVal);
                break;
            }
            case "latitude": {
                Float castedVal = (Float)val;
                rec.setLatitude(castedVal);
                Assert.assertEquals(rec.getLatitude(), castedVal);
                break;
            }
            case "longitude": {
                Float castedVal = (Float)val;
                rec.setLongitude(castedVal);
                Assert.assertEquals(rec.getLongitude(), castedVal);
                break;
            }
            default:
        }
    }

    @Test(enabled=true)
    public void usComponentsTestCatchesInvalidZipCode() {
        UsComponents rec = new UsComponents();
        Assert.assertNull(rec.getZipCode());

        String invalidValue = "Nope";
        try {
            rec.setZipCode(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code provided");
        }
    }

    @Test(enabled=true)
    public void usComponentsTestCatchesInvalidZipCodePlus4() {
        UsComponents rec = new UsComponents();
        Assert.assertNull(rec.getZipCodePlus4());

        String invalidValue = "Nope";
        try {
            rec.setZipCodePlus4(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid zip_code_plus_4 provided");
        }
    }

    @Test(enabled=true)
    public void usComponentsTestWithValidZipCodePlus4() {
        UsComponents rec = new UsComponents();
        Assert.assertNull(rec.getZipCodePlus4());

        String validValue = "1111";
        rec.setZipCodePlus4(validValue);
        Assert.assertNotNull(rec.getZipCodePlus4());
        Assert.assertEquals(rec.getZipCodePlus4(), validValue);
    }

    @Test(enabled=true)
    public void usComponentsTestCatchesInvalidCountyFips() {
        UsComponents rec = new UsComponents();
        Assert.assertNull(rec.getCountyFips());

        String invalidValue = "Nope";
        try {
            rec.setCountyFips(invalidValue);
            throw new Exception("Should Throw");
        } catch (Exception err) {
            Assert.assertEquals(err.getMessage(), "Invalid county_fips provided");
        }
    }
}

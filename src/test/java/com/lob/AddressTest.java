package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.model.Address;
import com.lob.model.AddressCollection;
import com.lob.model.DeletedStatus;
import com.lob.model.Verify;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddressTest {
    static Map<String, Object> defaultAddressParams = new HashMap<String, Object>();

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";

      defaultAddressParams.put("name", "Test Address");
      defaultAddressParams.put("address_line1", "123 Test Street");
      defaultAddressParams.put("address_city", "San Francisco");
      defaultAddressParams.put("address_state", "CA");
      defaultAddressParams.put("address_zip", "94107");
    }

    @Test
    public void list_it_should_have_correct_defaults() throws LobException {
        AddressCollection addresses = Address.list(null, null, Lob.apiKey);
        assertThat(addresses.getObject()).isNotNull();
        assertThat(addresses.getData()).isNotNull();
        assertThat(addresses.getData().size()).isEqualTo(10);
        assertThat(addresses.getCount()).isNotNull();
        assertThat(addresses.getNext_url()).isNotNull();
        assertThat(addresses.getNext_url()).isEqualTo("https://api.lob.com/" +
        "v1/addresses?count=10&offset=10");
        assertThat(addresses.getPrevious_url()).isNull();
        assertThat(addresses.getObject()).isEqualTo("list");
        assertThat(addresses.getCount()).isEqualTo(10);
    }

    @Test
    public void list_it_should_let_you_limit_the_count() throws LobException {
        AddressCollection addresses = Address.list(5, null, Lob.apiKey);
        assertThat(addresses.getCount()).isEqualTo(5);
    }

    @Test
    public void list_it_should_error_on_high_count() throws LobException {
        try {
            AddressCollection addresses = Address.list(589, null, Lob.apiKey);
            fail("Should be an APIException");
        } catch (APIException ex) {
            assertThat(ex.getMessage()).isEqualTo("count must be less than or equal to 100");
        }
    }

    @Test
    public void list_it_should_let_you_shift_the_offset() throws LobException {
        AddressCollection addresses = Address.list(null, 10, Lob.apiKey);
        String address1id = addresses.getData().get(9).getId();
        AddressCollection addresses2 = Address.list(1, 9, Lob.apiKey);
        String address2id = addresses2.getData().get(0).getId();
        assertThat(address1id).isNotEqualTo(address2id);
    }

    @Test
    public void testAddressRetrieveAll() throws LobException {
      Map<String, Object> listParams = new HashMap<String, Object>();
      listParams.put("count", 2);
      listParams.put("offset", 3);

      AddressCollection addresses = Address.all(listParams, Lob.apiKey);
      assertEquals(addresses.getData().size(), 2);
      assertEquals("list", addresses.getObject());
    }

    @Test(expected = APIException.class)
    public void testAddressRetrieveAllFail() throws LobException {
      Map<String, Object> listParams = new HashMap<String, Object>();
      listParams.put("count", 100000);

      AddressCollection addresses = Address.all(listParams, Lob.apiKey);
    }

    @Test
    public void create_it_should_succeed_with_default_POST_request() throws LobException {
      final String name = "Harry Zhang";
      final String email = "harry@Lob.com";
      final String phone = "5555555555";
      final String addressLine1 = "123 Test Street";
      final String addressLine2 = "Unit 123";
      final String addressCity = "San Francisco";
      final String addressState = "CA";
      final String addressZip = "94158";
      final String addressCountry = "US";
      Address address = Address.create(new HashMap<String, Object>(){{
        put("name", name);
        put("email", email);
        put("phone", phone);
        put("address_line1", addressLine1);
        put("address_line2", addressLine2);
        put("address_city", addressCity);
        put("address_state", addressState);
        put("address_zip", addressZip);
        put("address_country", addressCountry);
      }}, Lob.apiKey);
      assertThat(address.getId()).isNotNull();
      assertThat(address.getName()).isNotNull();
      assertThat(address.getName()).isEqualTo(name);
      assertThat(address.getEmail()).isNotNull();
      assertThat(address.getEmail()).isEqualTo(email);
      assertThat(address.getPhone()).isNotNull();
      assertThat(address.getPhone()).isEqualTo(phone);
      assertThat(address.getAddress_line1()).isNotNull();
      assertThat(address.getAddress_line1()).isEqualTo(addressLine1);
      assertThat(address.getAddress_line2()).isNotNull();
      assertThat(address.getAddress_line2()).isEqualTo(addressLine2);
      assertThat(address.getAddress_city()).isNotNull();
      assertThat(address.getAddress_city()).isEqualTo(addressCity);
      assertThat(address.getAddress_state()).isNotNull();
      assertThat(address.getAddress_state()).isEqualTo("California");
      assertThat(address.getAddress_zip()).isNotNull();
      assertThat(address.getAddress_zip()).isEqualTo(addressZip);
      assertThat(address.getAddress_country()).isNotNull();
      assertThat(address.getAddress_country()).isEqualTo("United States");
      assertThat(address.getDate_created()).isNotNull();
      assertThat(address.getDate_modified()).isNotNull();
      assertThat(address.getObject()).isNotNull();
      assertThat(address.getObject()).isEqualTo("address");
    }

    @Test
    public void create_it_should_succeed_with_foreign_state_and_country() throws LobException {
      final String name = "Harry Zhang";
      final String email = "harry@Lob.com";
      final String phone = "5555555555";
      final String addressLine1 = "123 Test Street";
      final String addressLine2 = "Unit 123";
      final String addressCity = "Armstrong";
      final String addressState = "British Columbia";
      final String addressZip = "V0E 1Y0";
      final String addressCountry = "CA";
      Address address = Address.create(new HashMap<String, Object>(){{
        put("name", name);
        put("email", email);
        put("phone", phone);
        put("address_line1", addressLine1);
        put("address_line2", addressLine2);
        put("address_city", addressCity);
        put("address_state", addressState);
        put("address_zip", addressZip);
        put("address_country", addressCountry);
      }}, Lob.apiKey);
      assertThat(address.getId()).isNotNull();
      assertThat(address.getName()).isNotNull();
      assertThat(address.getName()).isEqualTo(name);
      assertThat(address.getEmail()).isNotNull();
      assertThat(address.getEmail()).isEqualTo(email);
      assertThat(address.getPhone()).isNotNull();
      assertThat(address.getPhone()).isEqualTo(phone);
      assertThat(address.getAddress_line1()).isNotNull();
      assertThat(address.getAddress_line1()).isEqualTo(addressLine1);
      assertThat(address.getAddress_line2()).isNotNull();
      assertThat(address.getAddress_line2()).isEqualTo(addressLine2);
      assertThat(address.getAddress_city()).isNotNull();
      assertThat(address.getAddress_city()).isEqualTo(addressCity);
      assertThat(address.getAddress_state()).isNotNull();
      assertThat(address.getAddress_state()).isEqualTo("British Columbia");
      assertThat(address.getAddress_zip()).isNotNull();
      assertThat(address.getAddress_zip()).isEqualTo(addressZip);
      assertThat(address.getAddress_country()).isNotNull();
      assertThat(address.getAddress_country()).isEqualTo("Canada");
      assertThat(address.getDate_created()).isNotNull();
      assertThat(address.getDate_modified()).isNotNull();
      assertThat(address.getObject()).isNotNull();
      assertThat(address.getObject()).isEqualTo("address");
    }

    @Test(expected = APIException.class)
    public void create_it_should_error_when_no_name_is_provided() throws LobException {
      final String email = "harry@Lob.com";
      final String phone = "5555555555";
      final String addressLine1 = "123 Test Street";
      final String addressLine2 = "Unit 123";
      final String addressCity = "San Francisco";
      final String addressState = "CA";
      final String addressZip = "94158";
      final String addressCountry = "US";
      Address.create(new HashMap<String, Object>(){{
        put("email", email);
        put("phone", phone);
        put("address_line1", addressLine1);
        put("address_line2", addressLine2);
        put("address_city", addressCity);
        put("address_state", addressState);
        put("address_zip", addressZip);
        put("address_country", addressCountry);
      }}, Lob.apiKey);
    }

    @Test(expected = APIException.class)
    public void create_it_should_error_when_no_address_line1_is_provided() throws LobException {
      final String name = "Harry Zhang";
      final String email = "harry@Lob.com";
      final String phone = "5555555555";
      final String addressLine2 = "Unit 123";
      final String addressCity = "San Francisco";
      final String addressState = "CA";
      final String addressZip = "94158";
      final String addressCountry = "US";
      Address.create(new HashMap<String, Object>(){{
        put("name", name);
        put("email", email);
        put("phone", phone);
        put("address_line2", addressLine2);
        put("address_city", addressCity);
        put("address_state", addressState);
        put("address_zip", addressZip);
        put("address_country", addressCountry);
      }}, Lob.apiKey);
    }

    @Test(expected = APIException.class)
    public void create_it_should_error_when_no_address_zip_is_provided() throws LobException {
      final String name = "Harry Zhang";
      final String email = "harry@Lob.com";
      final String phone = "5555555555";
      final String addressLine1 = "123 Test Street";
      final String addressLine2 = "Unit 123";
      final String addressCity = "San Francisco";
      final String addressState = "CA";
      final String addressCountry = "US";
      Address.create(new HashMap<String, Object>(){{
        put("name", name);
        put("email", email);
        put("phone", phone);
        put("address_line1", addressLine1);
        put("address_line2", addressLine2);
        put("address_city", addressCity);
        put("address_state", addressState);
        put("address_country", addressCountry);
      }}, Lob.apiKey);
    }

    @Test(expected = APIException.class)
    public void create_it_should_error_when_an_invalid_state_is_provided() throws LobException {
      final String name = "Harry Zhang";
      final String email = "harry@Lob.com";
      final String phone = "5555555555";
      final String addressLine1 = "123 Test Street";
      final String addressLine2 = "Unit 123";
      final String addressCity = "San Francisco";
      final String addressState = "ZZ";
      final String addressZip = "94158";
      final String addressCountry = "US";
      Address.create(new HashMap<String, Object>(){{
        put("name", name);
        put("email", email);
        put("phone", phone);
        put("address_line1", addressLine1);
        put("address_line2", addressLine2);
        put("address_city", addressCity);
        put("address_state", addressState);
        put("address_zip", addressZip);
        put("address_country", addressCountry);
      }}, Lob.apiKey);
    }

    @Test
    public void testAddressRetrieve() throws LobException {
      Address createdAddress = Address.create(defaultAddressParams, Lob.apiKey);
      Address retrievedAddress = Address.retrieve(createdAddress.getId(), Lob.apiKey);
      assertEquals(createdAddress.getId(), retrievedAddress.getId());
    }

    @Test(expected = APIException.class)
    public void testAddressRetrieveFail() throws LobException {
      Address address = Address.retrieve("asdf", Lob.apiKey);
    }

    @Test
    public void testAddressDelete() throws LobException {
      Address address = Address.create(defaultAddressParams, Lob.apiKey);
      assertEquals(address.getName(), "Test Address");
      assertEquals(address.getAddress_line1(), "123 Test Street");
      DeletedStatus status = Address.delete(address.getId(), Lob.apiKey);
      assertTrue(status.getDeleted());
      Address retrievedAddress = Address.retrieve(address.getId(), Lob.apiKey);
      assertTrue(retrievedAddress.getDeleted());
    }

    @Test
    public void testAddressVerify() throws LobException {
      Map<String, Object> addressMap = new HashMap<String, Object>();
      addressMap.put("address_line1", "220 William T Morrissey Boulevard");
      addressMap.put("address_city", "Boston");
      addressMap.put("address_state", "MA");
      addressMap.put("address_zip", "02125");
      Verify verify = Address.verify(addressMap, Lob.apiKey);
      assertEquals("220 WILLIAM T MORRISSEY BLVD", verify.getAddress().getAddress_line1());
      assertEquals("", verify.getAddress().getAddress_line2());
      assertEquals("BOSTON", verify.getAddress().getAddress_city());
      assertEquals("MA", verify.getAddress().getAddress_state());
      assertEquals("02125-3314", verify.getAddress().getAddress_zip());
      assertEquals("US", verify.getAddress().getAddress_country());
      assertNull(verify.getAddress().getEmail());
      assertNull(verify.getAddress().getPhone());
    }

}

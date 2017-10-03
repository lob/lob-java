package com.lob.model;

import com.lob.BaseTest;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class AddressTest extends BaseTest {

    @Test
    public void testListAddresses() throws Exception {
        LobResponse<AddressCollection> response = Address.list();

        assertEquals(200, response.getResponseCode());
        assertEquals(10, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Address.class));
    }

    @Test
    public void testListAddressesWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<AddressCollection> response = Address.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Address.class));
    }

    @Test
    public void testRetrieveAddress() throws Exception {
        Address testAddress = Address.list().getResponseBody().getData().get(0);

        LobResponse<Address> response = Address.retrieve(testAddress.getId());
        Address address = response.getResponseBody();

        assertEquals(testAddress.getId(), address.getId());
    }

    @Test
    public void testCreateAddress() throws Exception {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        LobResponse<Address> response = new Address.RequestBuilder()
                .setCompany("Lob.com")
                .setName("Donald")
                .setLine1("185 Berry St")
                .setLine2("Ste 6100")
                .setCity("San Francisco")
                .setState("CA")
                .setZip("94107")
                .setCountry("US")
                .setPhone("123-456-7890")
                .setEmail("test@lob.com")
                .setDescription("Java Wrapper Automated Test")
                .setMetadata(metadata)
                .create();

        Address address = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals("address", address.getObject());
        assertNotNull(address.getId());
        assertEquals("LOB.COM", address.getCompany());
        assertEquals("DONALD", address.getName());
        assertEquals("185 BERRY ST STE 6100", address.getLine1());
        assertEquals("", address.getLine2());
        assertEquals("SAN FRANCISCO", address.getCity());
        assertEquals("CA", address.getState());
        assertEquals("94107-1741", address.getZip());
        assertEquals("UNITED STATES", address.getCountry());
        assertEquals("123-456-7890", address.getPhone());
        assertEquals("test@lob.com", address.getEmail());
        assertEquals("Java Wrapper Automated Test", address.getDescription());
        assertNotNull(address.getMetadata());
        assertNotNull(address.getDateCreated());
        assertNotNull(address.getDateModified());
        assertFalse(address.isDeleted());

        assertNotNull(address.toString());
    }

    @Test
    public void testDeleteAddress() throws Exception {
        Address address = new Address.RequestBuilder()
                .setCompany("Lob.com")
                .setName("Donald")
                .setLine1("185 Berry St")
                .setLine2("Ste 6600")
                .setCity("San Francisco")
                .setState("CA")
                .setZip("94107")
                .setCountry("US")
                .setPhone("123-456-7890")
                .setEmail("test@lob.com")
                .setDescription("Java Wrapper Automated Test")
                .create()
                .getResponseBody();

        assertFalse(address.isDeleted());

        LobResponse<Address> response = Address.delete(address.getId());

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody(), instanceOf(Address.class));
        assertTrue(response.getResponseBody().isDeleted());
    }

    @Test(expected = AuthenticationException.class)
    public void testAddressNoAuth() throws Exception {
        RequestOptions options = new RequestOptions.Builder().setApiKey("").build();
        new Address.RequestBuilder().create(options);
    }

    @Test(expected = InvalidRequestException.class)
    public void testAddressInvalidRequest() throws Exception {
        new Address.RequestBuilder().create();
    }

    @Test(expected = RateLimitException.class)
    public void testAddressRateLimit() throws Exception {
        RequestOptions options = new RequestOptions.Builder().setApiKey("test_03b4c5206b1f4c04b8d9fb5b4dd72ffd2d4").build();

        new Address.RequestBuilder()
                .setCompany("Lob.com")
                .setName("Donald")
                .setLine1("185 Berry St")
                .setLine2("Ste 6600")
                .setCity("San Francisco")
                .setState("CA")
                .setZip("94107")
                .setCountry("US")
                .setPhone("123-456-7890")
                .setEmail("test@lob.com")
                .setDescription("Java Wrapper Automated Test")
                .create(options);
    }

}

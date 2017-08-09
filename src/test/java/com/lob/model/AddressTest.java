package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;

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
        Address testAddress = ((AddressCollection) Address.list().getResponseBody()).getData().get(0);

        LobResponse<Address> response = Address.retrieve(testAddress.getId());
        Address address = response.getResponseBody();

        assertEquals(testAddress.getId(), address.getId());
    }

}

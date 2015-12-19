package com.lob.client.test;

import com.google.common.collect.Maps;
import com.lob.LobApiException;
import com.lob.id.AddressId;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.Filter;
import com.lob.protocol.request.Filters;
import com.lob.protocol.response.AddressDeleteResponse;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.AddressResponseList;
import com.lob.protocol.response.ErrorResponse;
import org.joda.time.DateTime;
import org.junit.Test;

import java.net.URI;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AddressTest extends BaseTest {
    @Test
    public void testListAddresses() throws Exception {
        final AddressResponseList addresses = client.getAddresses().get();
        final AddressResponse response = addresses.get(0);
        assertTrue(response instanceof AddressResponse);
        assertThat(addresses.getObject(), is("list"));

        assertFalse(addresses.isEmpty());
        assertFalse(addresses.getData().isEmpty());
        assertFalse(addresses.getNextUrl().isEmpty());
        assertTrue(addresses.getCount() > 0);
        assertNull(addresses.getPreviousUrl());
        assertNotNull(addresses.toString());
        assertNotNull(response.toString());
    }

    @Test
    public void testListAddressesLimit() throws Exception {
        final AddressResponseList addresses = client.getAddresses(2).get();
        final AddressResponse response = addresses.get(0);
        assertTrue(response instanceof AddressResponse);
        assertThat(addresses.getCount(), is(2));

        final Filter filter1 = Filters.ofCount(1);
        final Filter filter2 = Filters.ofCount(1).withOffset(2);
        final Filter filter3 = Filters.ofOffset(2).withCount(1);
        assertNotNull(filter1.toString());

        assertThat(client.getAddresses(1, 2).get().getCount(), is(1));
        assertThat(client.getAddresses(filter1).get().getCount(), is(1));
        assertThat(client.getAddresses(filter2).get().getCount(), is(1));
        assertThat(client.getAddresses(filter3).get().getCount(), is(1));

        assertFalse(addresses.isEmpty());
    }

    @Test(expected = ExecutionException.class)
    public void testListAddressesFail() throws Exception {
        client.getAddresses(1000).get();
    }

    @Test
    public void testListAddressesFail2() throws Exception {
        try {
            client.getAddresses(1000).get();
        }
        catch (final ExecutionException e) {
            final LobApiException lobException = (LobApiException) e.getCause();
            assertFalse(lobException.getMessage().isEmpty());
            assertTrue(lobException.getUri() instanceof URI);
            assertTrue(lobException.getErrorResponse() instanceof ErrorResponse);
            assertNotNull(lobException.getErrorResponse().toString());
            assertNotNull(lobException.getErrorResponse().getError().getMessage());
            assertNotNull(lobException.getErrorResponse().getError().getStatusCode());
        }
    }

    @Test
    public void testCreateAddress() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);

        final AddressRequest.Builder builder = AddressRequest.builder()
            .name("Lob")
            .description("address response")
            .company("Lob")
            .email("support@lob.com")
            .phone("555-555-5555")
            .line1("185 Berry Street")
            .line2("Suite 1510")
            .city("San Francisco")
            .state("CA")
            .zip("94107")
            .country("US")
            .metadata(metadata);

        final AddressResponse response = client.createAddress(builder.build()).get();
        assertTrue(response instanceof AddressResponse);
        assertThat(response.getName(), is("Lob"));
        assertThat(response.getDescription(), is("address response"));
        assertThat(response.getCompany(), is("Lob"));

        assertFalse(response.getEmail().isEmpty());
        assertFalse(response.getPhone().isEmpty());
        assertTrue(response.getDateCreated() instanceof DateTime);
        assertTrue(response.getDateModified() instanceof DateTime);
        assertThat(response.getObject(), is("address"));
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));

        final AddressResponse metadataResponse = client.getAddresses(Filters.ofMetadata(metadata).withMetadata(metadata).withCount(1)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        client.createAddress(builder.butWith()
            .zip(ZipCode.parse("94107"))
            .country(CountryCode.parse("US"))
            .build()).get();

        final AddressRequest request = builder.build();
        assertFalse(request.getEmail().isEmpty());
        assertFalse(request.getPhone().isEmpty());
        assertFalse(request.getCity().isEmpty());
        assertFalse(request.getLine1().isEmpty());
        assertFalse(request.getLine2().isEmpty());
        assertFalse(request.getState().isEmpty());
        assertTrue(request.getCountry() instanceof CountryCode);
        assertThat(request.getName(), is("Lob"));
        assertThat(request.getCompany(), is("Lob"));
        assertTrue(request.getZip() instanceof ZipCode);
        assertNotNull(request.toString());

        final AddressId id = response.getId();
        final AddressResponse retrievedResponse = client.getAddress(id).get();
        assertThat(retrievedResponse.getId(), is(id));
    }

    @Test
    public void testRetrieveAddress() throws Exception {
        final AddressResponse response = client.getAddresses().get().get(0);
        assertTrue(response instanceof AddressResponse);
    }

    @Test
    public void testDeleteAddress() throws Exception {
        final AddressId id = client.getAddresses().get().get(0).getId();
        final AddressDeleteResponse response = client.deleteAddress(id).get();
        assertThat(response.getId(), is(id));
        assertTrue(response.isDeleted());
        assertNotNull(response.toString());
    }
}

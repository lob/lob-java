package com.lob.client.test;

import ch.qos.logback.classic.Level;
import com.google.common.collect.Maps;
import com.lob.LobApiException;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.AddressId;
import com.lob.id.CountryCode;
import com.lob.id.ZipCode;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.VerifyAddressRequest;
import com.lob.protocol.response.AddressDeleteResponse;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.AddressResponseList;
import com.lob.protocol.response.ErrorResponse;
import com.lob.protocol.response.VerifyAddressResponse;
import com.ning.http.client.AsyncHttpClientConfig;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AddressTest extends QuietLogging {
    private final LobClient client = AsyncLobClient.create(
        "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc",
        new AsyncHttpClientConfig.Builder().build());

    @Test
    public void testListAddresses() throws Exception {
        final AddressResponseList addresses = print(client.getAddresses().get());
        final AddressResponse response = addresses.get(0);
        assertTrue(response instanceof AddressResponse);
        assertThat(addresses.getObject(), is("list"));

        assertFalse(addresses.isEmpty());
        assertFalse(addresses.getData().isEmpty());
        assertFalse(addresses.getNextUrl().isEmpty());
        print(addresses.getPreviousUrl());
        assertTrue(addresses.getCount() > 0);
    }

    @Test
    public void testListAddressesLimit() throws Exception {
        final AddressResponseList addresses = client.getAddresses(2).get();
        final AddressResponse response = addresses.get(0);
        assertTrue(response instanceof AddressResponse);
        assertThat(addresses.getCount(), is(2));

        assertThat(client.getAddresses(1, 2).get().getCount(), is(1));

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
            print(lobException);
            assertFalse(lobException.getMessage().isEmpty());
            assertTrue(lobException.getUri() instanceof URI);
            assertTrue(lobException.getErrorResponse() instanceof ErrorResponse);
        }
    }

    @Test
    public void testCreateAddress() throws Exception {
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", "value0");
        metadata.put("key1", "value1");

        final AddressRequest.Builder builder = AddressRequest.builder()
            .name("Lob")
            .email("support@lob.com")
            .phone("555-555-5555")
            .line1("185 Berry Street")
            .line2("Suite 1510")
            .city("San Francisco")
            .state("CA")
            .zip("94107")
            .country("US")
            .metadata(metadata);

        final AddressResponse response = print(client.createAddress(builder.build()).get());
        assertTrue(response instanceof AddressResponse);
        assertThat(response.getName(), is("Lob"));

        assertFalse(response.getEmail().isEmpty());
        assertFalse(response.getPhone().isEmpty());
        assertTrue(response.getDateCreated() instanceof DateTime);
        assertTrue(response.getDateModified() instanceof DateTime);
        assertThat(response.getObject(), is("address"));
        assertThat(response.getMetadata().get("key0"), is("value0"));
        assertThat(response.getMetadata().get("key1"), is("value1"));

        client.createAddress(builder.butWith()
            .zip(ZipCode.parse("94107"))
            .country(CountryCode.parse("US"))
            .build()).get();

        final AddressRequest request = print(builder.build());
        assertFalse(request.getEmail().isEmpty());
        assertFalse(request.getPhone().isEmpty());
        assertFalse(request.getCity().isEmpty());
        assertFalse(request.getLine1().isEmpty());
        assertFalse(request.getLine2().isEmpty());
        assertFalse(request.getState().isEmpty());
        assertTrue(request.getCountry() instanceof CountryCode);
        assertThat(request.getName(), is("Lob"));
        assertTrue(request.getZip() instanceof ZipCode);

        final AddressId id = response.getId();
        final AddressResponse retrievedResponse = client.getAddress(id).get();
        assertThat(retrievedResponse.getId(), is(id));
    }

    @Test
    public void testRetrieveAddress() throws Exception {
        final AddressResponse response = print(client.getAddresses().get().get(0));
        assertTrue(response instanceof AddressResponse);
    }

    @Test
    public void testDeleteAddress() throws Exception {
        final AddressId id = client.getAddresses().get().get(0).getId();
        final AddressDeleteResponse response = print(client.deleteAddress(id).get());
        assertThat(response.getId(), is(id));
        assertTrue(response.isDeleted());
    }

    @Test
    public void testAddressVerification() throws Exception {
        final VerifyAddressRequest.Builder builder = VerifyAddressRequest.builder()
            .line1("220 William T Morrissey")
            .line2("Suite 1510")
            .city("Boston")
            .state("MA")
            .zip("02125")
            .country("US");

        final VerifyAddressResponse response = print(client.verifyAddress(print(builder.build())).get());
        assertThat(response.getLine1(), is("220 WILLIAM T MORRISSEY BLVD"));
        assertFalse(response.getLine2().isEmpty());
        assertFalse(response.getCity().isEmpty());
        assertFalse(response.getState().isEmpty());
        assertTrue(response.getZip() instanceof ZipCode);
        assertTrue(response.getCountry() instanceof CountryCode);
        assertThat(response.getObject(), is("address"));

        client.verifyAddress(builder.butWith().country(CountryCode.parse("US")).zip(ZipCode.parse("02125")).build()).get();
    }
}

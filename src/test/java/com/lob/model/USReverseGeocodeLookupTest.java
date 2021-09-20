package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class USReverseGeocodeLookupTest extends BaseTest {

    @Test
    public void testUSReverseGeocodeLookup() throws Exception {
        LobResponse<USReverseGeocodeLookup> response = new USReverseGeocodeLookup.RequestBuilder()
                .setLatitude(37.777456)
                .setLongitude(-122.393039)
                .lookup();

        USReverseGeocodeLookup USReverseGeocodeLookup = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(USReverseGeocodeLookup.getId());
        assertThat(USReverseGeocodeLookup.getAddresses().get(0), instanceOf(USReverseGeocodeLookup.Addresses.class));
        assertEquals("us_reverse_geocode_lookup", USReverseGeocodeLookup.getObject());
    }

}

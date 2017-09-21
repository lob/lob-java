package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class USZipLookupTest extends BaseTest {

    @Test
    public void testUSZipLookup() throws Exception {
        LobResponse<USZipLookup> response = new USZipLookup.RequestBuilder()
                .setZipCode("94107")
                .lookup();

        USZipLookup usZipLookup = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(usZipLookup.getId());
        assertEquals("94107", usZipLookup.getZipCode());
        assertEquals("standard", usZipLookup.getZipCodeType());
        assertEquals("SAN FRANCISCO", usZipLookup.getCities().get(0).getCity());
        assertThat(usZipLookup.getCities().get(0), instanceOf(USZipLookup.City.class));
        assertEquals("us_zip_lookup", usZipLookup.getObject());
    }

}

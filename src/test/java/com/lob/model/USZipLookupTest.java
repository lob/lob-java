package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class USZipLookupTest extends BaseTest {
    @Test
    public void testUSZipLookup() throws Exception {
        LobResponse<USZipLookup> response = USZipLookup.creator()
                .setZipCode("94107")
                .lookup();

        USZipLookup usZipLookup = response.getResponseBody();
        assertThat(usZipLookup.getZipCode(), is("94107"));
        assertThat(usZipLookup.getZipCodeType(), is("standard"));
    }
}
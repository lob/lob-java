package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZipCodeTest extends BaseTest {
    @Test
    public void testRouteRetrieve() throws Exception {
        LobResponse<ZipCode> response = ZipCode.retrieve("94158-C002", null);

        ZipCode zipCode = response.getResponseBody();
        assertThat(zipCode.getZipCode(), is("94158"));
    }

    @Test
    public void testRouteList() throws Exception {
        // This needs to be fixed. Not sure how to use a Map with duplicate keys
        String zipCodes = "zip_codes=48168-C016&zip_codes=94158";
        LobResponse<ZipCodeCollection> response = ZipCode.list(zipCodes, null);

        ZipCodeCollection zipCodeCollection = response.getResponseBody();
        assertNotNull(zipCodeCollection);
    }
}
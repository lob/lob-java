package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BulkIntlVerificationTest extends BaseTest {

    @Test
    public void testBulkIntlVerification() throws Exception {
        List<IntlVerification.RequestBuilder> addresses = new ArrayList<IntlVerification.RequestBuilder>();
        addresses.add(new IntlVerification.RequestBuilder()
                .setPrimaryLine("370 Water St")
                .setCity("Summerside")
                .setState("Prince Edward Island")
                .setPostalCode("C1N 1C4")
                .setCountry("CA"));
        LobResponse<BulkIntlVerification> response = new BulkIntlVerification.RequestBuilder()
                .setAddresses(addresses)
                .verify();

        BulkIntlVerification bulkIntlVerification = response.getResponseBody();
        List<IntlVerification> responseAddresses = bulkIntlVerification.getAddresses();

        IntlVerification intlVerification = responseAddresses.get(0);
        assertEquals(200, response.getResponseCode());
        assertEquals("TEST KEYS DO NOT VERIFY ADDRESSES", intlVerification.getRecipient());
    }
}

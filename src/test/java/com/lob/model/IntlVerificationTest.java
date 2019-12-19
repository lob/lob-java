package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntlVerificationTest extends BaseTest {

    @Test
    public void testInternationalVerification() throws Exception {
        LobResponse<IntlVerification> response = new IntlVerification.RequestBuilder()
                    .setPrimaryLine("370 Water St")
                    .setCity("Summerside")
                    .setState("Prince Edward Island")
                    .setPostalCode("C1N 1C4")
                    .setCountry("CA")
                    .verify();

        IntlVerification intlVerification = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals("TEST KEYS DO NOT VERIFY ADDRESSES", intlVerification.getRecipient());
    }

}

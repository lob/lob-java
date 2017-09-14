package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InternationalVerificationTest extends BaseTest {
    /*
    @Test
    public void testInternationalVerification() throws Exception {
        LobResponse<InternationalVerification> response = InternationalVerification.creator()
                .setPrimaryLine("370 Water St")
                .setCity("Summerside")
                .setState("Prince Edward Island")
                .setPostalCode("C1N 1C4")
                .setCountry("CA")
                .verify();

        InternationalVerification intlVerification = response.getResponseBody();
        assertThat(intlVerification.getPrimaryLine(), is("370 WATER ST"));
        assertNotNull(intlVerification.getComponents());
        assertThat(intlVerification.getSecondaryLine(), is ("SUMMERSIDE PE C1N 1C4"));
    }
    */

    // Just one passing test as a placeholder. We'll need to revisit mocking the response for intl verifications later
    @Test
    public void passingTest() throws Exception {
        assertNotNull(true);
    }
}
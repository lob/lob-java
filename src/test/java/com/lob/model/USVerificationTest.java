package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class USVerificationTest extends BaseTest {

    @Test
    public void testUsVerification() throws Exception {
        LobResponse<USVerification> response = new USVerification.RequestBuilder()
                .setRecipient("Donald")
                .setPrimaryLine("185 Berry St")
                .setSecondaryLine("Ste 6100")
                .setUrbanization("")
                .setCity("San Francisco")
                .setState("CA")
                .setZipCode("94107")
                .verify();

        USVerification usVerification = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals("DONALD", usVerification.getRecipient());
        assertEquals("185 BERRY ST STE 6100", usVerification.getPrimaryLine());
        assertEquals("", usVerification.getSecondaryLine());
        assertEquals("", usVerification.getUrbanization());
        assertEquals("SAN FRANCISCO CA 94107-1234", usVerification.getLastLine());
        assertEquals("deliverable", usVerification.getDeliverability());
        assertNotNull(usVerification.getComponents());
        assertNotNull(usVerification.getDeliverabilityAnalysis());
    }

}

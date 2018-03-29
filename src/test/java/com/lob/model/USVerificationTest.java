package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class USVerificationTest extends BaseTest {

    @Test
    public void testUsVerification() throws Exception {
        LobResponse<USVerification> response = new USVerification.RequestBuilder()
                .setRecipient("Donald")
                .setPrimaryLine("deliverable")
                .setSecondaryLine("Ste 6100")
                .setUrbanization("")
                .setCity("San Francisco")
                .setState("CA")
                .setZipCode("94107")
                .verify();

        USVerification usVerification = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals("1 TELEGRAPH HILL BLVD", usVerification.getPrimaryLine());
        assertEquals("", usVerification.getSecondaryLine());
        assertEquals("", usVerification.getUrbanization());
        assertEquals("SAN FRANCISCO CA 94133-3106", usVerification.getLastLine());
        assertEquals("deliverable", usVerification.getDeliverability());
        assertNotNull(usVerification.getComponents());
        assertNotNull(usVerification.getDeliverabilityAnalysis());
    }

    @Test
    public void testUsVerificationSingleLineAddress() throws Exception {
        LobResponse<USVerification> response = new USVerification.RequestBuilder()
                .setAddress("deliverable")
                .verify();

        USVerification usVerification = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals("1 TELEGRAPH HILL BLVD", usVerification.getPrimaryLine());
        assertEquals("", usVerification.getSecondaryLine());
        assertEquals("", usVerification.getUrbanization());
        assertEquals("SAN FRANCISCO CA 94133-3106", usVerification.getLastLine());
        assertEquals("deliverable", usVerification.getDeliverability());
        assertNotNull(usVerification.getComponents());
        assertNotNull(usVerification.getDeliverabilityAnalysis());
    }
    
    @Test
    public void testUsVerificationWithCustomCase() throws Exception {
        Map<String, Object> query = new HashMap<>();
        query.put("case", "proper");

        LobResponse<USVerification> response = new USVerification.RequestBuilder()
                .setRecipient("Donald")
                .setPrimaryLine("deliverable")
                .setSecondaryLine("Ste 6100")
                .setUrbanization("")
                .setCity("San Francisco")
                .setState("CA")
                .setZipCode("94107")
                .verify(query);

        USVerification usVerification = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals("1 Telegraph Hill Blvd", usVerification.getPrimaryLine());
        assertEquals("", usVerification.getSecondaryLine());
        assertEquals("", usVerification.getUrbanization());
        assertEquals("San Francisco CA 94133-3106", usVerification.getLastLine());
        assertEquals("deliverable", usVerification.getDeliverability());
        assertNotNull(usVerification.getComponents());
        assertNotNull(usVerification.getDeliverabilityAnalysis());
    }

}

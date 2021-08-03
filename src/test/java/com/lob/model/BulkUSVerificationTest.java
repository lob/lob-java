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

public class BulkUSVerificationTest extends BaseTest {

    @Test
    public void testBulkUsVerification() throws Exception {
        List<USVerification.RequestBuilder> addresses = new ArrayList<USVerification.RequestBuilder>();
        addresses.add(new USVerification.RequestBuilder()
                .setRecipient("Donald")
                .setPrimaryLine("deliverable")
                .setSecondaryLine("Ste 6100")
                .setUrbanization("")
                .setCity("San Francisco")
                .setState("CA")
                .setZipCode("94107"));
        LobResponse<BulkUSVerification> response = new BulkUSVerification.RequestBuilder()
                .setAddresses(addresses)
                .verify();

        BulkUSVerification bulkUSVerification = response.getResponseBody();
        List<USVerification> responseAddresses = bulkUSVerification.getAddresses();

        USVerification usVerification = responseAddresses.get(0);

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

        List<USVerification.RequestBuilder> addresses = new ArrayList<USVerification.RequestBuilder>();
        addresses.add(new USVerification.RequestBuilder()
                .setRecipient("Donald")
                .setPrimaryLine("deliverable")
                .setSecondaryLine("Ste 6100")
                .setUrbanization("")
                .setCity("San Francisco")
                .setState("CA")
                .setZipCode("94107"));
        LobResponse<BulkUSVerification> response = new BulkUSVerification.RequestBuilder()
        .setAddresses(addresses)
        .verify(query);

        BulkUSVerification bulkUSVerification = response.getResponseBody();
        List<USVerification> responseAddresses = bulkUSVerification.getAddresses();

        USVerification usVerification = responseAddresses.get(0);

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

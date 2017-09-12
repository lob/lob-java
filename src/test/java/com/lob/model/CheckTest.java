package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class CheckTest extends BaseTest {
    @Test
    public void testListChecks() throws Exception {
        LobResponse<CheckCollection> response = Check.list();

        assertEquals(200, response.getResponseCode());
        assertEquals(10, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Check.class));
    }

    @Test
    public void testListCheckWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<CheckCollection> response = Check.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Check.class));
    }

    @Test
    public void testRetrieveCheck() throws Exception {
        Check testCheck = Check.list().getResponseBody().getData().get(0);

        LobResponse<Check> response = Check.retrieve(testCheck.getId());
        Check check = response.getResponseBody();

        assertEquals(testCheck.getId(), check.getId());
    }

    @Test
    public void testCreateHTMLCheck() throws Exception {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<BankAccount> bank = BankAccount.creator()
                .setDescription("Test Bank Account")
                .setRoutingNumber("322271627")
                .setAccountNumber("9999999")
                .setSignatory("John Doe")
                .setAccountType("individual")
                .create();

        LobResponse<BankAccount> bankVerifed = BankAccount.verify(bank.getResponseBody().getId(), Arrays.asList(10, 50), null);

        LobResponse<Check> response = Check.creator()
                .setDescription("Test Check")
                .setCheckBottom("<h1>Hello {{name}}</h1>")
                .setMergeVariables(mergeVariables)
                .setAmount(1.00f)
                .setTo(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setMetadata(metadata)
                .setBankaccount(bankVerifed.getResponseBody())
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertEquals("Test Check", check.getDescription());
        assertNotNull(check.getTo());
        assertEquals("LOB.COM", check.getTo().getCompany());
        assertNotNull(check.getFrom());
        assertNull(check.getMessage());
        assertNotNull(check.getUrl());
        assertNull(check.getCheckBottomTemplateId());
        assertEquals("USPS", check.getCarrier());
        assertNotNull(check.getTrackingEvents());
        assertNotNull(check.getThumbnails());
        assertEquals("usps_first_class", check.getMailType());
        assertNotNull(check.getExpectedDeliveryDate());
        assertNotNull(check.getDateCreated());
        assertNotNull(check.getDateModified());
        assertNotNull(check.getSendDate());
        assertEquals(metadata, check.getMetadata());
        assertFalse(check.isDeleted());
        assertEquals("check", check.getObject());
        assertNotNull(check.toString());
    }

    @Test
    public void testCreateFileCheck() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("8.5x11.pdf").getPath());

        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        LobResponse<BankAccount> bank = BankAccount.creator()
                .setDescription("Test Bank Account")
                .setRoutingNumber("322271627")
                .setAccountNumber("9999999")
                .setSignatory("John Doe")
                .setAccountType("individual")
                .create();

        LobResponse<BankAccount> bankVerifed = BankAccount.verify(bank.getResponseBody().getId(), Arrays.asList(10, 50), null);

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<Check> response = Check.creator()
                .setDescription("Test Check")
                .setCheckBottom(file)
                .setMergeVariables(mergeVariables)
                .setTo(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setAmount(1.00f)
                .setBankaccount(bankVerifed.getResponseBody())
                .setMetadata(metadata)
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertEquals("Test Check", check.getDescription());
        assertNotNull(check.getTo());
        assertEquals("LOB.COM", check.getTo().getCompany());
        assertNotNull(check.getFrom());
        assertNotNull(check.getUrl());
        assertNull(check.getCheckBottomTemplateId());
        assertNull(check.getCheckBottomVersionId());
        assertEquals("USPS", check.getCarrier());
        assertNotNull(check.getTrackingEvents());
        assertNotNull(check.getThumbnails());
        assertEquals("usps_first_class", check.getMailType());
        assertNotNull(check.getExpectedDeliveryDate());
        assertNotNull(check.getDateCreated());
        assertNotNull(check.getDateModified());
        assertNotNull(check.getSendDate());
        assertEquals(metadata, check.getMetadata());
        assertFalse(check.isDeleted());
        assertEquals("check", check.getObject());
        assertNotNull(check.toString());
    }
    
    @Test
    public void testDeleteCheck() throws Exception {
        LobResponse<BankAccount> bank = BankAccount.creator()
                .setDescription("Test Bank Account")
                .setRoutingNumber("322271627")
                .setAccountNumber("9999999")
                .setSignatory("John Doe")
                .setAccountType("individual")
                .create();

        LobResponse<BankAccount> bankVerifed = BankAccount.verify(bank.getResponseBody().getId(), Arrays.asList(10, 50), null);

        LobResponse<Check> response = Check.creator()
                .setDescription("Test Check")
                .setCheckBottom("<h1>Hello {{name}}</h1>")
                .setAmount(1.00f)
                .setTo(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setBankaccount(bankVerifed.getResponseBody())
                .create();

        assertFalse(response.getResponseBody().isDeleted());

        Check deletedCheck = Check.delete(response.getResponseBody().getId()).getResponseBody();

        assertTrue(deletedCheck.isDeleted());
    }
}
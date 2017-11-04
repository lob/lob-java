package com.lob.model;

import com.lob.BaseTest;
import com.lob.Lob;
import com.lob.net.LobResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class CheckTest extends BaseTest {

    private static String VERIFIED_BANK_ACCOUNT;

    @BeforeClass
    public static void beforeClass() {
        Lob.init("test_7b1960d06d6dfe28d3862b98380b8b0dc93");

        try {
            BankAccount newBankAccount = new BankAccount.RequestBuilder()
                    .setRoutingNumber("322271627")
                    .setAccountNumber("123456789")
                    .setAccountType("company")
                    .setSignatory("Donald")
                    .create()
                    .getResponseBody();

            ArrayList<Integer> verificationAmounts = new ArrayList<Integer>();
            verificationAmounts.add(25);
            verificationAmounts.add(63);

            VERIFIED_BANK_ACCOUNT = BankAccount.verify(newBankAccount.getId(), verificationAmounts).getResponseBody().getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<String, String>();
        mergeVariables.put("name", "Lob");

        LobResponse<Check> response = new Check.RequestBuilder()
                .setDescription("Test Check")
                .setCheckBottom("<h1>Hello {{name}}</h1>")
                .setAttachment("<h1>This is a HTML attachment</h1")
                .setMergeVariables(mergeVariables)
                .setAmount(1.00f)
                .setMemo("memo")
                .setLogo("https://s3-us-west-2.amazonaws.com/lob-assets/lob_check_logo.png")
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        new Address.RequestBuilder()
                                .setName("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setMetadata(metadata)
                .setBankAccount(VERIFIED_BANK_ACCOUNT)
                .setMailType("usps_first_class")
                .setCheckNumber(12345)
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertEquals("Test Check", check.getDescription());
        assertNotNull(check.getTo());
        assertEquals("LOB.COM", check.getTo().getCompany());
        assertNotNull(check.getFrom());
        assertEquals("DONALD", check.getFrom().getName());
        assertEquals(VERIFIED_BANK_ACCOUNT, check.getBankAccount().getId());
        assertEquals(12345, check.getCheckNumber());
        assertEquals("memo", check.getMemo());
        assertNotNull(check.getUrl());
        assertEquals(1.00f, check.getAmount(), 0.0001);
        assertNull(check.getMessage());
        assertNotNull(check.getUrl());
        assertNull(check.getCheckBottomTemplateId());
        assertNull(check.getAttachmentTemplateId());
        assertNull(check.getCheckBottomTemplateVersionId());
        assertNull(check.getAttachmentTemplateVersionId());
        assertEquals("USPS", check.getCarrier());
        assertNull(check.getTrackingNumber());
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
    public void testCreateTemplateCheck() throws Exception {
        LobResponse<Check> response = new Check.RequestBuilder()
                .setCheckBottom("tmpl_c4aa2dc83ebad7e")
                .setAttachment("tmpl_c4aa2dc83ebad7e")
                .setAmount(1.00f)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        new Address.RequestBuilder()
                                .setName("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setBankAccount(VERIFIED_BANK_ACCOUNT)
                .setMailType("usps_first_class")
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertEquals("tmpl_c4aa2dc83ebad7e", check.getCheckBottomTemplateId());
        assertEquals("tmpl_c4aa2dc83ebad7e", check.getAttachmentTemplateId());
        assertNotNull(check.getCheckBottomTemplateVersionId());
        assertNotNull(check.getAttachmentTemplateVersionId());
    }

    @Test
    public void testCreateCheckWithFile() throws Exception {
        final File logo = new File(getClass().getClassLoader().getResource("lob_check_test_logo.png").getPath());
        final File attachment = new File(getClass().getClassLoader().getResource("8.5x11.2.pdf").getPath());

        LobResponse<Check> response = new Check.RequestBuilder()
                .setMessage("Hello Check")
                .setAmount(1.00f)
                .setMemo("memo")
                .setLogo(logo)
                .setAttachment(attachment)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        new Address.RequestBuilder()
                                .setName("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setBankAccount(VERIFIED_BANK_ACCOUNT)
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertEquals("Hello Check", check.getMessage());
        assertNotNull(check.getUrl());
        assertEquals(VERIFIED_BANK_ACCOUNT, check.getBankAccount().getId());
        assertEquals("check", check.getObject());
    }

    @Test
    public void testCreateFutureCheck() throws Exception {
        ZonedDateTime today = ZonedDateTime.now();
        ZonedDateTime futureDate = today.plusDays(1);

        LobResponse<Check> response = new Check.RequestBuilder()
                .setDescription("Test Future Check")
                .setAmount(1.00f)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        new Address.RequestBuilder()
                                .setName("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setBankAccount(VERIFIED_BANK_ACCOUNT)
                .setMailType("usps_first_class")
                .setSendDate(futureDate)
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertTrue(check.getSendDate().isAfter(today));
    }

    @Test
    public void testDeleteCheck() throws Exception {
        Check newCheck = new Check.RequestBuilder()
                .setMessage("Check to be deleted")
                .setAmount(1.00f)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        new Address.RequestBuilder()
                                .setName("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setBankAccount(VERIFIED_BANK_ACCOUNT)
                .create()
                .getResponseBody();


        assertFalse(newCheck.isDeleted());

        Check deletedCheck = Check.delete(newCheck.getId()).getResponseBody();

        assertTrue(deletedCheck.isDeleted());
    }
}

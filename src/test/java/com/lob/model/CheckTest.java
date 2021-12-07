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

    private static String templateId;

    @BeforeClass
    public static void beforeClass() {
        Lob.init(System.getenv("LOB_API_KEY"));

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

            LobResponse<Template> templateResponse = new Template.RequestBuilder()
                    .setDescription("Test Template")
                    .setHtml("<h1>Hello</h1>")
                    .setEngine("handlebars")
                    .create();

            Template template = templateResponse.getResponseBody();
            templateId = template.getId();
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
                .setAmount("1.00")
                .setMemo("memo")
                .setLogo("https://s3-us-west-2.amazonaws.com/public.lob.com/assets/check_logo.png")
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
        assertEquals(1.00, check.getAmount(), 0);
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
        assertEquals(mergeVariables, check.getMergeVariables());
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
    public void testCreateCheckWithMergeVariableBoolean() throws Exception {
        Map<String, Boolean> mergeVariables = new HashMap<String, Boolean>();
        mergeVariables.put("is_awesome", true);

        LobResponse<Check> response = new Check.RequestBuilder()
                .setDescription("Test Check with Merge Variable Boolean")
                .setCheckBottom("<html>{{#is_awesome}}You are awesome!{{/is_awesome}}</html>")
                .setAttachment("<h1>This is a HTML attachment</h1")
                .setMergeVariables(mergeVariables)
                .setAmount("1.00")
                .setMemo("memo")
                .setLogo("https://s3-us-west-2.amazonaws.com/public.lob.com/assets/check_logo.png")
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
                                .setName("Anonymous")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setBankAccount(VERIFIED_BANK_ACCOUNT)
                .setMailType("usps_first_class")
                .setCheckNumber(12345)
                .create();

        Check check = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(check.getId());
        assertEquals("Test Check with Merge Variable Boolean", check.getDescription());
        assertEquals(mergeVariables, check.getMergeVariables());
        assertEquals("check", check.getObject());
    }

    @Test
    public void testCreateTemplateCheck() throws Exception {
        LobResponse<Check> response = new Check.RequestBuilder()
                .setCheckBottom(templateId)
                .setAttachment(templateId)
                .setAmount("1.00")
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
        assertEquals(templateId, check.getCheckBottomTemplateId());
        assertEquals(templateId, check.getAttachmentTemplateId());
        assertNotNull(check.getCheckBottomTemplateVersionId());
        assertNotNull(check.getAttachmentTemplateVersionId());
    }

    @Test
    public void testCreateCheckWithFile() throws Exception {
        final File logo = new File(getClass().getClassLoader().getResource("lob_check_test_logo.png").getPath());
        final File attachment = new File(getClass().getClassLoader().getResource("8.5x11.2.pdf").getPath());

        LobResponse<Check> response = new Check.RequestBuilder()
                .setMessage("Hello Check")
                .setAmount("1.00")
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
                .setAmount("1.00")
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
    public void testCreateCheckWithStringAmount() throws Exception {
        LobResponse<Check> response = new Check.RequestBuilder()
                .setAmount("131072.01")
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
        assertEquals(131072.01, check.getAmount(), 0);
    }

    @Test
    public void testDeleteCheck() throws Exception {
        Check newCheck = new Check.RequestBuilder()
                .setMessage("Check to be deleted")
                .setAmount("1.00")
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

package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class LetterTest extends BaseTest {

    @Test
    public void testListLetters() throws Exception {
        LobResponse<LetterCollection> response = Letter.list();

        assertEquals(200, response.getResponseCode());
        assertEquals(10, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Letter.class));
    }

    @Test
    public void testListLetterWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<LetterCollection> response = Letter.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Letter.class));
    }

    @Test
    public void testRetrieveLetter() throws Exception {
        Letter testLetter = Letter.list().getResponseBody().getData().get(0);

        LobResponse<Letter> response = Letter.retrieve(testLetter.getId());
        Letter Letter = response.getResponseBody();

        assertEquals(testLetter.getId(), Letter.getId());
    }

    @Test
    public void testCreateHTMLLetter() throws Exception {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<String, String>();
        mergeVariables.put("name", "Lob");

        LobResponse<Letter> response = new Letter.RequestBuilder()
                .setDescription("Test Letter")
                .setFile("<h1>Hello {{name}}</h1>")
                .setMergeVariables(mergeVariables)
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
                .setColor(true)
                .setDoubleSided(false)
                .setAddressPlacement("insert_blank_page")
                .setReturnEnvelope(true)
                .setPerforatedPage(1)
                .setMetadata(metadata)
                .setMailType("usps_first_class")
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("Test Letter", letter.getDescription());
        assertNotNull(letter.getTo());
        assertEquals("LOB.COM", letter.getTo().getCompany());
        assertNotNull(letter.getFrom());
        assertEquals("DONALD", letter.getFrom().getName());
        assertTrue(letter.isColor());
        assertFalse(letter.isDoubleSided());
        assertEquals("insert_blank_page", letter.getAddressPlacement());
        assertTrue(letter.isReturnEnvelope());
        assertEquals(new Integer(2), letter.getPerforatedPage());
        assertNull(letter.getExtraService());
        assertEquals("usps_first_class", letter.getMailType());
        assertNotNull(letter.getUrl());
        assertNull(letter.getTemplateId());
        assertNull(letter.getTemplateVersionId());
        assertEquals("USPS", letter.getCarrier());
        assertNull(letter.getTrackingNumber());
        assertNotNull(letter.getTrackingEvents());
        assertNotNull(letter.getThumbnails());
        assertNotNull(letter.getExpectedDeliveryDate());
        assertNotNull(letter.getDateCreated());
        assertNotNull(letter.getDateModified());
        assertNotNull(letter.getSendDate());
        assertEquals(metadata, letter.getMetadata());
        assertFalse(letter.isDeleted());
        assertEquals("letter", letter.getObject());
        assertNotNull(letter.toString());
    }

    @Test
    public void testCreateTemplateLetter() throws Exception {
        LobResponse<Letter> response = new Letter.RequestBuilder()
                .setFile("tmpl_c4aa2dc83ebad7e")
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
                .setColor(true)
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("tmpl_c4aa2dc83ebad7e", letter.getTemplateId());
        assertNotNull(letter.getTemplateVersionId());
    }

    @Test
    public void testCreateFileLetter() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("8.5x11.2.pdf").getPath());

        LobResponse<Letter> response = new Letter.RequestBuilder()
                .setDescription("Test Letter")
                .setFile(file)
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
                                .setCompany("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setColor(true)
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertNotNull(letter.getUrl());
        assertFalse(letter.isDeleted());
        assertEquals("letter", letter.getObject());
    }

    @Test
    public void testCreateCertifiedLetter() throws Exception {
        LobResponse<Letter> response = new Letter.RequestBuilder()
                .setFile("<h1>Hello from Lob</h1>")
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
                                .setCompany("Donald")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setExtraService("certified")
                .setColor(false)
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("certified", letter.getExtraService());
        assertFalse(letter.isDeleted());
        assertEquals("letter", letter.getObject());
    }

    @Test
    public void testCreateFutureLetter() throws Exception {
        ZonedDateTime today = ZonedDateTime.now();
        ZonedDateTime futureDate = today.plusDays(1);

        LobResponse<Letter> response = new Letter.RequestBuilder()
                .setDescription("Test Letter")
                .setFile("<h1>Hello from Lob</h1>")
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
                .setColor(true)
                .setSendDate(futureDate)
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertTrue(letter.getSendDate().isAfter(today));
    }

    @Test
    public void testDeleteLetter() throws Exception {
        Letter letter = new Letter.RequestBuilder()
                .setFile("<h1>Hello {{name}}</h1>")
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setColor(true)
                .setFrom(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .create()
                .getResponseBody();

        assertFalse(letter.isDeleted());

        Letter deletedLetter = Letter.delete(letter.getId()).getResponseBody();

        assertTrue(deletedLetter.isDeleted());
    }

}

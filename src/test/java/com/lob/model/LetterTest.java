package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;

import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
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
        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<Letter> response = Letter.creator()
                .setDescription("Test Letter")
                .setFile("<h1>Hello {{name}}</h1>")
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
                .setColor(true)
                .setMetadata(metadata)
                .create();

        Letter Letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(Letter.getId());
        assertEquals("Test Letter", Letter.getDescription());
        assertNotNull(Letter.getTo());
        assertEquals("LOB.COM", Letter.getTo().getCompany());
        assertNotNull(Letter.getFrom());
        assertNotNull(Letter.getUrl());
        assertNull(Letter.getTemplateId());
        assertNull(Letter.getTemplateVersionId());
        assertEquals("USPS", Letter.getCarrier());
        assertNotNull(Letter.getTrackingEvents());
        assertNotNull(Letter.getThumbnails());
        assertEquals("usps_first_class", Letter.getMailType());
        assertNotNull(Letter.getExpectedDeliveryDate());
        assertNotNull(Letter.getDateCreated());
        assertNotNull(Letter.getDateModified());
        assertNotNull(Letter.getSendDate());
        assertEquals(metadata, Letter.getMetadata());
        assertFalse(Letter.isDeleted());
        assertEquals("letter", Letter.getObject());
        assertNotNull(Letter.toString());
    }

    @Test
    public void testCreateFileLetter() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("8.5x11.pdf").getPath());

        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<Letter> response = Letter.creator()
                .setDescription("Test Letter")
                .setFile(file)
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
                .setColor(true)
                .setMetadata(metadata)
                .create();

        Letter Letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(Letter.getId());
        assertEquals("Test Letter", Letter.getDescription());
        assertNotNull(Letter.getTo());
        assertEquals("LOB.COM", Letter.getTo().getCompany());
        assertNotNull(Letter.getFrom());
        assertNotNull(Letter.getUrl());
        assertNull(Letter.getTemplateId());
        assertNull(Letter.getTemplateVersionId());
        assertEquals("USPS", Letter.getCarrier());
        assertNotNull(Letter.getTrackingEvents());
        assertNotNull(Letter.getThumbnails());
        assertEquals("usps_first_class", Letter.getMailType());
        assertNotNull(Letter.getExpectedDeliveryDate());
        assertNotNull(Letter.getDateCreated());
        assertNotNull(Letter.getDateModified());
        assertNotNull(Letter.getSendDate());
        assertEquals(metadata, Letter.getMetadata());
        assertFalse(Letter.isDeleted());
        assertEquals("letter", Letter.getObject());
        assertNotNull(Letter.toString());
    }

    @Test
    public void testDeleteLetter() throws Exception {
        Letter letter = Letter.creator()
                .setFile("<h1>Hello {{name}}</h1>")
                .setTo(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setColor(true)
                .setFrom(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSendDate(DateTime.now().plusMinutes(5))
                .create()
                .getResponseBody();

        assertFalse(letter.isDeleted());

        Letter deletedLetter = Letter.delete(letter.getId()).getResponseBody();

        assertTrue(deletedLetter.isDeleted());
    }
}
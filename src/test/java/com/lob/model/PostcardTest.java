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

public class PostcardTest extends BaseTest {

    @Test
    public void testListPostcards() throws Exception {
        LobResponse<PostcardCollection> response = Postcard.list();

        assertEquals(200, response.getResponseCode());
        assertEquals(10, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Postcard.class));
    }

    @Test
    public void testListPostcardWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<PostcardCollection> response = Postcard.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Postcard.class));
    }

    @Test
    public void testRetrievePostcard() throws Exception {
        Postcard testPostcard = Postcard.list().getResponseBody().getData().get(0);

        LobResponse<Postcard> response = Postcard.retrieve(testPostcard.getId());
        Postcard postcard = response.getResponseBody();

        assertEquals(testPostcard.getId(), postcard.getId());
    }

    @Test
    public void testCreateHTMLPostcard() throws Exception {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<Postcard> response = Postcard.creator()
                .setDescription("Test Postcard")
                .setFront("<h1>Hello {{name}}</h1>")
                .setBack("<h1>Back</h1>")
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
                .setSize("4x6")
                .setMetadata(metadata)
                .create();

        Postcard postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertEquals("Test Postcard", postcard.getDescription());
        assertNotNull(postcard.getTo());
        assertEquals("LOB.COM", postcard.getTo().getCompany());
        assertNull(postcard.getFrom());
        assertNull(postcard.getMessage());
        assertNotNull(postcard.getUrl());
        assertNull(postcard.getFrontTemplateId());
        assertNull(postcard.getBackTemplateId());
        assertNull(postcard.getFrontTemplateVersionId());
        assertNull(postcard.getBackTemplateVersionId());
        assertEquals("USPS", postcard.getCarrier());
        assertNotNull(postcard.getTrackingEvents());
        assertNotNull(postcard.getThumbnails());
        assertEquals("4x6", postcard.getSize());
        assertEquals("usps_first_class", postcard.getMailType());
        assertNotNull(postcard.getExpectedDeliveryDate());
        assertNotNull(postcard.getDateCreated());
        assertNotNull(postcard.getDateModified());
        assertNotNull(postcard.getSendDate());
        assertEquals(metadata, postcard.getMetadata());
        assertFalse(postcard.isDeleted());
        assertEquals("postcard", postcard.getObject());
        assertNotNull(postcard.toString());
    }

    @Test
    public void testCreateFilePostcard() throws Exception {
        final File front = new File(getClass().getClassLoader().getResource("postcardfront.pdf").getPath());

        LobResponse<Postcard> response = Postcard.creator()
                .setDescription("Test Postcard")
                .setFront(front)
                .setMessage("this is a message")
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
                                .setName("Donald Little")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .create();

        Postcard postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertEquals("Test Postcard", postcard.getDescription());
        assertNotNull(postcard.getTo());
        assertEquals("LOB.COM", postcard.getTo().getCompany());
        assertNotNull(postcard.getFrom());
        assertEquals("DONALD LITTLE", postcard.getFrom().getName());
        assertEquals("this is a message", postcard.getMessage());
        assertNotNull(postcard.getUrl());
        assertNull(postcard.getFrontTemplateId());
        assertNull(postcard.getBackTemplateId());
        assertNull(postcard.getFrontTemplateVersionId());
        assertNull(postcard.getBackTemplateVersionId());
        assertEquals("USPS", postcard.getCarrier());
        assertNotNull(postcard.getTrackingEvents());
        assertNotNull(postcard.getThumbnails());
        assertEquals("4x6", postcard.getSize());
        assertEquals("usps_first_class", postcard.getMailType());
        assertNotNull(postcard.getExpectedDeliveryDate());
        assertNotNull(postcard.getDateCreated());
        assertNotNull(postcard.getDateModified());
        assertNotNull(postcard.getSendDate());
        assertEquals(new HashMap<String, String>(), postcard.getMetadata());
        assertFalse(postcard.isDeleted());
        assertEquals("postcard", postcard.getObject());
        assertNotNull(postcard.toString());
    }

    @Test
    public void testDeletePostcard() throws Exception {
        Postcard postcard = Postcard.creator()
                .setFront("<h1>Front</h1>")
                .setBack("<h1>Back</h1>")
                .setTo(
                        Address.creator()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .setSendDate(DateTime.now().plusMinutes(5))
                .create()
                .getResponseBody();

        assertFalse(postcard.isDeleted());

        Postcard deletedPostcard = Postcard.delete(postcard.getId()).getResponseBody();

        assertTrue(deletedPostcard.isDeleted());
    }

}

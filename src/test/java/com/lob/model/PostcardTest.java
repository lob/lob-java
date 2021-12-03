package com.lob.model;

import com.lob.BaseTest;
import com.lob.Lob;
import com.lob.net.LobResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class PostcardTest extends BaseTest {

    private static String templateId;

    @BeforeClass
    public static void beforeClass() {
        Lob.init(System.getenv("LOB_API_KEY"));

        try {
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
    public void testListPostcardWithMetadata() throws Exception {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("key0", "8f43a8f2-360d-4fea-bdeb-6f545f084c74");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("metadata", metadata);

        LobResponse<Postcard> createResponse = new Postcard.RequestBuilder()
                .setDescription("Test Postcard with Merge Variable List")
                .setFront("<html>Content</html>")
                .setBack("<h1>Back</h1>")
                .setMetadata(metadata)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .setMailType("usps_first_class")
                .create();
        assertEquals(200, createResponse.getResponseCode());

        LobResponse<PostcardCollection> response = Postcard.list(params);

        assertEquals(200, response.getResponseCode());
        assertTrue(response.getResponseBody().getCount() > 0);
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
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<String, String>();
        mergeVariables.put("name", "Lob");

        LobResponse<Postcard> response = new Postcard.RequestBuilder()
                .setDescription("Test Postcard")
                .setFront("<h1>Hello {{name}}</h1>")
                .setBack("<h1>Back</h1>")
                .setMergeVariables(mergeVariables)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .setMetadata(metadata)
                .setMailType("usps_first_class")
                .create();

        Postcard postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertEquals("Test Postcard", postcard.getDescription());
        assertNotNull(postcard.getTo());
        assertEquals("LOB.COM", postcard.getTo().getCompany());
        assertNull(postcard.getFrom());
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
        assertEquals(mergeVariables, postcard.getMergeVariables());
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
    public void testCreatePostcardWithMergeVariableList() throws Exception {
        Map<String, Object> mergeVariables = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        Map<String, String> data1 = new HashMap<String, String>();
        Map<String, String> data2 = new HashMap<String, String>();

        data1.put("name", "Larissa");
        data2.put("name", "Larry");
        list.add(data1);
        list.add(data2);
        mergeVariables.put("list", list);

        LobResponse<Postcard> response = new Postcard.RequestBuilder()
                .setDescription("Test Postcard with Merge Variable List")
                .setFront("<html>{{#list}} {{name}} {{/list}}</html>")
                .setBack("<h1>Back</h1>")
                .setMergeVariables(mergeVariables)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .setMailType("usps_first_class")
                .create();

        Postcard postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertEquals("Test Postcard with Merge Variable List", postcard.getDescription());
        assertEquals(mergeVariables, postcard.getMergeVariables());
        assertEquals("postcard", postcard.getObject());
    }

    @Test
    public void testCreateTemplatePostcard() throws Exception {
        LobResponse<Postcard> response = new Postcard.RequestBuilder()
                .setFront(templateId)
                .setBack(templateId)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
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
        assertEquals(templateId, postcard.getFrontTemplateId());
        assertEquals(templateId, postcard.getBackTemplateId());
        assertNotNull(postcard.getFrontTemplateVersionId());
        assertNotNull(postcard.getBackTemplateVersionId());
    }

    @Test
    public void testCreateFilePostcard() throws Exception {
        final File front = new File(getClass().getClassLoader().getResource("postcardfront.pdf").getPath());

        LobResponse<Postcard> response = new Postcard.RequestBuilder()
                .setDescription("Test Postcard")
                .setFront(front)
                .setBack("<h1>this is a message</h1>")
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setFrom(
                        new Address.RequestBuilder()
                                .setName("Donald Little")
                                .setLine1("210 King St")
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
        assertNull(postcard.getMergeVariables());
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
    public void testCreateFuturePostcard() throws Exception {
        ZonedDateTime today = ZonedDateTime.now();
        ZonedDateTime futureDate = today.plusDays(1);

        LobResponse<Postcard> response = new Postcard.RequestBuilder()
                .setDescription("Test Postcard")
                .setFront("<h1>Hello from Lob</h1>")
                .setBack("<h1>Back</h1>")
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .setSendDate(futureDate)
                .create();

        Postcard postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertTrue(postcard.getSendDate().isAfter(today));
    }

    @Test
    public void testDeletePostcard() throws Exception {
        Postcard postcard = new Postcard.RequestBuilder()
                .setFront("<h1>Front</h1>")
                .setBack("<h1>Back</h1>")
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("210 King St")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSize("4x6")
                .create()
                .getResponseBody();

        assertFalse(postcard.isDeleted());

        Postcard deletedPostcard = Postcard.delete(postcard.getId()).getResponseBody();

        assertTrue(deletedPostcard.isDeleted());
    }

}

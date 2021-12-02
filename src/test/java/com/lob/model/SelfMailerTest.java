package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class SelfMailerTest extends BaseTest {

    @Test
    public void testListSelfMailers() throws Exception {
        LobResponse<SelfMailerCollection> response = SelfMailer.list();

        assertEquals(200, response.getResponseCode());
        assertTrue(response.getResponseBody().getCount() > 0);
        assertThat(response.getResponseBody().getData().get(0), instanceOf(SelfMailer.class));
    }

    @Test
    public void testListSelfMailersWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<SelfMailerCollection> response = SelfMailer.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(SelfMailer.class));
    }

    @Test
    public void testListSelfMailersWithMetadata() throws Exception {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("campaign", "LOB-TEST");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("metadata", metadata);

        LobResponse<SelfMailer> createResponse = new SelfMailer.RequestBuilder()
                .setDescription("Test Self Mailer with MetaData")
                .setOutside("<h1>Outside</h1>")
                .setInside("<html>Content</html>")
                .setMetadata(metadata)
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setMailType("usps_first_class")
                .create();
        assertEquals(200, createResponse.getResponseCode());

        LobResponse<SelfMailerCollection> response = SelfMailer.list(params);

        assertEquals(200, response.getResponseCode());
        assertTrue(response.getResponseBody().getCount() > 0);
        assertThat(response.getResponseBody().getData().get(0), instanceOf(SelfMailer.class));
    }

    @Test
    public void testRetrieveSelfMailer() throws Exception {
        SelfMailer testSelfMailer = SelfMailer.list().getResponseBody().getData().get(0);

        LobResponse<SelfMailer> response = SelfMailer.retrieve(testSelfMailer.getId());
        SelfMailer selfMailer = response.getResponseBody();

        assertEquals(testSelfMailer.getId(), selfMailer.getId());
    }

    @Test
    public void testCreateHTMLSelfMailer() throws Exception {

        Map<String, String> mergeVariables = new HashMap<String, String>();
        mergeVariables.put("name", "Lob");

        LobResponse<SelfMailer> response = new SelfMailer.RequestBuilder()
                .setDescription("Test Self Mailer")
                .setOutside("<h1>Outside</h1>")
                .setInside("<h1>Hello {{name}}</h1>")
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
                .setMailType("usps_first_class")
                .create();

        SelfMailer selfMailer = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(selfMailer.getId());
        assertEquals("Test Self Mailer", selfMailer.getDescription());
        assertNotNull(selfMailer.getTo());
        assertEquals("LOB.COM", selfMailer.getTo().getCompany());
        assertNull(selfMailer.getFrom());
        assertNotNull(selfMailer.getUrl());
        assertNull(selfMailer.getOutsideTemplateId());
        assertNull(selfMailer.getInsideTemplateId());
        assertNull(selfMailer.getOutsideTemplateVersionId());
        assertNull(selfMailer.getInsideTemplateVersionId());
        assertEquals("USPS", selfMailer.getCarrier());
        assertNotNull(selfMailer.getTrackingEvents());
        assertNotNull(selfMailer.getThumbnails());
        assertEquals("usps_first_class", selfMailer.getMailType());
        assertEquals(mergeVariables, selfMailer.getMergeVariables());
        assertNotNull(selfMailer.getExpectedDeliveryDate());
        assertNotNull(selfMailer.getDateCreated());
        assertNotNull(selfMailer.getDateModified());
        assertNotNull(selfMailer.getSendDate());
        assertFalse(selfMailer.isDeleted());
        assertEquals("self_mailer", selfMailer.getObject());
        assertNotNull(selfMailer.toString());
    }

    @Test
    public void testCreateSelfMailerWithMergeVariableList() throws Exception {
        Map<String, Object> mergeVariables = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        Map<String, String> data1 = new HashMap<String, String>();
        Map<String, String> data2 = new HashMap<String, String>();

        data1.put("name", "Larissa");
        data2.put("name", "Larry");
        list.add(data1);
        list.add(data2);
        mergeVariables.put("list", list);

        LobResponse<SelfMailer> response = new SelfMailer.RequestBuilder()
                .setDescription("Test Self Mailer with Merge Variable List")
                .setOutside("<h1>Outside</h1>")
                .setInside("<html>{{#list}} {{name}} {{/list}}</html>")
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
                .setMailType("usps_first_class")
                .create();

        SelfMailer selfMailer = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(selfMailer.getId());
        assertEquals("Test Self Mailer with Merge Variable List", selfMailer.getDescription());
        assertEquals(mergeVariables, selfMailer.getMergeVariables());
        assertEquals("self_mailer", selfMailer.getObject());
    }

    @Test
    public void testCreateFileSelfMailer() throws Exception {
        final File outside = new File(getClass().getClassLoader().getResource("sfm-6x18-outside.pdf").getPath());
        final File inside = new File(getClass().getClassLoader().getResource("sfm-6x18-inside.pdf").getPath());

        LobResponse<SelfMailer> response = new SelfMailer.RequestBuilder()
                .setDescription("Test Self Mailer")
                .setOutside(outside)
                .setInside(inside)
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
                                .setName("Donald Little")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .create();

        SelfMailer selfMailer = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(selfMailer.getId());
        assertEquals("Test Self Mailer", selfMailer.getDescription());
        assertNotNull(selfMailer.getTo());
        assertEquals("LOB.COM", selfMailer.getTo().getCompany());
        assertNotNull(selfMailer.getFrom());
        assertEquals("DONALD LITTLE", selfMailer.getFrom().getName());
        assertNotNull(selfMailer.getUrl());
        assertNull(selfMailer.getOutsideTemplateId());
        assertNull(selfMailer.getInsideTemplateId());
        assertNull(selfMailer.getOutsideTemplateVersionId());
        assertNull(selfMailer.getInsideTemplateVersionId());
        assertEquals("USPS", selfMailer.getCarrier());
        assertNotNull(selfMailer.getTrackingEvents());
        assertNotNull(selfMailer.getThumbnails());
        assertEquals("usps_first_class", selfMailer.getMailType());
        assertNull(selfMailer.getMergeVariables());
        assertNotNull(selfMailer.getExpectedDeliveryDate());
        assertNotNull(selfMailer.getDateCreated());
        assertNotNull(selfMailer.getDateModified());
        assertNotNull(selfMailer.getSendDate());
        assertEquals(new HashMap<String, String>(), selfMailer.getMetadata());
        assertFalse(selfMailer.isDeleted());
        assertEquals("self_mailer", selfMailer.getObject());
        assertNotNull(selfMailer.toString());
    }

    @Test
    public void testCreateFileSelfMailer12x9() throws Exception {
        final File outside = new File(getClass().getClassLoader().getResource("sfm-12x9-outside.pdf").getPath());
        final File inside = new File(getClass().getClassLoader().getResource("sfm-12x9-inside.pdf").getPath());

        LobResponse<SelfMailer> response = new SelfMailer.RequestBuilder()
                .setDescription("Test Self Mailer")
                .setOutside(outside)
                .setInside(inside)
                .setSize("12x9_bifold")
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
                                .setName("Donald Little")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .create();

        SelfMailer selfMailer = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(selfMailer.getId());
        assertEquals("Test Self Mailer", selfMailer.getDescription());
        assertNotNull(selfMailer.getTo());
        assertEquals("LOB.COM", selfMailer.getTo().getCompany());
        assertNotNull(selfMailer.getFrom());
        assertEquals("DONALD LITTLE", selfMailer.getFrom().getName());
        assertNotNull(selfMailer.getUrl());
        assertNull(selfMailer.getOutsideTemplateId());
        assertNull(selfMailer.getInsideTemplateId());
        assertNull(selfMailer.getOutsideTemplateVersionId());
        assertNull(selfMailer.getInsideTemplateVersionId());
        assertEquals("USPS", selfMailer.getCarrier());
        assertNotNull(selfMailer.getTrackingEvents());
        assertNotNull(selfMailer.getThumbnails());
        assertEquals("usps_first_class", selfMailer.getMailType());
        assertNull(selfMailer.getMergeVariables());
        assertNotNull(selfMailer.getExpectedDeliveryDate());
        assertNotNull(selfMailer.getDateCreated());
        assertNotNull(selfMailer.getDateModified());
        assertNotNull(selfMailer.getSendDate());
        assertEquals(new HashMap<String, String>(), selfMailer.getMetadata());
        assertFalse(selfMailer.isDeleted());
        assertEquals("self_mailer", selfMailer.getObject());
        assertNotNull(selfMailer.toString());
    }

    @Test
    public void testCreateFutureSelfMailer() throws Exception {
        ZonedDateTime today = ZonedDateTime.now();
        ZonedDateTime futureDate = today.plusDays(1);

        LobResponse<SelfMailer> response = new SelfMailer.RequestBuilder()
                .setDescription("Test Scheduled Self Mailer")
                .setOutside("<h1>Hello from Lob</h1>")
                .setInside("<h1>Inside</h1>")
                .setTo(
                        new Address.RequestBuilder()
                                .setCompany("Lob.com")
                                .setLine1("185 Berry St Ste 6100")
                                .setCity("San Francisco")
                                .setState("CA")
                                .setZip("94107")
                                .setCountry("US")
                )
                .setSendDate(futureDate)
                .create();

        SelfMailer selfMailer = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(selfMailer.getId());
        assertTrue(selfMailer.getSendDate().isAfter(today));
    }

    @Test
    public void testDeleteSelfMailer() throws Exception {
        SelfMailer selfMailer = new SelfMailer.RequestBuilder()
                .setOutside("<h1>Outside</h1>")
                .setInside("<h1>Inside</h1>")
                .setTo(
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

        assertFalse(selfMailer.isDeleted());

        SelfMailer deletedselfMailer = SelfMailer.delete(selfMailer.getId()).getResponseBody();

        assertTrue(deletedselfMailer.isDeleted());
    }

}

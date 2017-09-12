package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class AreaTest extends BaseTest {
    @Test
    public void testListAreas() throws Exception {
        LobResponse<AreaCollection> response = Area.list();

        assertEquals(200, response.getResponseCode());
        assertEquals(10, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Area.class));
    }

    @Test
    public void testListAreaWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<AreaCollection> response = Area.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Area.class));
    }

    @Test
    public void testRetrieveArea() throws Exception {
        Area testArea = Area.list().getResponseBody().getData().get(0);

        LobResponse<Area> response = Area.retrieve(testArea.getId());
        Area postcard = response.getResponseBody();

        assertEquals(testArea.getId(), postcard.getId());
    }

    @Test
    public void testCreateHTMLArea() throws Exception {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<Area> response = Area.creator()
                .setDescription("Test Area")
                .setFront("<h1>Hello {{name}}</h1>")
                .setBack("<h1>Back</h1>")
                .setRoutes("94939")
                .setMergeVariables(mergeVariables)
                .setMetadata(metadata)
                .create();

        Area postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertEquals("Test Area", postcard.getDescription());

        assertNotNull(postcard.getUrl());
        assertNull(postcard.getFrontTemplateId());
        assertNull(postcard.getBackTemplateId());
        assertNull(postcard.getFrontTemplateVersionId());
        assertNull(postcard.getBackTemplateVersionId());
        assertNotNull(postcard.getThumbnails());
        assertNotNull(postcard.getExpectedDeliveryDate());
        assertNotNull(postcard.getDateCreated());
        assertNotNull(postcard.getDateModified());
        assertEquals(metadata, postcard.getMetadata());
        assertEquals("area", postcard.getObject());
        assertNotNull(postcard.toString());
    }

    @Test
    public void testCreateFileArea() throws Exception {
        final File front = new File(getClass().getClassLoader().getResource("areafront.pdf").getPath());
        final File back = new File(getClass().getClassLoader().getResource("areaback.pdf").getPath());

        Map<String, String> metadata = new HashMap<>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<>();
        mergeVariables.put("name", "Lob");

        LobResponse<Area> response = Area.creator()
                .setDescription("Test Area")
                .setFront(front)
                .setBack(back)
                .setRoutes("94939")
                .setMergeVariables(mergeVariables)
                .setMetadata(metadata)
                .create();

        Area postcard = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(postcard.getId());
        assertEquals("Test Area", postcard.getDescription());

        assertNotNull(postcard.getUrl());
        assertNull(postcard.getFrontTemplateId());
        assertNull(postcard.getBackTemplateId());
        assertNull(postcard.getFrontTemplateVersionId());
        assertNull(postcard.getBackTemplateVersionId());
        assertNotNull(postcard.getThumbnails());
        assertNotNull(postcard.getExpectedDeliveryDate());
        assertNotNull(postcard.getDateCreated());
        assertNotNull(postcard.getDateModified());
        assertEquals(metadata, postcard.getMetadata());
        assertEquals("area", postcard.getObject());
        assertNotNull(postcard.toString());
    }
}
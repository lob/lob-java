package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
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
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        Map<String, String> mergeVariables = new HashMap<String, String>();
        mergeVariables.put("name", "Lob");

        LobResponse<Area> response = new Area.RequestBuilder()
                .setDescription("Test Area")
                .setFront("<h1>Hello {{name}}</h1>")
                .setBack("<h1>Back</h1>")
                .setRoutes(Arrays.asList("94158-C001", "94107-C031"))
                .setTargetType("residential")
                .setMergeVariables(mergeVariables)
                .setMetadata(metadata)
                .create();

        Area area = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(area.getId());
        assertEquals("Test Area", area.getDescription());
        assertNotNull(area.getZipCodes());
        assertTrue(area.getAddresses() > 0);
        assertNotNull(area.getPrice());
        assertNotNull(area.getUrl());
        assertEquals("residential", area.getTargetType());
        assertNotNull(area.getThumbnails());
        assertNotNull(area.getTrackings());
        assertNotNull(area.getExpectedDeliveryDate());
        assertNotNull(area.getDateCreated());
        assertNotNull(area.getDateModified());
        assertEquals(metadata, area.getMetadata());
        assertEquals("area", area.getObject());
        assertNotNull(area.toString());
    }

    @Test
    public void testCreateFileArea() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("6_25x11_25.pdf").getPath());

        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        LobResponse<Area> response = new Area.RequestBuilder()
                .setDescription("Test Area")
                .setFront(file)
                .setBack(file)
                .setRoutes("94939")
                .setTargetType("residential")
                .setMetadata(metadata)
                .create();

        Area area = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(area.getId());
        assertEquals("Test Area", area.getDescription());
        assertNotNull(area.getZipCodes());
        assertTrue(area.getAddresses() > 0);
        assertNotNull(area.getPrice());
        assertNotNull(area.getUrl());
        assertEquals("residential", area.getTargetType());
        assertNotNull(area.getThumbnails());
        assertNotNull(area.getTrackings());
        assertNotNull(area.getExpectedDeliveryDate());
        assertNotNull(area.getDateCreated());
        assertNotNull(area.getDateModified());
        assertEquals(metadata, area.getMetadata());
        assertEquals("area", area.getObject());
        assertNotNull(area.toString());
    }

}

package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.id.LobObjectId;
import com.lob.id.SettingId;
import com.lob.protocol.request.Filters;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.request.LobParam;
import com.lob.protocol.response.LobObjectDeleteResponse;
import com.lob.protocol.response.LobObjectResponse;
import com.lob.protocol.response.LobObjectResponseList;
import com.lob.protocol.response.SettingResponse;
import com.lob.protocol.response.ThumbnailResponse;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LobObjectTest extends BaseTest {
    @Test
    public void testListObjects() throws Exception {
        final LobObjectResponseList responseList = client.getLobObjects().get();
        assertEquals(200, responseList.getStatusCode());
        assertNotNull(responseList.getHeaders());
        assertEquals("application/json; charset=utf-8", responseList.getHeaders().getFirstValue("content-type"));

        final LobObjectResponse response = responseList.get(0);

        assertTrue(response instanceof LobObjectResponse);
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }

    @Test
    public void testListObjectsLimit() throws Exception {
        final LobObjectResponseList responseList = client.getLobObjects(2).get();
        final LobObjectResponse response = Iterables.get(responseList, 0);

        assertTrue(response instanceof LobObjectResponse);
        assertThat(responseList.getCount(), is(2));

        assertThat(client.getLobObjects(1, 2).get().getCount(), is(1));
    }

    @Test(expected = ExecutionException.class)
    public void testListObjectsFail() throws Exception {
        client.getLobObjects(1000).get();
    }

    @Test
    public void testCreateObjectUrl() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);

        final Map<String, String> data = Maps.newHashMap();
        data.put("key0", "value0");
        data.put("key1", "value1");

        final LobObjectRequest.Builder builder = LobObjectRequest.builder()
            .description("description")
            .file("https://s3-us-west-2.amazonaws.com/lob-assets/200_201_card.pdf")
            .setting(201)
            .metadata(metadata)
            .data(data);

        final LobObjectResponse response = client.createLobObject(builder.build()).get();

        assertTrue(response instanceof LobObjectResponse);
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));

        final LobObjectResponse metadataResponse = client.getLobObjects(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        client.createLobObject(builder.butWith().setting(201).build()).get();

        final LobObjectDeleteResponse deleteResponse = client.deleteLobObject(response.getId()).get();
        assertThat(deleteResponse.getId(), is(response.getId()));
        assertTrue(deleteResponse.isDeleted());
        assertNotNull(deleteResponse.toString());

        assertThat(response.getDescription(), is("description"));
        assertFalse(response.getObject().isEmpty());
        assertTrue(response.getQuantity() > 0);
        assertTrue(response.getPages() > 0);
        assertTrue(response.getSetting() instanceof SettingResponse);
        assertFalse(response.getThumbnails().isEmpty());
        assertFalse(response.getUrl().isEmpty());
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));

        final ThumbnailResponse thumbnail = response.getThumbnails().get(0);
        assertFalse(thumbnail.getLarge().isEmpty());
        assertFalse(thumbnail.getMedium().isEmpty());
        assertFalse(thumbnail.getSmall().isEmpty());

        final LobObjectRequest request = builder.build();
        assertThat(request.getMetadata().get("key0"), is(value0));
        assertThat(request.getMetadata().get("key1"), is(value1));
        assertThat(request.getData().get("key0"), is("value0"));
        assertThat(request.getData().get("key1"), is("value1"));
        assertThat(request.getDescription(), is("description"));
        assertTrue(request.getFile() instanceof LobParam);
        assertNull(request.getQuantity());
        assertTrue(request.getSetting() instanceof SettingId);
        assertNotNull(request.toString());
    }

    @Test
    public void testCreateObjectLocalFile() throws Exception {
        final File file = ClientUtil.fileFromResource("goblue.pdf");

        final LobObjectRequest request = LobObjectRequest.builder()
            .file(file)
            .setting(200)
            .build();

        final LobObjectResponse response = client.createLobObject(request).get();

        assertTrue(response instanceof LobObjectResponse);
    }

    @Test
    public void testRetrieveObject() throws Exception {
        final LobObjectResponseList responseList = client.getLobObjects(1).get();
        final LobObjectId id = Iterables.get(responseList, 0).getId();
        final LobObjectResponse retrievedResponse = client.getLobObject(id).get();

        assertTrue(retrievedResponse instanceof LobObjectResponse);
        assertThat(retrievedResponse.getId(), is(id));
    }
}

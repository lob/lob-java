package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.ServiceId;
import com.lob.protocol.response.ServiceResponse;
import com.lob.protocol.response.ServiceResponseList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ServiceTest extends BaseTest {
    @Test
    public void testServices() throws Exception {
        final ServiceResponseList responseList = client.getServices().get();
        final ServiceResponse response = responseList.get(0);

        assertThat(responseList.getData().get(0), is(response));
        assertTrue(response instanceof ServiceResponse);
        assertThat(responseList.getObject(), is("list"));
        assertFalse(responseList.isEmpty());
        assertTrue(responseList.size() > 0);
        assertTrue(responseList.iterator().hasNext());

        assertTrue(response.getId() instanceof ServiceId);
        assertFalse(response.getDescription().isEmpty());
        assertFalse(response.getName().isEmpty());
        assertFalse(response.getObject().isEmpty());
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }
}

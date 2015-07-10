package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.ServiceId;
import com.lob.protocol.response.ServiceResponse;
import com.lob.protocol.response.ServiceResponseList;
import org.junit.Test;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ServiceTest extends QuietLogging {
    private final LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @Test
    public void testServices() throws Exception {
        final ServiceResponseList responseList = print(client.getServices().get());
        final ServiceResponse response = print(responseList.get(0));

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
    }
}

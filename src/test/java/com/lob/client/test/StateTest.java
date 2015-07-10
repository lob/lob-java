package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.response.StateResponse;
import com.lob.protocol.response.StateResponseList;
import org.junit.Test;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StateTest extends QuietLogging {
    private final LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @Test
    public void testStates() throws Exception {
        final StateResponseList responseList = print(client.getStates().get());
        final StateResponse response = print(responseList.get(0));

        assertTrue(responseList.iterator().hasNext());
        assertTrue(responseList.size() > 0);
        assertFalse(responseList.isEmpty());
        assertTrue(response instanceof StateResponse);
        assertThat(responseList.getObject(), is("list"));
        assertTrue(response.getId() >= 0);
        assertFalse(response.getName().isEmpty());
        assertFalse(response.getShortName().isEmpty());
        assertThat(response.getObject(), is("state"));
    }
}

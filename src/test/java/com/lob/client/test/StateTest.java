package com.lob.client.test;

import com.lob.protocol.response.StateResponse;
import com.lob.protocol.response.StateResponseList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StateTest extends BaseTest {
    @Test
    public void testStates() throws Exception {
        final StateResponseList responseList = client.getStates().get();
        assertEquals(200, responseList.getStatusCode());
        assertNotNull(responseList.getHeaders());
        assertEquals("application/json; charset=utf-8", responseList.getHeaders().getFirstValue("content-type"));

        final StateResponse response = responseList.get(0);

        assertTrue(responseList.iterator().hasNext());
        assertTrue(responseList.size() > 0);
        assertFalse(responseList.isEmpty());
        assertTrue(response instanceof StateResponse);
        assertThat(responseList.getObject(), is("list"));
        assertTrue(response.getId() >= 0);
        assertFalse(response.getName().isEmpty());
        assertFalse(response.getShortName().isEmpty());
        assertThat(response.getObject(), is("state"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }
}

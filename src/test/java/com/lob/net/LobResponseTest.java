package com.lob.net;

import com.lob.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LobResponseTest extends BaseTest {

    @Test
    public void testLobResponse() {
        final LobResponse<String> response = new LobResponse<String>(200, "{}");

        assertEquals(200, response.getResponseCode());
        assertEquals("{}", response.getResponseBody());
        assertNull(response.getResponseHeaders());
    }

    @Test
    public void testLobResponseWithHeaders() {
        HashMap<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("User-Agent", Arrays.asList("LobBindingsTest"));

        final LobResponse<String> response = new LobResponse<String>(200, "{}", headers);

        assertEquals(200, response.getResponseCode());
        assertEquals("{}", response.getResponseBody());
        assertEquals(Arrays.asList("LobBindingsTest"), response.getResponseHeaders().get("User-Agent"));
    }

}

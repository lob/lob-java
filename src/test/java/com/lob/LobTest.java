package com.lob;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LobTest {

    @Test
    public void testLobInit() {
        final String API_KEY = "test_7b1960d06d6dfe28d3862b98380b8b0dc93";

        Lob.init(API_KEY);
        assertEquals(API_KEY, Lob.apiKey);
        assertNull(Lob.apiVersion);
    }

    @Test
    public void testLobInitWithApiVersion() {
        final String API_KEY = "test_7b1960d06d6dfe28d3862b98380b8b0dc93";
        final String API_VERSION = "    2017-09-01";

        Lob.init(API_KEY, API_VERSION);
        assertEquals(API_KEY, Lob.apiKey);
        assertEquals(API_VERSION, Lob.apiVersion);
    }

}

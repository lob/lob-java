package com.lob;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LobTest {

    @Test
    public void testLobInit() {
        final String API_KEY = System.getenv("LOB_API_KEY");

        Lob.init(API_KEY);
        assertEquals(API_KEY, Lob.apiKey);
        assertNull(Lob.apiVersion);
    }

    @Test
    public void testLobInitWithApiVersion() {
        final String API_KEY = System.getenv("LOB_API_KEY");
        final String API_VERSION = "2017-09-01";

        Lob.init(API_KEY, API_VERSION);
        assertEquals(API_KEY, Lob.apiKey);
        assertEquals(API_VERSION, Lob.apiVersion);
    }

}

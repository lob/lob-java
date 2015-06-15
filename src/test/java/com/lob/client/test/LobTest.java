package com.lob.client.test;

import com.google.common.base.Optional;
import com.lob.Lob;
import com.lob.client.AsyncLobClient;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LobTest extends QuietLogging {
    private final static String baseUrl = Lob.getBaseUrl();

    @AfterClass
    public static void tearDown() throws Exception {
        Lob.setBaseUrl(baseUrl);
        Lob.clearApiVersion();
    }

    @Test
    public void testSetApiVersion() throws Exception {
        Lob.setApiVersion("lol");
        assertThat(Lob.getApiVersion().get(), is("lol"));
    }

    @Test
    public void testSetBaseUrl() throws Exception {
        Lob.setBaseUrl("lol");
        assertThat(Lob.getBaseUrl(), is("lol"));
    }

    @Test(expected = ExecutionException.class)
    public void testInvalidAuth() throws Exception {
        Lob.setBaseUrl(baseUrl);
        Lob.clearApiVersion();

        AsyncLobClient.createDefault("lol").getAddresses().get();
    }
}

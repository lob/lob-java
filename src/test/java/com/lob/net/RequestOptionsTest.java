package com.lob.net;

import com.lob.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestOptionsTest extends BaseTest {

    @Test
    public void testRequestOptionsBuilder() throws Exception {
        final RequestOptions options = new RequestOptions.Builder()
                .setApiKey("test_123456789")
                .setIdempotencyKey("123456789")
                .build();

        assertEquals("test_123456789", options.getApiKey());
        assertNull(options.getLobVersion());
        assertEquals("123456789", options.getIdempotencyKey());
    }

    @Test
    public void testRequestOptionsBuilderGetters() throws Exception {
        final RequestOptions.Builder optionsBuilder = new RequestOptions.Builder()
                .setApiKey("test_123456789")
                .setLobVersion("2017-99-99")
                .setIdempotencyKey("123456789");

        assertEquals("test_123456789", optionsBuilder.getApiKey());
        assertEquals("2017-99-99", optionsBuilder.getLobVersion());
        assertEquals("123456789", optionsBuilder.getIdempotencyKey());
    }

    @Test
    public void testEquals() throws Exception {
        final RequestOptions options = RequestOptions.getDefault();
        final RequestOptions otherOptions = RequestOptions.getDefault();
        final RequestOptions differetApiKeyOptions = new RequestOptions.Builder().setApiKey("test_123456789").build();
        final RequestOptions differentVersionOptions = new RequestOptions.Builder().setLobVersion("2017-99-99").build();
        final RequestOptions differentIdempotencyOptions = new RequestOptions.Builder().setIdempotencyKey("123456789").build();

        assertEquals(options, otherOptions);
        assertNotEquals(options, differetApiKeyOptions);
        assertNotEquals(options, differentVersionOptions);
        assertNotEquals(options, differentIdempotencyOptions);
    }

}

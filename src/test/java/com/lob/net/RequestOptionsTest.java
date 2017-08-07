package com.lob.net;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestOptionsTest {

    @Test
    public void testRequestOptionsBuilder() throws Exception {
        final RequestOptions options = RequestOptions.builder()
                .setApiKey("test_123456789")
                .setIdempotencyKey("123456789")
                .build();

        assertEquals("test_123456789", options.getApiKey());
        assertNull(options.getLobVersion());
        assertEquals("123456789", options.getIdempotencyKey());
    }

    @Test
    public void testRequestOptionsBuilderGetters() throws Exception {
        final RequestOptions.RequestOptionsBuilder optionsBuilder = RequestOptions.builder()
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
        final RequestOptions differetApiKeyOptions = RequestOptions.builder().setApiKey("test_123456789").build();
        final RequestOptions differentVersionOptions = RequestOptions.builder().setLobVersion("2017-99-99").build();
        final RequestOptions differentIdempotencyOptions = RequestOptions.builder().setIdempotencyKey("123456789").build();

        assertEquals(options, otherOptions);
        assertNotEquals(options, differetApiKeyOptions);
        assertNotEquals(options, differentVersionOptions);
        assertNotEquals(options, differentIdempotencyOptions);
    }

}

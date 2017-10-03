package com.lob.net;

import com.lob.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ResponseGetterTest extends BaseTest {

    @Test
    public void testRequestOptionsBuilder() throws Exception {
        final RequestOptions options = new RequestOptions.Builder()
                .setApiKey("test_123456789")
                .setLobVersion("2017-99-99")
                .setIdempotencyKey("123456789")
                .build();

        final Map<String, String> headers = ResponseGetter.getHeaders(options);

        assertEquals("Basic dGVzdF8xMjM0NTY3ODk6", headers.get("Authorization"));
        assertThat(headers.get("User-Agent"), containsString("LobJava/"));
        assertEquals("123456789", headers.get("Idempotency-Key"));
    }

    @Test
    public void testCreateQuery() throws Exception {
        final Map<String, Object> nested = new HashMap<String, Object>();
        nested.put("b", "1");
        nested.put("c", "2");

        final List<String> list = new LinkedList<String>();
        list.add("f");
        list.add("g");

        final Map<String, Object> query = new HashMap<String, Object>();
        query.put("a", nested);
        query.put("d", 3);
        query.put("e", list);

        final String queryString = ResponseGetter.createQuery(query);

        assertThat(queryString, containsString("a%5Bb%5D=1"));
        assertThat(queryString, containsString("a%5Bc%5D=2"));
        assertThat(queryString, containsString("e%5B%5D=f"));
        assertThat(queryString, containsString("e%5B%5D=g"));
    }

}

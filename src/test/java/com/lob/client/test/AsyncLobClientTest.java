package com.lob.client.test;

import com.google.common.util.concurrent.ListenableFuture;
import com.lob.Lob;
import com.lob.client.AsyncLobClient;
import com.lob.protocol.response.AddressResponseList;
import com.ning.http.client.AsyncHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.FluentStringsMap;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutionException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AsyncLobClientTest extends BaseTest {
    private final static String baseUrl = Lob.getBaseUrl();

    @Mock private AsyncHttpClient httpClient;
    @Mock private AsyncHttpClient.BoundRequestBuilder builder;

    private AsyncLobClient lobClient;

    @Before
    public void setUp() throws Exception {
        final Constructor<AsyncLobClient> ctor = AsyncLobClient.class.getDeclaredConstructor(
            AsyncHttpClient.class,
            String.class);

        ctor.setAccessible(true);
        this.lobClient = ctor.newInstance(httpClient, baseUrl);

        when(httpClient.prepareGet(anyString())).thenReturn(builder);
        when(builder.setQueryParams(any(FluentStringsMap.class))).thenReturn(builder);

        Lob.setApiVersion("lol");

        AsyncLobClient.create("lol", new AsyncHttpClientConfig.Builder().build());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Lob.setBaseUrl(baseUrl);
        Lob.clearApiVersion();
    }

    @Test
    public void closeTest() throws Exception {
        lobClient.close();
    }

    @Test
    public void closeAsynchronouslyTest() throws Exception {
        lobClient.closeAsynchronously();
    }
}

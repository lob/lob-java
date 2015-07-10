package com.lob.client.test;

import com.google.common.util.concurrent.ListenableFuture;
import com.lob.Lob;
import com.lob.client.AsyncLobClient;
import com.lob.protocol.response.AddressResponseList;
import com.ning.http.client.AsyncHandler;
import com.ning.http.client.AsyncHttpClient;
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
import java.util.concurrent.ExecutorService;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AsyncLobClientTest extends QuietLogging {
    private final static String baseUrl = Lob.getBaseUrl();

    @Mock private AsyncHttpClient httpClient;
    @Mock private ExecutorService executorService;
    @Mock private AsyncHttpClient.BoundRequestBuilder builder;

    private AsyncLobClient lobClient;

    @Before
    public void setUp() throws Exception {
        final Constructor<AsyncLobClient> ctor = AsyncLobClient.class.getDeclaredConstructor(
            AsyncHttpClient.class,
            String.class,
            ExecutorService.class);

        ctor.setAccessible(true);
        this.lobClient = ctor.newInstance(httpClient, baseUrl, executorService);

        when(httpClient.prepareGet(anyString())).thenReturn(builder);
        when(builder.setQueryParameters(any(FluentStringsMap.class))).thenReturn(builder);

        Lob.setApiVersion("lol");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Lob.setBaseUrl(baseUrl);
        Lob.clearApiVersion();
    }

    @Test(expected = ExecutionException.class)
    public void requestIOExceptionTest() throws Exception {
        when(builder.execute(any(AsyncHandler.class))).thenThrow(new IOException());

        final ListenableFuture<AddressResponseList> responseList = lobClient.getAddresses();
        responseList.get();
    }
}

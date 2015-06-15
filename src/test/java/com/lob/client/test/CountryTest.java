package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.response.CountryResponse;
import com.lob.protocol.response.CountryResponseList;
import org.junit.Test;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CountryTest extends QuietLogging {
    private final LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @Test
    public void testCountries() throws Exception {
        final CountryResponseList responseList = print(client.getCountries().get());
        final CountryResponse response = print(responseList.get(0));

        assertTrue(response instanceof CountryResponse);
        assertThat(responseList.getObject(), is("list"));
    }
}

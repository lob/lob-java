package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.response.CountryResponse;
import com.lob.protocol.response.CountryResponseList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountryTest extends BaseTest {
    @Test
    public void testCountries() throws Exception {
        final CountryResponseList responseList = client.getCountries().get();
        final CountryResponse response = responseList.get(0);

        assertTrue(response instanceof CountryResponse);
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }
}

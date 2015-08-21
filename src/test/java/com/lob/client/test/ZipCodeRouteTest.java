package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.ZipCode;
import com.lob.id.ZipCodeRouteId;
import com.lob.protocol.request.ZipCodeRouteRequest;
import com.lob.protocol.response.RouteResponse;
import com.lob.protocol.response.ZipCodeRouteResponse;
import com.lob.protocol.response.ZipCodeRouteResponseList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ZipCodeRouteTest extends BaseTest {
    @Test
    public void testZipCodeRoute() throws Exception {
        final ZipCodeRouteRequest request = ZipCodeRouteRequest.builder()
            .addStringZips("94158", "60031")
            .build();
        final ZipCodeRouteResponseList responseList = client.getZipCodeRoutes(request).get();
        final ZipCodeRouteResponse response = responseList.get(0);

        assertTrue(response instanceof ZipCodeRouteResponse);
        assertThat(responseList.getObject(), is("list"));

        final RouteResponse route = response.getRoutes().get(0);
        assertFalse(route.getObject().isEmpty());
        assertFalse(request.getZipCodes().isEmpty());
    }

    @Test
    public void testZipCodeRouteWithZipCodeClass() throws Exception {

        final ZipCode zip1 = ZipCode.parse("94158");
        final ZipCode zip2 = ZipCode.parse("60031");
        final ZipCode zip3 = ZipCode.parse("02139");

        final ZipCodeRouteRequest request = ZipCodeRouteRequest.builder()
                .addZips(zip1, zip2, zip3)
                .build();
        final ZipCodeRouteResponseList responseList = client.getZipCodeRoutes(request).get();
        final ZipCodeRouteResponse response = responseList.get(0);

        assertTrue(response instanceof ZipCodeRouteResponse);
        assertThat(responseList.getObject(), is("list"));

        final RouteResponse route = response.getRoutes().get(0);
        assertFalse(route.getObject().isEmpty());
        assertFalse(request.getZipCodes().isEmpty());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidId() throws Exception {
        ZipCodeRouteId.parse("lolol");
    }
}

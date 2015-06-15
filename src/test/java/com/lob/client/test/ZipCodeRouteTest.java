package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.ZipCodeRouteRequest;
import com.lob.protocol.response.RouteResponse;
import com.lob.protocol.response.ZipCodeRouteResponse;
import com.lob.protocol.response.ZipCodeRouteResponseList;
import org.junit.Test;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ZipCodeRouteTest extends QuietLogging {
    private final LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @Test
    public void testZipCodeRoute() throws Exception {
        final ZipCodeRouteRequest request = print(
            ZipCodeRouteRequest.builder()
                .addStringZips("94158", "60031")
                .build());
        final ZipCodeRouteResponseList responseList = print(client.getZipCodeRoutes(request).get());
        final ZipCodeRouteResponse response = print(responseList.get(0));

        assertTrue(response instanceof ZipCodeRouteResponse);
        assertThat(responseList.getObject(), is("list"));

        final RouteResponse route = print(response.getRoutes().get(0));
        print(route.getBusiness());
        print(route.getResidential());
        assertFalse(route.getObject().isEmpty());
        print(response.getZipCode().toZipCodeRouteId(route.getRoute()));

        assertFalse(request.getZipCodes().isEmpty());
    }
}

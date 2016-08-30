package com.lob.client.test;

import com.lob.id.ZipCode;
import com.lob.id.ZipCodeRouteId;
import com.lob.protocol.request.ZipCodeRouteRequest;
import com.lob.protocol.response.RouteResponse;
import com.lob.protocol.response.ZipCodeRouteResponse;
import com.lob.protocol.response.ZipCodeRouteResponseList;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZipCodeRouteTest extends BaseTest {
    @Test
    public void testZipCodeRoute() throws Exception {
        final ZipCodeRouteRequest request = ZipCodeRouteRequest.builder()
            .addStringZips("94158", "60031")
            .addZips(ZipCode.parse("94158"), ZipCode.parse("60031"))
            .build();
        assertNotNull(request.toString());
        final ZipCodeRouteResponseList responseList = client.getZipCodeRoutes(request).get();
        assertEquals(200, responseList.getStatusCode());
        assertNotNull(responseList.getHeaders());
        assertEquals("application/json; charset=utf-8", responseList.getHeaders().getFirstValue("content-type"));

        final ZipCodeRouteResponse response = responseList.get(0);

        assertTrue(response instanceof ZipCodeRouteResponse);
        assertThat(responseList.getObject(), is("list"));

        final RouteResponse route = response.getRoutes().get(0);
        assertFalse(route.getObject().isEmpty());
        assertFalse(request.getZipCodes().isEmpty());
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
        assertNotNull(route.getResidential());
        assertNotNull(route.getBusiness());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidId() throws Exception {
        ZipCodeRouteId.parse("lolol");
    }
}

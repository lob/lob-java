package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RoutesTest extends BaseTest {

    @Test
    public void testListRoutes() throws Exception {
        ArrayList<String> zipCodes = new ArrayList<String>();
        zipCodes.add("94158");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("zip_codes", zipCodes);

        LobResponse<RoutesCollection> response = Routes.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals("94158", response.getResponseBody().getData().get(0).getZipCode());
        assertEquals(7, response.getResponseBody().getData().get(0).getRoutes().size());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Routes.class));
    }

    @Test
    public void testRetrieveRoute() throws Exception {
        Routes routes = Routes.retrieve("94158-C002").getResponseBody();

        assertEquals("94158", routes.getZipCode());
        assertEquals("C002", routes.getRoutes().get(0).getRoute());
    }

}

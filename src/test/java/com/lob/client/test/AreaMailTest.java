package com.lob.client.test;

import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.OrCollection;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.AreaMailId;
import com.lob.id.RouteId;
import com.lob.id.ZipCode;
import com.lob.id.ZipCodeRouteId;
import com.lob.protocol.request.AreaMailRequest;
import com.lob.protocol.request.Filters;
import com.lob.protocol.request.LobParam;
import com.lob.protocol.request.TargetType;
import com.lob.protocol.request.ZipCodeRouteRequest;
import com.lob.protocol.response.AreaMailResponse;
import com.lob.protocol.response.AreaMailResponseList;
import com.lob.protocol.response.ZipCodeRouteResponseList;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AreaMailTest extends BaseTest {
    @Test
    public void testCreateArea() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);

        final AreaMailRequest.Builder builder = AreaMailRequest.builder()
            .description("area mail")
            .front("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
            .back("https://s3-us-west-2.amazonaws.com/lob-assets/areafront.pdf")
            .routesForZips("94158", "60031")
            .targetType(TargetType.ALL)
            .metadata(metadata);

        final AreaMailResponse response = client.createAreaMail(builder.build()).get();
        assertTrue(response instanceof AreaMailResponse);

        final ZipCodeRouteRequest routeRequest = ZipCodeRouteRequest.builder().addStringZips("94158").build();
        final ZipCodeRouteResponseList route = client.getZipCodeRoutes(routeRequest).get();

        assertTrue(response.getId() instanceof AreaMailId);
        assertThat(response.getDescription(), is("area mail"));
        assertFalse(response.getUrl().isEmpty());
        assertThat(response.getObject(), is("area"));
        assertTrue(response.getExpectedDeliveryDate() instanceof DateTime);
        assertTrue(response.getNumAddresses() > 0);
        assertTrue(response.getPrice() instanceof Money);
        assertTrue(response.getTargetType() instanceof TargetType);
        assertFalse(response.getThumbnails().isEmpty());
        assertFalse(response.getZipCodeRouteResponses().isEmpty());
        assertTrue(response.getDateCreated() instanceof DateTime);
        assertTrue(response.getDateModified() instanceof DateTime);
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));
        assertNotNull(route.toString());
        assertNotNull(response.toString());

        final AreaMailResponse metadataResponse = client.getAreaMails(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        final ZipCodeRouteId routeId = ZipCodeRouteId.parse("94158-C001");
        assertTrue(routeId.getRouteId() instanceof RouteId);
        assertTrue(routeId.getZipCode() instanceof ZipCode);

        final AreaMailRequest request = builder.build();
        assertTrue(request.getBack() instanceof LobParam);
        assertTrue(request.getFront() instanceof LobParam);
        assertTrue(request.getRoutes() instanceof OrCollection);
        assertTrue(request.getTargetType() instanceof TargetType);

        final AreaMailId id = response.getId();
        final AreaMailResponse retrievedResponse = client.getAreaMail(id).get();
        assertThat(retrievedResponse.getId(), is(id));
        assertNotNull(retrievedResponse.toString());
    }

    @Test
    public void testCreateAreaLocalFile() throws Exception {
        final ZipCodeRouteRequest routeRequest = ZipCodeRouteRequest.builder().addStringZips("94158").build();
        final ZipCodeRouteResponseList route = client.getZipCodeRoutes(routeRequest).get();
        final File front = ClientUtil.fileFromResource("areafront.pdf");
        final File back = ClientUtil.fileFromResource("areaback.pdf");

        final AreaMailRequest request = AreaMailRequest.builder()
            .front(front)
            .back(back)
            .routes(route)
            .targetType(TargetType.ALL)
            .build();

        final AreaMailResponse response = client.createAreaMail(request).get();
        assertTrue(response instanceof AreaMailResponse);
    }

    @Test
    public void testListAreas() throws Exception {
        final AreaMailResponseList responseList = client.getAreaMails().get();
        final AreaMailResponse response = responseList.get(0);
        assertTrue(response instanceof AreaMailResponse);
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
    }

    @Test
    public void testListAreasLimit() throws Exception {
        final AreaMailResponseList responseList = client.getAreaMails(2).get();
        final AreaMailResponse response = responseList.get(0);
        assertTrue(response instanceof AreaMailResponse);
        assertThat(responseList.getCount(), is(2));

        assertThat(client.getAreaMails(1, 2).get().getCount(), is(1));
    }

    @Test(expected = ExecutionException.class)
    public void testListAreasFail() throws Exception {
        client.getAreaMails(1000).get();
    }
}

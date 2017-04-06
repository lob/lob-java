package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.Or;
import com.lob.id.AddressId;
import com.lob.id.PostcardId;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.Filters;
import com.lob.protocol.request.LobParam;
import com.lob.protocol.request.PostcardRequest;
import com.lob.protocol.response.*;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class PostcardTest extends BaseTest {
    @Test
    public void testListPostcards() throws Exception {
        final PostcardResponseList responseList = client.getPostcards().get();
        assertEquals(200, responseList.getStatusCode());
        assertNotNull(responseList.getHeaders());
        assertEquals("application/json; charset=utf-8", responseList.getHeaders().getFirstValue("content-type"));

        final PostcardResponse response = responseList.get(0);

        assertTrue(response instanceof PostcardResponse);
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
        assertNull(response.getMessage());
    }

    @Test
    public void testListPostcardsLimit() throws Exception {
        final PostcardResponseList responseList = client.getPostcards(2).get();

        assertThat(responseList.getCount(), is(2));
        assertThat(responseList.getObject(), is("list"));

        assertThat(client.getPostcards(1, 2).get().getCount(), is(1));
    }

    @Test(expected = ExecutionException.class)
    public void testListPostcardsFail() throws Exception {
        client.getPostcards(1000).get();
    }

    @Test
    public void testCreatePostcard() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);
        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);

        final PostcardRequest.Builder builder = PostcardRequest.builder()
                .description("postcard")
                .to(address.getId())
                .from(address.getId())
                .front("<h1>testing</h1>")
                .back("<h1>testing</h1>")
                .size("6x11")
                .metadata(metadata);

        final PostcardRequest request1 = builder.build();
        assertNotNull(request1.toString());
        final PostcardResponse response = client.createPostcard(request1).get();
        assertTrue(response instanceof PostcardResponse);
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getDescription(), is("postcard"));
        assertThat(response.getUrl(), containsString(response.getId().toString()));
        assertNotNull(response.getExpectedDeliveryDate());
        assertEquals(2, response.getThumbnails().size());
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(response.getSize(), is("6x11"));
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));

        final PostcardResponse metadataResponse = client.getPostcards(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        assertNull(response.getPrice());

        final Or<AddressId, AddressRequest> orAddress = Or.typeA(address.getId());
        final PostcardRequest request2 = builder
                .butWith()
                .to(orAddress)
                .from(orAddress)
                .message("Hello World!")
                .build();
        assertTrue(request2.getBack() instanceof LobParam);
        assertEquals("Hello World!", request2.getMessage());
        assertTrue(request2.getFrom() instanceof Or);
        assertTrue(request2.getFront() instanceof LobParam);
        assertEquals("6x11", request2.getSize());
        assertTrue(request2.getTo() instanceof Or);
    }

    @Test
    public void testCreatePostcardInline() throws Exception {
        final PostcardRequest request = PostcardRequest.builder()
                .to(
                        AddressRequest.builder()
                                .name("Lob0")
                                .line1("185 Berry Street")
                                .line2("Suite 1510")
                                .city("San Francisco")
                                .state("CA")
                                .zip("94107")
                                .country("US")
                                .build())
                .from(
                        AddressRequest.builder()
                                .name("Lob1")
                                .line1("185 Berry Street")
                                .line2("Suite 1510")
                                .city("San Francisco")
                                .state("CA")
                                .zip("94107")
                                .country("US")
                                .build())
                .front(LobParam.file("front", ClientUtil.fileFromResource("postcardfront.pdf")))
                .back(LobParam.file("back", ClientUtil.fileFromResource("postcardback.pdf")))
                .build();

        final PostcardResponse response = client.createPostcard(request).get();
        assertTrue(response instanceof PostcardResponse);
        assertThat(response.getTo().getName(), is("Lob0"));
        assertThat(response.getFrom().getName(), is("Lob1"));
    }

    @Test
    public void testCreatePostcardNoFrom() throws Exception {
        final PostcardRequest request = PostcardRequest.builder()
                .to(
                        AddressRequest.builder()
                                .name("Lob0")
                                .line1("185 Berry Street")
                                .line2("Suite 1510")
                                .city("San Francisco")
                                .state("CA")
                                .zip("94107")
                                .country("US")
                                .build())
                .front("https://lob.com/4x6_postcard_template.pdf")
                .back("https://lob.com/4x6_postcard_template.pdf")
                .build();

        final PostcardResponse response = client.createPostcard(request).get();
        assertTrue(response instanceof PostcardResponse);
        assertThat(response.getTo().getName(), is("Lob0"));
        assertNull(response.getFrom());
    }

    @Test
    public void testCreatePostcardLocalFile() throws Exception {
        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);
        final File file = ClientUtil.fileFromResource("postcardfront.pdf");

        final PostcardRequest request = PostcardRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .front(file)
                .back(file)
                .build();

        final PostcardResponse response = client.createPostcard(request).get();
        assertTrue(response instanceof PostcardResponse);

        final PostcardResponse retrievedResponse = client.getPostcard(response.getId()).get();
        assertThat(retrievedResponse.getId(), is(response.getId()));
    }

    @Test
    public void testCreatePostcardSendDate() throws Exception {
        // Date time 5 days in the future
        final DateTime fiveDaysFromNow = new DateTime().plusDays(5);

        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);
        final File file = ClientUtil.fileFromResource("postcardfront.pdf");

        final PostcardRequest request = PostcardRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .front(file)
                .back(file)
                .sendDate(fiveDaysFromNow)
                .build();

        final PostcardResponse response = client.createPostcard(request).get();
        assertTrue(response instanceof PostcardResponse);
        assertTrue(response.getSendDate() instanceof String);

        final PostcardResponse retrievedResponse = client.getPostcard(response.getId()).get();
        assertThat(retrievedResponse.getId(), is(response.getId()));
    }

    @Test
    public void testTrackingEvents() throws Exception {
        final PostcardResponse response = client.getPostcard(PostcardId.parse("psc_d1f8830b03cde4ef")).get();

        assertEquals("USPS", response.getCarrier());
        assertEquals(1, response.getTrackingEvents().size());

        final TrackingEventResponse event = response.getTrackingEvents().get(0);

        assertEquals("Scanned", event.getName());
        assertEquals("14692", event.getLocation());
        assertNotNull(event.getTime());
        assertNotNull(event.getDateCreated());
        assertNotNull(event.getDateModified());
        assertEquals("tracking_event", event.getObject());
        assertNotNull(event.toString());
    }

    @Test
    public void testDeletePostcard() throws Exception {
        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);

        final PostcardRequest.Builder builder = PostcardRequest.builder()
                .to(address.getId())
                .front("<h1>testing</h1>")
                .back("<h1>testing</h1>");

        final PostcardRequest request = builder.build();

        final PostcardId id = client.createPostcard(request).get().getId();
        final PostcardDeleteResponse response = client.deletePostcard(id).get();
        assertThat(response.getId(), is(id));
        assertTrue(response.isDeleted());
        assertNotNull(response.toString());
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));
    }
}

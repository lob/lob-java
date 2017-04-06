package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.id.LetterId;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.Filters;
import com.lob.protocol.request.LetterRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.LetterDeleteResponse;
import com.lob.protocol.response.LetterResponse;
import com.lob.protocol.response.LetterResponseList;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LetterTest extends BaseTest {
    @Test
    public void testListLetters() throws Exception {
        final LetterResponseList responseList = client.getLetters().get();
        assertEquals(200, responseList.getStatusCode());
        assertNotNull(responseList.getHeaders());
        assertEquals("application/json; charset=utf-8", responseList.getHeaders().getFirstValue("content-type"));

        final LetterResponse response = responseList.get(0);

        assertThat(client.getLetter(response.getId()).get().getId(), is(response.getId()));
        assertTrue(response instanceof LetterResponse);
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }

    @Test
    public void testListLettersLimit() throws Exception {
        final LetterResponseList responseList = client.getLetters(2).get();

        assertThat(responseList.getCount(), is(2));
        assertThat(responseList.getObject(), is("list"));
        assertThat(client.getLetters(1, 2).get().getCount(), is(1));
    }

    @Test(expected = ExecutionException.class)
    public void testListLettersFail() throws Exception {
        client.getLetters(1000).get();
    }

    @Test
    public void testCreateLetter() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);
        final AddressResponse address = client.getAddresses(1).get().get(0);

        final Map<String, String> data = Maps.newHashMap();
        data.put("name", "peter");
        final String file = "<html style='padding-top: 3in; margin: .5in;'>HTML Letter for {{name}}</html>";
        final LetterRequest.Builder builder = LetterRequest.builder()
            .to(address.getId())
            .from(address.getId())
            .file(file)
            .data(data)
            .color(true)
            .addressPlacement("top_first_page")
            .doubleSided(false)
            .metadata(metadata)
            .description("letter");

        final LetterRequest request = builder.build();
        assertThat(Iterables.get(request.getFile().getStringParam(), 0), is(file));

        final LetterResponse response = client.createLetter(request).get();
        assertTrue(response instanceof LetterResponse);
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(response.getDescription(), is("letter"));
        assertTrue(response.getExpectedDeliveryDate() instanceof DateTime);
        assertFalse(response.getUrl().isEmpty());
        assertTrue(response.isColor());
        assertFalse(response.isDoubleSided());
        assertThat(response.getAddressPlacement(), is("top_first_page"));
        assertNull(response.getExtraService());
        assertFalse(response.isReturnEnvelope());
        assertNull(response.getPerforatedPage());
        assertEquals(1, response.getThumbnails().size());
        assertNotNull(response.getTrackingEvents());
        assertNull(response.getTrackingNumber());
        assertNotNull(response.getCarrier());
        assertThat(response.getPages(), is(0));
        assertTrue(response.getId() instanceof LetterId);
        assertNull(response.getPrice());
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));

        final LetterResponse metadataResponse = client.getLetters(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        final AddressRequest addrRequest = AddressRequest.builder()
            .name("Lob0")
            .line1("185 Berry Street")
            .line2("Suite 1510")
            .city("San Francisco")
            .state("CA")
            .zip("94107")
            .country("US")
            .build();

        final LetterRequest otherRequest = builder.butWith()
            .description("otherRequest")
            .color(false)
            .to(addrRequest)
            .from(addrRequest)
            .file(ClientUtil.fileFromResource("goblue.pdf"))
            .build();

        assertThat(otherRequest.getDescription(), is("otherRequest"));
        assertThat(otherRequest.getFrom().getTypeB(), is(addrRequest));
        assertThat(otherRequest.getTo().getTypeB(), is(addrRequest));
        assertThat(otherRequest.getData(), is(data));
        assertThat(otherRequest.getMetadata(), is(metadata));
        assertFalse(otherRequest.isColor());
        assertFalse(otherRequest.isDoubleSided());
        assertThat(otherRequest.getAddressPlacement(), is("top_first_page"));
    }

    @Test
    public void testCreateCertifiedLetter() throws Exception {
        final AddressResponse address = client.getAddresses(1).get().get(0);
        final String file = "<html style='padding-top: 3in; margin: .5in;'>HTML Letter</html>";
        final String extraService = "certified";

        final LetterRequest.Builder builder = LetterRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .file(file)
                .color(true)
                .addressPlacement("top_first_page")
                .doubleSided(false)
                .extraService(extraService)
                .description("letter");

        final LetterRequest request = builder.build();

        assertThat(request.getExtraService(), is(extraService));
        assertNotNull(request.toString());

        final LetterResponse response = client.createLetter(request).get();

        assertThat(response.getExtraService(), is(extraService));
    }

    @Test
    public void testCreateLetterSendDate() throws Exception {
        // Date time 5 days in the future
        final DateTime fiveDaysFromNow = new DateTime().plusDays(5);

        final AddressResponse address = client.getAddresses(1).get().get(0);
        final String file = "<html style='padding-top: 3in; margin: .5in;'>HTML Letter</html>";

        final LetterRequest.Builder builder = LetterRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .file(file)
                .color(true)
                .addressPlacement("top_first_page")
                .doubleSided(false)
                .sendDate(fiveDaysFromNow)
                .description("letter");

        final LetterRequest request = builder.build();
        assertNotNull(request.toString());

        final LetterResponse response = client.createLetter(request).get();
        assertTrue(response.getSendDate() instanceof String);
    }

    @Test
    public void testCreateReturnEnvelopeLetter() throws Exception {
        final AddressResponse address = client.getAddresses(1).get().get(0);
        final String file = "<html style='padding-top: 3in; margin: .5in;'>HTML Letter</html>";
        final int perforatedPage = 1;

        final LetterRequest.Builder builder = LetterRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .file(file)
                .color(true)
                .addressPlacement("top_first_page")
                .doubleSided(false)
                .returnEnvelope(true)
                .perforatedPage(perforatedPage)
                .description("letter");

        final LetterRequest request = builder.build();

        assertTrue(request.isReturnEnvelope());
        assertThat(request.getPerforatedPage(), is(perforatedPage));

        final LetterResponse response = client.createLetter(request).get();

        assertTrue(response.isReturnEnvelope());
        assertThat(response.getPerforatedPage(), is(perforatedPage));
    }

    @Test
    public void testDeleteLetter() throws Exception {
        final AddressResponse address = client.getAddresses(1).get().get(0);
        final String file = "<html style='padding-top: 3in; margin: .5in;'>HTML Letter for {{name}}</html>";

        final LetterRequest.Builder builder = LetterRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .color(false)
                .file(file);

        final LetterRequest request = builder.build();

        final LetterId id = client.createLetter(request).get().getId();
        final LetterDeleteResponse response = client.deleteLetter(id).get();
        assertThat(response.getId(), is(id));
        assertTrue(response.isDeleted());
        assertNotNull(response.toString());
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getHeaders());
        assertEquals("application/json; charset=utf-8", response.getHeaders().getFirstValue("content-type"));
    }
}

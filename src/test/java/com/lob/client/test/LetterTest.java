package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.Or;
import com.lob.OrCollection;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.JobRequest;
import com.lob.protocol.request.LetterRequest;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.JobResponse;
import com.lob.protocol.response.LetterResponse;
import com.lob.protocol.response.LetterResponseList;
import com.lob.protocol.response.LobObjectResponse;
import com.lob.protocol.response.LobObjectResponseList;
import com.lob.protocol.response.TrackingResponse;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LetterTest extends QuietLogging {
    private final LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @Test
    public void testListLetters() throws Exception {
        final LetterResponseList responseList = print(client.getLetters().get());
        final LetterResponse response = print(responseList.get(0));

        assertTrue(response instanceof LetterResponse);
        assertThat(responseList.getObject(), is("list"));
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
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", "value0");
        metadata.put("key1", "value1");
        final AddressResponse address = client.getAddresses(1).get().get(0);

        final Map<String, String> data = Maps.newHashMap();
        data.put("name", "peter");
        final LetterRequest.Builder builder = print(
            LetterRequest.builder()
                .to(address.getId())
                .from(address.getId())
                .file("<html style='padding-top: 3in; margin: .5in;'>HTML Letter for {{name}}</html>")
                .data(data)
                .color(true)
                .metadata(metadata));

        final LetterResponse response = print(client.createLetter(builder.build()).get());
        assertTrue(response instanceof LetterResponse);
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(response.getMetadata().get("key0"), is("value0"));
        assertThat(response.getMetadata().get("key1"), is("value1"));

        assertFalse(response.getStatus().isEmpty());
    }
}

package com.lob.client.test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.lob.ClientUtil;
import com.lob.Or;
import com.lob.OrCollection;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.Filters;
import com.lob.protocol.request.JobRequest;
import com.lob.protocol.request.LobObjectRequest;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.JobResponse;
import com.lob.protocol.response.JobResponseList;
import com.lob.protocol.response.LobObjectResponse;
import com.lob.protocol.response.LobObjectResponseList;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class JobTest extends BaseTest {
    @Test
    public void testListJobs() throws Exception {
        final JobResponseList responseList = client.getJobs().get();
        final JobResponse response = responseList.get(0);

        assertTrue(response instanceof JobResponse);
        assertThat(responseList.getObject(), is("list"));
    }

    @Test
    public void testListJobsLimit() throws Exception {
        final JobResponseList responseList = client.getJobs(2).get();

        assertThat(responseList.getCount(), is(2));
        assertThat(responseList.getObject(), is("list"));
        assertThat(client.getJobs(1, 2).get().getCount(), is(1));
    }

    @Test(expected = ExecutionException.class)
    public void testListJobsFail() throws Exception {
        client.getJobs(1000).get();
    }

    @Test
    public void testCreateJob() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);
        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);
        final LobObjectResponseList objects = client.getLobObjects(1).get();
        final LobObjectResponse lobObject = objects.get(0);

        final JobRequest.Builder builder = JobRequest.builder()
            .to(address.getId())
            .from(address.getId())
            .objectIds(lobObject.getId())
            .metadata(metadata);

        final JobResponse response = client.createJob(builder.build()).get();
        assertTrue(response instanceof JobResponse);
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(response.getObjects().get(0).getId(), is(lobObject.getId()));
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));

        final JobResponse metadataResponse = client.getJobs(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        assertFalse(response.getPrice().isEmpty());

        final JobRequest otherRequest = builder.butWith().objectIds(objects).build();
        assertTrue(otherRequest.getFrom() instanceof Or);
        assertTrue(otherRequest.getTo() instanceof Or);
        assertTrue(otherRequest.getObjects() instanceof OrCollection);
        assertNull(otherRequest.getService());

    }

    @Test
    public void testCreateJobInline() throws Exception {
        final JobRequest request = JobRequest.builder()
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
            .objects(
                LobObjectRequest.builder()
                    .file("https://s3-us-west-2.amazonaws.com/lob-assets/200_201_card.pdf")
                    .setting(200)
                .build())
            .build();

        final JobResponse response = client.createJob(request).get();
        assertTrue(response instanceof JobResponse);
        assertThat(response.getTo().getName(), is("Lob0"));
        assertThat(response.getFrom().getName(), is("Lob1"));
    }

    @Test
    public void testCreateJobMultiObject() throws Exception {
        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);

        final JobRequest request = JobRequest.builder()
            .to(address.getId())
            .from(address.getId())
            .objects(
                LobObjectRequest.builder()
                    .file(ClientUtil.fileFromResource("goblue.pdf"))
                    .setting(200)
                    .quantity(2)
                    .build())
            .build();

        final JobResponse response = client.createJob(request).get();
        assertTrue(response instanceof JobResponse);
        assertThat(response.getTo().getId(), is(address.getId()));
        assertThat(response.getFrom().getId(), is(address.getId()));
        assertThat(Iterables.get(response.getObjects(), 0).getQuantity(), is(2));
    }

    @Test
    public void testCreateJobLocalFile() throws Exception {
        final AddressResponse address = Iterables.get(client.getAddresses(1).get(), 0);

        final JobRequest request = JobRequest.builder()
            .to(address.getId())
            .from(address.getId())
            .objects(
                LobObjectRequest.builder()
                    .file(ClientUtil.fileFromResource("goblue.pdf"))
                    .setting(200)
                    .build())
            .build();

        final JobResponse response = client.createJob(request).get();
        assertTrue(response instanceof JobResponse);

        final JobResponse retrievedResponse = client.getJob(response.getId()).get();
        assertThat(retrievedResponse.getId(), is(response.getId()));
    }
}

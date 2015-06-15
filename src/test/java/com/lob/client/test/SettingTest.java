package com.lob.client.test;

import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.id.SettingId;
import com.lob.protocol.response.SettingResponse;
import com.lob.protocol.response.SettingResponseList;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SettingTest extends QuietLogging {
    public static final SettingId SETTING_ID = SettingId.parse(200);
    private final LobClient client = AsyncLobClient.createDefault("test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc");

    @Test
    public void testSettings() throws Exception {
        final SettingResponseList responseList = print(client.getSettings().get());
        final SettingResponse response = print(responseList.get(0));

        assertTrue(response instanceof SettingResponse);
        assertThat(responseList.getObject(), is("list"));

        assertFalse(responseList.isEmpty());
        assertTrue(responseList.size() > 0);
        assertTrue(responseList.iterator().hasNext());
    }

    @Test
    public void testRetrieveSetting() throws Exception {
        final SettingResponse response = client.getSetting(SETTING_ID).get();

        assertTrue(response instanceof SettingResponse);
        assertThat(response.getId(), is(SETTING_ID));

        assertFalse(response.getColor().isEmpty());
        assertFalse(response.getDescription().isEmpty());
        assertFalse(response.getLength().isEmpty());
        assertFalse(response.getNotes().isEmpty());
        assertThat(response.getObject(), is("setting"));
        assertFalse(response.getPaper().isEmpty());
        assertFalse(response.getType().isEmpty());
        assertFalse(response.getWidth().isEmpty());
    }

    @Test(expected = ExecutionException.class)
    public void testRetrieveSettingFail() throws Exception {
        client.getSetting(SettingId.parse(132123)).get();
    }
}

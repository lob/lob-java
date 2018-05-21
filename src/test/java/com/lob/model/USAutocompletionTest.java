package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class USAutocompletionTest extends BaseTest {

    @Test
    public void testUSAutocompletion() throws Exception {
        LobResponse<USAutocompletion> response = new USAutocompletion.RequestBuilder()
            .setAddressPrefix("185 BER")
            .setCity("SAN FRANCISCO")
            .setState("CA")
            .autocomplete();

        USAutocompletion usAutocompletion = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(usAutocompletion.getId());
        assertThat(usAutocompletion.getSuggestions().get(0), instanceOf(USAutocompletion.Suggestion.class));
        assertEquals("us_autocompletion", usAutocompletion.getObject());
    }

}

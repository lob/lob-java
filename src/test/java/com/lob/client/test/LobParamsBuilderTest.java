package com.lob.client.test;

import com.lob.LobParamsBuilder;
import com.lob.Or;
import com.lob.OrCollection;
import com.lob.id.RouteId;
import org.joda.money.Money;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LobParamsBuilderTest extends QuietLogging {

    @Test
    @SuppressWarnings("unchecked")
    public void testLotsOfNulls() throws Exception {
        final LobParamsBuilder builder = LobParamsBuilder.create()
            .put("key", (String) null)
            .put("key", (Boolean) null)
            .put("key", (Integer) null)
            .put("key", (Money) null)
            .put("key", (Or) null)
            .put("key", (RouteId) null)
            .putAllInts("key", null)
            .putAllStrings("key", null)
            .putAllStringValued("key", (Collection) null)
            .putAllStringValued("key", (OrCollection) null)
            .putMap("key", (Map) null)
            .putLobParams("key", null);

        assertTrue(builder.build().isEmpty());
    }
}

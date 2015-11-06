package com.lob.client.test;

import com.lob.id.AddressId;
import com.lob.id.IntegerId;
import com.lob.id.LobId;
import com.lob.id.ServiceId;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class IdTest extends BaseTest {

    @Test
    public void testEquals() throws Exception {
        final AddressId id = AddressId.parse("adr_0000000000000000");
        final AddressId other = AddressId.parse("adr_0000000000000001");
        assertTrue(id.equals(id));
        assertFalse(id.equals(null));
        assertFalse(id.equals(other));
        assertFalse(id.hashCode() == other.hashCode());
    }
    @Test
    public void testIntegerId() throws Exception {
        final IntegerId id = ServiceId.create(1);
        assertTrue(id.equals(id));
        assertFalse(id.equals(null));
        assertFalse(id.equals(ServiceId.create(2)));

        final IntegerId otherId = ServiceId.create(1);
        assertEquals(id.hashCode(), otherId.hashCode());

        assertThat(ServiceId.parse("1").getId(), is(1));
    }

    @Test
    public void testServiceId() throws Exception {
        assertEquals(ServiceId.create(1).getId(), 1);
    }

    private static class FakeId extends LobId {
        public FakeId(final String id) {
            super(Prefix.ADDRESS, id);
        }
    }

    @Test
    public void testLobId() throws Exception {
        final LobId id = AddressId.parse("adr_1111111111111111");
        assertTrue(id.equals(id));
        assertFalse(id.equals(null));

        final LobId otherId = AddressId.parse("adr_1111111111111111");
        assertEquals(id.hashCode(), otherId.hashCode());
    }

}

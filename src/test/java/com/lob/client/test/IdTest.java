package com.lob.client.test;

import com.lob.id.AddressId;
import com.lob.id.IntegerId;
import com.lob.id.LobId;
import com.lob.id.PackagingId;
import com.lob.id.ServiceId;
import org.junit.Test;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class IdTest extends QuietLogging {

    @Test
    public void testPackagingId() throws Exception {
        print(PackagingId.create(1));
        assertThat(PackagingId.parse("1").getId(), is(1));
    }

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
        final IntegerId id = PackagingId.create(1);
        assertTrue(id.equals(id));
        assertFalse(id.equals(null));

        final IntegerId otherId = PackagingId.create(1);
        assertEquals(id.hashCode(), otherId.hashCode());

        print(PackagingId.create(1));
        assertThat(PackagingId.parse("1").getId(), is(1));
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

    @Test(expected = IllegalArgumentException.class)
    public void testLobIdBad() throws Exception {
        new FakeId("BLARGHBLARGHBLARGHBLA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLobIdBadLength() throws Exception {
        new FakeId("adr_BLARGH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLobIdWrongPrefix() throws Exception {
        new FakeId("obj_BLARGHBLARGHBLAR");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLobIdBadPrefix() throws Exception {
        new FakeId("blargh_BLARGHBLARGHB");
    }

    public void testLobId() throws Exception {
        final LobId id = AddressId.parse("adr_1111111111111111");
        assertTrue(id.equals(id));
        assertFalse(id.equals(null));

        final LobId otherId = AddressId.parse("adr_1111111111111111");
        assertEquals(id.hashCode(), otherId.hashCode());
    }

    public void testZipCode() throws Exception {

    }
}

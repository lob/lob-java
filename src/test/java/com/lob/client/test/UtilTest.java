package com.lob.client.test;

import com.lob.ClientUtil;
import com.lob.Lob;
import com.lob.OrCollection;
import com.lob.Util;
import com.lob.protocol.request.Filters;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UtilTest extends BaseTest {

    @Test(expected = NullPointerException.class)
    public void testCheckNotNullWithNull() throws Exception {
        Util.checkNotNull(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckPresentWithEmptyString() throws Exception {
        Util.checkPresent("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckPresentWithEmptyCollection() throws Exception {
        Util.checkPresent(OrCollection.typeA(Collections.emptyList()), "");
    }

    @Test
    public void testDefensiveCopyWithEmptyList() {
        assertEquals(Collections.emptyList(), Util.defensiveCopy(Collections.emptyList()));
    }

    @Test
    public void constructorsTest() {
        new Util();
        new ClientUtil();
        new Lob();
        new Filters();
    }
}

package com.lob.client.test;

import com.lob.Or;
import org.junit.Test;

public class OrTest extends QuietLogging {

    @Test(expected = IllegalStateException.class)
    public void testOrWrongTypeA() throws Exception {
        Or.typeA("a").getTypeB();
    }

    @Test(expected = IllegalStateException.class)
    public void testOrWrongTypeB() throws Exception {
        Or.typeB("a").getTypeA();
    }
}

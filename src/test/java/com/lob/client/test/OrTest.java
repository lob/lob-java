package com.lob.client.test;

import com.lob.Or;
import org.junit.Test;

public class OrTest extends BaseTest {

    @Test(expected = IllegalStateException.class)
    public void testOrWrongTypeA() throws Exception {
        Or.typeA("a").toString();
        Or.typeA("a").getTypeB();
    }

    @Test(expected = IllegalStateException.class)
    public void testOrWrongTypeB() throws Exception {
        Or.typeB("a").getTypeA();
    }
}

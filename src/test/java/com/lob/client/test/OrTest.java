package com.lob.client.test;

import com.lob.Or;
import org.junit.Test;

import static com.lob.Util.print;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OrTest extends QuietLogging {

    @Test(expected = IllegalStateException.class)
    public void testOrWrongTypeA() throws Exception {
        print(Or.typeA("a")).getTypeB();
    }

    @Test(expected = IllegalStateException.class)
    public void testOrWrongTypeB() throws Exception {
        Or.typeB("a").getTypeA();
    }
}

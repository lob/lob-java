package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.State;
import com.lob.model.StateCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

public class StateTest {

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test
    public void testStateRetrieveAll() throws LobException {
      StateCollection states = State.all(Lob.apiKey);
      assertEquals(states.getData().size(), 62);
      assertEquals("list", states.getObject());
      assertNull(states.getData().get(0).getId());
      assertEquals("Alabama", states.getData().get(0).getName());
      assertEquals("AL", states.getData().get(0).getShort_name());
      assertEquals("state", states.getData().get(0).getObject());
    }
}

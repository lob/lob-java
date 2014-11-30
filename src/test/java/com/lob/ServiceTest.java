package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Service;
import com.lob.model.ServiceCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceTest {

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test
    public void testServiceRetrieveAll() throws LobException {
      ServiceCollection services = Service.all(Lob.apiKey);
      assertEquals(2, services.getData().size());
      assertEquals("list", services.getObject());
      assertEquals("3", services.getData().get(0).getId());
      assertEquals("Registered Mail", services.getData().get(0).getName());
      assertEquals("Registered USPS Mail", services.getData().get(0).getDescription());
      assertEquals("service", services.getData().get(0).getObject());
    }
}

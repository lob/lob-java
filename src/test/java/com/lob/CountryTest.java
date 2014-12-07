package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Country;
import com.lob.model.CountryCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountryTest {
    static Map<String, Object> defaultAddressParams = new HashMap<String, Object>();

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";
    }

    @Test
    public void testCountryRetrieveAll() throws LobException {
      CountryCollection countries = Country.all(Lob.apiKey);
      assertEquals(countries.getData().size(), 246);
      assertEquals("list", countries.getObject());
      assertNull(countries.getData().get(0).getId());
      assertEquals("United States", countries.getData().get(0).getName());
      assertEquals("US", countries.getData().get(0).getShort_name());
      assertEquals("country", countries.getData().get(0).getObject());
    }
}

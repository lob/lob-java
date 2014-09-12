package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Country;
import com.lob.model.CountryCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
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
    }
}

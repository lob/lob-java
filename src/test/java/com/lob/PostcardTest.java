package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Address;
import com.lob.model.Postcard;
import com.lob.model.PostcardCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class PostcardTest {
    static Map<String, java.lang.Object> defaultAddressParams = new HashMap<String, java.lang.Object>();
    static Map<String, java.lang.Object> defaultPostcardParams = new HashMap<String, java.lang.Object>();

    static Address defaultAddress;

    @BeforeClass
    public static void setUp() throws LobException {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";

      defaultAddressParams.put("name", "Test Address");
      defaultAddressParams.put("address_line1", "123 Test Street");
      defaultAddressParams.put("address_city", "San Francisco");
      defaultAddressParams.put("address_state", "CA");
      defaultAddressParams.put("address_zip", "94107");

      defaultAddress = Address.create(defaultAddressParams, Lob.apiKey);

      defaultPostcardParams.put("name", "Test Postcard");
      defaultPostcardParams.put("to", defaultAddress.getId());
      defaultPostcardParams.put("from", defaultAddress.getId());
      defaultPostcardParams.put("front", "https://www.lob.com/test.pdf");
      defaultPostcardParams.put("back", "https://www.lob.com/test.pdf");
    }

    @Test
    public void testPostcardRetrieveAll() throws LobException {
      Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
      listParams.put("count", 2);
      listParams.put("offset", 3);

      PostcardCollection jobs = Postcard.all(listParams, Lob.apiKey);
      assertEquals(jobs.getData().size(), 2);
    }

    @Test(expected=APIException.class)
    public void testPostcardRetrieveAllFail() throws LobException {
      Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
      listParams.put("count", 100000);

      PostcardCollection jobs = Postcard.all(listParams, Lob.apiKey);
    }

    @Test
    public void testPostcardCreate() throws LobException {
      Postcard job = Postcard.create(defaultPostcardParams, Lob.apiKey);
      assertEquals(job.getName(), "Test Postcard");
    }

    @Test(expected=APIException.class)
    public void testPostcardCreateFail() throws LobException {
      Map<String, java.lang.Object> badPostcardParams = new HashMap<String, java.lang.Object>();
      badPostcardParams.put("name", "Test Postcard");
      Postcard badPostcard = Postcard.create(badPostcardParams, Lob.apiKey);
    }

    @Test
    public void testPostcardRetrieve() throws LobException {
      Postcard createdPostcard = Postcard.create(defaultPostcardParams, Lob.apiKey);
      Postcard retrievedPostcard = Postcard.retrieve(createdPostcard.getId(), Lob.apiKey);
      assertEquals(createdPostcard.getId(), retrievedPostcard.getId());
      assertEquals(createdPostcard.getName(), retrievedPostcard.getName());
      assertEquals(createdPostcard.getTo().getId(), retrievedPostcard.getTo().getId());
      assertEquals(createdPostcard.getFrom().getId(), retrievedPostcard.getFrom().getId());
      assertEquals(createdPostcard.getMessage(), retrievedPostcard.getMessage());
      assertEquals(createdPostcard.getFront(), retrievedPostcard.getFront());
      assertEquals(createdPostcard.getBack(), retrievedPostcard.getBack());
    }

    @Test(expected=APIException.class)
    public void testPostcardRetrieveFail() throws LobException {
      Postcard job = Postcard.retrieve("asdf", Lob.apiKey);
    }
}

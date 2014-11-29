package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.DeletedStatus;
import com.lob.model.Object;
import com.lob.model.ObjectCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class ObjectTest {
    static Map<String, java.lang.Object> defaultObjectParams = new HashMap<String, java.lang.Object>();

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";

      defaultObjectParams.put("name", "Test Object");
      defaultObjectParams.put("file", "https://www.lob.com/test.pdf");
      defaultObjectParams.put("setting_id", "201");
    }

    @Test
    public void testObjectRetrieveAll() throws LobException {
      Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
      listParams.put("count", 2);
      listParams.put("offset", 3);

      ObjectCollection objects = Object.all(listParams, Lob.apiKey);
      assertEquals(objects.getData().size(), 2);
    }

    @Test(expected=APIException.class)
    public void testObjectRetrieveAllFail() throws LobException {
      Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
      listParams.put("count", 100000);

      ObjectCollection objects = Object.all(listParams, Lob.apiKey);
    }

    @Test
    public void testObjectCreate() throws LobException {
      Object object = Object.create(defaultObjectParams, Lob.apiKey);
      assertEquals(object.getName(), "Test Object");
    }

    @Test
    public void testObjectDelete() throws LobException {
      Object object = Object.create(defaultObjectParams, Lob.apiKey);
      assertEquals(object.getName(), "Test Object");
      DeletedStatus status = Object.delete(object.getId(), Lob.apiKey);
      assertEquals("1", status.getMessage());
    }

    @Test
    public void testObjectCreateLocal() throws LobException {
      Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
      ObjectMap.put("name", "GO BLUE");
      ObjectMap.put("file", "@" + System.getProperty("user.dir") + "/assets/test.pdf");
      ObjectMap.put("quantity", 2);
      ObjectMap.put("setting_id", 201);

      Object object = Object.create(ObjectMap, Lob.apiKey);
      assertEquals(object.getName(), "GO BLUE");
    }

    @Test(expected=APIException.class)
    public void testObjectCreateFail() throws LobException {
      Map<String, java.lang.Object> badObjectParams = new HashMap<String, java.lang.Object>();
      badObjectParams.put("name", "Test Object");
      Object badObject = Object.create(badObjectParams, Lob.apiKey);
    }

    @Test
    public void testObjectRetrieve() throws LobException {
      Object createdObject = Object.create(defaultObjectParams, Lob.apiKey);
      Object retrievedObject = Object.retrieve(createdObject.getId(), Lob.apiKey);
      assertEquals(createdObject.getId(), retrievedObject.getId());
    }

    @Test(expected=APIException.class)
    public void testObjectRetrieveFail() throws LobException {
      Object object = Object.retrieve("asdf", Lob.apiKey);
    }
}

package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Address;
import com.lob.model.Job;
import com.lob.model.JobCollection;
import com.lob.model.Object;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class JobTest {
    static Map<String, java.lang.Object> defaultAddressParams = new HashMap<String, java.lang.Object>();
    static Map<String, java.lang.Object> defaultJobParams = new HashMap<String, java.lang.Object>();
    static Map<String, java.lang.Object> defaultObjectParams = new HashMap<String, java.lang.Object>();

    static Address defaultAddress;
    static Object defaultObject;

    @BeforeClass
    public static void setUp() throws LobException {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";

      defaultObjectParams.put("name", "Test Object");
      defaultObjectParams.put("file", "https://www.lob.com/test.pdf");
      defaultObjectParams.put("setting_id", "201");

      defaultObject = Object.create(defaultObjectParams, Lob.apiKey);

      defaultAddressParams.put("name", "Test Address");
      defaultAddressParams.put("address_line1", "123 Test Street");
      defaultAddressParams.put("address_city", "San Francisco");
      defaultAddressParams.put("address_state", "CA");
      defaultAddressParams.put("address_zip", "94107");

      defaultAddress = Address.create(defaultAddressParams, Lob.apiKey);

      defaultJobParams.put("name", "Test Job");
      defaultJobParams.put("to", defaultAddress.getId());
      defaultJobParams.put("from", defaultAddress.getId());
      defaultJobParams.put("object1", defaultObject.getId());
    }

    @Test
    public void testJobRetrieveAll() throws LobException {
      Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
      listParams.put("count", 2);
      listParams.put("offset", 3);

      JobCollection jobs = Job.all(listParams, Lob.apiKey);
      assertEquals(jobs.getData().size(), 2);
    }

    @Test(expected=APIException.class)
    public void testJobRetrieveAllFail() throws LobException {
      Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
      listParams.put("count", 100000);

      JobCollection jobs = Job.all(listParams, Lob.apiKey);
    }

    @Test
    public void testJobCreate() throws LobException {
      Job job = Job.create(defaultJobParams, Lob.apiKey);
      assertEquals(job.getName(), "Test Job");
    }

    @Test(expected=APIException.class)
    public void testJobCreateFail() throws LobException {
      Map<String, java.lang.Object> badJobParams = new HashMap<String, java.lang.Object>();
      badJobParams.put("name", "Test Job");
      Job badJob = Job.create(badJobParams, Lob.apiKey);
    }

    @Test
    public void testJobRetrieve() throws LobException {
      Job createdJob = Job.create(defaultJobParams, Lob.apiKey);
      Job retrievedJob = Job.retrieve(createdJob.getId(), Lob.apiKey);
      assertEquals(createdJob.getId(), retrievedJob.getId());
    }

    @Test(expected=APIException.class)
    public void testJobRetrieveFail() throws LobException {
      Job job = Job.retrieve("asdf", Lob.apiKey);
    }
}

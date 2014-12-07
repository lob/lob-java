package com.lob.model;

import java.util.Map;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Object extends APIResource {
    String id;
    String name;
    String file;
    Setting setting;
    Integer quantity;
    Integer double_sided;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getFile() {
        return file;
    }
    public Setting getSetting() {
        return setting;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Integer getDouble_sided() {
        return double_sided;
    }
    public static Object retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, instanceURL(Object.class, id), null,
                Object.class, apiKey);
    }

    public static Object create(Map<String, java.lang.Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.POST, classURL(Object.class), params,
                    Object.class, apiKey);
    }

    public static DeletedStatus delete(String id, String apiKey)
    throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.DELETE,
                instanceURL(Object.class, id), null,
                DeletedStatus.class, apiKey);
    }

    public static ObjectCollection all(Map<String, java.lang.Object> params,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return request(RequestMethod.GET, classURL(Object.class), params,
                ObjectCollection.class, apiKey);
    }

}

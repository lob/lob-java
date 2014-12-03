package com.lob.model;

import java.util.Map;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Postcard extends APIResource {
    String id;
    String name;
    Address to;
    Address from;
    String message;
    String front;
    String back;
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public static Postcard retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, instanceURL(Postcard.class, id), null,
                Postcard.class, apiKey);
    }

    public static Postcard create(Map<String, java.lang.Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.POST, classURL(Postcard.class), params,
                    Postcard.class, apiKey);
    }   
    
    public static PostcardCollection all(Map<String, java.lang.Object> params,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException, 
            APIException {
        return request(RequestMethod.GET, classURL(Postcard.class), params,
                PostcardCollection.class, apiKey);
    }

}

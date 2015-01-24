package com.lob.model;

import java.util.Map;
import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Job extends APIResource {
    String id;
    String name;
    Double price;
    Address to;
    Address from;
    Object[] objects;
    Integer quantity;
    String status;
    Tracking tracking;
    Packaging packaging;
    Service service;
    String object;

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }


    public Address getTo() {
        return to;
    }


    public Address getFrom() {
        return from;
    }


    public Object[] getObjects() {
        return objects;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public String getStatus() {
        return status;
    }


    public Tracking getTracking() {
        return tracking;
    }


    public Packaging getPackaging() {
        return packaging;
    }


    public Service getService() {
        return service;
    }


    public String getObject() {
        return object;
    }


    public static Job retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, instanceURL(Job.class, id), null,
                Job.class, apiKey);
    }

    public static Job create(Map<String, java.lang.Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.POST, classURL(Job.class), params,
                    Job.class, apiKey);
    }

    public static JobCollection all(Map<String, java.lang.Object> params,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return request(RequestMethod.GET, classURL(Job.class), params,
                JobCollection.class, apiKey);
    }

}

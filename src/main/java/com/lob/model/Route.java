package com.lob.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Route extends APIResource {
    String route;
    Integer residential;
    Integer business;
    String object;

    public String getRoute() {
        return route;
    }

    public Integer getResidential() {
        return residential;
    }

    public Integer getBusiness() {
        return business;
    }

    public String getObject() {
        return object;
    }

    public static RouteCollection all(List<String> zipCodes, String apiKey)
        throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        final Map<String, java.lang.Object> params = new HashMap<String, java.lang.Object>();
        int index = 0;
        for (String zipCode : zipCodes) {
            params.put("zip_codes[" + index + "]", zipCode);
            index += 1;
        }
        return request(RequestMethod.GET, classURL(Route.class), params,
                RouteCollection.class, apiKey);
    }
}

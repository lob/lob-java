package com.lob.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Area extends APIResource {
    String id;
    String name;
    String status;
    Double price;
    String url;
    String target_type;
    Integer adresses;
    List<Zip_code> zip_codes;
    Date date_created;
    Date date_modified;
    String object;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getTarget_type() {
        return target_type;
    }

    public Integer getAddresses() {
        return adresses;
    }

    public List<Zip_code> getZip_codes() {
        return zip_codes;
    }

    public Date getDate_created() {
        return date_created;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public String getObject() {
        return object;
    }

    public String getId() {
        return id;
    }

    public static Area retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, instanceURL(Area.class, id), null,
                Area.class, apiKey);
    }

    public static Area create(Map<String, java.lang.Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.POST, classURL(Area.class), params,
                    Area.class, apiKey);
    }

    public static AreaCollection list(Integer count, Integer offset,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        final Map<String, java.lang.Object> params = new HashMap<String, java.lang.Object>();
        params.put("count", count == null ? 10 : count);
        params.put("offset", offset == null ? 0 : offset);
        return request(RequestMethod.GET, classURL(Area.class), params,
                AreaCollection.class, apiKey);
    }
}

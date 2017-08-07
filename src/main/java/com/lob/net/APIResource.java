package com.lob.net;

import com.lob.exception.APIException;
import java.util.Map;

public abstract class APIResource  {

    private static ResponseGetter responseGetter = new ResponseGetter();

    public static final String CHARSET = "UTF-8";

    public enum RequestMethod {
        GET, POST, DELETE
    }

    public enum RequestType {
        NORMAL, MULTIPART
    }

    public static <T> LobResponse request(APIResource.RequestMethod method,
                                  String url, Map<String, Object> params, Class<T> clazz,
                                  RequestOptions options) throws APIException, Exception {
        return responseGetter.request(method, url, params, clazz, RequestType.NORMAL, options);
    }

}

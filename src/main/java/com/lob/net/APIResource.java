package com.lob.net;

import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;

import java.io.IOException;
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

    public static <T> LobResponse<T> request(APIResource.RequestMethod method, APIResource.RequestType type,
                                  String url, Map<String, Object> params, Class<T> clazz,
                                  RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        return responseGetter.request(method, url, params, clazz, type, options);
    }

}

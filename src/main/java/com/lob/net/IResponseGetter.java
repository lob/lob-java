package com.lob.net;

import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import java.io.IOException;
import java.util.Map;

public interface IResponseGetter {
    <T> LobResponse request(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            Class<T> clazz,
            APIResource.RequestType type,
            RequestOptions options) throws AuthenticationException, APIException, IOException;
}

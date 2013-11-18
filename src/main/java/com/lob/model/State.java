package com.lob.model;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class State extends APIResource {
	String id;
	String name;
	String short_name;
	String object;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getShort_name() {
		return short_name;
	}

	public String getObject() {
		return object;
	}
	
	public static StateCollection all(String apiKey) 
		throws AuthenticationException,
			InvalidRequestException, APIConnectionException, 
			APIException {
		return request(RequestMethod.GET, classURL(State.class), null,
				StateCollection.class, apiKey);
	}

}

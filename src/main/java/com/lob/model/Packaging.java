package com.lob.model;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Packaging extends APIResource {
	String id;
	String name;
	String description;
	String object;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getObject() {
		return object;
	}
	
	public static Packaging retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.GET, instanceURL(Packaging.class, id), null,
				Packaging.class, apiKey);
	}

	public static PackagingCollection all(String apiKey) 
		throws AuthenticationException,
			InvalidRequestException, APIConnectionException, 
			APIException {
		return request(RequestMethod.GET, classURL(Packaging.class), null,
				PackagingCollection.class, apiKey);
	}

}

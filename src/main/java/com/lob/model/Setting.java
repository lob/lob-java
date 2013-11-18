package com.lob.model;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Setting extends APIResource {
	String id;
	String type;
	String description;
	String paper;
	String width;
	String length;
	String color;
	String notes;
	String object;
	
	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getPaper() {
		return paper;
	}

	public String getWidth() {
		return width;
	}

	public String getLength() {
		return length;
	}

	public String getColor() {
		return color;
	}

	public String getNotes() {
		return notes;
	}

	public String getObject() {
		return object;
	}
	
	public static Setting retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.GET, instanceURL(Setting.class, id), null,
				Setting.class, apiKey);
	}

	public static SettingCollection all(String apiKey) 
		throws AuthenticationException,
			InvalidRequestException, APIConnectionException, 
			APIException {
		return request(RequestMethod.GET, classURL(Setting.class), null,
				SettingCollection.class, apiKey);
	}

}

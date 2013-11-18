package com.lob.model;

import java.util.Map;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Address extends APIResource {
	String id;
	String name;
	String email;
	String phone;
	String address_line1;
	String address_line2;
	String address_city;
	String address_state;
	String address_zip;
	String address_country;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_state() {
		return address_state;
	}

	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}

	public String getAddress_zip() {
		return address_zip;
	}

	public void setAddress_zip(String address_zip) {
		this.address_zip = address_zip;
	}

	public String getAddress_country() {
		return address_country;
	}

	public void setAddress_country(String address_country) {
		this.address_country = address_country;
	}

	public String getId() {
		return id;
	}

	public static Address retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.GET, instanceURL(Address.class, id), null,
				Address.class, apiKey);
	}

	public static Address update(String id, Map<String, java.lang.Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
			return request(RequestMethod.POST,
					instanceURL(Address.class, id), params, Address.class,
					apiKey);
	}

	public static Address create(Map<String, java.lang.Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
			return request(RequestMethod.POST, classURL(Address.class), params,
					Address.class, apiKey);
	}	
	
	public static DeletedStatus delete(String id, String apiKey)
	throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
			return request(RequestMethod.DELETE,
				instanceURL(Address.class, id), null,
				DeletedStatus.class, apiKey);
	}	
	
	public static AddressCollection all(Map<String, java.lang.Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, 
			APIException {
		return request(RequestMethod.GET, classURL(Address.class), params,
				AddressCollection.class, apiKey);
	}

	public static Verify verify(Map<String, java.lang.Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, 
			APIException {
		return request(RequestMethod.POST, singleClassURL(Verify.class), params,
				Verify.class, apiKey);
	}	
}

package com.lob.model;

import java.util.Map;
import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Check extends APIResource {
	String id;
	String name;
	String check_number;
	Bank_account bank_account;
	Address to;
	Double amount;
	String message;
	String memo;
	
	public String getId() {
		return id;
	}


	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCheck_number() {
		return check_number;
	}



	public void setCheck_number(String check_number) {
		this.check_number = check_number;
	}



	public Bank_account getBank_account() {
		return bank_account;
	}



	public void setBank_account(Bank_account bank_account) {
		this.bank_account = bank_account;
	}



	public Address getTo() {
		return to;
	}



	public void setTo(Address to) {
		this.to = to;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public static Check retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
		return request(RequestMethod.GET, instanceURL(Check.class, id), null,
				Check.class, apiKey);
	}

	public static Check create(Map<String, java.lang.Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
			return request(RequestMethod.POST, classURL(Check.class), params,
					Check.class, apiKey);
	}	
	
	public static DeletedStatus delete(String id, String apiKey)
	throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException {
			return request(RequestMethod.DELETE,
				instanceURL(Check.class, id), null,
				DeletedStatus.class, apiKey);
	}	
	
	public static CheckCollection all(Map<String, java.lang.Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, 
			APIException {
		return request(RequestMethod.GET, classURL(Check.class), params,
				CheckCollection.class, apiKey);
	}

}

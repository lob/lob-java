package com.lob.model;

import java.util.Date;
import java.util.Map;

import com.lob.exception.APIConnectionException;
import com.lob.exception.APIException;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.net.APIResource;

public class Bank_account extends APIResource {
    String id;
    String routing_number;
    String account_number;
    String bank_code;
    Address bank_address;
    Address account_address;
    String signatory;
    Date date_created;
    Date date_modified;
    String object;

    public String getRouting_number() {
        return routing_number;
    }

    public String getAccount_number() {
        return account_number;
    }

    public String getBank_code() {
        return bank_code;
    }

    public Address getBank_address() {
        return bank_address;
    }

    public Address getAccount_address() {
        return account_address;
    }

    public String getId() {
        return id;
    }

    public String getSignatory() {
        return signatory;
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

    public static Bank_account retrieve(String id, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
        return request(RequestMethod.GET, instanceURL(Bank_account.class, id), null,
                Bank_account.class, apiKey);
    }

    public static Bank_account create(Map<String, java.lang.Object> params, String apiKey)
            throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.POST, classURL(Bank_account.class), params,
                    Bank_account.class, apiKey);
    }

    public static DeletedStatus delete(String id, String apiKey)
    throws AuthenticationException, InvalidRequestException,
            APIConnectionException, APIException {
            return request(RequestMethod.DELETE,
                instanceURL(Bank_account.class, id), null,
                DeletedStatus.class, apiKey);
    }

    public static BankAccountCollection all(Map<String, java.lang.Object> params,
            String apiKey) throws AuthenticationException,
            InvalidRequestException, APIConnectionException,
            APIException {
        return request(RequestMethod.GET, classURL(Bank_account.class), params,
                BankAccountCollection.class, apiKey);
    }

}

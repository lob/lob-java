/*
 * Lob
 * The Lob API is organized around REST. Our API is designed to have predictable, resource-oriented URLs and uses HTTP response codes to indicate any API errors. <p> Looking for our [previous documentation](https://lob.github.io/legacy-docs/)? 
 *
 * The version of the OpenAPI document: 1.3.0
 * Contact: lob-openapi@lob.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.lob.api.client;

import com.lob.api.ApiException;
import com.lob.model.LobError;
import com.lob.model.MailType;
import com.lob.model.SelfMailer;
import com.lob.model.SelfMailerDeletion;
import com.lob.model.SelfMailerEditable;
import com.lob.model.SelfMailerList;
import com.lob.model.SelfMailerSize;
import com.lob.model.SortBy5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.*;

/**
 * API tests for SelfMailersApi
 */
@Test(enabled=false)
public class SelfMailersApiTest {

    private final SelfMailersApi api = new SelfMailersApi();

    
    /**
     * create
     *
     * Creates a new self_mailer given information
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void selfMailerCreateTest() throws ApiException {
        SelfMailerEditable selfMailerEditable = null;
        String idempotencyKey = null;
                SelfMailer response = api.selfMailerCreate(selfMailerEditable, idempotencyKey);
        // TODO: test validations
    }
    
    /**
     * delete
     *
     * Completely removes a self mailer from production. This can only be done if the self mailer&#39;s &#x60;send_date&#x60; has not yet passed.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void selfMailerDeleteTest() throws ApiException {
        String sfmId = null;
                SelfMailerDeletion response = api.selfMailerDelete(sfmId);
        // TODO: test validations
    }
    
    /**
     * get
     *
     * Retrieves the details of an existing self_mailer. You need only supply the unique self_mailer identifier that was returned upon self_mailer creation.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void selfMailerRetrieveTest() throws ApiException {
        String sfmId = null;
                SelfMailer response = api.selfMailerRetrieve(sfmId);
        // TODO: test validations
    }
    
    /**
     * list
     *
     * Returns a list of your self_mailers. The self_mailers are returned sorted by creation date, with the most recently created self_mailers appearing first.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void selfMailersListTest() throws ApiException {
        Integer limit = null;
        String before = null;
        String after = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> metadata = null;
        List<SelfMailerSize> size = null;
        Boolean scheduled = null;
        Map<String, String> sendDate = null;
        MailType mailType = null;
        SortBy5 sortBy = null;
                SelfMailerList response = api.selfMailersList(limit, before, after, include, dateCreated, metadata, size, scheduled, sendDate, mailType, sortBy);
        // TODO: test validations
    }
    
}

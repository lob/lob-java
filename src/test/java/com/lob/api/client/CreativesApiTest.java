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
import com.lob.model.CreativePatch;
import com.lob.model.CreativeResponse;
import com.lob.model.CreativeWritable;
import com.lob.model.LobError;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.*;

/**
 * API tests for CreativesApi
 */
@Test(enabled=false)
public class CreativesApiTest {

    private final CreativesApi api = new CreativesApi();

    
    /**
     * create
     *
     * Creates a new creative with the provided properties
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void creativeCreateTest() throws ApiException {
        CreativeWritable creativeWritable = null;
        String xLangOutput = null;
                CreativeResponse response = api.creativeCreate(creativeWritable, xLangOutput);
        // TODO: test validations
    }
    
    /**
     * get
     *
     * Retrieves the details of an existing creative. You need only supply the unique creative identifier that was returned upon creative creation.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void creativeRetrieveTest() throws ApiException {
        String crvId = null;
                CreativeResponse response = api.creativeRetrieve(crvId);
        // TODO: test validations
    }
    
    /**
     * update
     *
     * Update the details of an existing creative. You need only supply the unique identifier that was returned upon creative creation.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test(enabled=false)
    public void creativeUpdateTest() throws ApiException {
        String crvId = null;
        CreativePatch creativePatch = null;
                CreativeResponse response = api.creativeUpdate(crvId, creativePatch);
        // TODO: test validations
    }
    
}

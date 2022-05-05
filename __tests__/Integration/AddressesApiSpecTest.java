package Integration;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.AddressesApi;

import org.openapitools.client.model.Address;
import org.openapitools.client.model.AddressDeletion;
import org.openapitools.client.model.AddressEditable;
import org.openapitools.client.model.AddressList;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.*;

public class AddressesApiSpecTest {
    private AddressesApi validApi;
    private AddressesApi invalidApi;
    private List<AddressEditable> addressEditableList;
    private List<Address> createdAddresses = new ArrayList<Address>();
    private String nextUrl;
    private String previousUrl;



    @BeforeClass
    public void before_class()
    {
        validApi = new AddressesApi(Configuration.getConfigForIntegration());
        invalidApi = new AddressesApi(Configuration.getBadConfigForIntegration());

        addressEditableList = new TestFixtures().get_ADDRESSES_EDITABLE();
        for (AddressEditable ae : addressEditableList) {
            try {
                createdAddresses.add(validApi.addressCreate(ae));
            } catch (Exception e) {
                Assert.fail("Creating addresses before has failed");
            }
        }

        try {
            AddressList response = validApi.addressesList(null, null, null, null, null, null);
            Assert.assertNotNull(response);
            Assert.assertNotNull(response.getNextUrl());
            nextUrl = response.getNextUrl().substring(response.getNextUrl().indexOf("after=") + 6);
            Assert.assertNotNull(nextUrl);
            AddressList responseAfter = validApi.addressesList(10, null, nextUrl, null, null, null);
            Assert.assertNotNull(responseAfter);
            Assert.assertNotNull(responseAfter.getPreviousUrl());
            previousUrl = responseAfter.getPreviousUrl().substring(responseAfter.getPreviousUrl().indexOf("before=") + 7);
            Assert.assertNotNull(previousUrl);
        } catch (ApiException e ) {
            Assert.fail("Listing addresses before has failed");
        }
    }

    @AfterClass
    public void after_class()
    {
        for (Address address: createdAddresses) {
            try {
                validApi.addressDelete(address.getId());
            } catch (Exception e) {
                Assert.fail("Deleting addresses after has failed");
            }
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Address", "Valid"}
    )
    public void addressCreateTest() throws ApiException {
        Address response = validApi.addressCreate(addressEditableList.get(0));

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getAddressLine1(), addressEditableList.get(0).getAddressLine1());
        createdAddresses.add(response);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'addressEditable'.*",
        groups={"Integration", "Create", "Address", "Invalid"}
    )
    public void addressCreateTestBadParameter() throws ApiException {
        validApi.addressCreate(null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "Address", "Invalid"}
    )
    public void addressCreateTestBadUsername() throws ApiException {
        try {
            invalidApi.addressCreate(addressEditableList.get(0));
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Retrieve", "Address", "Valid"}
    )
    public void addressRetrieveTest() throws ApiException {
        Address response = validApi.addressRetrieve(createdAddresses.get(0).getId());

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getId(), createdAddresses.get(0).getId());
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'adrId'.*",
        groups={"Integration", "Retrieve", "Address", "Invalid"}
    )
    public void addressRetrieveTestBadParameter() throws ApiException {
        validApi.addressRetrieve(null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Retrieve", "Address", "Invalid"}
    )
    public void addressRetrieveTestBadUsername() throws ApiException {
        try {
            invalidApi.addressRetrieve(createdAddresses.get(0).getId());
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Address", "Valid"}
    )
    public void addressListTest() throws ApiException {
        AddressList response = validApi.addressesList(null, null, null, null, null, null);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() > 0);
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Address", "Valid"}
    )
    public void addressListTestWithBeforeParam() throws ApiException {
        AddressList response = validApi.addressesList(10, previousUrl, null, null, null, null);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() > 0);
    }


    @Test(
        enabled=true,
        groups={"Integration", "List", "Address", "Valid"}
    )
    public void addressListTestWithIncludesParam() throws ApiException {
        List<String> includeList = new ArrayList<String>();
        includeList.add("total_es");
        AddressList response = validApi.addressesList(10, null, null, includeList, null, null);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() > 0);
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Address", "Valid"}
    )
    public void addressListTestWithNextPageToken() throws ApiException {
        AddressList response = validApi.addressesList(10, null, null, null, null, null);
        AddressList responseAfter = validApi.addressesList(10, null, response.getNextPageToken(), null, null, null);


        Assert.assertNotNull(responseAfter);
        Assert.assertTrue(responseAfter.getCount() > 0);
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Address", "Valid"}
    )
    public void addressListTestWithPreviousPageToken() throws ApiException {
        AddressList response = validApi.addressesList(10, null, null, null, null, null);
        AddressList responseAfter = validApi.addressesList(10, null, response.getPreviousPageToken(), null, null, null);

        Assert.assertNotNull(responseAfter);
        Assert.assertTrue(responseAfter.getCount() > 0);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "Address", "Invalid"}
    )
    public void addressListTestBadUsername() throws ApiException {
        try {
            invalidApi.addressesList(10, null, null, null, null, null);
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Delete", "Address", "Valid"}
    )
    public void addressDeleteTest() throws ApiException {
        AddressDeletion response = validApi.addressDelete(createdAddresses.get(0).getId());

        Assert.assertNotNull(response.getId());
    }
}
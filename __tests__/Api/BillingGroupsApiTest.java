package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.BillingGroupsApi;

import org.openapitools.client.model.BillingGroup;
import org.openapitools.client.model.BillingGroupEditable;
import org.openapitools.client.model.BillingGroupList;
import org.openapitools.client.model.SortBy5;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(enabled=true, groups={"Unit", "Billing Group"})
public class BillingGroupsApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Billing Group", "Valid"})
    public void billingGroupCreateTest() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        BillingGroup fakeBillingGroup = new BillingGroup();
        BillingGroupEditable billingGroupEditable = new BillingGroupEditable();
        
        fakeBillingGroup.setId("bg_fakeId");
        
        when(billingGroupApiMock.billingGroupCreate(billingGroupEditable)).thenReturn(fakeBillingGroup);
        BillingGroup response = billingGroupApiMock .billingGroupCreate(billingGroupEditable);

        Assert.assertEquals(fakeBillingGroup.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupCreateTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.billingGroupCreate(null)).thenThrow(error);
        billingGroupApiMock.billingGroupCreate(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.billingGroupCreate(null)).thenThrow(error);

        billingGroupApiMock.billingGroupCreate(null);

        Assert.fail("This should not happen");   
    }   
    
    @Test(enabled=true, groups={"Unit", "Retrieve", "Billing Group", "Valid"})
    public void billingGroupRetrieveTest() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        BillingGroup fakeBillingGroup = new BillingGroup();
        
        fakeBillingGroup.setId("bg_fakeId");
        
        when(billingGroupApiMock.billingGroupRetrieve("bg_fakeId")).thenReturn(fakeBillingGroup);
        BillingGroup response = billingGroupApiMock.billingGroupRetrieve("bg_fakeId");

        Assert.assertEquals(fakeBillingGroup.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupRetrieveTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.billingGroupRetrieve(null)).thenThrow(error);
        billingGroupApiMock.billingGroupRetrieve(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Retrieve", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupRetrieveTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.billingGroupRetrieve(null)).thenThrow(error);

        billingGroupApiMock.billingGroupRetrieve(null);
    }
  
    @Test(enabled=true, groups={"Unit", "Update", "Billing Group", "Valid"})
    public void billingGroupUpdateTest() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        BillingGroup fakeBillingGroup = new BillingGroup();
        BillingGroupEditable billingGroupEditable = new BillingGroupEditable();

        
        fakeBillingGroup.setId("bg_fakeId");
        
        when(billingGroupApiMock.billingGroupUpdate("bg_fakeId", billingGroupEditable)).thenReturn(fakeBillingGroup);
        BillingGroup response = billingGroupApiMock.billingGroupUpdate("bg_fakeId", billingGroupEditable);

        Assert.assertEquals(fakeBillingGroup.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Update", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupUpdateTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.billingGroupUpdate(null, null)).thenThrow(error);
        billingGroupApiMock.billingGroupUpdate(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupUpdateTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.billingGroupUpdate(null, null)).thenThrow(error);

        billingGroupApiMock.billingGroupUpdate(null, null);
    }
    
    @Test(enabled=false, groups={"Unit", "List", "Billing Group", "Valid"})
    public void billingGroupsListTest() throws ApiException {
        Integer limit = null;
        Integer offset = null;
        List<String> include = null;
        Map<String, String> dateCreated = null;
        Map<String, String> dateModified = null;
        SortBy5 sortBy = null;
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        BillingGroupList fakeBillingGroup = new BillingGroupList();
        List<BillingGroup> data = new ArrayList<BillingGroup>();
        BillingGroup data1 = new BillingGroup();
        BillingGroup data2 = new BillingGroup();

        data1.setId("adr_Id");
        data2.setId("adr_Id2");
        data.add(data1);
        data.add(data2);
        fakeBillingGroup.setData(data);
        fakeBillingGroup.setObject("list");
        fakeBillingGroup.setCount(data.size());

        when(billingGroupApiMock.billingGroupsList(limit, offset, include, dateCreated, dateModified, sortBy)).thenReturn(fakeBillingGroup);
        BillingGroupList response = billingGroupApiMock.billingGroupsList(limit, offset, include, dateCreated, dateModified, sortBy);
       
       Assert.assertEquals(fakeBillingGroup.getCount(), response.getCount()); 
    }

    @Test(enabled=true, groups={"Unit", "List", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupListTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.billingGroupsList(null, null, null, null, null, null)).thenThrow(error);
        billingGroupApiMock.billingGroupsList(null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupListTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.billingGroupsList(null,null, null, null, null, null)).thenThrow(error);

        billingGroupApiMock.billingGroupsList(null, null, null, null, null, null);
    }
}

package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.BillingGroupsApi;

import com.lob.model.BillingGroup;
import com.lob.model.BillingGroupEditable;
import com.lob.model.BillingGroupList;
import com.lob.model.SortByDateModified;
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

        when(billingGroupApiMock.create(billingGroupEditable)).thenReturn(fakeBillingGroup);
        BillingGroup response = billingGroupApiMock .create(billingGroupEditable);

        Assert.assertEquals(fakeBillingGroup.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupCreateTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.create(null)).thenThrow(error);
        billingGroupApiMock.create(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupCreateTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.create(null)).thenThrow(error);

        billingGroupApiMock.create(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Billing Group", "Valid"})
    public void billingGroupGetTest() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        BillingGroup fakeBillingGroup = new BillingGroup();

        fakeBillingGroup.setId("bg_fakeId");

        when(billingGroupApiMock.get("bg_fakeId")).thenReturn(fakeBillingGroup);
        BillingGroup response = billingGroupApiMock.get("bg_fakeId");

        Assert.assertEquals(fakeBillingGroup.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Get", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupGetTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.get(null)).thenThrow(error);
        billingGroupApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupGetTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.get(null)).thenThrow(error);

        billingGroupApiMock.get(null);
    }

    @Test(enabled=true, groups={"Unit", "Update", "Billing Group", "Valid"})
    public void billingGroupUpdateTest() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        BillingGroup fakeBillingGroup = new BillingGroup();
        BillingGroupEditable billingGroupEditable = new BillingGroupEditable();


        fakeBillingGroup.setId("bg_fakeId");

        when(billingGroupApiMock.update("bg_fakeId", billingGroupEditable)).thenReturn(fakeBillingGroup);
        BillingGroup response = billingGroupApiMock.update("bg_fakeId", billingGroupEditable);

        Assert.assertEquals(fakeBillingGroup.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Update", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupUpdateTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.update(null, null)).thenThrow(error);
        billingGroupApiMock.update(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupUpdateTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.update(null, null)).thenThrow(error);

        billingGroupApiMock.update(null, null);
    }

    @Test(enabled=false, groups={"Unit", "List", "Billing Group", "Valid"})
    public void billingGroupsListTest() throws ApiException {
        Integer limit = null;
        Integer offset = null;
        List<String> include = null;
        Map<String, OffsetDateTime> dateCreated = null;
        Map<String, String> dateModified = null;
        SortByDateModified sortBy = null;
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

        when(billingGroupApiMock.list(limit, offset, include, dateCreated, dateModified, sortBy)).thenReturn(fakeBillingGroup);
        BillingGroupList response = billingGroupApiMock.list(limit, offset, include, dateCreated, dateModified, sortBy);

       Assert.assertEquals(fakeBillingGroup.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void billingGroupListTestCatchesException() throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(billingGroupApiMock.list(null, null, null, null, null, null)).thenThrow(error);
        billingGroupApiMock.list(null, null, null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "List", "Billing Group", "Invalid"}, expectedExceptions = {ApiException.class})
    public void billingGroupListTestCatchesExceptionWithResponseBody () throws ApiException {
        BillingGroupsApi billingGroupApiMock = mock(BillingGroupsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(billingGroupApiMock.list(null,null, null, null, null, null)).thenThrow(error);

        billingGroupApiMock.list(null, null, null, null, null, null);
    }
}

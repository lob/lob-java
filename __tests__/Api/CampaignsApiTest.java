package Api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lob.api.ApiException;
import com.lob.api.client.CampaignsApi;

import com.lob.model.Campaign;
import com.lob.model.CampaignDeletion;
import com.lob.model.CampaignsList;
import com.lob.model.CampaignUpdatable;
import com.lob.model.CampaignWritable;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(enabled=true, groups={"Unit", "PMAPI", "Campaign"})
public class CampaignsApiTest {
    @Test(enabled=true, groups={"Unit", "Create", "Campaign", "Valid"})
    public void createCampaignTest() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        Campaign fakeCampaign = new Campaign();
        fakeCampaign.setId("cmp_fakeId");
        CampaignWritable campaignWritable = new CampaignWritable();

        when(campaignApiMock.create(campaignWritable, null)).thenReturn(fakeCampaign);
        Campaign response = campaignApiMock.create(campaignWritable, null);

        Assert.assertEquals(fakeCampaign.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Campaign", "Valid"})
    public void createCampaignTestWithXLangOutput() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        Campaign fakeCampaign = new Campaign();
        fakeCampaign.setId("cmp_fakeId");
        CampaignWritable campaignWritable = new CampaignWritable();

        when(campaignApiMock.create(campaignWritable, "match")).thenReturn(fakeCampaign);
        Campaign response = campaignApiMock.create(campaignWritable, "match");

        Assert.assertEquals(fakeCampaign.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Create", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void createCampaignTestCatchesException() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(campaignApiMock.create(null, null)).thenThrow(error);
        campaignApiMock.create(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class})
    public void createCampaignTestCatchesExceptionWithResponseBody () throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(campaignApiMock.create(null, null)).thenThrow(error);

        campaignApiMock.create(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Campaign", "Valid"})
    public void campaignDeleteTest() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        CampaignDeletion fakeCampaign = new CampaignDeletion();
        fakeCampaign.setId("cmp_fakeId");

        when(campaignApiMock.delete("cmp_fakeId")).thenReturn(fakeCampaign);
        CampaignDeletion response = campaignApiMock.delete("cmp_fakeId");

        Assert.assertEquals(fakeCampaign.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void campaignDeleteTestCatchesException() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(campaignApiMock.delete(null)).thenThrow(error);
        campaignApiMock.delete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Delete", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class})
    public void campaignDeleteTestCatchesExceptionWithResponseBody () throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(campaignApiMock.delete(null)).thenThrow(error);

        campaignApiMock.delete(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Campaign", "Valid"})
    public void campaignGetTest() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        Campaign fakeCampaign = new Campaign();
        fakeCampaign.setId("cmp_fakeId");

        when(campaignApiMock.get("cmp_fakeId")).thenReturn(fakeCampaign);
        Campaign response = campaignApiMock.get("cmp_fakeId");

        Assert.assertEquals(fakeCampaign.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Get", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void campaignGetTestCatchesException() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(campaignApiMock.get(null)).thenThrow(error);
        campaignApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Get", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class})
    public void campaignGetTestCatchesExceptionWithResponseBody () throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(campaignApiMock.get(null)).thenThrow(error);

        campaignApiMock.get(null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Campaign", "Valid"})
    public void campaignUpdateTest() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        Campaign fakeCampaign = new Campaign();
        CampaignUpdatable campaignUpdate = new CampaignUpdatable();

        fakeCampaign.setId("cmp_fakeId");

        when(campaignApiMock.update("cmp_fakeId", campaignUpdate)).thenReturn(fakeCampaign);
        Campaign response = campaignApiMock.update("cmp_fakeId", campaignUpdate);

        Assert.assertEquals(fakeCampaign.getId(), response.getId());
    }

    @Test(enabled=true, groups={"Unit", "Update", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void campaignUpdateTestCatchesException() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(campaignApiMock.update(null, null)).thenThrow(error);
        campaignApiMock.update(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Update", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class})
    public void campaignUpdateTestCatchesExceptionWithResponseBody () throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(campaignApiMock.update(null, null)).thenThrow(error);

        campaignApiMock.update(null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=false, groups={"Unit", "List", "Campaign", "Valid"})
    public void campaignListTest() throws ApiException {
        Integer limit = null;
        List<String> include = null;
        String before = null;
        String after = null;

        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        CampaignsList fakeCampaignsList = new CampaignsList();
        List<Campaign> data = new ArrayList<Campaign>();
        Campaign data1 = new Campaign();
        Campaign data2 = new Campaign();

        data1.setId("cmp_Id1");
        data2.setId("cmp_Id2");
        data.add(data1);
        data.add(data2);
        fakeCampaignsList.setData(data);
        fakeCampaignsList.setObject("list");
        fakeCampaignsList.setCount(data.size());

        when(campaignApiMock.list(limit, include, before, after)).thenReturn(fakeCampaignsList);
        CampaignsList response = campaignApiMock.list(limit, include, before, after);

        Assert.assertEquals(fakeCampaignsList.getCount(), response.getCount());
    }

    @Test(enabled=true, groups={"Unit", "List", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class}, expectedExceptionsMessageRegExp = "error reported by API")
    public void campaignListTestCatchesException() throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error reported by API");

        when(campaignApiMock.list(null, null, null, null)).thenThrow(error);
        campaignApiMock.list(null, null, null, null);

        Assert.fail("This should not happen");
    }

    @Test(enabled=true, groups={"Unit", "Create", "Campaign", "Invalid"}, expectedExceptions = {ApiException.class})
    public void campaignListTestCatchesExceptionWithResponseBody () throws ApiException {
        CampaignsApi campaignApiMock = mock(CampaignsApi.class);
        ApiException error = new ApiException("error", null, 500, null, "error reported by API");
        when(campaignApiMock.list(null, null, null, null)).thenThrow(error);

        campaignApiMock.list(null, null, null, null);

        Assert.fail("This should not happen");
    }
}

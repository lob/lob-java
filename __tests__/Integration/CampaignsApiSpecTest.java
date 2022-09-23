package Integration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.CampaignsApi;

import com.lob.model.Campaign;
import com.lob.model.CampaignWritable;
import com.lob.model.CampaignUpdatable;
import com.lob.model.CampaignsList;
import com.lob.model.InlineResponse200;
import com.lob.model.CmpScheduleType;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeGroups;

public class CampaignsApiSpecTest {

    private CampaignsApi validApi;
    private List<Campaign> createdCampaigns = new ArrayList<Campaign>();

    @BeforeClass
    public void before_class()
    {
        validApi = new CampaignsApi(Configuration.getConfigForIntegration());
    }

    @AfterClass
    public void after_class()
    {
        for (Campaign campaign: createdCampaigns) {
            try {
                validApi.delete(campaign.getId());
            } catch (Exception e) {
                Assert.fail("Deleting Campaigns after has failed");
            }
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Campaign", "Valid"}
    )
    public void createCampaignTest() throws ApiException {
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("Java Integration Test Campaign A");
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);

        Campaign response = validApi.create(cmpWritable, null);

        Assert.assertNotNull(response.getId());
        createdCampaigns.add(response);
    }

    @Test(
        enabled=true,
        groups={"Integration", "Retrieve", "Campaign", "Valid"}
    )
    public void campaignRetrieveTest() throws ApiException {
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("Java Integration Test Campaign B");
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);

        Campaign createdCmp = validApi.create(cmpWritable, null);
        createdCampaigns.add(createdCmp);

        Campaign response = validApi.get(createdCmp.getId());

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getId(), createdCmp.getId());
    }

    @Test(
        enabled=false,
        groups={"Integration", "Update", "Campaign", "Valid"}
    )
    public void CampaignUpdateTest() throws ApiException {
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("Java Integration Test Campaign C");
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);

        Campaign createdCmp = validApi.create(cmpWritable, null);
        createdCampaigns.add(createdCmp);

        CampaignUpdatable update = new CampaignUpdatable();

        update.setDescription("Java Integration Test Updated Campaign");

        Campaign response = validApi.update(createdCmp.getId(), update);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getDescription(), "Java Integration Test Updated Campaign");
    }

    @Test(
        enabled=true,
        groups={"Integration", "Delete", "Campaign", "Valid"}
    )
    public void campaignDeleteTest() throws ApiException {
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("Java Integration Test Campaign D");
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);

        Campaign createdCmp = validApi.create(cmpWritable, null);

        InlineResponse200 response = validApi.delete(createdCmp.getId());

        Assert.assertNotNull(response);
        Assert.assertTrue(response.getDeleted());
        Assert.assertEquals(response.getId(), createdCmp.getId());
    }

    @BeforeGroups("List")
    public void before_list_test()
    {
        CampaignWritable cmpWritable = new CampaignWritable();
        cmpWritable.setName("Java Integration Test Campaign E");
        cmpWritable.setScheduleType(CmpScheduleType.IMMEDIATE);

        try {
            Campaign createdCmp1 = validApi.create(cmpWritable, null);
            createdCampaigns.add(createdCmp1);
        } catch (ApiException e) {
            Assert.fail("Creating cmp1 for List Test has failed");
        }

        cmpWritable.setName("Java Integration Test Campaign F");
        try {
            Campaign createdCmp2 = validApi.create(cmpWritable, null);
            createdCampaigns.add(createdCmp2);
        } catch (ApiException e) {
            Assert.fail("Creating cmp2 for List Test has failed");
        }

        cmpWritable.setName("Java Integration Test Campaign G");
        try {
            Campaign createdCmp3 = validApi.create(cmpWritable, null);
            createdCampaigns.add(createdCmp3);
        } catch (ApiException e) {
            Assert.fail("Creating cmp3 for List Test has failed");
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Campaign", "Valid"}
    )
    public void campaignListTest() throws ApiException {
        CampaignsList response = validApi.list(3, null, null, null);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.getCount() == 3);
        Assert.assertNotNull(response.getNextUrl());
        String nextUrl = response.getNextUrl().substring(response.getNextUrl().indexOf("after=") + 6);
        Assert.assertNotNull(nextUrl);

        CampaignsList responseAfter = validApi.list(null, null, null, nextUrl);
        Assert.assertNotNull(responseAfter);
        Assert.assertNotNull(responseAfter.getPreviousUrl());
        String previousUrl = responseAfter.getPreviousUrl().substring(responseAfter.getPreviousUrl().indexOf("before=") + 7);
        Assert.assertNotNull(previousUrl);

        CampaignsList responseBefore = validApi.list(null, null, previousUrl, null);
        Assert.assertNotNull(responseBefore);

        List<String> includeList = new ArrayList<String>();
        includeList.add("total_count");
        CampaignsList responseInclude = validApi.list(null, includeList, null, null);
        Assert.assertNotNull(responseInclude);
        Assert.assertNotNull(responseInclude.getTotalCount());
    }
}

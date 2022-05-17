package Integration;

import java.util.ArrayList;
import java.util.List;

import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.client.BillingGroupsApi;

import org.openapitools.client.model.BillingGroup;
import org.openapitools.client.model.BillingGroupEditable;
import org.openapitools.client.model.BillingGroupList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.TestFixtures;

public class BillingGroupsApiSpecTest {
    private BillingGroupsApi validApi;
    private BillingGroupsApi invalidApi;
    private List<BillingGroupEditable> createdBillingGroups = new ArrayList<BillingGroupEditable>();

    @BeforeClass
    public void before_class()
    {
        validApi = new BillingGroupsApi(Configuration.getConfigForIntegration());
        invalidApi = new BillingGroupsApi(Configuration.getBadConfigForIntegration());
        createdBillingGroups = new TestFixtures().get_BILLING_GROUP_EDITABLE();
    }

    @Test(
        enabled=true,
        groups={"Integration", "Create", "Billing Group", "Valid"}
    )
    public void billingGroupCreateTest() throws ApiException {
        BillingGroup response = validApi.create(createdBillingGroups.get(0));

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getName(),createdBillingGroups.get(0).getName());
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Missing the required parameter 'billingGroupEditable'.*",
        groups={"Integration", "Create", "Billing Group", "Invalid"}
    )
    public void billingGroupCreateTestBadParameter() throws ApiException {
        validApi.create(null);
    }

    @Test(
        enabled=true,
        expectedExceptions={ApiException.class},
        expectedExceptionsMessageRegExp=".*Your API key is not valid. Please sign up on lob.com to get a valid api key..*",
        groups={"Integration", "Create", "Billing Group", "Invalid"}
    )
    public void billingGroupCreateTestInvalidCredentials() throws ApiException {
        try {
            invalidApi.create(createdBillingGroups.get(0));
        }
        catch(ApiException e) {
            throw e;
        }
    }

    @Test(
        enabled=true,
        groups={"Integration", "List", "Billing Group", "Valid"}
    )
    public void billingGroupListTest() throws ApiException {
        validApi.create(createdBillingGroups.get(1));
        validApi.create(createdBillingGroups.get(2));
        
        BillingGroupList response = validApi.list(10, null, null, null, null, null);
        Assert.assertTrue(response.getCount() > 0);
    }
}
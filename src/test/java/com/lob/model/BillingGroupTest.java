package com.lob.model;

import com.lob.BaseTest;
import com.lob.exception.AuthenticationException;
import com.lob.exception.InvalidRequestException;
import com.lob.exception.RateLimitException;
import com.lob.net.LobResponse;
import com.lob.net.RequestOptions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class BillingGroupTest extends BaseTest {

	@Test
    public void testListBillingGroups() throws Exception {
        LobResponse<BillingGroupCollection> response = BillingGroup.list();

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(BillingGroup.class));
    }

	@Test
    public void testListBillingGroupsWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<BillingGroupCollection> response = BillingGroup.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(BillingGroup.class));
    }

	@Test
    public void testCreateAndRetrieveBillingGroup() throws Exception {
        LobResponse<BillingGroup> createResponse = new BillingGroup.RequestBuilder()
                .setName("Java Billing Group Test")
                .setDescription("Java Wrapper Automated Test")
                .create();

        BillingGroup billingGroup = createResponse.getResponseBody();

        assertEquals(200, createResponse.getResponseCode());
        assertEquals("billing_group", billingGroup.getObject());
        assertNotNull(billingGroup.getId());
        assertEquals("Java Billing Group Test", billingGroup.getName());
        assertEquals("Java Wrapper Automated Test", billingGroup.getDescription());
        assertNotNull(billingGroup.getDateCreated());
        assertNotNull(billingGroup.getDateModified());
        assertNull(billingGroup.isDeleted());
        assertNotNull(billingGroup.toString());

		String bgId = billingGroup.getId();

		LobResponse<BillingGroup> retrieveReponse = BillingGroup.retrieve(bgId);
		BillingGroup retrievedBillingGroup = retrieveReponse.getResponseBody();

		assertEquals(bgId, retrievedBillingGroup.getId());
    }

}

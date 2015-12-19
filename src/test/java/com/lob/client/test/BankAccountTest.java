package com.lob.client.test;

import com.google.common.collect.Maps;
import com.lob.Or;
import com.lob.client.AsyncLobClient;
import com.lob.client.LobClient;
import com.lob.protocol.request.AddressRequest;
import com.lob.protocol.request.BankAccountRequest;
import com.lob.protocol.request.BankAccountVerifyRequest;
import com.lob.protocol.request.Filters;
import com.lob.protocol.response.AddressResponse;
import com.lob.protocol.response.BankAccountDeleteResponse;
import com.lob.protocol.response.BankAccountResponse;
import com.lob.protocol.response.BankAccountResponseList;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankAccountTest extends BaseTest {
    @Test
    public void testListBankAccounts() throws Exception {
        final BankAccountResponseList responseList = client.getBankAccounts().get();
        final BankAccountResponse response = responseList.get(0);

        assertTrue(response instanceof BankAccountResponse);
        assertThat(responseList.getObject(), is("list"));
        assertNotNull(responseList.toString());
        assertNotNull(response.toString());
    }

    @Test
    public void testListBankAccountsLimit() throws Exception {
        final BankAccountResponseList responseList = client.getBankAccounts(2).get();
        final BankAccountResponse response = responseList.get(0);

        assertTrue(response instanceof BankAccountResponse);
        assertThat(responseList.getCount(), is(2));

        assertThat(client.getBankAccounts(1, 2).get().getCount(), is(1));
    }

    @Test(expected = ExecutionException.class)
    public void testListBankAccountsFail() throws Exception {
        client.getBankAccounts(1000).get();
    }

    @Test
    public void testCreateBankAccount() throws Exception {
        final String value0 = UUID.randomUUID().toString();
        final String value1 = UUID.randomUUID().toString();
        final Map<String, String> metadata = Maps.newHashMap();
        metadata.put("key0", value0);
        metadata.put("key1", value1);

        final BankAccountRequest.Builder builder = BankAccountRequest.builder()
            .routingNumber("122100024")
            .accountNumber("123456789")
            .signatory("John Doe")
            .description("bank account")
            .metadata(metadata);

        final BankAccountResponse response = client.createBankAccount(builder.build()).get();
        assertTrue(response instanceof BankAccountResponse);
        assertThat(response.getDescription(), is("bank account"));
        assertFalse(response.isVerified());
        assertFalse(response.getAccountNumber().isEmpty());
        assertFalse(response.getRoutingNumber().isEmpty());
        assertFalse(response.getSignatory().isEmpty());
        assertThat(response.getMetadata().get("key0"), is(value0));
        assertThat(response.getMetadata().get("key1"), is(value1));

        final BankAccountResponse metadataResponse = client.getBankAccounts(Filters.ofMetadata(metadata)).get().get(0);
        assertThat(metadataResponse.getId(), is(response.getId()));

        final BankAccountResponse retrievedResponse = client.getBankAccount(response.getId()).get();
        assertThat(retrievedResponse.getId(), is(response.getId()));

        final BankAccountVerifyRequest verifyRequest = BankAccountVerifyRequest.builder()
            .id(response.getId())
            .amounts(20, 40)
            .build();
        assertThat(verifyRequest.getAmounts(), is(Arrays.asList(20, 40)));
        assertNotNull(verifyRequest.toString());

        final BankAccountResponse verifyResponse = client.verifyBankAccount(verifyRequest).get();
        assertTrue(verifyResponse.isVerified());

        client.createBankAccount(builder.butWith().signatory("other account").build()).get();

        final BankAccountRequest request = builder.build();
        assertFalse(request.getAccountNumber().isEmpty());
        assertFalse(request.getRoutingNumber().isEmpty());
        assertFalse(request.getSignatory().isEmpty());
        assertNotNull(request.toString());
    }

    @Test
    public void testDeleteBankAccount() throws Exception {
        final BankAccountResponse response = client.getBankAccounts().get().get(0);
        final BankAccountDeleteResponse deleteResponse = client.deleteBankAccount(response.getId()).get();
        assertThat(deleteResponse.getId(), is(response.getId()));
        assertNotNull(deleteResponse.toString());
    }
}

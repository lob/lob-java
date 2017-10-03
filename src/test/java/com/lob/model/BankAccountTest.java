package com.lob.model;

import com.lob.BaseTest;
import com.lob.net.LobResponse;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class BankAccountTest extends BaseTest {

    @Test
    public void testListBankAccounts() throws Exception {
        LobResponse<BankAccountCollection> response = BankAccount.list();

        assertEquals(200, response.getResponseCode());
        assertEquals(10, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(BankAccount.class));
    }

    @Test
    public void testListBankAccountsWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        LobResponse<BankAccountCollection> response = BankAccount.list(params);

        assertEquals(200, response.getResponseCode());
        assertEquals(1, response.getResponseBody().getCount());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(BankAccount.class));
    }

    @Test
    public void testRetrieveBankAccount() throws Exception {
        BankAccount testBankAccount = BankAccount.list().getResponseBody().getData().get(0);

        LobResponse<BankAccount> response = BankAccount.retrieve(testBankAccount.getId());
        BankAccount bankAccount = response.getResponseBody();

        assertEquals(testBankAccount.getId(), bankAccount.getId());
    }

    @Test
    public void testCreateBankAccount() throws Exception {
        Map<String, String> metadata = new HashMap<String, String>();
        metadata.put("a", "b");

        LobResponse<BankAccount> response = new BankAccount.RequestBuilder()
                .setDescription("Test Bank Account")
                .setRoutingNumber("322271627")
                .setAccountNumber("123456789")
                .setAccountType("company")
                .setSignatory("Donald")
                .setMetadata(metadata)
                .create();

        BankAccount bankAccount = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(bankAccount.getId());
        assertEquals("Test Bank Account", bankAccount.getDescription());
        assertEquals("J.P. MORGAN CHASE BANK, N.A.", bankAccount.getBankName());
        assertEquals("322271627", bankAccount.getRoutingNumber());
        assertEquals("123456789", bankAccount.getAccountNumber());
        assertEquals("company", bankAccount.getAccountType());
        assertEquals("Donald", bankAccount.getSignatory());
        assertFalse(bankAccount.isVerified());
        assertNotNull(bankAccount.getDateCreated());
        assertNotNull(bankAccount.getDateModified());
        assertFalse(bankAccount.isDeleted());
        assertEquals("bank_account", bankAccount.getObject());
        assertNotNull(bankAccount.toString());
    }

    @Test
    public void testVerifyBankAccount() throws Exception {
        BankAccount newBankAccount = new BankAccount.RequestBuilder()
                .setRoutingNumber("322271627")
                .setAccountNumber("123456789")
                .setAccountType("company")
                .setSignatory("Donald")
                .create()
                .getResponseBody();

        assertFalse(newBankAccount.isVerified());

        LobResponse<BankAccount> response = BankAccount.verify(newBankAccount.getId(), Arrays.asList(25, 63));

        BankAccount bankAccount = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals(newBankAccount.getId(), bankAccount.getId());
        assertTrue(bankAccount.isVerified());
    }

    @Test
    public void testDeleteBankAccount() throws Exception {
        BankAccount newBankAccount = new BankAccount.RequestBuilder()
                .setRoutingNumber("322271627")
                .setAccountNumber("123456789")
                .setAccountType("company")
                .setSignatory("Donald")
                .create()
                .getResponseBody();

        assertFalse(newBankAccount.isDeleted());

        LobResponse<BankAccount> response = BankAccount.delete(newBankAccount.getId());

        BankAccount bankAccount = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertEquals(newBankAccount.getId(), bankAccount.getId());
        assertTrue(bankAccount.isDeleted());
    }

}

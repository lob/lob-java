package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Bank_account;
import com.lob.model.BankAccountCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {
    static Map<String, Object> defaultBankAccountParams = new HashMap<String, Object>();

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";

      defaultBankAccountParams.put("name", "Testing Bank Account");
      defaultBankAccountParams.put("routing_number", "122100024");
      defaultBankAccountParams.put("account_number", "123456789");
      defaultBankAccountParams.put("bank_address[name]", "Chase Bank");
      defaultBankAccountParams.put("bank_address[address_line1]", "55 Edmonds");
      defaultBankAccountParams.put("bank_address[address_city]", "Palo Alto");
      defaultBankAccountParams.put("bank_address[address_state]", "CA");
      defaultBankAccountParams.put("bank_address[address_zip]", "90081");
      defaultBankAccountParams.put("bank_address[address_country]", "US");
      defaultBankAccountParams.put("account_address[name]", "Leore Avidar");
      defaultBankAccountParams.put("account_address[address_line1]", "123 Test Street.");
      defaultBankAccountParams.put("account_address[address_line2]", "Apt 155");
      defaultBankAccountParams.put("account_address[address_city]", "Sunnyvale");
      defaultBankAccountParams.put("account_address[address_state]", "CA");
      defaultBankAccountParams.put("account_address[address_zip]", "94085");
      defaultBankAccountParams.put("account_address[address_country]", "US");
    }

    @Test
    public void testBankAccountRetrieveAll() throws LobException {
      Map<String, Object> listParams = new HashMap<String, Object>();
      listParams.put("count", 2);
      listParams.put("offset", 3);

      BankAccountCollection bankAccounts = Bank_account.all(listParams, Lob.apiKey);
      assertEquals(bankAccounts.getData().size(), 2);
    }

    @Test(expected=APIException.class)
    public void testBankAccountRetrieveAllFail() throws LobException {
      Map<String, Object> listParams = new HashMap<String, Object>();
      listParams.put("count", 100000);

      BankAccountCollection bankAccounts = Bank_account.all(listParams, Lob.apiKey);
    }

    @Test
    public void testBankAccountCreate() throws LobException {
      Bank_account bankAccount = Bank_account.create(defaultBankAccountParams, Lob.apiKey);
      assertEquals(bankAccount.getRouting_number(), "122100024");
    }

    @Test(expected=APIException.class)
    public void testBankAccountCreateFail() throws LobException {
      Map<String, Object> badBankAccountParams = new HashMap<String, Object>();
      badBankAccountParams.put("routing_number", "Test Address");
      Bank_account badBankAccount = Bank_account.create(badBankAccountParams, Lob.apiKey);
    }

    @Test
    public void testBankAccountRetrieve() throws LobException {
      Bank_account createdBankAccount = Bank_account.create(defaultBankAccountParams, Lob.apiKey);
      Bank_account retrievedBankAccount = Bank_account.retrieve(createdBankAccount.getId(), Lob.apiKey);
      assertEquals(createdBankAccount.getId(), retrievedBankAccount.getId());
    }

    @Test(expected=APIException.class)
    public void testBankAccountRetrieveFail() throws LobException {
      Bank_account bankAccount = Bank_account.retrieve("asdf", Lob.apiKey);
    }
}

package com.lob;

import com.lob.exception.LobException;
import com.lob.exception.APIException;
import com.lob.Lob;
import com.lob.model.Bank_account;
import com.lob.model.Check;
import com.lob.model.CheckCollection;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckTest {
    static Map<String, Object> defaultCheckParams = new HashMap<String, Object>();
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

      defaultCheckParams.put("name", "Test Check");
      defaultCheckParams.put("to[name]", "Payee");
      defaultCheckParams.put("to[address_line1]", "123 Test Street");
      defaultCheckParams.put("to[address_city]", "San Francisco");
      defaultCheckParams.put("to[address_state]", "CA");
      defaultCheckParams.put("to[address_zip]", "94107");
      defaultCheckParams.put("amount", "2000");
    }

    @Test
    public void testCheckRetrieveAll() throws LobException {
      Map<String, Object> listParams = new HashMap<String, Object>();
      listParams.put("count", 2);
      listParams.put("offset", 3);

      CheckCollection checks = Check.all(listParams, Lob.apiKey);
      assertEquals(checks.getData().size(), 2);
      assertEquals("list", checks.getObject());
    }

    @Test(expected=APIException.class)
    public void testCheckRetrieveAllFail() throws LobException {
      Map<String, Object> listParams = new HashMap<String, Object>();
      listParams.put("count", 100000);

      CheckCollection checks = Check.all(listParams, Lob.apiKey);
    }

    @Test
    public void testCheckCreate() throws LobException {
      Bank_account bankAccount = Bank_account.create(defaultBankAccountParams, Lob.apiKey);
      defaultCheckParams.put("bank_account", bankAccount.getId());
      Check check = Check.create(defaultCheckParams, Lob.apiKey);
      assertEquals(check.getName(), "Test Check");
    }

    @Test(expected=APIException.class)
    public void testCheckCreateFail() throws LobException {
      Map<String, Object> badCheckParams = new HashMap<String, Object>();
      badCheckParams.put("amount", "2000");
      Check badCheck = Check.create(badCheckParams, Lob.apiKey);
    }

    @Test
    public void testCheckRetrieve() throws LobException {
      Check createdCheck = Check.create(defaultCheckParams, Lob.apiKey);
      Check retrievedCheck = Check.retrieve(createdCheck.getId(), Lob.apiKey);
      assertEquals(createdCheck.getId(), retrievedCheck.getId());
    }

    @Test(expected=APIException.class)
    public void testCheckRetrieveFail() throws LobException {
      Check bankAccount = Check.retrieve("asdf", Lob.apiKey);
    }
}

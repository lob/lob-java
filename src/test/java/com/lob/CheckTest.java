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
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

public class CheckTest {
    static Map<String, Object> defaultCheckParams = new HashMap<String, Object>();
    static Map<String, Object> defaultBankAccountParams = new HashMap<String, Object>();

    @BeforeClass
    public static void setUp() {
      Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc";

      defaultBankAccountParams.put("description", "Testing Bank Account");
      defaultBankAccountParams.put("signatory", "John Doe");
      defaultBankAccountParams.put("routing_number", "122100024");
      defaultBankAccountParams.put("account_number", "123456788");
      defaultBankAccountParams.put("bank_address[name]", "Chase");
      defaultBankAccountParams.put("bank_address[address_line1]", "123 Test Street");
      defaultBankAccountParams.put("bank_address[address_line2]", "Unit 199");
      defaultBankAccountParams.put("bank_address[address_city]", "San Francisco");
      defaultBankAccountParams.put("bank_address[address_state]", "CA");
      defaultBankAccountParams.put("bank_address[address_zip]", "60039");
      defaultBankAccountParams.put("bank_address[address_country]", "US");
      defaultBankAccountParams.put("account_address[name]", "Lob.com");
      defaultBankAccountParams.put("account_address[address_line1]", "123 Test Street.");
      defaultBankAccountParams.put("account_address[address_line2]", "Unit 199");
      defaultBankAccountParams.put("account_address[address_city]", "San Francisco");
      defaultBankAccountParams.put("account_address[address_state]", "CA");
      defaultBankAccountParams.put("account_address[address_zip]", "60039");
      defaultBankAccountParams.put("account_address[address_country]", "US");

      defaultCheckParams.put("description", "Test Check");
      defaultCheckParams.put("to[name]", "Payee");
      defaultCheckParams.put("to[address_line1]", "123 Test Street");
      defaultCheckParams.put("to[address_city]", "Mountain View");
      defaultCheckParams.put("to[address_state]", "CA");
      defaultCheckParams.put("to[address_zip]", "94041");
      defaultCheckParams.put("to[address_country]", "US");
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
    @Ignore
    public void testCheckCreate() throws LobException {
      Bank_account bankAccount = Bank_account.create(defaultBankAccountParams, Lob.apiKey);
      defaultCheckParams.put("bank_account", bankAccount);
      Check check = Check.create(defaultCheckParams, Lob.apiKey);
      assertEquals("Test Check", check.getDescription());
      assertEquals("10000", check.getCheck_number());
      assertEquals("123456789", check.getBank_account().getAccount_number());
      assertEquals("Lob.com", check.getTo().getName());
      assertEquals(2000.0, check.getAmount(), 1);
      assertNull(check.getMessage());
      assertNull(check.getMemo());
    }

    @Test(expected=APIException.class)
    public void testCheckCreateFail() throws LobException {
      Map<String, Object> badCheckParams = new HashMap<String, Object>();
      badCheckParams.put("amount", "2000");
      Check badCheck = Check.create(badCheckParams, Lob.apiKey);
    }

    @Test
    @Ignore
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

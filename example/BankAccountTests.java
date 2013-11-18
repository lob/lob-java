import java.util.HashMap;
import java.util.Map;

import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Bank_account;
import com.lob.model.BankAccountCollection;

public class BankAccountTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "bank_dfceb4a2a05b57e";
        try {
 
        	Bank_account b1 = Bank_account.retrieve(id, Lob.apiKey);
            System.out.println(b1);           
       
            Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
            
            ObjectMap.put("routing_number", "123456789");
            ObjectMap.put("account_number", "123456789");
            ObjectMap.put("bank_code", "123456789");
            ObjectMap.put("bank_address[name]", "Chase Bank");
            ObjectMap.put("bank_address[address_line1]", "55 Edmonds");
            ObjectMap.put("bank_address[address_city]", "Palo Alto");
            ObjectMap.put("bank_address[address_state]", "CA");
            ObjectMap.put("bank_address[address_zip]", "90081");
            ObjectMap.put("bank_address[address_country]", "US");
            ObjectMap.put("account_address[name]", "Leore Avidar");
            ObjectMap.put("account_address[address_line1]", "123 Test Street.");
            ObjectMap.put("account_address[address_line2]", "Apt 155");
            ObjectMap.put("account_address[address_city]", "Sunnyvale");
            ObjectMap.put("account_address[address_state]", "CA");
            ObjectMap.put("account_address[address_zip]", "94085");
            ObjectMap.put("account_address[address_country]", "US"); 
          
            Bank_account b2 = Bank_account.create(ObjectMap, Lob.apiKey);
            System.out.println(b2);
            
            Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
            listParams.put("count", 2);
            listParams.put("offset", 3);
            BankAccountCollection ac = Bank_account.all(listParams, Lob.apiKey);
            System.out.println(ac);
            

            
        } catch (LobException e) {
        	System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
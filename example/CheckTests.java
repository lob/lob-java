import java.util.HashMap;
import java.util.Map;

import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Check;
import com.lob.model.CheckCollection;

public class CheckTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "chk_a70f7e3893f8f1d8";
        try {
 
        	Check c1 = Check.retrieve(id, Lob.apiKey);
            System.out.println(c1);           
       
            Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
            ObjectMap.put("name", "Demo Check");
            ObjectMap.put("to[name]", "Harry Zhang");
            ObjectMap.put("to[address_line1]", "123 Test Street");
            ObjectMap.put("to[address_city]", "Mountain View");
            ObjectMap.put("to[address_state]", "CA");
            ObjectMap.put("to[address_zip]", "94041");
            ObjectMap.put("to[address_country]", "US");
            ObjectMap.put("bank_account", "bank_3e64d9904356b20");
            ObjectMap.put("amount", 2200);
            ObjectMap.put("memo", "rent");
            		
            Check c2 = Check.create(ObjectMap, Lob.apiKey);
            System.out.println(c2);
            
            Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
            listParams.put("count", 2);
            listParams.put("offset", 3);
            CheckCollection ac = Check.all(listParams, Lob.apiKey);
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
import java.util.HashMap;
import java.util.Map;

import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Postcard;
import com.lob.model.PostcardCollection;

public class PostCardTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "psc_5c002b86ce47537a";
        try {
 
        	Postcard p1 = Postcard.retrieve(id, Lob.apiKey);
            System.out.println(p1);           
       
            Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
            ObjectMap.put("name", "Demo Postcard job");
            ObjectMap.put("to[name]", "Harry Zhang");
            ObjectMap.put("to[address_line1]", "123 Test Street");
            ObjectMap.put("to[address_city]", "Mountain View");
            ObjectMap.put("to[address_state]", "CA");
            ObjectMap.put("to[address_zip]", "94041");
            ObjectMap.put("to[address_country]", "US");
            ObjectMap.put("from[name]", "Harry Zhang");
            ObjectMap.put("from[address_line1]", "123 Test Avenue");
            ObjectMap.put("from[address_city]", "Seattle");
            ObjectMap.put("from[address_state]", "WA");
            ObjectMap.put("from[address_zip]", "94041");
            ObjectMap.put("from[address_country]", "US");
            ObjectMap.put("front", "https://www.lob.com/postcardfront.pdf");
            ObjectMap.put("back", "https://www.lob.com/postcardback.pdf");           
           		
            Postcard p2 = Postcard.create(ObjectMap, Lob.apiKey);
            System.out.println(p2);
            
            Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
            listParams.put("count", 2);
            listParams.put("offset", 3);
            PostcardCollection ac = Postcard.all(listParams, Lob.apiKey);
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
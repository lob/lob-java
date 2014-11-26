import java.util.HashMap;
import java.util.Map;

import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Address;
import com.lob.model.DeletedStatus;
import com.lob.model.AddressCollection;
import com.lob.model.Verify;

public class LobExample {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "adr_fa85158b26c3eb7c";
        try {
 
            Address a1 = Address.retrieve(id, Lob.apiKey);
            System.out.println(a1);
            
            Map<String, Object> AddressMap2 = new HashMap<String, Object>();
            AddressMap2.put("name", "James Chen");
            AddressMap2.put("email", "james@lob.com");
            AddressMap2.put("phone", "5555555555");
            AddressMap2.put("address_line1", "345 Main Street");
            AddressMap2.put("address_line2", "Apt. 111");
            AddressMap2.put("address_city", "Mountain View");
            AddressMap2.put("address_state", "CA");
            AddressMap2.put("address_zip", "94085");
            AddressMap2.put("address_country", "US");
            
            Address a3 = Address.create(AddressMap2, Lob.apiKey);
            System.out.println(a3);
            
            DeletedStatus d1 = Address.delete(a3.getId(), Lob.apiKey);
            System.out.println(d1);
            
            Map<String, Object> listParams = new HashMap<String, Object>();
            listParams.put("count", 2);
            listParams.put("offset", 3);
            AddressCollection ac = Address.all(listParams, Lob.apiKey);
            System.out.println(ac);
            
            Map<String, Object> AddressMap3 = new HashMap<String, Object>();
            AddressMap3.put("address_line1", "220 William T Morrissey Boulevard");
            //AddressMap3.put("address_line2", "SUNSET TOWN");
            AddressMap3.put("address_city", "Boston");
            AddressMap3.put("address_state", "MA");
            AddressMap3.put("address_zip", "02125");
            //AddressMap3.put("address_country", "US");
            Verify a4 = Address.verify(AddressMap3, Lob.apiKey);
            System.out.println(a4);
            
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
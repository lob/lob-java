import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Setting;
import com.lob.model.SettingCollection;

public class SettingTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "100";
        try {
 
        	Setting s1 = Setting.retrieve(id, Lob.apiKey);
            System.out.println(s1);           
           
            SettingCollection ac = Setting.all(Lob.apiKey);
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
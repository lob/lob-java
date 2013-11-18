import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Packaging;
import com.lob.model.PackagingCollection;

public class PackagingTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        try {
            PackagingCollection ac = Packaging.all(Lob.apiKey);
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
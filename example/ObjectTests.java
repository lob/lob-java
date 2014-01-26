import java.util.HashMap;
import java.util.Map;

import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Object;
import com.lob.model.DeletedStatus;
import com.lob.model.ObjectCollection;
import java.io.*;

public class ObjectTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "obj_4241a46e01b4f892";
        try {
 
        	Object o1 = Object.retrieve(id, Lob.apiKey);
            System.out.println(o1);           
       
            Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
            ObjectMap.put("name", "GO BLUE");
            ObjectMap.put("file", "@F:/Jimmy/goblue.pdf");
            ObjectMap.put("quantity", 2);
            ObjectMap.put("setting_id", 100);
            ObjectMap.put("double_sided", 1);
            
            Object o2 = Object.create(ObjectMap, Lob.apiKey);
            System.out.println(o2);
            
            DeletedStatus d1 = Object.delete(o2.getId(), Lob.apiKey);
            System.out.println(d1);
            
            Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
            listParams.put("count", 2);
            listParams.put("offset", 3);
            ObjectCollection ac = Object.all(listParams, Lob.apiKey);
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
    
    public static byte[] readFile(File file) throws IOException {
        // Open file
        RandomAccessFile f = new RandomAccessFile(file, "r");
        try {
            // Get and check length
            long longlength = f.length();
            int length = (int) longlength;
            if (length != longlength)
                throw new IOException("File size >= 2 GB");
            // Read file and return data
            byte[] data = new byte[length];
            f.readFully(data);
            return data;
        } finally {
            f.close();
        }
    }    
}
import java.util.HashMap;
import java.util.Map;

import com.lob.Lob;
import com.lob.exception.LobException;
import com.lob.model.Job;
import com.lob.model.JobCollection;

public class JobTests {

    public static void main(String[] args) {
        Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
        String id = "job_0e3eff58cb59c935";
        try {
 
        	Job j1 = Job.retrieve(id, Lob.apiKey);
            System.out.println(j1);           
       
            Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
            ObjectMap.put("name", "Michigan fan letter");
            ObjectMap.put("to", "adr_43769b47aed248c2");
            ObjectMap.put("from", "adr_7f9ece71fbca3796");
            ObjectMap.put("object1", "obj_7ca5f80b42b6dfca");
            ObjectMap.put("object2", "obj_12128d3aad2aa98f");
            ObjectMap.put("object3", "obj_4241a46e01b4f892");       
            		
            Job j2 = Job.create(ObjectMap, Lob.apiKey);
            System.out.println(j2);
            
            Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
            listParams.put("count", 2);
            listParams.put("offset", 3);
            JobCollection ac = Job.all(listParams, Lob.apiKey);
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
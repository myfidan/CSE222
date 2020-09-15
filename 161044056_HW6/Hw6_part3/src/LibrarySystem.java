import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LibrarySystem {
    //Password for admin login
    private String SystemPass="123@pass";

    public Map<String,Map<String, Set<String>>> BookMap=new HashMap<>();



    public String getPass(){
        return SystemPass;
    }
}

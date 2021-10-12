
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Instantiate the HashMap
        HashMap<String, String> nicknames = new HashMap<>();
        
        // Add names to the HashMap
        nicknames.put("matthew", "matt");
        nicknames.put("michael", "mix");
        nicknames.put("arthur", "artie");
        
        System.out.println(nicknames.get("matthew"));
    }

}

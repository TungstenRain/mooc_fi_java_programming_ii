import java.util.Map;
import java.util.HashMap;

public class MainProgram {

    public static void main(String[] args) {
        // test your method here
        Map<String, String> names = new HashMap<>();
        
        names.put("1", "first");
        names.put("2", "second");

        System.out.println(returnSize(names));
    }

    /**
     * Return the size of the Map<String, String>
     * @param map Map<String, String>: the Map to get the size of
     * @return int: the size of the Map
     */
    public static int returnSize(Map<String, String> map) {
        return map.size();
    }
}

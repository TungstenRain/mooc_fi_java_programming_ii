
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Instantiate HashMap
        HashMap<String, String> hashMap = new HashMap<>();
        
        // Add values to the HashMap
        hashMap.put("f.e.", "for example");
        hashMap.put("etc.", "and so on");
        hashMap.put("i.e.", "more precisely");
        
        printKeys(hashMap);
        System.out.println("---");
        printKeysWhere(hashMap, "i");
        System.out.println("---");
        printValuesOfKeysWhere(hashMap, ".e");
    }
    
    // Methods
    /**
     * Print all the keys in the given HashMap
     * @param hashMap HashMap<String, String>: the HashMap
     */
    public static void printKeys(HashMap<String, String> hashMap) {
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }
    }
    
    /**
     * Print the keys in the given HashMap which contain the given String as a parameter
     * @param hashMap HashMap<String, String>: the HashMap
     * @param text String: the parameter
     */
    public static void printKeysWhere(HashMap<String, String> hashMap, String text) {
        for (String key : hashMap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }
    }
    
    /**
     * Print the values in the given HashMap which keys contain the given string
     * @param hashMap
     * @param text 
     */
    public static void printValuesOfKeysWhere(HashMap<String, String> hashMap, String text) {
        for (String key: hashMap.keySet()) {
            if (key.contains(text)) {
                System.out.println(hashMap.get(key));
            }
        }
    }
}

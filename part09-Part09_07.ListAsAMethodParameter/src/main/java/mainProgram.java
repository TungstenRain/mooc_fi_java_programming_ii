import java.util.ArrayList;
import java.util.List;

public class mainProgram {

    public static void main(String[] args) {
        // Instantiate the List
        List<String> names = new ArrayList<>();
        
        // Add to the list
        names.add("First");
        names.add("Second");
        names.add("Third");
        
        // Display the results
        System.out.println(returnSize(names));
    }

    
    /**
     * Return the size of a List<String>
     * @param list List<String>: the List to get the size of
     * @return int: the size of the list
     */
    public static int returnSize(List<String> list) {
        return list.size();
    }
}

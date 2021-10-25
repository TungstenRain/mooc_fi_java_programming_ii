
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        // Variables
        final String file = "literacy.csv";
        
        // Instantiate List
        List<LiteracyData> data = new ArrayList<>();
        
        // Get data from the file
        try {
            // Process the data and put it into the List
            Files.lines(Paths.get(file))
                    // split the rows into parts
                    .map(row -> row.split(","))
                    // Instantiate a LiteracyData from the part
                    .map(parts -> new LiteracyData(parts[0].trim(), parts[1].trim(), parts[2].replace("(%)", "").trim(), parts[3].trim(), Integer.valueOf(parts[4].trim()), Double.valueOf(parts[5].trim())))
                    // Add each LiteracyData to the ArrayList
                    .forEach(each -> data.add(each));
            
            // Print results
            data.stream()
                    // sort the data
                    .sorted()
                    // Print them
                    .forEach(each -> System.out.println(each));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
    
    
}

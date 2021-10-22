
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        // Instantiate Scanner and ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listOfIntegers = new ArrayList<>();
        
        // Request and capture input
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            listOfIntegers.add(input);
        }
        
        // Calculate and display results
        double average = listOfIntegers.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();
        
        System.out.println("Average of numbers: " + average);
    }
}

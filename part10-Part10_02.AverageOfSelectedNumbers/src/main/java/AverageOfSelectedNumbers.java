
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        // Instantiate Scanner and ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listOfNumbers = new ArrayList<>();
        
        // Request and capture input from user
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            listOfNumbers.add(input);
        }
        
        // Request and capture input from user
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String input = scanner.nextLine();
        
        // Calculate the average of numbers (negative or positive) and display results
        double average = 0.0;
        
        switch (input) {
                case "n":
                    average = listOfNumbers.stream()
                            .mapToInt(s -> Integer.valueOf(s))
                            .filter(number -> number < 0)
                            .average()
                            .getAsDouble();
                    input = "negative";
                    break;
                case "p":
                    average = listOfNumbers.stream()
                            .mapToInt(s -> Integer.valueOf(s))
                            .filter(number -> number >= 0)
                            .average()
                            .getAsDouble();
                    input = "positive";
                    break;
                default:
                    break;
        }
                
        System.out.println("Average of the " + input + " numbers: " + average);
    }
}

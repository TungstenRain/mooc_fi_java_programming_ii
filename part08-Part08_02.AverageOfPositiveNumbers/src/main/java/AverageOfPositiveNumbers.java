
import java.util.Scanner;
import java.util.ArrayList;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        // Instantiate Scanner and ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> positiveNumbers = new ArrayList<>();
        
        // Request and capture user input
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == 0) {
                break;
            }
            
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }
        
        if (positiveNumbers.isEmpty()) {
            System.out.println("Cannot calculate the average");
        } else {
            int sum = 0;
            for (int number : positiveNumbers) {
                sum+= number;
            }
            double average = (double) sum / positiveNumbers.size();
            System.out.println(average);
        }
        
    }
}

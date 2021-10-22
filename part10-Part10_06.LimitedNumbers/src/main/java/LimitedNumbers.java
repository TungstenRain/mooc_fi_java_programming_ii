
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        // Instantiate Scanner and ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        
        // Capture user input
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input < 0 ) {
                break;
            }
            listOfIntegers.add(input);
        }
        
        // Print all numbers the user has given between the numbers between 1 and 5
        listOfIntegers.stream()
                .filter(number -> (number >= 1) && (number <= 5))
                .forEach(number -> System.out.println(number));
    }
}

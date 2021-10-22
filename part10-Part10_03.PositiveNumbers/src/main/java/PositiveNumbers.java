
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        // Instantiate Scanner and List
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfIntegers = new ArrayList<>();
        
        // Request and capture input from user
        System.out.println("Input an integer, positive or negative. Type 'end' to stop.");
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            listOfIntegers.add(Integer.valueOf(input));
        }
        
        System.out.println(positive(listOfIntegers));
    }
    
    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}

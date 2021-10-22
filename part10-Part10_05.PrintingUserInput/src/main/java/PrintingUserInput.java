
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        // Instantiate Scanner and ArrayList
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listOfWords = new ArrayList<>();
        
        // Request and capture user input
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            listOfWords.add(input);
        }
        
        String combined = listOfWords.stream()
                .reduce("", (previousString, word) -> previousString + word + "\n");
        System.out.println(combined);
    }
}

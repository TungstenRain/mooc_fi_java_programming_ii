
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        // Instantiate Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Request and capture input
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            int number = Integer.valueOf(input);
            System.out.println((number * number * number));
        }
    }
}

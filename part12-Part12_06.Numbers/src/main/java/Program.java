
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // Instantiate Scanner and Random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Request and capture user input
        System.out.println("How many random numbers should be printed?");
        int input = Integer.valueOf(scanner.nextLine());
        
        // Display results
        for (int i = 0; i < input; i++) {
            System.out.println(random.nextInt(11));
        }
    }

}

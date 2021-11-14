package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        // Instantiate Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Request anc capture user input
        System.out.println("Please enter a title: ");
        String title = scanner.nextLine();
        
        // Call the GUI
        Application.launch(UserTitle.class, "--title=" + title);
    }

}

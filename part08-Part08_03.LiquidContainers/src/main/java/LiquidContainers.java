
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        // Instantiate Scanner
        Scanner scan = new Scanner(System.in);
        
        // Initialize variables
        int containerOne = 0;
        int containerTwo = 0;
        
        // Request and capture user input, process input
        while (true) {
            // Display container amount
            System.out.println("First: " + containerOne + "/100");
            System.out.println("Second: " + containerTwo + "/100");
            
            // Capture command from user
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            // Split the input into components
            final String[] components = input.split(" ");
            final String command = components[0];
            int amount = Integer.parseInt(components[1]);
            
            // Process the commands
            switch (command) {
                case "add":
                    /**
                     * adds the amount of liquid specified by the parameter to 
                     * the first container. The inserted amount must be 
                     * specified as an integer. The container can't hold more 
                     * than a hundred liters and everything added past that 
                     * will go to waste.
                     */
                    if (amount > 0) {
                        containerOne+= amount;
                    }
                    if (containerOne > 100) {
                        containerOne = 100;
                    }
                    break;
                case "move":
                    /**
                     * moves the amount of liquid specified by the parameter 
                     * from the first container to the second container. The 
                     * given amount must be specified as an integer. If the 
                     * program is requested to move more liquid than than the 
                     * first container currently holds, move all the remaining 
                     * liquid. The second container can't hold more than one 
                     * hundred liters of liquid and everything past that will 
                     * go to waste.
                     */
                    if (amount > 0) {
                        if (containerOne >= amount) {
                            containerOne-= amount;
                            containerTwo+= amount;
                        } else {
                            int remainder = Math.abs(containerOne - amount);
                            containerOne = 0;
                            containerTwo+= (amount - remainder);
                        }
                    }
                    if (containerTwo > 100) {
                        containerTwo = 100;
                    }
                    break;
                case "remove":
                    /**
                     * removes the amount of liquid specified by the parameter 
                     * from the second container. If the program is requested 
                     * to remove more liquid than the container currently 
                     * holds, remove all the remaining liquid.
                     */
                    if (amount > 0) {
                        if (containerTwo >= amount) {
                            containerTwo-= amount;
                        } else {
                            containerTwo = 0;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

}

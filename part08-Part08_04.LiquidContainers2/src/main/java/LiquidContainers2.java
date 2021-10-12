
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        // Instantiate Scanner and Containers
        Scanner scanner = new Scanner(System.in);
        Container containerOne = new Container();
        Container containerTwo = new Container();
        
        /**
         * NOTE: I would have preferred to create and instantiate a UserInterface
         * class wherein most of the processing would have been completed. This
         * would have been a continuation of things learned in previous sections.
         * However, the Unit Testing for this would not allow it.
         */
        
        // Request and capture user input
        while (true) {
            System.out.println("First: " + containerOne);
            System.out.println("Second: " + containerTwo);

            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            final String[] components = input.split(" ");
            final String command = components[0].toLowerCase();
            final int amount = Integer.parseInt(components[1]);
            
            // Process commands
            processCommands(command, amount, containerOne, containerTwo);
        }
    }
    
    /**
     * Process commands given by the user
     * @param command String: the command
     * @param amount int: the amount involved with the command
     * @param containerOne Container: the first container
     * @param containerTwo Container: the second container
     */
    private static void processCommands (String command, int amount, Container containerOne, Container containerTwo) {
        switch (command) {
            case "add":
                add(amount, containerOne);
                break;
            case "move":
                move(amount, containerOne, containerTwo);
                break;
            case "remove":
                remove(amount, containerTwo);
                break;
            default:
                break;
        }
    }
    /**
     * Add an amount to a Container
     * @param amount int: the amount to add
     * @param container Container: the container to be added to
     */
    private static void add(int amount, Container container) {
        container.add(amount);
    }
    /**
     * Move an amount from one container to another
     * @param amount int: the amount to be moved
     * @param containerOne Container: the container to be moved from
     * @param containerTwo Container: the container to be moved to
     */
    private static void move(int amount, Container containerOne, Container containerTwo) {
        if (amount > containerOne.contains()) {
            int remainder = Math.abs(containerOne.contains() - amount);
            containerTwo.add(amount - remainder);
        } else {
            containerTwo.add(amount);
        }
        containerOne.remove(amount);
    }
    /**
     * Remove an amount from a container
     * @param amount int: the amount to be removed
     * @param container Container: the Container from which the amount is removed
     */
    private static void remove(int amount, Container container) {
        container.remove(amount);
    }
}

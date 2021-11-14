package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
    // Variables
    private Scanner scanner;
    private TodoDao database;
    
    // Constructors
    /**
     * Construct the UserInterface
     * @param scanner Scanner: the Scanner
     * @param database TodoDao: the database connection
     */
    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }
    
    // Methods
    public void start() throws SQLException {
        // Actions while the application is running
        while (true) {
            printCommands();
            
            // Capture user input
            String command = this.scanner.nextLine().trim().toLowerCase();
            
            if (command.equals("x") || command.equals("quit")) {
                break;
            }
            
            // Choose functionality based on user input
            switch (command) {
                case "1":
                case "list":
                    commandList();
                    break;
                case "2":
                case "add":
                    commandAdd();
                    break;
                case "3":
                case "mark as done":
                    commandMarkAsDone();
                    break;
                case "4":
                case "remove":
                    commandRemove();
                    break;
                default:
                    commandInvalid();
                    break;
            }
        }
        
        // End the program
        System.out.println("Thank you!");
    }
    
    /**
     * Print a list of commands to the user
     */
    private void printCommands() {
        System.out.println("");
        System.out.println("Enter command:");
        System.out.println("1) list");
        System.out.println("2) add");
        System.out.println("3) mark as done");
        System.out.println("4) remove");
        System.out.println("x) quit");
        System.out.print("> ");
    }
    
    /**
     * List the items in the Todo
     */
    private void commandList() throws SQLException {
        System.out.println("Listing the database contents");
        
        // List all the Todos
        database.list()
                .forEach(task -> {
                    System.out.println(task);
                });
    }
    
    /**
     * Add a Todo
     */
    private void commandAdd() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        
        // Capture user input
        String todoName = scanner.nextLine().trim();
        
        System.out.println("Enter description");
        
        // Capture user input
        String todoDescription = scanner.nextLine().trim();
        
        // Instantiate a Todo and add it to the database
        database.add(new Todo(todoName, todoDescription, false));
    }
    
    /**
     * Mark a Todo as complete
     */
    private void commandMarkAsDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        
        // Capture user input
        String todoID = scanner.nextLine().trim();
        
        // Mark Todo as completed
        database.markAsDone(Integer.valueOf(todoID));
    }
    
    /**
     * Remove a Todo
     */
    private void commandRemove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        
        // Capture user input
        String todoID = scanner.nextLine().trim();
        
        // Remove the Todo from the database
        database.remove(Integer.valueOf(todoID));
    }
    
    /**
     * Request a valid command
     */
    private void commandInvalid() {
        System.out.println("Please enter a valid command.");
    }
}

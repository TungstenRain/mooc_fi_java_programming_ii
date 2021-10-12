/**
 * UserInterface for Part06_10
 * @author frank
 */

import java.util.Scanner;

public class UserInterface {
    // Variables
    private Scanner scanner;
    private TodoList toDoList;
    
    // Constructors
    public UserInterface(TodoList list, Scanner scanner) {
        this.scanner = scanner;
        this.toDoList = list;
    }
    
    // Methods
    public void start() {
        this.requestInformation();
    }
    
    /**
     * Request and capture user information
     */
    private void requestInformation() {
        // Request and capture user input
        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();
            
            if (command.equals("stop")) {
                break;
            }
            
            this.processCommands(command);
        }
    }
    
    /**
     * Process the command given by the user
     * @param command String: the command
     */
    private void processCommands(String command) {
        // Switch statement for commands
        switch (command) {
            case "add":
                this.add();
                break;
            case "list":
                this.list();
                break;
            case "remove":
                this.remove();
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }
    
    /**
     * Request and add a task
     */
    private void add() {
        // Request and capture input
        System.out.println("To add:");
        String task = scanner.nextLine();
        
        toDoList.add(task);
    }
    
    /**
     * Display all the tasks on the ToDoList
     */
    private void list() {
        toDoList.print();
    }
    
    /**
     * Request which task to remove and remove it
     */
    private void remove() {
        // Request and capture user input
        System.out.println("Which one is removed?");
        int number = Integer.parseInt(scanner.nextLine());
        
        toDoList.remove(number);
    }
}

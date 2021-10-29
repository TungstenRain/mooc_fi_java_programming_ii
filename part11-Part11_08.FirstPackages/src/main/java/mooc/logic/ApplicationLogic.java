package mooc.logic;

/**
 * ApplicationLogic for Part11_08
 * @author frank
 */

import mooc.ui.UserInterface;

public class ApplicationLogic {
    // Variables
    private UserInterface ui;
    
    // Constructors
    /**
     * The constructor of the ApplicationLogic class. 
     * It receives as a parameter a class that implements the UserInterface 
     * interface.
     * @param ui UserInterface: the UserInterface
     */
    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }
    
    
    // Methods
    /**
     * Prints the string "Application logic is working" the number of times 
     * that is indicated by the variable times. After each print, the method 
     * should call the update() method of the object that was received as a 
     * constructor parameter (which implements the UserInterface interface).
     * @param times int: the number of times to print
     */
    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Application logic is working");
            this.ui.update();
        }
    }

}

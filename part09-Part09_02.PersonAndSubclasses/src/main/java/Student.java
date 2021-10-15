/**
 * Student Class for Part09_02
 * Inherits Person Class
 * @author frank
 */
public class Student extends Person {
    // Variables
    private int credits;
    
    // Constructors
    /**
     * Construct the Student
     * @param name String: the Student's name
     * @param address String: the Student's address
     */
    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }
    
    // Methods
    /**
     * Each time a Student studies, their credits increase
     */
    public void study(){
        credits++;
    }
    
    /**
     * Get the number of credits
     * @return int: the number of credits the Student has
     */
    public int credits() {
        return credits;
    }
    
    @Override
    /**
     * Returns a String in the following format
     * [name]
     *   [address]
     *   Study credits [credits]
     */
    public String toString() {
        return super.toString() + "\n  Study credits " + credits;
    }
}

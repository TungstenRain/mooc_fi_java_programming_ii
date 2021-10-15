/**
 * Teacher Class for Part09_02
 * Inherits Person Class
 * @author frank
 */
public class Teacher extends Person {
    // Variables
    private int salary;
    
    // Constructors
    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }
    
    // Methods
    @Override
    /**
     * Returns a String in the following format
     * [name]
     *   [address]
     *   salary [salary] euro/month
     */
    public String toString() {
        return super.toString() + "\n  salary " + salary + " euro/month";
    }
}

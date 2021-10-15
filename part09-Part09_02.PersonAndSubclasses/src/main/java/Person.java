/**
 * Person Class for Part09_02
 * @author frank
 */
public class Person {
    // Variables    
    private String name;
    private String address;
    
    // Constructors
    /**
     * Construct the Person
     * @param name String: the Person's name
     * @param address String: the Person's address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    // Methods
    @Override
    /**
     * Returns a String in the following format
     * [name]
     *   [address]
     */
    public String toString() {
        return name + "\n  " + address;
    }
}

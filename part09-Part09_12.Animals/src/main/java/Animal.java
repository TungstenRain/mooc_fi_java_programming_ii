/**
 * Animal Class for Part09_12
 * @author frank
 */
public abstract class Animal {
    // Variables
    private String name;
    
    // Constructors
    public Animal(String name) {
        this.name = name;
    }
    
    // Methods
    /**
     * Print that the Animal eats
     */
    public void eat() {
        System.out.println(this.name + " eats");
    }
    /**
     * Print that the Animal sleeps
     */
    public void sleep() {
        System.out.println(this.name + " sleeps");
    }
    /**
     * Get the Animal name
     * @return String: the Animal name
     */
    public String getName() {
        return this.name;
    }
}

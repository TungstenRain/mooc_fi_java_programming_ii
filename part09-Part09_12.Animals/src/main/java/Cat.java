/**
 * Cat Class for Part09_12
 * @author frank
 */
public class Cat extends Animal implements NoiseCapable {
    // Variables
    
    
    // Constructors
    /**
     * Construct the Cat
     */
    public Cat() {
        super("Cat");
    }
    /**
     * Construct the Cat
     * @param name String: the Cat name
     */
    public Cat(String name) {
        super(name);
    }
        
    // Methods
    /**
     * Print out that the Cat purrs
     */
    public void purr() {
        System.out.println(super.getName() + " purrs");
    }

    @Override
    public void makeNoise() {
        this.purr();
    }
}

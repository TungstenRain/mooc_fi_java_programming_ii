/**
 * Dog Class for Part09_12
 * @author frank
 */
public class Dog extends Animal implements NoiseCapable {
    // Variables
    
    // Constructors
    public Dog() {
        super("Dog");
    }
    public Dog(String name) {
        super(name);
    }
    
    // Methods
    public void bark() {
        System.out.println(super.getName() + " barks");
    }

    @Override
    public void makeNoise() {
        this.bark();
    }
}

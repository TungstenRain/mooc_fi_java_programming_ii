/**
 * Container Class for Part07_02
 * @author frank
 */
public class Container {
    // Variables
    private int amount;
    
    // Constructors
    /**
     * Construct the Container
     */
    public Container() {
        this.amount = 0;
    }
    
    // Methods
    /**
     * Add an amount to the Container. Containers cannot hold more than 100
     * @param amount int: the amount to add
     */
    public void add(int amount) {
        if (amount > 0) {
            this.amount+= amount;
        } else {
            return;
        }
        if (this.amount > 100) {
            this.amount = 100;
        }
    }
    /**
     * Remove an amount from the Container. Containers cannot hold less than 0.
     * @param amount int: the amount to remove
     */
    public void remove(int amount) {
        if (amount > 0) {
            this.amount-= amount;
        } else {
            return;
        }
        if (this.amount < 0) {
            this.amount = 0;
        }
    }
    
    /**
     * Get the amount in the container
     * @return int: the amount in the container
     */
    public int contains() {
        return this.amount;
    }
    
    @Override
    /**
     * Return a String in the following format:
     * [amount]/100
     */
    public String toString() {
        return this.amount + "/100";
    }
}

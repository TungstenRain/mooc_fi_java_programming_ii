

public class Warehouse {
    // Variables
    private double capacity;
    private double balance;
    
    // Constructors
    /**
     * Construct the Warehouse
     * @param capacity double: the capacity of the Warehouse
     */
    public Warehouse(double capacity) {
        if (capacity > 0.0) {
            this.capacity = capacity;
        } else {
            this.capacity = 0.0;
        }

        this.balance = 0.0;
    }
    
    // Methods
    /**
     * Get the balance of the Warehouse
     * @return double: the balance
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Get the Warehouse capacity
     * @return double: the Warehouse capacity
     */
    public double getCapacity() {
        return this.capacity;
    }
    
    /**
     * Determine how much space remains in the Warehouse
     * @return double: the remaining space left
     */
    public double howMuchSpaceLeft() {
        return this.capacity - this.balance;
    }
    
    /**
     * Add an amount to the Warehouse
     * @param amount double: the amount to add
     */
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= howMuchSpaceLeft()) {
            this.balance = this.balance + amount;
        } else {
            this.balance = this.capacity;
        }
    }
    
    /**
     * Take an amount from the Warehouse
     * @param amount double: the amount to take away
     * @return double: the remaining amount
     */
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > this.balance) {
            double allThatWeCan = this.balance;
            this.balance = 0.0;
            return allThatWeCan;
        }

        this.balance = this.balance - amount;
        return amount;
    }
    
    /**
     * Return a String in the following format:
     * balance [balance], space left [space left]
     */
    public String toString() {
        return "balance = " + this.balance + ", space left " + howMuchSpaceLeft();
    }
}

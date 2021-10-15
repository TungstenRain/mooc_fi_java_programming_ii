
import java.util.HashSet;
import java.util.Set;

/**
 * ProductWarehouseWithHistory Class for Part09_03
 * @author frank
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    // Variables
    private ChangeHistory changeHistory;
    
    // Constructors
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.setInitialBalance(initialBalance);
    }
    
    // Methods
    /**
     * Set the initial balance and record the action
     * @param initialBalance double: the initial balance
     */
    private void setInitialBalance(double initialBalance) {
        super.addToWarehouse(initialBalance);
        this.changeHistory = new ChangeHistory();
        this.changeHistory.add(initialBalance);
    }
    
    /**
     * Returns the product history like this [0.0, 119.2, 21.2]. 
     * Use the string representation of the ChangeHistory object as is.
     * @return String: the ChangeHistory of the ProductWarehouseWithHistory
     */
    public String history() {
       return changeHistory.toString();
    }
    
    @Override
    /**
     * Works just like the method in the Warehouse class, but we also record the 
     * changed state to the history. 
     * NOTE: the value recorded in the history should be the warehouse's balance
     * after adding, not the amount added!
     * @param amount double: the amount to add to the warehouse
     */
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.changeHistory.add(super.getBalance());
    }
    
    @Override
    /**
     * Works just like the method in the Warehouse class, but we also record the
     * changed state to the history. 
     * NOTE: the value recorded in the history should be the warehouse's balance
     * after removing, not the amount removed!
     * @param amount double: the amount removed from the warehouse
     * @return double: the remaining amount from the warehouse
     */
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        this.changeHistory.add(super.getBalance());
        return amountTaken;
    }
    
    /**
     * Prints history related information for the product in the following format:
     * Product: [product name]
     * History: [history of changes]
     * Largest amount of product: [maximum amount of product]
     * Smallest amount of product: [minimum amount of product]
     * Average: [Average amount of product]
     */
    public void printAnalysis() {
        System.out.println("Product: " + super.getName() + "\n"
                + "History: " + this.history() + "\n"
                + "Largest amount of product: " + this.changeHistory.maxValue() + "\n"
                + "Smallest amount of product: " + this.changeHistory.minValue() + "\n"
                + "Average: " + this.changeHistory.average());
    }
}

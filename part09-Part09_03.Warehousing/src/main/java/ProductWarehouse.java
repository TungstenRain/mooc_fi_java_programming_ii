/**
 * ProductWarehouse for Part 09_03
 * Inherits Warehouse Class
 * @author frank
 */
public class ProductWarehouse extends Warehouse {
    // Variables
    private String productName;
    
    // Constructors
    /**
     * Construct the ProductWarehouse
     * @param productName String: the ProductWarehouse name
     * @param capacity double: the Warehouse capacity
     */
    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }
    
    // Methods
    /**
     * Get the ProductWarehouse name
     * @return String: the ProductWarehouse name
     */
    public String getName() {
        return productName;
    }
    
    /**
     * Sets a new name for the product.
     * @param newName String: the new name for the ProductWarehouse
     */
    public void setName(String newName) {
        this.productName = newName;
    }
    
    @Override
    /**
     * Return a String in the following format:
     * [Product name]: balance [balance], space left [space left]
     */
    public String toString() {
       return this.productName + ": balance = " + this.getBalance() + ", space left " + this.howMuchSpaceLeft();
    }
}

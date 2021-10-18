/**
 * Item Class for Part09_10
 * @author frank
 */
public class Item {
    // Variables
    private String product;
    private int quantity;
    private int unitPrice;
    
    // Constructors
    /**
     * Construct the Item
     * @param product String: the product name
     * @param qty int: the quantity
     * @param unitPrice int: the price per unit
     */
    public Item(String product, int qty, int unitPrice) {
        this.product = product;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }
    
    // Methods
    /**
     * Return the price of the item. You get the items price by multiplying its unit price by its quantity(qty).
     * @return 
     */
    public int price() {
        return this.quantity * this.unitPrice;
    }
    /**
     * increases the quantity by one.
     */
    public void increaseQuantity() {
        this.quantity++;
    }
    
    @Override
    /**
     * Returns a String in the following format:
     * [product]: [quantity]
     */
    public String toString() {
        return this.product + ": " + this.quantity;
    }

}

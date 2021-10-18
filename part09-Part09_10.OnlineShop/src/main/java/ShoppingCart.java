/**
 * ShoppingCart Class for Part09_10
 * @author frank
 */
import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
    // Variables
    private Map<String, Item> products;
    
    // Constructors
    /**
     * Construct the ShoppingCart
     */
    public ShoppingCart() {
        this.products = new HashMap<>();
    }
    
    // Methods
    /**
     * Adds an item to the cart that matches the product given as a parameter, with the price given as a parameter.
     * @param product
     * @param price 
     */
    public void add(String product, int price) {
        // Instantiate the Item
        Item item;
        
        // Determine if the ShoppingCart already has the product. If not, create a new item, otherwise increment the existing product
        if (!this.products.containsKey(product)) {
            item = new Item(product, 1, price);
        } else {
            item = this.products.get(product);
            item.increaseQuantity();
        }
        
        // Put the information into the Map
        this.products.put(product, item);
    }
    
    /**
     * Returns the total price of the shopping cart.
     * @return int: the total price in the shopping cart
     */
    public int price() {
        int total = 0;
        if (!this.products.isEmpty()) {
            for (Item item : this.products.values()) {
                total+= item.price();
            }
        }
        return total;
    }
    
    /**
     * Prints the contents of the shopping cart
     */
    public void print() {
        if (!this.products.isEmpty()) {
            for (Item item : this.products.values()) {
                System.out.println(item);
            }
        }
    }
}

/**
 * Store Class for Part09_10
 * @author frank
 */
import java.util.Scanner;

public class Store {
    // Variables
    private Warehouse warehouse;
    private Scanner scanner;
    
    // Constructors
    /**
     * Construct the Store
     * @param warehouse Warehouse: the Warehouse associated with the Store
     * @param scanner Scanner: the Scanner
     */
    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }
    
    // Methods
    /**
     * This handles the customer's visit to the store
     * @param customer String: the customer's name
     */
    public void shop(String customer) {
        // Instantiate the ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();
        
        // Greet the customer
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");
        
        // Display the products
        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }
        
        // Request and capture customer input
        while (true) {
            System.out.println("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            
            if (product.isEmpty()) {
                break;
            }
            
            // Get the item price and add it to the ShoppingCart
            if (this.warehouse.take(product)) {
                shoppingCart.add(product, this.warehouse.price(product));
            }
        }
        
        // Display contents to user
        System.out.println("your shoppingcart contents:");
        shoppingCart.print();
        System.out.println("total: " + shoppingCart.price());
    }
    
}

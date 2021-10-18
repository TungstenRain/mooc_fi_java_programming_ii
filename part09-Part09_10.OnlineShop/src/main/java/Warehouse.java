/**
 * Warehouse Class for Part09_10
 * @author frank
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Warehouse {
    // Variables
    private Map<String, Integer> products;
    private Map<String, Integer> productBalance;
    
    // Constructors
    /**
     * Construct the Warehouse
     * @param products Map<String, Integer>: the product name and price Map
     * @param productBalance Map<String, Integer>: the product name and quantity Map
     */
    public Warehouse(Map<String, Integer> products, Map<String, Integer> productBalance) {
        this.products = products;
        this.productBalance = productBalance;
    }
    public Warehouse() {
        this(new HashMap<>(), new HashMap<>());
    }
    
    // Methods
    /**
     * Adds a product to the warehouse with the price and stock balance given as parameters.
     * @param product String: the product name
     * @param price int: the price
     * @param stock int: the quantity
     */
    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.productBalance.put(product, stock);
    }
    
    /**
     * Return the price of the product it received as a parameter. If the product hasn't been added to the warehouse, the method must return -99.
     * @param product String: the product name
     * @return 
     */
    public int price(String product) {
        if (!this.products.containsKey(product)) {
            return -99;
        }
        return this.products.get(product);
    }
    
    /**
     * Returns the current remaining stock of the product in the warehouse. 
     * If the product hasn't been added to the warehouse, the method must return 0.
     * @param product String: the product to search for
     * @return int: the amount of stock left
     */
    public int stock(String product) {
        if (!this.productBalance.containsKey(product)) {
            return 0;
        }
        return this.productBalance.get(product);
    }
    
    /**
     * Reduces the stock remaining for the product it received as a parameter 
     * by one, and returns true if there was stock remaining. 
     * If the product was not available in the warehouse the method returns 
     * false. A products stock can't go below zero.
     * @param product String: the product
     * @return boolean: true if taken; false otherwise
     */
    public boolean take(String product) {
        if (!this.productBalance.containsKey(product)) {
            return false;
        }
        if ((this.productBalance.get(product) - 1) >= 0) {
            this.productBalance.put(product, this.productBalance.get(product) -1);
            return true;
        }
        return false;
    }
    
    /**
     * Returns the names of the products in the warehouse as a Set
     * @return Set<String>: the names of the products as a Set
     */
    public Set<String> products() {
        Set<String> set = new HashSet<>();
        if (!this.products.isEmpty()) {
            for (String product : this.products.keySet()) {
                set.add(product);
            }
        }
        return set;
    }
}

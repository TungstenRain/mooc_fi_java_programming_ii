/**
 * Box Class for Part09_06
 * @author frank
 */
import java.util.ArrayList;

public class Box implements Packable {
    // Variables
    private double maxCapacity;
    private ArrayList<Packable> contents;
    
    // Constructors
    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.contents = new ArrayList<>();
    }
    
    // Methods
    /**
     * Add a Packable item to the Box. 
     * Note: The total weight cannot exceed the maximum capacity for the Box
     * @param item Packable: the item to add
     */
    public void add(Packable item) {
        if ((this.getTotalWeight() + item.weight()) <= this.maxCapacity) {
            this.contents.add(item);
        }
    }
    
    /**
     * Get the total weight of the Box
     * @return double: the total weight
     */
    private double getTotalWeight() {
        double weight = 0;
        if (!contents.isEmpty()) {
            for (Packable item : contents) {
                weight+= item.weight();
            }
        }
        return weight;
    }
    
    /**
     * Get the maximum capacity of the Box
     * @return double: the maximum capacity of the Box
     */
    public double getMaxCapacity() {
        return this.maxCapacity;
    }
    
    @Override
    /**
     * Return the total weight in the Box
     * @return double: the total weight in the box
     */
    public double weight() {
        return this.getTotalWeight();
    }
    
    @Override
    /**
     * Return a String in the following format:
     * Box: [number of items in box] items, total weight [total weight in Box] kg
     */
    public String toString() {
        return "Box: " + contents.size() + " items, total weight " + this.getTotalWeight() + " kg";
    }
    
}

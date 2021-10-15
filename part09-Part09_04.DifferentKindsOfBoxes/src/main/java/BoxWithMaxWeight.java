/**
 * BoxWithMaxWeight Class for Part09_04
 * @author frank
 */
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    // Variables
    private int capacity;
    private ArrayList<Item> items;
    
    // Constructors
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    
    // Methods
    private int getTotalWeight() {
        int totalWeight = 0;
        for (Item item : this.items) {
            totalWeight+= item.getWeight();
        }
        return totalWeight;
    }
    
    @Override
    /**
     * Add an item to the BoxWithMaxWeight only if it does not exceed the capacity
     * @param item Item: the item to add to the BoxWithMaxWeight
     */
    public void add(Item item) {
        if ((this.getTotalWeight() + item.getWeight()) <= this.capacity) {
            this.items.add(item);
        }
    }
    
    @Override
    /**
     * Determine if an Item is in the BoxWithMaxWeight
     * @param item Item: the Item to find
     * @return boolean: true if in box; false otherwise
     */
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}

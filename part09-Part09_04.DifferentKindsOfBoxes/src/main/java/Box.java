
import java.util.ArrayList;

public abstract class Box {
    // Methods
    /**
     * Add to the box
     * @param items ArrayList<Item>: the ArrayList<Item> to add to the box
     */
    public void add(ArrayList<Item> items) {
        for (Item item : items) {
            Box.this.add(item);
        }
    }
    
    // Abstract Methods
    /**
     * Add an Item to the Box
     * @param item Item: the Item to add
     */
    public abstract void add(Item item);
    
    /**
     * Determine if the Item is in the box
     * @param item Item: the Item to search for
     * @return boolean: true if in the box; false otherwise
     */
    public abstract boolean isInBox(Item item);
}

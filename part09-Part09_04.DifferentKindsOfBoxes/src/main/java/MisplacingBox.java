/**
 * MisplacingBox Class for Part09_04
 * @author frank
 */
import java.util.ArrayList;

public class MisplacingBox extends Box{
    // Variables
    private ArrayList<Item> items;
    
    // Constructors
    public MisplacingBox() {
        this.items = new ArrayList<>();
    }
    
    // Methods
    @Override
    /**
     * Add an Item to the MisplacingBox
     * @param item Item: the Item to be added
     */
    public void add(Item item) {
        this.items.add(item);
    }
    
    @Override
    /**
     * Determine if the Item is in the Box
     * NOTE: this always returns false
     * @param item Item: the Item to find
     * @return boolean: all queries return false
     */
    public boolean isInBox(Item item) {
        return false;
    }
}

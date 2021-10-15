/**
 * OneItemBox Class for Part09_04
 * @author frank
 */
public class OneItemBox extends Box {
    // Variables
    private Item item;
    private int capacity;
    
    // Constructors
    public OneItemBox() {
        this.item = null;
        this.capacity = 0;
    }
    
    // Methods
    @Override
    /**
     * Add an item only if the box is empty
     * @param item Item: the item to be added
     */
    public void add(Item item) {
        if (this.item == null) {
            this.item = item;
        }
    }
    
    @Override
    /**
     * Determine if an Item is in the OneItemBox
     * @param item Item: the Item to determine if it is in the OneItemBox
     * @return boolean: true if in box; false otherwise
     */
    public boolean isInBox(Item item) {
        if (this.item != null && this.item.equals(item)) {
            return true;
        }
        return false;
    }
}

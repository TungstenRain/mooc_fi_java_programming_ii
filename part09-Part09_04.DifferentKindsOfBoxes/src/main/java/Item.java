
public class Item {
    // Variables
    private String name;
    private int weight;
    
    // Constructors
    /**
     * Construct the Item
     * @param name String: the Item's name
     * @param weight int: the Item's weight
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    /**
     * Construct the Item with an initial weight of 0
     * @param name String: the Item's name
     */
    public Item(String name) {
        this(name, 0);
    }
    
    // Methods
    /**
     * Get the Item name
     * @return String: the Item name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the Item weight
     * @return int: the Item weight
     */
    public int getWeight() {
        return weight;
    }
    
    @Override
    /**
     * Determine if the Item equals an object
     * @param Object: the object to compare
     * @return boolean: true if they are equal; false otherwise
     */
    public boolean equals(Object object) {
        // If they reference the same variable, they are equal
        if (this == object) {
            return true;
        }
        
        // If the object is not an instance of Item, they are not equal
        if (!(object instanceof Item)) {
            return false;
        }
        
        // Cast object as an Item and compare variables
        Item objectItem = (Item) object;
        
        if (this.name.equals(objectItem.name)) {
            return true;
        }
        return false;
    }
    
    /**
     * Return a hashCode for the Item
     * @return int: the hashCode
     */
    public int hashCode() {
        return this.name.hashCode();
    }
}

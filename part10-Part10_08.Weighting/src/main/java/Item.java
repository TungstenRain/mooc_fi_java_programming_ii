

public class Item {
    // Variables
    private String name;
    private int weight;
    
    // Constructors
    /**
     * Construct the Item
     * @param name String: the name
     * @param weight int: the weight
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    // Methods
    /**
     * Get the Item name
     * @return String: the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the Item weight
     * @return int: the weight
     */
    public int getWeight() {
        return this.weight;
    }

    @Override
    /**
     * Return a String in the following format:
     * [name]: ([weight] kg)
     */
    public String toString() {
        return this.name + ": (" + this.weight + " kg)";
    }
}

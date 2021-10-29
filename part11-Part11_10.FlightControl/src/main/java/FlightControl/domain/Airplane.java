package FlightControl.domain;

/**
 * Airplane Class for Part11_10
 * @author frank
 */
public class Airplane {
    // Variables
    private String id;
    private int capacity;
    
    // Constructors
    /**
     * Construct the Airplane
     * @param id String: the Airplane ID
     * @param capacity int: the Airplane's maximum capacity
     */
    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    
    // Methods
    /**
     * Get the Airplane's ID
     * @return String: the ID
     */
    public String getID() {
        return this.id;
    }
    
    /**
     * Get the Airplane's capacity
     * @return int: the Airplane's capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return this.id + " (" + this.capacity + " capacity)";
    }
}

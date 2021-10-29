package FlightControl.domain;

/**
 * Place Class for Part11_10
 * @author frank
 */
public class Place {
    // Variables
    private String ID;
    
    // Constructors
    /**
     * Construct the Place
     * @param ID String: the Place's ID
     */
    public Place(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return this.ID;
    }
}

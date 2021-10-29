package FlightControl.domain;

/**
 * Flight Class for Part11_10
 * @author frank
 */
public class Flight {
    // Variables
    private Airplane airplane;
    private Place departureAirport;
    private Place targetAirport;
    
    // Constructors
    /**
     * Construct the Flight
     * @param airplane Airplane: the Airplane
     * @param departureAirport Place: the place the Flight is departing from
     * @param targetAirport Place: the place the Flight is going to
     */
    public Flight(Airplane airplane, Place departureAirport, Place targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
    }
    
    // Methods
    /**
     * Get the Airplane
     * @return Airplane: the Airplane for this Flight
     */
    public Airplane getAirplane() {
        return this.airplane;
    }
    
    /**
     * Get the Place the Flight is departing from
     * @return Place: the Place the Flight is departing from
     */
    public Place getDeparturePlace() {
        return this.departureAirport;
    }
    
    /**
     * Get the Place the Flight is going to
     * @return Place: the Place the Flight is going to
     */
    public Place getTargetPlace() {
        return this.targetAirport;
    }

    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}

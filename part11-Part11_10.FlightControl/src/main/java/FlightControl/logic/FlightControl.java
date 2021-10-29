package FlightControl.logic;

/**
 * FlightControl Class for Part11_10
 * @author frank
 */

import java.util.Collection;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import java.util.HashMap;
import java.util.Map;
import FlightControl.domain.Place;

public class FlightControl {
    // Variables
    private HashMap<String, Airplane> airplanes = new HashMap<>();
    private HashMap<String, Flight> flights = new HashMap<>();
    private Map<String, Place> places;
    
    // Constructors
    /**
     * Construct the FlightControl
     */
    public FlightControl() {
        this.flights = new HashMap<>();
        this.airplanes = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    // Methods
    /**
     * Add an Airplane
     * @param ID String: the Airplane's ID
     * @param capacity int: the Airplane's maximum capacity
     */
    public void addAirplane(String ID, int capacity) {
        Airplane plane = new Airplane(ID, capacity);
        this.airplanes.put(ID, plane);
    }
    
    /**
     * Add a flight
     * @param plane Airplane: the Airplane for the Flight
     * @param departureID String: the ID for the departure
     * @param destinationID String: the ID for the destination
     */
    public void addFlight(Airplane plane, String departureID, String destinationID) {
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));

        Flight flight = new Flight(plane, this.places.get(departureID), this.places.get(destinationID));
        this.flights.put(flight.toString(), flight);
    }
    
    /**
     * Get all the Airplanes
     * @return Collection<Airplane>: all the Airplanes in the FlightControl
     */
    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }
    
    /**
     * Get all the Flights
     * @return Collection<Flight>: all the Flights in the FlightControl
     */
    public Collection<Flight> getFlights() {
        return this.flights.values();
    }
    
    /**
     * Get a specific Airplane
     * @param ID String: the ID for the Airplane
     * @return Airplane: the Airplane
     */
    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }
}
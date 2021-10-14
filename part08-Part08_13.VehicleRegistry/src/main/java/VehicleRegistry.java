/**
 * VehicleRegistry Class for Part8_13
 * @author frank
 */

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    // Variables
    private HashMap<LicensePlate, String> registry;
    
    // Constructors
    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }
    
    // Methods
    /**
     * Assigns the owner it received as a parameter to a car that corresponds to 
     * the license plate received as a parameter. 
     * If the license plate doesn't have an owner, the method returns true. 
     * If the license already has an owner attached, the method returns false 
     * and does nothing.
     * @param licensePlate LicensePlate: the LicensePlate
     * @param owner String: the owner's name
     * @return boolean: true if added; false otherwise
     */
    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.registry.get(licensePlate) == null) {
            registry.put(licensePlate, owner);
            return true;
        }
        return false;
    }
    
    /**
     * Returns the owner of the car corresponding to the license plate received 
     * as a parameter. If the car isn't in the registry, the method returns null.
     * @param licensePlate LicensePlate: the LicensePlate
     * @return String: the owner of the vehicle, if the vehicle isn't in the registry, returns null
     */
    public String get(LicensePlate licensePlate) {
        return this.registry.get(licensePlate);
    }
    
    /**
     * Removes the license plate and attached data from the registry. The 
     * method returns true if removed successfully and false if the license 
     * plate wasn't in the registry.
     * @param licensePlate LicensePlate: the LicensePlate to be removed
     * @return boolean: true if removed; false otherwise
     */
    public boolean remove(LicensePlate licensePlate) {
        if (this.registry.containsKey(licensePlate)) {
            this.registry.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    /**
     * Prints the LicensePlates in the VehicleRegistry
     */
    public void printLicensePlates() {
        for (LicensePlate licensePlate : this.registry.keySet()) {
            System.out.println(licensePlate);
        }
    }
    
    /**
     * Prints the owners of the vehicles. Each owner should only be printed once.
     */
    public void printOwners() {
        // Instantiate ArrayList
        ArrayList<String> ownerNames = new ArrayList<>();
        
        // Add owner names to the ArrayList
        for (String owner : this.registry.values()) {
            if(!ownerNames.contains(owner)) {
                ownerNames.add(owner);
                System.out.println(owner);
            }
        }
    }
}

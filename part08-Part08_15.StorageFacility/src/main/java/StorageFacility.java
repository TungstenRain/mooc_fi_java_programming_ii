/**
 * StorageFacility Class for Part08_15
 * @author frank
 */

import java.util.HashMap;
import java.util.ArrayList;

public class StorageFacility {
    // Variables
    private HashMap<String, ArrayList<String>> facility;
    
    
    // Constructors
    public StorageFacility() {
        this.facility = new HashMap<>();
    }
    
    // Methods
    /**
     * Adds the parameter item to the storage unit that is also given as a parameter.
     * @param unit String
     * @param item String:
     */
    public void add(String unit, String item) {
        // If the storage unit does not exist, add it
        this.facility.putIfAbsent(unit, new ArrayList<>());
        
        // Add to the storage unit
        this.facility.get(unit).add(item);
    }
    
    /**
     * Returns a list that contains all the items in the storage unit 
     * indicated by the parameter. 
     * If there is no such storage unit or it contains no items, the method 
     * should return an empty list.
     * @param storageUnit String: the name of the Storage Unit
     * @return ArrayList<String>: the contents of the storage unit
     */
    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> items = new ArrayList<>();
        if (this.facility.containsKey(storageUnit)) {
            for (String item : this.facility.get(storageUnit)) {
                items.add(item);
            }
        }
        return items;
    }
    
    /**
     * removes the given item from the given storage unit. 
     * Only removes one item — if there are several items with the same name, 
     * the rest still remain. If the storage unit would be empty after the 
     * removal, the method also removes the unit.
     * @param storageUnit String: the storage unit
     * @param item String: the item to remove
     */
    public void remove(String storageUnit, String item) {
        if (this.facility.containsKey(storageUnit)) {
            this.facility.get(storageUnit).remove(item);
        }
        if (this.facility.get(storageUnit).isEmpty()) {
            this.facility.remove(storageUnit);
        }
    }
    
    /**
     * Returns the names of the storage units as a list.
     * NOTE! Only the units that contain items are listed.
     * @return ArrayList<String>: a list of storage units with contents
     */
    public ArrayList<String> storageUnits() {
        ArrayList<String> storageUnits = new ArrayList<>();
        
        for (String unit : this.facility.keySet()) {
            if (!unit.isEmpty()) {
                storageUnits.add(unit);
            }
        }
        
        return storageUnits;
    }
}

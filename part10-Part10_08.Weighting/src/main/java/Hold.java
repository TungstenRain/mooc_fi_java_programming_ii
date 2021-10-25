

import java.util.ArrayList;

public class Hold {
    // Variables
    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;
    
    // Constructors
    /**
     * Construct the Hold
     * @param maximumWeight int: the Hold's maximum weight capacity
     */
    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.suitcases = new ArrayList<>();
    }
    
    // Methods
    /**
     * Add a suitcase to the Hold as long as it does not exceed the Hold's maximum capacity
     * @param Suitcase Suitcase: the Suitcase to be added
     */
    public void addSuitcase(Suitcase Suitcase) {
        if (this.totalWeight() + Suitcase.totalWeight() > maximumWeight) {
            return;
        }

        this.suitcases.add(Suitcase);
    }
    
    /**
     * Get the total weight
     * @return int: the total weight
     */
    public int totalWeight() {
        return this.suitcases.stream()
                .map(suitcase -> suitcase.totalWeight())
                .reduce(0, (previousWeight, value) -> previousWeight + value);
        
        /*
        int summa = 0;
        int indeksi = 0;
        while (indeksi < this.suitcases.size()) {
            summa += this.suitcases.get(indeksi).totalWeight();
            indeksi++;
        }
        return summa;
        */
    }
    
    /**
     * Print the items in the Suitcases
     */
    public void printItems() {
        this.suitcases.stream()
                .forEach(suitcase -> suitcase.printItems());
        
        /*
        int indeksi = 0;
        while (indeksi < this.suitcases.size()) {
            this.suitcases.get(indeksi).printItems();
            indeksi++;
        }
        */
    }

    @Override
    /**
     * Return a String based on the number of suitcases and its total weight
     */
    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}

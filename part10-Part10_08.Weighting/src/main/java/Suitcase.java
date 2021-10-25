
import java.util.ArrayList;

public class Suitcase {
    // Variables
    private int maximumWeight;
    private ArrayList<Item> Items;
    
    // Constructors
    /**
     * Construct the Suitcase
     * @param maximumWeight int: the Suitcase's maximum weight capacity
     */
    public Suitcase(int maximumWeight) {
        this.Items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }
    
    // Methods
    /**
     * Add an Item to the suitcase as long as it does not exceed the Suitcase's maximum capacity
     * @param Item Item: the Item to be added
     */
    public void addItem(Item Item) {
        if (this.totalWeight() + Item.getWeight() > this.maximumWeight) {
            return;
        }

        this.Items.add(Item);
    }
    
    /**
     * Get the total weight in the Suitcase
     * @return int: the total weight
     */
    public int totalWeight() {
        return this.Items.stream()
                .map(item -> item.getWeight())
                .reduce(0, (previousWeight, value) -> previousWeight + value);
        
        /*
        int summa = 0;
        int indeksi = 0;
        while (indeksi < this.Items.size()) {
            summa += this.Items.get(indeksi).getWeight();
            indeksi++;
        }
        return summa;
        */
    }
    
    /**
     * Print the Items in the Suitcase
     */
    public void printItems() {
        this.Items.stream()
                .forEach(item -> System.out.println(item));
        
        /*
        int indeksi = 0;
        while (indeksi < this.Items.size()) {
            Item t = this.Items.get(indeksi);
            System.out.println(t);
            indeksi++;
        }
        */
    }
    
    /**
     * Determine the heaviest item in the Suitcase
     * @return 
     */
    public Item heaviestItem() {
        if (this.Items.isEmpty()) {
            return null;
        }

        // Tutustumme järjestämiseen hieman myöhemmin kurssilla
        // Translation: We will get to know the organization a little later in the course 
        return this.Items.stream().max((t1, t2) -> t1.getWeight() - t2.getWeight()).get();
    }

    @Override
    /**
     * Return a String detailing the number of items and the total weight in the Suitcase
     */
    public String toString() {
        if (this.Items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.Items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.Items.size() + " items (" + this.totalWeight() + " kg)";
    }
}

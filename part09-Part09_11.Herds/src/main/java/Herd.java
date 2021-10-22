/**
 * Herd Class for Part09_11
 * @author frank
 */
import java.util.ArrayList;

public class Herd implements Movable {
    // Variables
    private ArrayList<Organism> herd;
    
    // Constructors
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    // Methods
    @Override
    /**
     * Moves the herd with by the amount specified by the parameters. 
     * Notice that here you have to move each member of the herd.
     */
    public void move(int dx, int dy) {
        for (Organism organism : this.herd) {
            organism.move(dx, dy);
        }
    }
    
    @Override
    /**
     * Returns a string representation of the positions of the members of the herd, each on its own line.
     */
    public String toString() {
        String string = "";
        for (Organism organism : this.herd) {
            string+= organism + "\n";
        }
        return string;
    }
    
    /**
     * Adds an object that implements the Movable interface to the herd.
     * @param movable Movable: the Object that can move and belongs in the Herd
     */
    public void addToHerd(Movable movable) {
        this.herd.add((Organism)movable);
    }
}

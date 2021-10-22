/**
 * Organism Class for Part09_11
 * @author frank
 */
public class Organism implements Movable {
    // Variables
    private int x;
    private int y;
    
    // Constructors
    /**
     * Construct the Organism
     * @param x int: the x-coordinate
     * @param y int: they y-coordinate
     */
    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Methods
    @Override
    /**
     * Moves the Organism by the values it receives as parameters.
     * @param dx int: the change to the x-coordinate
     * @param dy int: the change to the y-coordinate
     */
    public void move(int dx, int dy) {
        this.x+= dx;
        this.y+= dy;
    }
    
    @Override
    /**
     * Returns a String in the following format:
     * x: [x-coordinate]; y: [y-coordinate]
     */
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }

}

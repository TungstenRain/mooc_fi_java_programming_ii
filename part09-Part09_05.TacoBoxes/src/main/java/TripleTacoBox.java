/**
 * TripleTacoBox Class for Part09_05
 * @author frank
 */
public class TripleTacoBox implements TacoBox {
    // Variables
    private int tacos;
    
    // Constructors
    /**
     * Construct the TripleTacoBox with 3 tacos
     */
    public TripleTacoBox() {
        this.tacos = 3;
    }
    
    
    // Methods
    @Override
    /**
     * Return the number of tacos remaining.
     * @return int: the number of tacos remaining.
     */
    public int tacosRemaining() {
        return this.tacos;
    }

    @Override
    /**
     * Remove 1 taco. Cannot go below 0
     */
    public void eat() {
        if ((this.tacosRemaining() - 1) >= 0) {
            this.tacos--;
        }
    }
}

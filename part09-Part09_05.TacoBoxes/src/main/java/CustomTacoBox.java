/**
 *
 * @author frank
 */
public class CustomTacoBox implements TacoBox {
    // Variables
    private int tacos;
    
    // Constructors
    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }
    
    // Methods
    @Override
    /**
     * Return the number of tacos remaining
     * @return int: the number of tacos remaining
     */
    public int tacosRemaining() {
        return this.tacos;
    }

    @Override
    /**
     * Consume 1 taco. This cannot reduce the number of tacos below 0.
     */
    public void eat() {
        if ((this.tacosRemaining() -1) >= 0) {
            this.tacos--;
        }
    }
    
}

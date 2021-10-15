
public interface TacoBox {
    // Methods
    /**
     * Return the number of tacos remaining in the box
     * @return int: the number of tacos in the box
     */
    int tacosRemaining();
    
    /**
     * Reduces the number of tacos by one. The number of tacos cannot be less than zero.
     */
    void eat();
}

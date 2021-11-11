
import java.util.Random;

public class Die {
    // Variables
    private Random random;
    private int numberOfFaces;
    
    // Constructors
    /**
     * Construct the Die
     * @param numberOfFaces int: the number of faces on the Die
     */
    public Die(int numberOfFaces) {
        this.random = new Random();
        this.numberOfFaces = numberOfFaces;
    }
    
    /**
     * Return a random whole number between 1 and the number of faces
     * @return int: the random result
     */
    public int throwDie() {
        return this.random.nextInt(numberOfFaces) + 1;
    }
}

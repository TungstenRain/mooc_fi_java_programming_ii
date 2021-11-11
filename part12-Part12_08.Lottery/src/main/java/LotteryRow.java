
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {
    // Variables
    private ArrayList<Integer> numbers;
    
    // Constructors
    /**
     * Construct the LotteryRow
     */
    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }
    
    // Methods
    /**
     * Get the ArrayList of numbers
     * @return ArrayList<Integer>: the list of numbers
     */
    public ArrayList<Integer> numbers() {
        return this.numbers;
    }
    
    /**
     * Randomize the numbers in the LotteryRow
     */
    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        Random random = new Random();
        
        
        int i = 0;
        while (i < 7) {
            // Generate a number between 1 and 40
            int number = random.nextInt(40) + 1;
            
            if (!this.containsNumber(number)) {
                this.numbers.add(number);
                i++;
            }
        }
    }
    
    /**
     * Determine if the LotteryRow contains a given number
     * @param number int: the number in question
     * @return boolean: true if in the LotteryRow; false otherwise
     */
    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        for (int lotteryNumber : this.numbers) {
            if (lotteryNumber == number) {
                return true;
            }
        }
        return false;
    }
}


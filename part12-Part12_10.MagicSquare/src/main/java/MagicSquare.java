
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {
    // Variables
    private int[][] square;

    // Constructors
    /**
     * Construct the MagicSquare
     * @param size int: the size of the square
     */
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // Methods
    /**
     * Return an ArrayList of the sums of each row
     * @return ArrayList<Integer>: the sums of each row
     */
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();
        // Loop through the rows
        for (int row = 0; row < this.square.length; row++) {
            int sum = 0;
            for (int column = 0; column < this.square[row].length; column++) {
                sum+= this.square[row][column];
            }
            sums.add(sum);
        }
        
        return sums;
    }
    
    /**
     * Return the sums of each column
     * @return ArrayList<Integer>: the sums of each column
     */
    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();
        
        for (int column = 0; column < this.square.length; column++) {
            int sum = 0;
            for (int row = 0; row < this.square[column].length; row++) {
                sum+= this.square[row][column];
            }
            sums.add(sum);
        }
        
        return sums;
    }
    
    /**
     * Return the sums of the diagonals
     * @return ArrayList<Integer>: the sums of the diagonals
     */
    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();
        
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        
        for (int i = 0; i < this.getHeight(); i++) {
            firstDiagonal+= this.square[i][i];
        }
        sums.add(firstDiagonal);
        
        int column = this.getWidth() - 1;
        for (int i = 0; i < this.getHeight(); i++) {
            secondDiagonal+= this.square[i][column];
            column--;
        }
        sums.add(secondDiagonal);
        
        return sums;
    }

    // ready-made helper methods -- don't touch these
    /**
     * Determine if the MagicSquare 
     * @return 
     */
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }
    
    /**
     * Determine if all the numbers are different
     * @return boolean: true if they are different; false otherwise;
     */
    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }
    
    /**
     * Determine if the sums are the same
     * @return boolean: true if they are the same; false otherwise
     */
    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }
    
    /**
     * Read the value of a square with the given coordinates
     * @param x int: the x-coordinate
     * @param y int: the y-coordinate
     * @return int: the value at the coordinates
     */
    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }
    
    /**
     * 
     * @param x
     * @param y
     * @param value 
     */
    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }
    
    /**
     * Get the width of the square
     * @return int: the width of the square
     */
    public int getWidth() {
        return this.square.length;
    }
    
    /**
     * Get the height of the square
     * @return int: the height of the square
     */
    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}

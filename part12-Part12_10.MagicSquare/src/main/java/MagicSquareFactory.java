
public class MagicSquareFactory {
    /**
     * 
     * @param size
     * @return 
     */
    public MagicSquare createMagicSquare(int size) {
        // Instantiate the MagicSquare
        MagicSquare square = new MagicSquare(size);
        
        // Initialize variables
        int currentRow = 0;
        int currentColumn = size / 2;
        
        // Places 1 in the middle of the top row
        square.placeValue(currentColumn, currentRow, 1);
        
        for (int i = 2; i <= size*size; i++) {
            // Using the Siamese method, the next line is calculated as n-1
            int nextRow = currentRow - 1;
            
            // If nextRow is less than zero, reset to the bottom-most row
            if (nextRow < 0) {
                nextRow = square.getHeight() - 1;
            }
            
            // Calculate the next column, which is n+1
            int nextColumn = currentColumn + 1;
            
            // If this takes column past the last column, reset to the first column
            if (nextColumn >= square.getWidth()) {
                nextColumn = 0;
            }
            
            // With the new coordinates, determine if that spot already has a value
            int nextBoxValue = square.readValue(nextColumn, nextRow);
            
            // If that box has a value other than 0, reset the value to what they were before
            // then modify the row value in the opposite direction
            if (nextBoxValue != 0) {
                nextRow = currentRow + 1;
                nextColumn = currentColumn;
            }
            
            // Place the value of i in the correct cell
            square.placeValue(nextColumn, nextRow, i);
            
            // Update the column and row
            currentRow = nextRow;
            currentColumn = nextColumn;
        }
        
        
        return square;
    }

}

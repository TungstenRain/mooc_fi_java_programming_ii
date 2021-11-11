
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
        System.out.println("");
        
        int[][] matrix2 = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix2));
    }
    
    // Methods
    /**
     * Create a string representation of the array it receives as the parameter 
     * and return it.
     * @param array int[][]: the array
     * @return String: the string representation of the array
     */
    public static String arrayAsString(int[][] array) {
        // Instantiate StringBuilder
        StringBuilder output = new StringBuilder();
        
        // Loop through the two dimensional array
        // Start with the row
        for (int i = 0; i < array.length; i++) {
            // Loop through columns
            for (int j = 0; j < array[i].length; j++) {
                output.append(array[i][j]);
            }
            
            // Only add a line break if beginning a new row
            if (i < array.length -1) {
                output.append("\n");
            }
        }
        
        return output.toString();
    }
}

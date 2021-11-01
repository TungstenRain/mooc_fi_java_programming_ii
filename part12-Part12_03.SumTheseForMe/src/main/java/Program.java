public class Program {

    public static void main(String[] args) {
        
        
        int[] numbers = {3, -1, 8, 4};

        System.out.println(sum(numbers, 0, 0, 0, 0));
        System.out.println(sum(numbers, 0, 0, 0, 10));
        System.out.println(sum(numbers, 0, 1, 0, 10));
        System.out.println(sum(numbers, 0, 1, -10, 10));
        System.out.println(sum(numbers, -1, 999, -10, 10));

    }
    
    // Methods
    /**
     * Calculate the sum of the elements in the array between the lower and the 
     * upper limits. Only numbers smaller or equal to the int largest and 
     * larger or equal to the int smallest are added to the sum.
     * 
     * Check that the lower and the upper limit are valid indexes in the array. 
     * If the parameter fromWhere is smaller than 0, the lower limit becomes 0 
     * instead. Accordingly, if the parameter toWhere is larger than the size 
     * of the array, the upper limit becomes the last index of the array instead.
     * 
     * @param array int[]: the array of integers
     * @param fromWhere int: the starting index
     * @param toWhere int: the ending index
     * @param smallest int: the smallest number to be added
     * @param largest int: the largest number to be added
     * @return int: the sum of the numbers in the array between the indeces that match the summation criteria
     */
    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        if (fromWhere < 0) {
            fromWhere = 0;
        }
        if (array.length < toWhere) {
            toWhere = array.length;
        }
        
        int sum = 0;
        for (int i = fromWhere; i < toWhere; i++) {
            if ((array[i] <= largest) && (array[i] >= smallest)) {
                sum+= array[i];
            }
        }
        return sum;
    }

}

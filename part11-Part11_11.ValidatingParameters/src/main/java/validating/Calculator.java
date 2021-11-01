package validating;

public class Calculator {
    /**
     * Determine the factorial for a given number
     * @param num int: the number
     * @return int: the factorial
     */
    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("The number cannot be negative.");
        }
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }
    
    /**
     * Calculate the binomial coefficient
     * @param setSize int: the set size
     * @param subsetSize int: the subset size
     * @return int: the binomial coefficient
     */
    public int binomialCoefficent(int setSize, int subsetSize) {
        if ((setSize < 0) || (subsetSize < 0)) {
            throw new IllegalArgumentException("The set size and subset size must be positive numbers.");
        }
        if (subsetSize > setSize) {
            throw new IllegalArgumentException("The subset size cannot be greater than the set size.");
        }
        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}

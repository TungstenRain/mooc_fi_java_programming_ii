/**
 * ChangeHistory Class for Part09_03
 * @author frank
 */
import java.util.ArrayList;

public class ChangeHistory {
    // Variables
    private ArrayList<Double> changes;
    
    // Constructors
    /**
     * Construct the ChangeHistory
     */
    public ChangeHistory() {
        this.changes = new ArrayList<>();
    }
    
    // Methods
    /**
     * Adds provided status as the latest amount to remember in the change history.
     * @param status double: the amount to remember
     */
    public void add(double status) {
        this.changes.add(status);
    }
    
    /**
     * Empties the ChangeHistory.
     */
    public void clear() {
        this.changes.clear();
    }
    
    /**
     * Returns the string representation of the change history. The string representation provided by the ArrayList class is sufficient.
     * @return 
     */
    public String toString() {
        return changes.toString();
    }
    
    /**
     * Returns the largest value in the change history. If the history is empty, the method should return zero.
     * @return 
     */
    public double maxValue() {
        if (this.changes.isEmpty()) {
            return 0;
        }
        
        double max = changes.get(0);
        for (double number : changes) {
            if (number > max) {
                max = number;
            }
        }
        
        return max;
    }
    
    /**
     * Returns the smallest value in the change history. If the history is empty, the method should return zero.
     * @return 
     */
    public double minValue() {
        if (this.changes.isEmpty()) {
            return 0;
        }
        
        double min = changes.get(0);
        for (double number : changes) {
            if (number < min) {
                min = number;
            }
        }
        
        return min;
    }
    
    /**
     * Returns the average of the values in the change history. If the history is empty, the method should return zero.
     * @return 
     */
    public double average() {
        if (this.changes.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double number : changes) {
            sum+= number;
        }
        
        return sum / this.changes.size();
    }

}

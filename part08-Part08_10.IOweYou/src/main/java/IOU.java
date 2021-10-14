/**
 * IOU Class for Part08_10
 * @author frank
 */

import java.util.HashMap;

public class IOU {
    // Variables
    private HashMap<String, Double> debts;
    
    // Constructors
    public IOU() {
        this.debts = new HashMap<>();
    }
    
    // Methods
    /**
     * Set the amount owed and the person to whom the amount is owed
     * @param toWhom String: the person to whom money is owed
     * @param amount double: the amount owed
     */
    public void setSum(String toWhom, double amount) {
        debts.put(toWhom, amount);
    }
    
    /**
     * Find out how much is owed to a given person
     * @param toWhom String: the person who is owed
     * @return double: the amount owed
     */
    public double howMuchDoIOweTo(String toWhom) {
        if (!debts.containsKey(toWhom)) {
            return 0.0;
        }
        return debts.get(toWhom);
    }
}

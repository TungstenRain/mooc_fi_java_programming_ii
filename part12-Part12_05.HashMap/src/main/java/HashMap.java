/**
 * HashMap Generic Class for Part12_05
 * 
 * NOTE: This class utilizes Java's ready-made List class, per instructions, 
 * instead of the List created in Part12_04 and demonstrated throughout the lesson.
 * 
 * @author frank
 */
import java.util.List;
import java.util.ArrayList;

public class HashMap<K,V> {
    // Variables
    private List<Pair<K,V>>[] values;
    private int firstFreeIndex;
    
    // Constructors
    /**
     * Construct the HashMap
     */
    public HashMap() {
        this.values = new List[32];
        this.firstFreeIndex = 0;
    }
    
    // Methods
    /**
     * Get the value of the HashMap at K
     * @param key K: the key
     * @return V: the value at K
     */
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }
        
        List<Pair<K, V>> valuesAtIndex = this.values[hashValue];
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }
        
        return null;
    }
    
    /**
     * Get the List based on the Key
     * @param key K: the key
     * @return List<Pair<K, V>>: the List based on the key
     */
    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }
        return this.values[hashValue];
    }
    
    /**
     * Get the index of the key
     * @param myList List<Pair<K, V>>: the List to search through
     * @param key K: the key
     * @return int: the index of the key
     */
    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Add a Pair to the HashMap
     * @param key K: the key
     * @param value V: the value
     */
    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        int index = this.getIndexOfKey(valuesAtIndex, key);
        
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
        
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }
    
    /**
     * Increase the size of the HashMap
     */
    private void grow() {
        List<Pair<K, V>>[] newValues = new List[this.values.length * 2];
        
        for (int i = 0; i < this.values.length; i++) {
            copy(newValues, i);
        }
        
        this.values = newValues;
    }
    
    /**
     * Copy the List<Pair<K, V>>[] into a new List<Pair<K, V>>[] starting from a specified index
     * @param newArray List<Pair<K, V>>: the array to copy into 
     * @param frmIdx int: the starting index
     */
    private void copy(List<Pair<K, V>>[] newArray, int frmIdx) {
        for (int i = 0; i < this.values[frmIdx].size(); i++) {
            Pair<K, V> value = this.values[frmIdx].get(i);
            
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }
            
            newArray[hashValue].add(value);
        }
    }
    
    /**
     * Remove a Pair from the List
     * @param key K: the key
     * @return V: the value at K
     */
    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }
        
        int index = this.getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
}

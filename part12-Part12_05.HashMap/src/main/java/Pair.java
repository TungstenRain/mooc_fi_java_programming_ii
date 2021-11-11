/**
 * Pair Generic Class for Part12_05
 * @author frank
 */
public class Pair<K, V> {
    // Variables
    private K key;
    private V value;
    
    // Constructors
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    // Methods
    /**
     * Get the key
     * @return K: the key
     */
    public K getKey() {
        return this.key;
    }
    
    /**
     * Get the value
     * @return V: the value
     */
    public V getValue() {
        return this.value;
    }
    
    /**
     * Set the value
     * @param value V: the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }
}

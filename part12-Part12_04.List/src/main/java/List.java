/**
 * List Generic Class for Part12_04
 * @author frank
 */
public class List<Type> {
    // Variables
    private Type[] values;
    private int firstFreeIndex;
    
    // Constructors
    /**
     * Construct the List
     */
    public List() {
        this.values = (Type[]) new Object[10];
    }
    
    // Methods
    /**
     * Add an object of Type to the List
     * @param value Type: the object to be added to the List
     */
    public void add(Type value) {
        if (this.firstFreeIndex == this.values.length) {
            this.grow();
        }
        
        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    /**
     * Grow the List by old size + old size / 2
     */
    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        
        for (int i = 0; i < this.firstFreeIndex; i++) {
            newValues[i] = this.values[i];
        }
        
        this.values = newValues;
    }
    
    /**
     * Determine if the List contains an object of Type
     * @param value Type: the object to search for
     * @return boolean: true if the List contains the value; false otherwise
     */
    public boolean contains(Type value) {
        return (this.indexOfValue(value) >= 0);
    }
    
    /**
     * Remove an object of Type from the List
     * @param value Type: the object to remove
     */
    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }
        
        this.moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }
    
    /**
     * Return the index of the object of Type in the List
     * @param value Type: the object of Type
     * @return int: the index
     */
    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Migrate values to the left in the array starting from the given value
     * @param fromIndex int: the index to begin shifting from
     */
    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.values.length; i++) {
            this.values[i] = this.values[i + 1];
        }
    }
    
    /**
     * Return the object of Type from the List
     * @param index int: the index of the Type
     * @return Type: the object of Type at the index
     */
    public Type value(int index) {
        if ((index < 0) || (index >= this.firstFreeIndex)) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }
        
        return this.values[index];
    }
    
    /**
     * Return the size of the List
     * @return int: the size of the List
     */
    public int size() {
        return this.firstFreeIndex;
    }
}

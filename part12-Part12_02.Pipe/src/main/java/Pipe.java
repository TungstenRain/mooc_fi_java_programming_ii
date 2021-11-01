/**
 * Pipe Generic Class for Part12_02
 * @author frank
 */

import java.util.ArrayList;

public class Pipe<T> {
    // Variables
    private ArrayList<T> list;
    
    // Constructors
    public Pipe() {
        this.list = new ArrayList<>();
    }
    
    // Methods
    /**
     * Puts an object with a type in accordance with the type parameter given 
     * to the the class into the pipe.
     * @param value T: the object to add to the Pipe
     */
    public void putIntoPipe(T value) {
        this.list.add(value);
    }
    
    /**
     * Takes out the value, which has been in the pipe the longest. 
     * In case there is nothing in the pipe, return null. Calling the method 
     * returns the value, which has been in the pipe the longest, and removes 
     * it from the pipe.
     * @return T: the object in the Pipe that has been there the longest
     */
    public T takeFromPipe() {
        if (this.list.isEmpty()) {
            return null;
        }
        T object = this.list.get(0);
        this.list.remove(0);
        return object;
    }
    
    /**
     * Returns the value true if the pipe has values. In case the pipe is 
     * empty, it returns the value false.
     * @return boolean: true if the pipe has values; false otherwise
     */
    public boolean isInPipe() {
        if (!this.list.isEmpty()) {
            return true;
        }
        return false;
    }

}

/**
 * Hideout Generic Class for Part12_01
 * @author frank
 */
public class Hideout<T> {
    // Variables
    private T element;
    
    // Constructors
    public Hideout() {
        
    }
    
    //Methods
    /**
     * Puts an object with a type in accordance with the type parameter given 
     * to the the class into the hideout. In case an object is already in the hideout, it will disappear.
     * @param toHide T: the object to hide
     */
    public void putIntoHideout(T toHide) {
        this.element = toHide;
    }
    
    /**
     * Takes out the object with a type in accordance with the type parameter 
     * given to the the class from the hideout. In case there is nothing in the 
     * hideout, we return null. Calling the method returns the object in the 
     * hideout and removes the object from the hideout.
     * @return T: the object in the Hideout
     */
    public T takeFromHideout() {
       if (this.element == null) {
           return null;
       }
       T taken = this.element;
       this.element = null;
       return taken;
    }
    
    /**
     * Returns the value true if there is an object in the hideout. In case 
     * there isn't an object in the hideout, it should return the value false.
     * @return boolean: true if an object is in the Hideout; false otherwise
     */
    public boolean isInHideout() {
        if (this.element != null) {
            return true;
        }
        return false;
    }

}

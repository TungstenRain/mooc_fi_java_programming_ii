
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    // Variables
    private final String liNumber;
    private final String country;
    
    // Constructors
    /**
     * Construct the LicensePlate
     * @param country String: the license plate country
     * @param liNumber String: the license plate number
     */
    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    /**
     * Return a String in the following format:
     * [country] [license plate number]
     */
    public String toString() {
        return country + " " + liNumber;
    }
    
    @Override
    /**
     * Determine if this LicensePlate equals another LicensePlate
     * @return boolean: true if they are equal; false otherwise
     */
    public boolean equals(Object object) {
        // if they reference the same variable, they are equal
        if (this == object) {
            return true;
        }
        
        // If the object is not an instance of this, they are not equal
        if (!(object instanceof LicensePlate)) {
            return false;
        }
        
        // Cast the object as a LicensePlate and compare variables
        LicensePlate comparedObject = (LicensePlate) object;
        
        if (this.country.equals(comparedObject.country)
                && this.liNumber.equals(comparedObject.liNumber)) {
            return true;
        }
        return false;
    }
    
    @Override
    /**
     * Return a unique hash code for the LicensePlate
     */
    public int hashCode() {
        return Objects.hash(this.liNumber, this.country);
    }
}

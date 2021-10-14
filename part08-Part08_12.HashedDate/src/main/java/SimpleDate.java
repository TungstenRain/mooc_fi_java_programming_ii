import java.util.Objects;

public class SimpleDate {
    // Variables
    private int day;
    private int month;
    private int year;
    
    // Constructors
    /**
     * Construct the SimpleDate
     * @param day int: the day
     * @param month int: the month
     * @param year int: the year
     */
    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    /**
     * Return a String in the following format
     * [day].[month].[year]
     */
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
    
    /**
     * Determine if this SimpleDate is earlier than another
     * @param other SimpleDate: the SimpleDate to compare
     * @return booelean: true if earlier; false otherwise
     */
    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }
    
    /**
     * Determine the difference in years between this and another SimpleDate
     * @param other SimpleDate: the SimpleDate to compare
     * @return int: the difference in years
     */
    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }
    
    @Override
    /**
     * Compare this SimpleDate with an other object to determine if they are equal
     * @return boolean: true if equal; false otherwise
     */
    public boolean equals(Object object) {
        // If this is the same object, return true
        if (this == object) {
            return true;
        }
        
        // If they are not the same type of object, return false
        if (!(object instanceof SimpleDate)) {
            return false;
        }
        
        // Cast the object as a SimpleDate then compare variables
        SimpleDate comparedObject = (SimpleDate) object;
        
        if (this.day == comparedObject.day
                && this.month == comparedObject.month
                && this.year == comparedObject.year) {
            return true;
        }
        return false;
    }
    
    /**
     * Create a hash code for this SimpleDate in such a way that they are unique
     * @return int: the hash code
     */
    public int hashCode() {
        return Objects.hash(day, month, year);
    }
}

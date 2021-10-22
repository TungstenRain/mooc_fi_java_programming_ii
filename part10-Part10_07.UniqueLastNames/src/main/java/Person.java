public class Person {
    // Variables
    private String firstName;
    private String lastName;
    private int birthYear;
    
    // Constructors
    /**
     * Construct the Person
     * @param firstName String: the Person's first name
     * @param lastName String: the Person's last name
     * @param birthYear int: the Person's birth year
     */
    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }
    
    // Methods
    /**
     * Get the first name
     * @return String: the Person's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Get the Person's last name
     * @return String: the Person's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Get the Person's birth year
     * @return int: the Person's birth year
     */
    public int getBirthYear() {
        return birthYear;
    }

}

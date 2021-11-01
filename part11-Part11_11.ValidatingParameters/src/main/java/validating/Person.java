package validating;

/**
 *
 * @author frank
 */
public class Person {
    // Variables
    private String name;
    private int age;
    
    // Constructors
    /**
     * Construct the Person
     * @param name String: the Person's name
     * @param age int: the Person's age
     */
    public Person(String name, int age) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("A person's name cannot be null or empty.");
        }
        if (name.length() > 40) {
            throw new IllegalArgumentException("A person's name cannot be greater than 40 characters.");
        }
        if ((age < 0) || (age > 120)) {
            throw new IllegalArgumentException("The person's age must be between 0 and 120.");
        }
        this.name = name;
        this.age = age;
    }
    
    // Methods
    /**
     * Get the Person's name
     * @return String: the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the Person's age
     * @return int: the age
     */
    public int getAge() {
        return age;
    }
}



public class Student implements Comparable<Student> {
    // Variables
    private String name;
    
    // Constructors
    /**
     * Construct the Student
     * @param name String: the name
     */
    public Student(String name) {
        this.name = name;
    }
    
    // Methods
    /**
     * Get the name
     * @return String: the name
     */
    public String getName() {
        return name;
    }

    @Override
    /**
     * Return a String in the following format:
     * [name]
     */
    public String toString() {
        return name;
    }

    @Override
    /**
     * Compare this Student to another Student and put them in alphabetical order
     */
    public int compareTo(Student student) {
        return this.name.compareToIgnoreCase(student.name);
    }

}

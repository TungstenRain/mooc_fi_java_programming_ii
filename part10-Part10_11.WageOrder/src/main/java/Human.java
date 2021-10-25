
public class Human implements Comparable<Human> {
    // Variables
    private int wage;
    private String name;
    
    // Constructors
    /**
     * Construct the Human
     * @param name String: the name
     * @param wage int: the wage
     */
    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }
    
    // Methods
    /**
     * Get the name
     * @return String: the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the wage
     * @return int: the wage
     */
    public int getWage() {
        return wage;
    }


    @Override
    /**
     * Return a String in the following format:
     * [name] [wage]
     */
    public String toString() {
        return name + " " + wage;
    }

    @Override
    /**
     * Determine if the Human has a greater wage than the compared Human.
     * Order by largest to smallest.
     * @param Human: the Human to compare to this
     * @return int: 1 if this wage is less than the compared human; 0 if they are equal; -1 if this wage is greater than the compared human
     */
    public int compareTo(Human human) {
        return human.wage - this.wage;
    }
}

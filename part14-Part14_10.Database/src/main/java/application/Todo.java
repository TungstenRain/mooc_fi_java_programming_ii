package application;

public class Todo {
    // Variables
    private int id;
    private String name;
    private String description;
    private Boolean done;
    
    // Constructors
    /**
     * Construct the Todo
     * @param id int: the ID for the Todo
     * @param name String: the name
     * @param description String: the description
     * @param done boolean: true if completed, false otherwise
     */
    public Todo(int id, String name, String description, Boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
    }
    
    /**
     * Construct the Todo
     * @param name String: the name
     * @param description String: the description
     * @param done boolean: true if done, false otherwise
     */
    public Todo(String name, String description, Boolean done) {
        this(-1, name, description, done);
    }
    
    // Methods
    /**
     * Get the ID
     * @return int: the ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Set the ID
     * @param id int: the ID
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get the name
     * @return String: the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name
     * @param name String: the name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the description
     * @return String: the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Set the description
     * @param description String the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Get the status
     * @return 
     */
    public Boolean getDone() {
        return done;
    }
    
    /**
     * Set the status
     * @param done 
     */
    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", name=" + name + ", description=" + description + ", done=" + done + '}';
    }

}

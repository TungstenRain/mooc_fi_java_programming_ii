/**
 * ToDoList Class for Part06_10
 * @author frank
 */
import java.util.ArrayList;

public class TodoList {
    // Variables
    private ArrayList<String> list;
    
    // Constructors
    /**
     * Construct the ToDoList
     */
    public TodoList() {
        this.list = new ArrayList<>();
    }
    
    // Methods
    /**
     * Add task to the ToDoList
     * @param task String: the item to do
     */
    public void add(String task) {
        if (!list.contains(task)) {
            list.add(task);
        }
    }
    
    /**
     * Print out all tasks in the ToDoList
     */
    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ": " + list.get(i));
        }
    }
    
    /**
     * Remove the task at the given number
     * @param number int: the number of the task
     */
    public void remove(int number) {
        list.remove(number - 1);
    }
}

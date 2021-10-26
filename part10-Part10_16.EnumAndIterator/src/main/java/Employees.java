/**
 * Employees Class for Part10_16
 * @author frank
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Employees {
    // Variables
    private ArrayList<Person> people;
    
    // Constructors
    public Employees() {
        this.people = new ArrayList<>();
    }
    
    // Methods
    /**
     * Adds the given person to the employees list
     * @param personToAdd Person: the person to add
     */
    public void add(Person personToAdd) {
        this.people.add(personToAdd);
    }
    
    /**
     * Adds the given list of people to the employees list
     * @param peopleToAdd List<Person>: the list of Persons to add
     */
    public void add(List<Person> peopleToAdd) {
        for (Person person : peopleToAdd) {
            this.people.add(person);
        }
    }
    
    /**
     * Prints all employees
     */
    public void print() {
        // Instantiate the Iterator
        Iterator<Person> iterator = this.people.iterator();
        
        // Loop through the iterator and print
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    /**
     * Prints the employees whose education matches the education given as a parameter.
     * @param education Education: the education level of the employee
     */
    public void print(Education education) {
        // Instantiate the iterator
        Iterator<Person> iterator = this.people.iterator();
        
        // Iterate through the List and print all that match the education
        while (iterator.hasNext()) {
            // Instantiate Person
            Person person = iterator.next();
            
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }
    
    /**
     * Remove all employees whose education matches the education given as parameter from the employees list.
     * @param education 
     */
    public void fire(Education education) {
        // Instantiate the iterator
        Iterator<Person> iterator = this.people.iterator();
        
        // Iterate through the list and remove all that match the education
        while (iterator.hasNext()) {
            // Instantiate Person
            Person person = iterator.next();
            
            if (person.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}

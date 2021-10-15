import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Instantiate ArrayList<Person>
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200));
        persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028"));

        printPersons(persons);
    }
    
    // Methods
    /**
     * Prints all the persons on the list given as the parameter
     * @param persons ArrayList<Person>: the ArrayList of Persons to print
     */
    public static void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

}

import java.util.ArrayList;

public class MainProgram {

    public static void main(String[] args) {
        // Instantiate the Employees
        Employees employees = new Employees();
        
        // PHD, MA, BS, HS
        employees.add(new Person("a", Education.PHD));
        employees.add(new Person("b", Education.BA));
        employees.add(new Person("c", Education.MA));
        employees.add(new Person("d", Education.HS));
        
        System.out.println("Print all employees");
        employees.print();
        System.out.println("");
        
        // Instantiate ArrayList and various People
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person("e", Education.BA);
        Person person2 = new Person("f", Education.MA);
        Person person3 = new Person("g", Education.HS);
        Person person4 = new Person("h", Education.PHD);
        
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        
        employees.add(people);
        System.out.println("Print all employees");
        employees.print();
        System.out.println("");
        
        System.out.println("Print only HS employees");
        employees.print(Education.HS);
        System.out.println("");
        
        System.out.println("Fire the PHDs and print the remaining employees.");
        employees.fire(Education.PHD);
        employees.print();
    }
}

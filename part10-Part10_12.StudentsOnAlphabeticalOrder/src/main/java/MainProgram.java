import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        // Instantiate Students and ArrayList
        Student first = new Student("jamo");
        Student second = new Student("jamo1");
        Student third = new Student("Ted");
        Student fourth = new Student("Bob");
        ArrayList<Student> students = new ArrayList<>();
        
        students.add(first);
        students.add(second);
        students.add(third);
        students.add(fourth);
        
        System.out.println(students);
        
        Collections.sort(students);
        
        System.out.println(students);
    }
}

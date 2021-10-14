
public class Main {

    public static void main(String[] args) {
        // Instantiate SimpleDate
        SimpleDate d = new SimpleDate(1, 2, 2000);
        
        // Determine if they are equal
        System.out.println(d.equals("heh"));
        System.out.println(d.equals(new SimpleDate(5, 2, 2012)));
        System.out.println(d.equals(new SimpleDate(1, 2, 2000)));
    }
}

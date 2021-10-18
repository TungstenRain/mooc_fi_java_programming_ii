
public class Main {

    public static void main(String[] args) {
        // Instantiate Classes
        Book book1 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 2);
        Book book2 = new Book("Robert Martin", "Clean Code", 1);
        Book book3 = new Book("Kent Beck", "Test Driven Development", 0.5);
        
        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);
        
        Box box1 = new Box(10);
        Box box2 = new Box(2);
        Box box3 = new Box(4);
        
        // Add Packable items to the boxes
        box2.add(book1);
        box2.add(book2);
        box3.add(book2);
        box3.add(cd1);
        box3.add(cd2);
        box3.add(cd3);
        box1.add(box2);
        box1.add(box3);
        
        // Display results
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);
        System.out.println(box3);
        System.out.println(box2);
        System.out.println(box1);
    }

}

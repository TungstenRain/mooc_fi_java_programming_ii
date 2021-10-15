

public class Main {

    public static void main(String[] args) {
        // Instantiate BoxWithMaxWeight
        BoxWithMaxWeight coffeeBox = new BoxWithMaxWeight(10);
        
        // Add Items
        coffeeBox.add(new Item("Saludo", 5));
        coffeeBox.add(new Item("Pirkka", 5));
        coffeeBox.add(new Item("Kopi Luwak", 5));
        
        // Display results to user
        System.out.println(coffeeBox.isInBox(new Item("Saludo")));
        System.out.println(coffeeBox.isInBox(new Item("Pirkka")));
        System.out.println(coffeeBox.isInBox(new Item("Kopi Luwak")));
        
        /*
        // Instantiate OneItemBox
        OneItemBox box = new OneItemBox();
        box.add(new Item("Saludo", 5));
        box.add(new Item("Pirkka", 5));
        
        // Display results
        System.out.println(box.isInBox(new Item("Saludo")));
        System.out.println(box.isInBox(new Item("Pirkka")));
        */
    }
}

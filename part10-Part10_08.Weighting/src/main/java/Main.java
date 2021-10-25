

public class Main {

    public static void main(String[] args) {
        // Instantiate the Classes
        Item book = new Item("Book", 2);
        Item phone = new Item("Phone", 1);
        Item brick = new Item("Brick", 5);
        
        Suitcase mySuitcase = new Suitcase(5);
        Suitcase yourSuitcase = new Suitcase(10);
        
        Hold cargo1 = new Hold(5);
        Hold cargo2 = new Hold(20);
        
        // Add items to Suitcases and Hold
        mySuitcase.addItem(book);
        mySuitcase.addItem(phone);
        mySuitcase.addItem(brick);
        
        mySuitcase.printItems();
        System.out.println("");
        
        yourSuitcase.addItem(book);
        yourSuitcase.addItem(phone);
        yourSuitcase.addItem(brick);
        
        yourSuitcase.printItems();
        System.out.println("");
        
        cargo1.addSuitcase(mySuitcase);
        cargo1.addSuitcase(yourSuitcase);
        
        System.out.println("Cargo 1");
        cargo1.printItems();
        System.out.println("");
        
        cargo2.addSuitcase(mySuitcase);
        cargo2.addSuitcase(yourSuitcase);
        
        System.out.println("Cargo 2");
        cargo2.printItems();
    }

}

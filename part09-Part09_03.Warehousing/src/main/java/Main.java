

public class Main {

    public static void main(String[] args) {
        /*
        // Instantiate ProductWarehouseWithHistory
        ProductWarehouseWithHistory juice = new ProductWarehouseWithHistory("Juice", 1000.0, 1000.0);
        
        // Make some adjustments
        juice.takeFromWarehouse(11.3);
        juice.addToWarehouse(1.0);
        
        juice.printAnalysis();
        */
        ProductWarehouse juice = new ProductWarehouse("Juice", 1000.0);
        juice.addToWarehouse(1000.0);
        juice.takeFromWarehouse(11.3);
        System.out.println(juice.getName()); // Juice
        juice.addToWarehouse(1.0);
        System.out.println(juice); 
    }

}

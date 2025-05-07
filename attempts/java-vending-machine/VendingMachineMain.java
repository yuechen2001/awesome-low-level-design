import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineMain {
    public static void main(String[] args) {
        // Test setup
        System.out.println("===== VENDING MACHINE TEST =====");
        
        // Create products first
        Product coke = new Product(100, ProductType.COKE); // $1.00
        Product pepsi = new Product(100, ProductType.PEPSI);
        Product water = new Product(80, ProductType.WATER);  // $0.80
        Product snack = new Product(150, ProductType.SNACK); // $1.50
        Product chips = new Product(120, ProductType.CHIPS); // $1.20
        
        // 1. Initialize inventory
        Map<Product, Integer> initialInventory = new HashMap<>();
        initialInventory.put(coke, 5);
        initialInventory.put(pepsi, 5);
        initialInventory.put(water, 5);
        initialInventory.put(snack, 3);
        
        // Initialize cash with coins
        List<Cash> initialCash = new ArrayList<>();
        initialCash.add(new Cash(1, CashType.COIN)); // 100 coins
        
        // 2. Create the vending machine
        Machine vendingMachine = new Machine(initialInventory, initialCash);
        System.out.println("Vending machine initialized with products and cash");
        
        // 3. Test restocking
        System.out.println("\n----- Testing Restocking -----");
        vendingMachine.restock(coke, 3);
        vendingMachine.restock(chips, 5); // New product
        System.out.println("Restocked Coke (+3) and added new product Chips (5)");
        
        // 4. Test product selection and payment
        System.out.println("\n----- Testing Product Purchase -----");
        // Select a product
        try {
            System.out.println("Selecting Coke...");
            vendingMachine.chooseProduct(coke);
            
            // Insert money (100 coins for a $1.00 product)
            List<Cash> paymentCash = new ArrayList<>();
            paymentCash.add(new Cash(150, CashType.COIN));
            System.out.println("Inserting coins worth $1.50...");
            vendingMachine.collectMoney(paymentCash);
            
            // Dispense product
            System.out.println("Dispensing product...");
            vendingMachine.dispense(coke);
            
            // Get change
            List<Cash> changeReceived = new ArrayList<>();
            System.out.println("Returning change...");
            changeReceived = vendingMachine.returnChange();
            System.out.println("Received " + changeReceived.size() + " coins in change");
            
        } catch (IllegalStateException e) {
            System.out.println("Error during purchase: " + e.getMessage());
        }
        
        // 5. Test exceptional scenarios
        System.out.println("\n----- Testing Exception Scenarios -----");
        
        // Test insufficient funds
        try {
            System.out.println("Trying to purchase with insufficient funds...");
            vendingMachine.chooseProduct(water);
            List<Cash> insufficientCash = new ArrayList<>();
            insufficientCash.add(new Cash(50, CashType.COIN)); // Correct order
            vendingMachine.collectMoney(insufficientCash);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        
        System.out.println("\n===== TEST COMPLETE =====");
    }
}
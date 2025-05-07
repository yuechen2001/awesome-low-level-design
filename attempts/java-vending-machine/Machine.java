import java.util.List;
import java.util.ArrayList; 
import java.util.Map; 

public class Machine {
    private MachineState state; 
    private Map<Product, Integer> inventory; 
    private List<Cash> availableDenominations; 

    private IdleState idleState;
    private ReadyState readyState;
    private DispenseState dispenseState;
    private ReturnChangeState returnChangeState;

    private Product chosenProduct; 
    private Integer collectedAmount = 0; 

    public Machine(Map<Product, Integer> inventory, List<Cash> availableDenominations) {
        this.inventory = inventory; 
        this.availableDenominations = availableDenominations;

        this.idleState = new IdleState(this); 
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this); 
        this.returnChangeState = new ReturnChangeState(this); 

        this.state = idleState; 
    }
    
    public void restock(Product product, Integer quantity) {
        this.state.restock(product, quantity); 
    }

    public void updateInventory(Product product, Integer quantity) {
        if (this.inventory.containsKey(product)) {
            this.inventory.put(product, this.inventory.get(product) + quantity); 
        } else {
            this.inventory.put(product, quantity); 
        }
    }

    public void chooseProduct(Product product) {
        this.state.chooseProduct(product); 
    }

    public boolean isProductSold(Product product) {
        return this.inventory.containsKey(product); 
    }

    public void selectProduct(Product product) {
        this.chosenProduct = product; 
        this.state = this.readyState; 
    }

    public void collectMoney(List<Cash> cash) {
        try {
            this.state.collectMoney(cash); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCollectedAmount(List<Cash> cash) throws Exception {
        for (Cash c: cash) {
            this.collectedAmount += c.getValue();
        }
        Integer amountNeeded = this.chosenProduct.getPrice(); 
        if (this.collectedAmount >= amountNeeded) {
            this.state = this.dispenseState; 
        } else {
            this.state = this.readyState; 
            throw new Exception("You need to insert more money in the machine!");
        }
    }

    public void dispense(Product product) {
        this.state.dispense(product); 
    }

    public void dispenseProduct(Product product) {
        this.inventory.put(product, this.inventory.get(product) - 1);
        this.state = this.returnChangeState; 
    }

    public List<Cash> returnChange() {
        return this.state.returnChange();
    }

    public List<Cash> buildChange() {
        // Calculate amount to return
        Integer returnAmount = this.collectedAmount - this.chosenProduct.getPrice();
        List<Cash> returnCash = new ArrayList<>();
        
        // Create individual coins of value 1
        for (int i = 0; i < returnAmount; i++) {
            returnCash.add(new Cash(1, CashType.COIN));  // Add coins of type COIN with value 1
        }
        
        // Reset the collected amount and machine state
        this.collectedAmount = 0;
        this.state = this.idleState;
        
        return returnCash;
    }
}
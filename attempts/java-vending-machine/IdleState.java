import java.util.List; 

public class IdleState implements MachineState {
    private Machine machine; 

    public IdleState(Machine machine) {
        this.machine = machine; 
    }

    @Override
    public void restock(Product product, Integer quantity) {
        this.machine.updateInventory(product, quantity); 
    }

    @Override
    public void chooseProduct(Product product) {
        if (this.machine.isProductSold(product) == true) {
            this.machine.selectProduct(product); 
        } else {
            throw new IllegalArgumentException("The product selected does not exist.");
        }
    }

    @Override
    public void collectMoney(List<Cash> cash) {
        throw new IllegalStateException("Cannot collect money in idle state.");
    }

    @Override
    public void dispense(Product product) {
        throw new IllegalStateException("Cannot dispense drinks in idle state.");
    }

    @Override
    public List<Cash> returnChange() {
        throw new IllegalStateException("Cannot return change in idle state.");
    }
}
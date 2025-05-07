import java.util.List; 

public class DispenseState implements MachineState {
    private Machine machine; 

    public DispenseState(Machine machine) {
        this.machine = machine; 
    }

    @Override
    public void restock(Product product, Integer quantity) {
        throw new IllegalStateException("Cannot restock in dispense state.");
    }

    @Override
    public void chooseProduct(Product product) {
        throw new IllegalStateException("Cannot choose product in dispense state.");
    }

    @Override
    public void collectMoney(List<Cash> cash) {
        throw new IllegalStateException("Cannot collect money in dispense state.");
    }

    @Override
    public void dispense(Product product) {
        this.machine.dispenseProduct(product);
    }

    @Override
    public List<Cash> returnChange() {
        throw new IllegalStateException("Cannot return change in dispense state.");
    }
}
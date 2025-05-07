import java.util.List; 

public class ReadyState implements MachineState {
    private Machine machine; 

    public ReadyState(Machine machine) {
        this.machine = machine; 
    }

    @Override
    public void restock(Product product, Integer quantity) {
        throw new IllegalStateException("Cannot restock in ready state.");
    }

    @Override
    public void chooseProduct(Product product) {
        throw new IllegalStateException("Cannot choose product in ready state.");
    }

    @Override
    public void collectMoney(List<Cash> cash) throws Exception {
        this.machine.updateCollectedAmount(cash); 
    }

    @Override
    public void dispense(Product product) {
        throw new IllegalStateException("Cannot dispense drinks in ready state.");
    }

    @Override
    public List<Cash> returnChange() {
        throw new IllegalStateException("Cannot return change in ready state.");
    }
}
import java.util.List; 

public class ReturnChangeState implements MachineState {
    private Machine machine; 

    public ReturnChangeState(Machine machine) {
        this.machine = machine; 
    }

    @Override
    public void restock(Product product, Integer quantity) {
        throw new IllegalStateException("Cannot restock in returnChange state.");
    }

    @Override
    public void chooseProduct(Product product) {
        throw new IllegalStateException("Cannot choose product in returnChange state.");
    }

    @Override
    public void collectMoney(List<Cash> cash) {
        throw new IllegalStateException("Cannot collect money in returnChange state.");
    }

    @Override
    public void dispense(Product product) {
        throw new IllegalStateException("Cannot dispense in returnChange state.");
    }

    @Override
    public List<Cash> returnChange() {
        List<Cash> change = this.machine.buildChange(); 
        return change; 
    }
}
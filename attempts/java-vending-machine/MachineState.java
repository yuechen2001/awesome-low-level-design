import java.util.List; 

public interface MachineState{
    public void restock(Product product, Integer quantity);

    public void chooseProduct(Product product);

    public void collectMoney(List<Cash> cash) throws Exception;

    public void dispense(Product product);

    public List<Cash> returnChange();
}
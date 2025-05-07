public class Cash {
    private Integer value; 
    private CashType type;

    public Cash(Integer value, CashType type) {
        this.value = value; 
        this.type = type;
    } 
    
    public Integer getValue() {
        return this.value;
    }

    public CashType getType() {
        return this.type; 
    }
}
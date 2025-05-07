public class Product {
    private Integer price; 
    private ProductType type;

    public Product(Integer price, ProductType type) {
        this.price = price; 
        this.type = type;
    } 
    
    public Integer getPrice() {
        return this.price;
    }

    public ProductType getType() {
        return this.type; 
    }
}
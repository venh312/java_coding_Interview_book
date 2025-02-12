package design.factory;

public class Loan {
    public Product Loan() {
        return new Product.Builder()
                .name("loan")
                .price(100)
                .build();
    }
}

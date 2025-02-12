package design.factory;

public class Stock {
    public Product Stock() {
        return new Product.Builder()
                .name("stock")
                .price(100)
                .build();
    }
}

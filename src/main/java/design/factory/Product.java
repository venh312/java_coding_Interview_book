package design.factory;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static class Builder {
        private String name;
        private int price;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder price(int price) {
            this.price = price;
            return this;
        }

        Product build() {
            return new Product(name, price);
        }
    }
}

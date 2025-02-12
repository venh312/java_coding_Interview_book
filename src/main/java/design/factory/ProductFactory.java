package design.factory;

/*
인스턴스화 로직을 클라이언트에 노출하지 않고 객체를 만들 때 팩토리 디자인 패턴을 사용한다.
 */
public class ProductFactory {
    public static Product createProduct(String name) {
        switch (name) {
            case "loan" : new Loan();
            case "stock" : new Stock();
            default: throw new RuntimeException("No such product :: " + name);
        }
    }
}

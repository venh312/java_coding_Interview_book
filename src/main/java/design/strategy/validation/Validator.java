package design.strategy.validation;

public class Validator {
    private final ValidationStrategy strategy;
    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        System.out.println(numericValidator.validate("aaaa")); // false

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        System.out.println(lowerCaseValidator.validate("bbbb")); // true

        // 람다 표현식을 사용하면 IsNumeric 클래스를 만들지 않고 전략 디자인 패턴을 대신할 수 있다.
        // 람다 표현식은 코드 조각(또는 전략)을 캡슐화 한다.
        Validator numericValidatorLambda = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(numericValidatorLambda.validate("aaaa")); // false

        Validator lowerCaseValidatorLambda = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(lowerCaseValidatorLambda.validate("bbbb")); // true
    }
}

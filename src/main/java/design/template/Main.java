// 템플릿을 정의하는 AbstractClass
abstract class AbstractAlgorithmTemplate {
    // 템플릿 메서드: 알고리즘의 골격을 정의
    public final void executeAlgorithm() {
        step1();
        step2();
        step3();
    }

    // 추상 메서드: 하위 클래스에서 구현해야 하는 단계
    protected abstract void step1();
    protected abstract void step2();

    // 구체 메서드: 일부 단계는 구현되어 있음
    protected void step3() {
        System.out.println("Default implementation of step3");
    }
}

// 구상 클래스: AbstractAlgorithmTemplate을 구현
class ConcreteAlgorithm extends AbstractAlgorithmTemplate {
    @Override
    protected void step1() {
        System.out.println("Step 1 implemented by ConcreteAlgorithm");
    }

    @Override
    protected void step2() {
        System.out.println("Step 2 implemented by ConcreteAlgorithm");
    }

    // step3은 구현하지 않아도 됨 (부모의 디폴트 구현 사용)
}

public class Main {
    public static void main(String[] args) {
        // 템플릿을 사용하는 클라이언트 코드
        AbstractAlgorithmTemplate algorithm = new ConcreteAlgorithm();
        algorithm.executeAlgorithm();
    }
}

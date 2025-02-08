package design.strategy.validation;

import java.util.regex.Pattern;

public class IsEmail implements ValidationStrategy {
    // Pattern을 미리 생성해두면 정규식 파싱 비용을 줄일 수 있습니다.
    private static final Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Override
    public boolean execute(String s) {
        return pattern.matcher(s).matches();
    }
}

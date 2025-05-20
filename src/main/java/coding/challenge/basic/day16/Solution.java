package coding.challenge.basic.day16;

import java.util.*;

class Solution {
    public long solution(String expression) {
        // 연산자 우선순위 모든 경우의 수
        String[][] operators = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"}
        };

        // expression 파싱 (숫자와 연산자 분리)
        List<String> tokens = parseExpression(expression);

        long max = 0;

        for (String[] opSet : operators) {
            List<String> tempTokens = new ArrayList<>(tokens);
            for (String op : opSet) {
                tempTokens = compute(tempTokens, op);
            }
            max = Math.max(max, Math.abs(Long.parseLong(tempTokens.get(0))));
        }

        return max;
    }

    // 수식을 숫자와 연산자로 나눠 토큰 리스트로 반환
    private List<String> parseExpression(String expr) {
        List<String> result = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char ch : expr.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                result.add(number.toString());
                number.setLength(0);
                result.add(String.valueOf(ch));
            } else {
                number.append(ch);
            }
        }
        result.add(number.toString()); // 마지막 숫자
        return result;
    }

    // 해당 연산자에 대해 수식을 계산
    private List<String> compute(List<String> tokens, String op) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < tokens.size()) {
            String token = tokens.get(i);
            if (token.equals(op)) {
                long prev = Long.parseLong(result.remove(result.size() - 1));
                long next = Long.parseLong(tokens.get(++i));
                long res = operate(prev, next, op);
                result.add(String.valueOf(res));
            } else {
                result.add(token);
            }
            i++;
        }
        return result;
    }

    // 실제 계산 수행
    private long operate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}



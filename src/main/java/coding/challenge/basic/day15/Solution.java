package coding.challenge.basic.day15;

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || (stack.pop() != '(')) {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()()"));
        System.out.println(solution.solution("(())()"));
        System.out.println(solution.solution(")()("));
        System.out.println(solution.solution("(()("));
    }
}

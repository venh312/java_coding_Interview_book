package coding.challenge.basic.day21;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int base = prices[i];
            int time = 0;
            for (int j = i+1; j < prices.length; j++) {
                time++;
                if (base > prices[j]) {
                    break;
                }
            }
            answer[i] = time;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 2, 3}))); // [4, 3, 1, 1, 0]
    }
}

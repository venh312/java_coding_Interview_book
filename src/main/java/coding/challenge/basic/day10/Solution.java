package coding.challenge.basic.day10;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        // 배열을 2배로 확장 (원형 처리)
        int[] extended = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n];
        }

        // 부분 수열 길이 1부터 n까지
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = 0; i < len; i++) {
                    sum += extended[start + i];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{7,9,1,1,4}));
    }
}

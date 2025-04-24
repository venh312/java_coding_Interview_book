package coding.challenge.basic.day5;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int prev = -1; // arr의 원소는 0~9이므로 초기값은 -1로 설정

        for (int num : arr) {
            if (num != prev) {
                result.add(num);
                prev = num;
            }
        }

        // List를 int[]로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }
}

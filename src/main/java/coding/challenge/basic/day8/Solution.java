package coding.challenge.basic.day8;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;

        Set<Integer> uniqueMap = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int k = i+1; k < n; k++) {
                uniqueMap.add(numbers[i] + numbers[k]);
            }
        }

        return uniqueMap.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution.solution(new int[]{5, 0, 2, 7})));
    }
}

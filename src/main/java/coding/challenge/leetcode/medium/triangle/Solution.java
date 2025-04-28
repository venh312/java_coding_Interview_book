package coding.challenge.leetcode.medium.triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // 맨 마지막 줄을 복사해서 dp 배열을 만듬
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // 아래에서부터 위로 올라오면서 최소 경로 계산
        for (int layer = n - 2; layer >= 0; layer--) {
            for (int i = 0; i <= layer; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(layer).get(i);
            }
        }

        return dp[0];
    }

    // [[-1],[2,3],[1,-1,-3]] => -1
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> input  = new ArrayList<>();
        List<Integer> subInput1 = new ArrayList<>();
        subInput1.add(2);
        input.add(subInput1);
        List<Integer> subInput2 = new ArrayList<>();
        subInput2.add(3);
        subInput2.add(4);
        input.add(subInput2);
        List<Integer> subInput3 = new ArrayList<>();
        subInput3.add(6);
        subInput3.add(5);
        subInput3.add(7);
        input.add(subInput3);
        List<Integer> subInput4 = new ArrayList<>();
        subInput4.add(4);
        subInput4.add(1);
        subInput4.add(8);
        subInput4.add(3);
        input.add(subInput4);
        solution.minimumTotal(input);

        List<List<Integer>> input2  = new ArrayList<>();
        List<Integer> subInput5 = new ArrayList<>();
        subInput5.add(-1);
        input2.add(subInput5);
        List<Integer> subInput6 = new ArrayList<>();
        subInput6.add(2);
        subInput6.add(3);
        input2.add(subInput6);
        List<Integer> subInput7 = new ArrayList<>();
        subInput7.add(1);
        subInput7.add(-1);
        subInput7.add(-3);
        input2.add(subInput7);
        solution.minimumTotal(input2);
    }
}

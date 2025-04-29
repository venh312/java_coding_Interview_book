package coding.challenge.basic.day7;

public class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2}));
        System.out.println(solution.solution(new int[]{-1,0,1}, new int[]{1,0,-1}));
    }
}

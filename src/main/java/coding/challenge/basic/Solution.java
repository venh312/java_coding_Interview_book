package coding.challenge.basic.day3;

public class Solution {
    public int solution(String s) {
        int maxLen = 1; // 최소 길이는 1 이상

        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬 검사
            maxLen = Math.max(maxLen, expand(s, i, i));
            // 짝수 길이 팰린드롬 검사
            maxLen = Math.max(maxLen, expand(s, i, i + 1));
        }

        return maxLen;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 길이 반환
    }
}

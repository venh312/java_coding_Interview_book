package coding.challenge.basic.day6;

import java.util.Arrays;

import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열을 문자 배열로 변환
        char[] chars = s.toCharArray();

        // 문자 배열을 내림차순 정렬
        Arrays.sort(chars);

        // 배열 뒤집기 (오름차순 정렬 후 뒤집으면 내림차순)
        StringBuilder sb = new StringBuilder(new String(chars));
        return sb.reverse().toString();
    }
}

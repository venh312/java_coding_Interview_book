package coding.challenge.basic.day11;

import java.util.*;

/*
※ 핵심
2중 loop를 사용하지 않고, 전화번호 배열을 사전순으로 정렬하여 인접한 번호들만 비교하므로 효율적으로 문제를 해결
*/
class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 사전순으로 정렬
        Arrays.sort(phone_book);

        // 인접한 전화번호끼리 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 번호가 다음 번호의 접두어인지 확인
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false; // 접두어가 발견되면 false
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution.solution(new String[]{"123","456","789"}));
        System.out.println(solution.solution(new String[]{"12","123","1235","567","88"}));
    }
}

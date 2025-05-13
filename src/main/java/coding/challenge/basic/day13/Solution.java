package coding.challenge.basic.day13;

import java.util.*;

class Solution {
        public int[] solution(String[] gems) {
            Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
            int totalKinds = gemTypes.size();

            Map<String, Integer> gemMap = new HashMap<>();
            int start = 0, end = 0;
            int minLen = Integer.MAX_VALUE;
            int[] answer = {0, gems.length - 1};

            while (end < gems.length) {
                gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);

                while (gemMap.size() == totalKinds) {
                    if ((end - start) < minLen) {
                        minLen = end - start;
                        answer[0] = start + 1;  // 문제 조건: 1번 진열대부터 시작
                        answer[1] = end + 1;
                    }

                    gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                    if (gemMap.get(gems[start]) == 0) {
                        gemMap.remove(gems[start]);
                    }
                    start++;
                }

                end++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }
}

package coding.challenge.basic.day14;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(16, 0.75f, true);

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.containsKey(city)) {
                answer += 1;
                cache.get(city);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(cache.keySet().iterator().next());
                }
                cache.put(city, 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                3,
                  new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
                )
        );
        System.out.println(solution.solution(
                        3,
                        new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
                )
        );
        System.out.println(solution.solution(
                        2,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
                )
        );
        System.out.println(solution.solution(
                        5,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
                )
        );
        System.out.println(solution.solution(
                        2,
                        new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}
                )
        );
        System.out.println(solution.solution(
                        0,
                        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
                )
        );
    }
}

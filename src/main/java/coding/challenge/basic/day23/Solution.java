package coding.challenge.basic.day23;

import java.util.*;

class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    public int solution(int n) {
        if (dp.containsKey(n)) return dp.get(n);
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 1;
        int result = solution(n - 1) + solution(n - 2);
        dp.put(n, result % 1234567);
        return dp.get(n);
    }
}

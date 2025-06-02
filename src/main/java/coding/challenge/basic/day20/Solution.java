package coding.challenge.basic.day20;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int count = 0;
            while (progress < 100) {
                progress += speeds[i];
                count++;
            }
            queue.add(count);
        }

        if (!queue.isEmpty()) {
            int base = queue.poll();
            int count = 1;
            while (!queue.isEmpty()) {
                int day = queue.poll();
                if (base > day) {
                    count++;
                } else {
                    base = day;
                    answer.add(count);
                    count = 1;
                }
            }
            if (count > 0) answer.add(count);
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); // [2,1]
        System.out.println(Arrays.toString(solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))); // [1,3,2]
    }
}

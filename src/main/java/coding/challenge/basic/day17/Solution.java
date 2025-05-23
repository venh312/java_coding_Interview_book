package coding.challenge.basic.day17;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }

        int order = 0;

        while (!queue.isEmpty()) {
            Process current = queue.poll();

            boolean hasHigherPriority = queue.stream().anyMatch(p -> p.priority > current.priority);

            if (hasHigherPriority) {
                queue.offer(current); // 우선순위 높은 게 있으면 다시 뒤로
            } else {
                order++; // 실행
                if (current.index == location) {
                    return order; // 찾는 프로세스면 리턴
                }
            }
        }

        return -1; // 이론상 도달하지 않음
    }

    class Process {
        int index;
        int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2,1,4,3}, 3)); // 1
        System.out.println(solution.solution(new int[]{2,1,3,2}, 2)); // 1
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
    }
}



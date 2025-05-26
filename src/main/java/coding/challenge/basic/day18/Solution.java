package coding.challenge.basic.day18;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        int order = 0;
        while (!queue.isEmpty()) {
            Process current = queue.poll();
            boolean highValueFind = queue.stream().anyMatch(p -> p.priority > current.priority);

            if (highValueFind) {
                queue.add(current);
            } else {
                order++;
                if (current.index == location) {
                    return order;
                }
            }
        }

        return -1;
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


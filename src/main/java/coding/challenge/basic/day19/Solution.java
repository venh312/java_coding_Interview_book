package coding.challenge.basic.day19;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Truck {
        int weight;
        int enterTime;

        Truck(int weight, int enterTime) {
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int index = 0;

        while (index < truck_weights.length || !bridge.isEmpty()) {
            time++;

            // 다리에서 빠질 트럭 확인
            if (!bridge.isEmpty() && time - bridge.peek().enterTime >= bridge_length) {
                totalWeight -= bridge.poll().weight;
            }

            // 다음 트럭 진입 가능 여부 확인
            if (index < truck_weights.length && totalWeight + truck_weights[index] <= weight) {
                bridge.add(new Truck(truck_weights[index], time));
                totalWeight += truck_weights[index];
                index++;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 10, new int[]{7,4,5,6})); // 8
    }
}



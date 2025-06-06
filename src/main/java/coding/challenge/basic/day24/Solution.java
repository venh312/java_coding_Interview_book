package coding.challenge.basic.day24;

import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, i);
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int index) {
        visited[index] = true;
        for (int i = 0; i < computers[index].length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }
}

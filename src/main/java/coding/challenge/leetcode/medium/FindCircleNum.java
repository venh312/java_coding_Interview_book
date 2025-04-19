package coding.challenge.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/* Number of Provinces
https://leetcode.com/problems/number-of-provinces/description/

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
and city b is connected directly with city c, then city a is connected indirectly with city c.
n개의 도시가 있습니다. 그중 일부는 연결되어 있고, 일부는 연결되어 있지 않습니다.
도시 a가 도시 b와 직접 연결되어 있고, 도시 b가 도시 c와 직접 연결되어 있다면, 도시 a는 도시 c와 간접적으로 연결되어 있습니다.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.
지방은 직간접적으로 연결된 도시들의 집합이며, 그 집합 외부에는 다른 도시가 없습니다.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
n x n 행렬 isConnected가 주어집니다. 여기서 i번째 도시와 j번째 도시가 직접 연결되어 있으면 isConnected[i][j] = 1이고, 그렇지 않으면 isConnected[i][j] = 0입니다.

Return the total number of provinces.

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */
public class FindCircleNum {
    static boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        visited = new boolean[isConnected[0].length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bfs(isConnected, i);
                result++;
            }
        }

        return result;
    }

    void dfs(int[][] isConnected, int v) { // 1
        visited[v] = true; // 방문
        for (int i = 0; i < visited.length; i++) {
            if (isConnected[v][i] == 1 && !visited[i]) {
                dfs(isConnected, i);
            }
        }
    }

    void bfs(int[][] isConnected, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visited[poll] = true;
            for (int i = 0; i < visited.length; i++) {
                if (isConnected[poll][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        int[][] adj = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum.findCircleNum(adj));
    }
}




















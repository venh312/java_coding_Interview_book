package coding.challenge.basic.day25;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int answer = 0;
    static int[][] direction = {
        {-1, 0}, // up
        {0, 1}, // right
        {1, 0}, // down
        {0, -1} // left
    };

    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        int[][] visited = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;  // 시작점은 1로 표시 (거리)

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int[] d : direction) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return visited[rows - 1][cols - 1] == 0 ? -1 : visited[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Solution main = new Solution();

        int[][] array = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };

        int result = main.solution(array);
        System.out.println("result : " + result);
    }
}

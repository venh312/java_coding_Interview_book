package coding.challenge.FallingBall;

/*
rows * cols 크기의 격자 지도가 있습니다. 각(rows, cols) 칸에는 1에서 5 사이의 숫자로 고도가 표시되며,
숫작 5가 가장 높은 고도를 의미합니다. 공 하나가 격자 지도의 특정 칸에 놓입니다. 이 공은 위치한 칸보다 고도가 낮은 다른 칸으로
떨어질 수 있습니다. 공은 동서남북의 네 방향으로 떨어질 수 있습니다. 초기 상태의 격자 지도와, 공이 가능한 모든 경로를 다 지나간
후의 격자 지도를 출력하세요. 공이 지나간 경로는 0으료 표시하세요.
 */
public class FallingBall {
    public static void computePath(int prevElevation, int i , int j, int rows, int cols, int[][] elevations) {
        if (elevations == null) {
            throw new IllegalArgumentException("Elevations cannot be null");
        }

        // 공이 격자 지도의 영역 안에 있는지 확인합니다.
        if (i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {
            int currentElevation = elevations[i][j];

            // 공이 이전 칸에서 현재 칸으로 떨어질 수 있는지 확인합니다.
            if (prevElevation >= currentElevation && currentElevation > 0) {
                // 다음 이동을 계산할 때 사용하기 위해 현재 고도를 저장합니다.
                prevElevation = currentElevation;

                // 이 칸을 방문했다고 표시합니다.
                elevations[i][j] = 0;

                // 공을 이동할 수 있는지 확인합니다.
                computePath(prevElevation, i, j - 1, rows, cols ,elevations);
                computePath(prevElevation, i - 1, j, rows, cols ,elevations);
                computePath(prevElevation, i, j + 1, rows, cols ,elevations);
                computePath(prevElevation, i + 1, j, rows, cols ,elevations);
            }
        }
    }
}

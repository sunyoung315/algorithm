import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행렬의 크기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N * M의 행렬 입력
        int[][] space = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        int[][][] dp = new int[N][M][3];
        // 첫번째 행은 모든 방향을 space의 첫번째 행의 값으로 초기화
        for(int j = 0; j < M; j++) {
            dp[0][j][0] = space[0][j];
            dp[0][j][1] = space[0][j];
            dp[0][j][2] = space[0][j];
        }

        // 0: 왼쪽 아래, 1: 아래, 2: 오른쪽 아래
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 첫번째 열의 경우 0, 1번 방향에서만 올 수 있음
                if(j == 0) {
                    // 0번 방향에서 온 경우, 이전의 방향이 1이나 2여야 함
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + space[i][j];
                    // 1째 방향에서 온 경우, 이전의 방향이 0이나 2여야 하지만 0번째 열이기 때문에 2번 방향은 불가능
                    dp[i][j][1] = dp[i-1][j][0] + space[i][j];
                // 마지막 열의 경우 1, 2번 방향에서만 올 수 있음
                } else if(j == M-1) {
                    // 1번 방향에서 온 경우, 이전의 방향이 0이거나 2여야 하지만 마지막 열이기 때문에 0번 방향은 불가능
                    dp[i][j][1] = dp[i-1][j][2] + space[i][j];
                    // 2번 방향에서 온 경우, 이전의 방향이 0이나 1이어야 함.
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + space[i][j];
                } else {
                    // 각 방향에서 오기 위해서 이전 방향의 최소값 구하기
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + space[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + space[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + space[i][j];
                }
            }
        }

        int min = (int)1e9;
        // 마지막 행에서 최소값 찾기
        for(int j = 0; j < M; j++) {
            for(int k = 0; k < 3; k++) {
                if(dp[N-1][j][k] != 0)
                    min = Math.min(min, dp[N-1][j][k]);
            }
        }

        System.out.println(min);

    }
}

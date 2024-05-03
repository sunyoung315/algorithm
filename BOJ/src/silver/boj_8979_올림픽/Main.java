package silver.boj_8979_올림픽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 국가의 수
        int N = Integer.parseInt(st.nextToken());
        // 등수를 알 고 싶은 국가
        int K = Integer.parseInt(st.nextToken());

        int[][] rank = new int[N][4];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                rank[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 금, 은, 동메달의 개수 순서에 따라 정렬
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(rank[i][1] < rank[j][1]) {
                    int[] tmp = rank[i];
                    rank[i] = rank[j];
                    rank[j] = tmp;
                } else if(rank[i][1] == rank[j][1]) {
                    if(rank[i][2] < rank[j][2]) {
                        int[] tmp = rank[i];
                        rank[i] = rank[j];
                        rank[j] = tmp;
                    } else if(rank[i][2] == rank[j][2]) {
                        if(rank[i][3] < rank[j][3]) {
                            int[] tmp = rank[i];
                            rank[i] = rank[j];
                            rank[j] = tmp;
                        }
                    }
                }
            } //j
        } //i

        int[] rankArr = new int[N];
        rankArr[0] = 1;
        // 금, 은, 동메달의 수가 동일한 국가의 랭킹은 공동순위로 변경
        for(int i = 1; i < N; i++) {
            if(rankArr[i] == 0) {
                rankArr[i] = i+1;
            }
            if(rank[i-1][1] == rank[i][1] && rank[i-1][2] == rank[i][2] && rank[i-1][3] == rank[i][3]) {
                rankArr[i] = rankArr[i-1];
            }
        }

//        System.out.println(Arrays.toString(rankArr));
        // k국가의 순위 출력
        for(int i = 0; i < N; i++) {
            if(rank[i][0] == K) {
                System.out.println(rankArr[i]);
            }
        }
    } //main
}//class

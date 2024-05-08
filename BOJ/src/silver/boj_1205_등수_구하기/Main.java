package silver.boj_1205_등수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 리스트에 있는 점수 N개
        int N = Integer.parseInt(st.nextToken());
        // 태수의 새로운 점수
        int newScore = Integer.parseInt(st.nextToken());
        // 랭킹 리스트에 올라갈 수 있는 점수의 개수
        int P = Integer.parseInt(st.nextToken());

        // 주어지는 점수 리스트
        int[] scoreList = new int[N];

        // N > 0일 경우에만 두번째 입력줄이 있음
        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            // 점수리스트 입력
            for(int i = 0; i < N; i++) {
                scoreList[i] = Integer.parseInt(st.nextToken());
            }

            // 새로운 점수의 순위
            int rank = 1;
            // 동점인 점수의 개수
            int sameRankCnt = 0;
            for(int i = 0; i < N; i++) {
                if(scoreList[i] > newScore) rank++;
                else if(scoreList[i] == newScore) sameRankCnt++;
            }

            // (순위+동점 개수)가 랭크리스트의 개수보다 크면 순위에 들지 못하는 것!
            if(rank + sameRankCnt > P) System.out.println(-1);
            else System.out.println(rank);
        }
        // N = 0일 경우, 새로운 점수가 무조건 1등
        else {
            System.out.println(1);
        }
    }
}

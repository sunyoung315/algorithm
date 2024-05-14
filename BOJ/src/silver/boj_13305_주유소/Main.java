package silver.boj_13305_주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 개수 N
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1];
        long[] cost = new long[N];

        // 도로 길이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        // 리터랑 가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        // 첫번째 주유소의 가격의 최소 가격으로 초기화
        long minCost = cost[0];
        // 최소가격으로 주유할 거리를 첫번째 도로 거리로 초기화
        long totalDist = dist[0];
        // 최종 비용
        long totalCost = 0;

        // 두번째 주유소부터 순회
        for(int i = 1; i < N-1; i++) {
            // 이전 최소 가격보다 더 적으면, 
            if(cost[i] < minCost) {
                // 그 전의 최소가격과 누적거리 계산하여 그만큼 주유
                totalCost += minCost * totalDist;
                // 현재 위치의 가격으로 최소가격 저장
                minCost = cost[i];
                // 해당 거리부터 다시 누적
                totalDist = dist[i];
            } else {
                // 최소가격과 동일하거나 크면, 최소가격으로 주유할 거리 누적
                totalDist += dist[i];
            }
        }

        // 마지막으로 계산된 최소가격과 누적거리로 계산된 비용 추가
        totalCost += minCost * totalDist;

        System.out.println(totalCost);
    }
}

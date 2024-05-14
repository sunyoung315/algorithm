package silver.boj_13305_주유소;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_58percent {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 도시의 개수
        int N = Integer.parseInt(br.readLine());

        // 도시 사이의 거리를 입력받을 리스트
        List<Long> dists = new ArrayList<>();
        // 도시 사이의 거리 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            dists.add(Long.parseLong(st.nextToken()));
        }

        // 가장 저렴한 가격
        long minPrice = 1000000000;
        // 해당 가격의 인덱스
        int minIdx = 0;
        // 주유소의 리터당 가격을 입력받을 리스트
        List<Long> prices = new ArrayList<>();
        // 리터당 가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            long p = Long.parseLong(st.nextToken());
            prices.add(p);
            // 1~(N-1)번째 가격 중 가장 작은 가격인 곳 찾기
            if(p < minPrice) {
                minPrice = p;
                minIdx = i;
            }
        }

        // 최소비용
        long answer = 0;

        int lastIdx = N-1;

        while(minIdx != 0) {
            // 가격이 가장 작은 곳부터 끝까지 거리만큼은 여기서 전부 주유
            long totalDist = 0;
            for(int i = minIdx; i < lastIdx; i++) {
                totalDist += dists.get(i);
            }

            // 최소 주유비 더하기
            answer += (totalDist * minPrice);

            // 마지막 인덱스 이동
            lastIdx = minIdx;

            minPrice = 1000000000;
            minIdx = 0;
            for(int i = 0; i < lastIdx; i++) {
                if(minPrice > prices.get(i)) {
                    minPrice = prices.get(i);
                    minIdx = i;
                }
            }
        }

        long totalDist = 0;
        for(int i = 0; i < lastIdx; i++) {
            totalDist += dists.get(i);
        }

        answer += (minPrice * totalDist);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

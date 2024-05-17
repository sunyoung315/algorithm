package silver.boj_2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지방의 수 N
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 각 지방의 예산 요청을 입력받을 List
        int[] bArr = new int[N];
        // 각 지방의 예산 요청 총액
        int totalRequire = 0;

        // 최대 요청 예산
        int maxRequire = 0;

        for(int i = 0; i < N; i++) {
            int require = Integer.parseInt(st.nextToken());
            bArr[i] = require;
            totalRequire += require;
            if(require > maxRequire) maxRequire = require;
        }

        // 주어진 총 예산
        int budget = Integer.parseInt(br.readLine());

        if(budget > totalRequire) {
            System.out.println(maxRequire);
        } else {
            Arrays.sort(bArr);

            int prevTotal = 0;
            // 평균보다 큰 예산의 개수
            int cnt = N - 1;

            for(int i = 0; i < N - 1; i++) {
                if(bArr[i] < (budget - (prevTotal + bArr[i])) / cnt) {
                    prevTotal += bArr[i];
                    cnt--;
                } else
                    break;
            }

            System.out.println((budget - prevTotal) / (cnt + 1));

        }
    }
}

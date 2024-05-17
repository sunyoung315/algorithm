package silver.boj_21921_블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 블로그를 시작하고 지난 일수 N
        int N = Integer.parseInt(st.nextToken());
        // 방문자수를 구할 기간 M
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 방문자수를 입력하기 위한 List
        List<Integer> arr = new ArrayList<>();

        // "SAD"를 출력해야하는지 확인하기 위한 변수
        int zeroSum = 0;
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr.add(temp);
            zeroSum += temp;
        }

        // 방문자 수가 전부 0인지 아닌지 판단
        if(zeroSum != 0) {
            // 첫번째 M 기간의 방문자 수의 합
            int sum = 0;
            for(int i = 0; i < M; i++) {
                sum += arr.get(i);
            }
            // 첫번째 시작 index
            int startIdx = 0;
            // 최대 방문자 수
            int maxVisitors = sum;
            // 최대 방문자 수인 기간의 개수
            int maxCnt = 1;
            // 이전 M 기간의 첫번째 날의 방문자 수를 빼고 이번 M 기간의 마지막날 방문자 수를 더해서
            // 이번 M 기간의 총 방문자 수 구하기
            for(int i = M; i < N; i++) {
                sum = sum - arr.get(startIdx++) + arr.get(i);
                if(sum > maxVisitors) {
                    maxVisitors = sum;
                    maxCnt = 1;
                } else if(sum == maxVisitors)
                    maxCnt++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(maxVisitors).append("\n").append(maxCnt);
            System.out.println(sb);
        } else
            System.out.println("SAD");
    }
}

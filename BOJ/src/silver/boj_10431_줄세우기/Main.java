package silver.boj_10431_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        // 테스트 케이스
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            // 몇 번째 테스트케이스인지
            int n = Integer.parseInt(st.nextToken());

            // 움직인 횟수
            int moveCnt = 0;
            // 20명 줄서기
            int[] arr = new int[20];
            // 첫번째 사람 키 입력 받기
            arr[0] = Integer.parseInt(st.nextToken());

            // 두번째 사람부터 입력 받고 버블정렬
            for(int i = 1; i < 20; i++) {
                // 새로운 키 입력
                arr[i] = Integer.parseInt(st.nextToken());
                // 앞에 사람들 중 현재 키보다 큰 사람 중 가장 앞에 있는 사람 앞에 서고,
                // 그 위치에서 뒤에 있는 사람들 모두 뒤로 한칸씩 이동!
                for(int j = i-1; j >= 0; j--) {
                   if(arr[j+1] < arr[j]) {
                       int tmp = arr[j];
                       arr[j] = arr[j+1];
                       arr[j+1] = tmp;
                       moveCnt++;
                   }
                }
            }
            sb.append(n).append(" ").append(moveCnt).append("\n");
        }
        System.out.println(sb);
    }
}

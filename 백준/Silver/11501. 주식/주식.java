import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트케이스 수
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            // 날의 수
            int N = Integer.parseInt(br.readLine());
            // 날 별 주가
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 날 별 주가를 입력하기 위한 배열
            int[] days = new int[N];
            for(int i = 0; i < N; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = days[N-1];
            for(int i = N-2; i >= 0; i--) {
                if(days[i] < max)
                    sum += max - days[i];
                else
                    max = days[i];
            }

            bw.write(sum + "\n");
        }//for tc

        bw.flush();
        bw.close();
    }//main
}//Main

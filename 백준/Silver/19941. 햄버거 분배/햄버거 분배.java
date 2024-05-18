import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 식탁의 길이
        int N = Integer.parseInt(st.nextToken());
        // 햄버거를 선택할 수 있는 거리
        int K = Integer.parseInt(st.nextToken());

        // 사람과 햄버거의 위치
        char[] arr = br.readLine().toCharArray();
        // 해당 위치의 햄버거를 먹을 수 있는지 표시하기 위한 배결
        boolean[] canEat = new boolean[N];

        // 해당 위치에 먹을 수 있는 햄버거가 있는지 표시
        for(int i = 0; i < N; i++) {
            if(arr[i] == 'H') canEat[i] = true;
        }

        // 햄버거를 먹을 수 있는 사람 수
        int cnt = 0;
        out: for(int i = 0; i < N; i++) {
            // 현 위치가 사람이면
            if(arr[i] == 'P') {
                for(int j = i - K; j <= i + K; j++) {
                    // 해당 위치로부터 K만큼 떨어진 위치에 먹을 수 있는 햄버거가 있으면 카운팅
                    if(j >= 0 && j < N && arr[j] == 'H' && canEat[j]) {
                        cnt++;
                        // 이 위치의 햄버거는 먹었으므로 false 처리
                        canEat[j] = false;
                        continue out;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

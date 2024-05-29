import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사람의 수
        int N = Integer.parseInt(br.readLine());
        // 사람들이 줄을 선 위치를 입력할 배열
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            // 키가 i인 사람의 왼쪽에 있는 사람의 수
            int left = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++) {
                if(left == 0 && arr[j] == 0) {
                    arr[j] = i;
                    break;
                }
                if(arr[j] == 0) {
                    left--;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();

    }//main
}//Mains

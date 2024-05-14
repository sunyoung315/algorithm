package silver.boj_2164_카드2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N장의 카드
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        // 큐에 카드 넣기
        for(int i = 1; i <= N; i++) q.add(i);

        // 카드가 1개만 남을 때까지 반복
        while(q.size() > 1) {
            // 맨 앞장은 버리기
            q.poll();
            // 두 번째 장은 가장 뒤로
            q.add(q.poll());
        }

        // BufferedWriter로 정수형을 출력하려면 문자열로 변환해야 함!!
        bw.write(String.valueOf(q.poll()));
        bw.flush();
        bw.close();
    }
}
